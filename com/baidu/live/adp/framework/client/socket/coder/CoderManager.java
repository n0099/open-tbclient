package com.baidu.live.adp.framework.client.socket.coder;

import com.baidu.live.adp.framework.client.socket.SocketConfig;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdGzipHelper;
import com.baidu.live.adp.lib.util.SecureHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class CoderManager {
    private static volatile CoderManager sInstance = null;

    public static CoderManager getInstance() {
        if (sInstance == null) {
            synchronized (CoderManager.class) {
                if (sInstance == null) {
                    sInstance = new CoderManager();
                }
            }
        }
        return sInstance;
    }

    private CoderManager() {
    }

    public byte[] encode(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        boolean z3 = false;
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + CoderHeaderInfo.EXTRA_DATA_HEADER_LEN);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(SocketConfig.CODEC_PACK_EXTRA_DATA_FAILED);
                }
                allocate.putInt(encodeExtraDataInBackGround.length);
                allocate.put(encodeExtraDataInBackGround);
                allocate.put(encodeInBackGround);
                encodeInBackGround = allocate.array();
                z3 = true;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = compressGzip(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = SecureHelper.encryptWithAES(CoderSecretManager.getInstance().getSecretKey(), encodeInBackGround);
            }
            return CoderHeaderInfo.wrapHeaderIntoBody(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(SocketConfig.CODEC_UNKOWN_ERROR);
        }
    }

    public CoderPackInfo decodeRaw(CoderPackInfo coderPackInfo) throws CoderException {
        if (coderPackInfo == null || coderPackInfo.headerInfo == null || coderPackInfo.body == null) {
            throw new CoderException(SocketConfig.CODEC_INVALID_MSG);
        }
        CoderHeaderInfo coderHeaderInfo = coderPackInfo.headerInfo;
        if (coderHeaderInfo.getEncryptType() && coderPackInfo.bodyLength > 0) {
            if (CoderSecretManager.getInstance().getSecretKey() == null) {
                throw new CoderException(SocketConfig.CODEC_SECURE_KEY_NOT_READY);
            }
            try {
                coderPackInfo.body = SecureHelper.decryptWithAES(CoderSecretManager.getInstance().getSecretKey(), coderPackInfo.body, coderPackInfo.bodyOffset, coderPackInfo.bodyLength);
                coderPackInfo.bodyOffset = 0;
                coderPackInfo.bodyLength = coderPackInfo.body.length;
            } catch (Exception e) {
                throw new CoderException(SocketConfig.CODEC_SECURE_DECRYPT_FAILED);
            }
        }
        if (coderHeaderInfo.getCompressType() && coderPackInfo.bodyLength > 0) {
            try {
                coderPackInfo.body = uncompressGzip(coderPackInfo.body, coderPackInfo.bodyOffset, coderPackInfo.bodyLength);
                coderPackInfo.bodyOffset = 0;
                coderPackInfo.bodyLength = coderPackInfo.body.length;
            } catch (Exception e2) {
                throw new CoderException(SocketConfig.CODEC_UNZIP_FAILED);
            }
        }
        return coderPackInfo;
    }

    public CoderPackInfo decodeHeader(byte[] bArr) throws CoderException {
        int headerLengthInBytes = CoderHeaderInfo.getHeaderLengthInBytes();
        if (bArr == null || bArr.length < headerLengthInBytes) {
            throw new CoderException(SocketConfig.CODEC_INVALID_MSG);
        }
        CoderHeaderInfo extractFromRawBytes = CoderHeaderInfo.extractFromRawBytes(bArr);
        if (extractFromRawBytes == null) {
            throw new CoderException(SocketConfig.CODEC_INVALID_MSG);
        }
        CoderPackInfo coderPackInfo = new CoderPackInfo();
        coderPackInfo.headerInfo = extractFromRawBytes;
        coderPackInfo.body = bArr;
        coderPackInfo.bodyOffset = headerLengthInBytes;
        coderPackInfo.bodyLength = bArr.length - headerLengthInBytes;
        return coderPackInfo;
    }

    public SocketResponsedMessage decodeBody(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        int i2;
        String str;
        SocketResponsedMessage newInstance;
        try {
            Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
            try {
                newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
            }
            newInstance.setOrginalMessage(socketMessage);
            if (z) {
                try {
                    newInstance.onDecodeFailedInBackGround(i, bArr, SocketConfig.CODEC_UNPACK_FAILED);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                newInstance.decodeInBackGround(i, bArr);
            }
            return newInstance;
        } catch (Throwable th) {
            long j = 0;
            if (socketMessage != null) {
                j = socketMessage.getClientLogID();
            }
            if (bArr == null) {
                i2 = 0;
            } else {
                i2 = bArr.length;
            }
            if (th == null) {
                str = null;
            } else {
                str = th.getMessage();
            }
            BdStatisticsManager.getInstance().error("im", j, (String) null, "cmd", Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(SocketConfig.CODEC_UNPACK_FAILED);
        }
    }

    protected byte[] uncompressGzip(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BdGzipHelper.decompress(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            BdCloseHelper.close((OutputStream) byteArrayOutputStream);
            BdCloseHelper.close((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] compressGzip(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BdGzipHelper.compress(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            BdCloseHelper.close((OutputStream) byteArrayOutputStream);
            BdCloseHelper.close((InputStream) byteArrayInputStream);
        }
    }
}
