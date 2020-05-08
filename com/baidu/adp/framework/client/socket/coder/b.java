package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {
    private static b Hm = null;

    public static b jD() {
        if (Hm == null) {
            synchronized (b.class) {
                if (Hm == null) {
                    Hm = new b();
                }
            }
        }
        return Hm;
    }

    private b() {
    }

    public byte[] a(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        boolean z3 = false;
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.EXTRA_DATA_HEADER_LEN);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(h.CODEC_PACK_EXTRA_DATA_FAILED);
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
                encodeInBackGround = u.encryptWithAES(d.jE().getSecretKey(), encodeInBackGround);
            }
            return a.wrapHeaderIntoBody(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(h.CODEC_UNKOWN_ERROR);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.Hn == null || cVar.body == null) {
            throw new CoderException(h.CODEC_INVALID_MSG);
        }
        a aVar = cVar.Hn;
        if (aVar.getEncryptType() && cVar.bodyLength > 0) {
            if (d.jE().getSecretKey() == null) {
                throw new CoderException(h.CODEC_SECURE_KEY_NOT_READY);
            }
            try {
                cVar.body = u.decryptWithAES(d.jE().getSecretKey(), cVar.body, cVar.bodyOffset, cVar.bodyLength);
                cVar.bodyOffset = 0;
                cVar.bodyLength = cVar.body.length;
            } catch (Exception e) {
                throw new CoderException(h.CODEC_SECURE_DECRYPT_FAILED);
            }
        }
        if (aVar.getCompressType() && cVar.bodyLength > 0) {
            try {
                cVar.body = uncompressGzip(cVar.body, cVar.bodyOffset, cVar.bodyLength);
                cVar.bodyOffset = 0;
                cVar.bodyLength = cVar.body.length;
            } catch (Exception e2) {
                throw new CoderException(h.CODEC_UNZIP_FAILED);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int headerLengthInBytes = a.getHeaderLengthInBytes();
        if (bArr == null || bArr.length < headerLengthInBytes) {
            throw new CoderException(h.CODEC_INVALID_MSG);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(h.CODEC_INVALID_MSG);
        }
        c cVar = new c();
        cVar.Hn = h;
        cVar.body = bArr;
        cVar.bodyOffset = headerLengthInBytes;
        cVar.bodyLength = bArr.length - headerLengthInBytes;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.CODEC_UNPACK_FAILED);
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
            throw new CoderException(h.CODEC_UNPACK_FAILED);
        }
    }

    protected byte[] uncompressGzip(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.decompress(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.f.a.close((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] compressGzip(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.compress(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.f.a.close((InputStream) byteArrayInputStream);
        }
    }
}
