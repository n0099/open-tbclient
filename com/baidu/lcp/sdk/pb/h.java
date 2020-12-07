package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.LcmPb;
import com.baidu.lcp.sdk.pb.RpcMetaPb;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes14.dex */
public class h {
    public com.baidu.lcp.sdk.connect.b i(InputStream inputStream) throws Exception {
        com.baidu.lcp.sdk.connect.b bVar = new com.baidu.lcp.sdk.connect.b();
        if (inputStream instanceof ByteArrayInputStream) {
            com.baidu.lcp.sdk.d.d.d("PbProcessor", "parseResponse quic");
            return bVar;
        } else if (inputStream instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) inputStream;
            byte readByte = dataInputStream.readByte();
            byte readByte2 = dataInputStream.readByte();
            byte readByte3 = dataInputStream.readByte();
            byte readByte4 = dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt > 1048576 || readInt2 > 1048576) {
                com.baidu.lcp.sdk.d.d.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[readInt - readInt2];
            dataInputStream.readFully(bArr2);
            com.baidu.lcp.sdk.d.d.v("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + bArr2.length);
            return b(bVar, bArr, bArr2);
        } else {
            return bVar;
        }
    }

    private com.baidu.lcp.sdk.connect.b b(com.baidu.lcp.sdk.connect.b bVar, byte[] bArr, byte[] bArr2) throws Exception {
        RpcMetaPb.RpcMeta parseFrom = RpcMetaPb.RpcMeta.parseFrom(bArr);
        if (parseFrom.getCompressType() == 1) {
            bArr2 = F(bArr2);
            com.baidu.lcp.sdk.d.d.d("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
        }
        bVar.azu = bArr2;
        if (parseFrom.hasNotify()) {
            RpcMetaPb.RpcNotifyMeta notify = parseFrom.getNotify();
            bVar.errorCode = 0;
            bVar.errorMsg = "notify";
            bVar.serviceId = notify.getServiceId();
            bVar.methodId = notify.getMethodId();
            bVar.msgId = notify.getLogId();
            bVar.azt = true;
            return bVar;
        } else if (parseFrom.hasResponse()) {
            RpcMetaPb.RpcResponseMeta response = parseFrom.getResponse();
            bVar.errorCode = response.getErrorCode();
            bVar.errorMsg = response.getErrorText();
            bVar.serviceId = response.getServiceId();
            bVar.methodId = response.getMethodId();
            bVar.msgId = response.getLogId();
            bVar.azt = false;
            if (bVar.errorCode == 0 && bVar.serviceId == 1) {
                return a(bVar, bArr2);
            }
            return bVar;
        } else if (parseFrom.hasRequest()) {
            RpcMetaPb.RpcRequestMeta request = parseFrom.getRequest();
            bVar.serviceId = request.getServiceId();
            bVar.methodId = request.getMethodId();
            com.baidu.lcp.sdk.d.d.d("PbProcessor", "parseRpcMeta requestMeta");
            return a(bVar, bArr2);
        } else {
            return bVar;
        }
    }

    private com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, byte[] bArr) throws Exception {
        LcmPb.RpcData parseFrom = LcmPb.RpcData.parseFrom(bArr);
        if (parseFrom.hasLcmResponse()) {
            LcmPb.LcmResponse lcmResponse = parseFrom.getLcmResponse();
            com.baidu.lcp.sdk.d.d.d("PbProcessor", "methodId ：" + bVar.methodId + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
            if (lcmResponse.getErrorCode() == 0) {
                if (bVar.methodId == 1) {
                    bVar.azw = 0;
                    bVar.azv = lcmResponse.getNextIntervalMs();
                } else if (bVar.methodId == 2) {
                    bVar.azw = -1;
                } else if (bVar.methodId == 3) {
                    bVar.azv = lcmResponse.getNextIntervalMs();
                } else if (bVar.methodId == 4) {
                    com.baidu.lcp.sdk.d.d.d("PbProcessor", "parseLcmResponse notify");
                }
            } else {
                bVar.errorCode = lcmResponse.getErrorCode();
                bVar.errorMsg = lcmResponse.getErrorMsg();
                bVar.azw = -1;
            }
        } else if (parseFrom.hasLcmNotify()) {
            com.baidu.lcp.sdk.d.d.d("PbProcessor", "lcmpb hasLcmNotify");
        } else if (parseFrom.hasLcmRequest()) {
            bVar.msgId = parseFrom.getLcmRequest().getLogId();
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] F(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "Exception ", e);
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "unzip exception :", e);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e3) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "Exception ", e3);
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e4) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "Exception ", e4);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }
}
