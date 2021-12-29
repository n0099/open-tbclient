package c.a.u.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final c.a.u.a.c.b a(c.a.u.a.c.b bVar, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bArr)) == null) {
            LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
            if (parseFrom.hasLcmResponse()) {
                LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
                c.a.u.a.h.e.a("PbProcessor", "methodId ：" + bVar.f27027i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
                if (lcmResponse.getErrorCode() == 0) {
                    long j2 = bVar.f27027i;
                    if (j2 == 1) {
                        bVar.f27028j = 0;
                        bVar.f27025g = lcmResponse.getNextIntervalMs();
                    } else if (j2 == 2) {
                        bVar.f27028j = -1;
                    } else if (j2 == 3) {
                        bVar.f27025g = lcmResponse.getNextIntervalMs();
                    } else if (j2 == 4) {
                        c.a.u.a.h.e.a("PbProcessor", "parseLcmResponse notify");
                    }
                } else {
                    bVar.f27021c = lcmResponse.getErrorCode();
                    bVar.f27022d = lcmResponse.getErrorMsg();
                    bVar.f27028j = -1;
                }
            } else if (parseFrom.hasLcmNotify()) {
                c.a.u.a.h.e.a("PbProcessor", "lcmpb hasLcmNotify");
            } else if (parseFrom.hasLcmRequest()) {
                bVar.n = parseFrom.getLcmRequest().getLogId();
            }
            return bVar;
        }
        return (c.a.u.a.c.b) invokeLL.objValue;
    }

    public c.a.u.a.c.b b(InputStream inputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            c.a.u.a.c.b bVar = new c.a.u.a.c.b();
            if (inputStream instanceof ByteArrayInputStream) {
                c.a.u.a.h.e.a("PbProcessor", "parseResponse quic");
            } else if (inputStream instanceof DataInputStream) {
                DataInputStream dataInputStream = (DataInputStream) inputStream;
                byte readByte = dataInputStream.readByte();
                byte readByte2 = dataInputStream.readByte();
                byte readByte3 = dataInputStream.readByte();
                byte readByte4 = dataInputStream.readByte();
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                if (readInt <= 1048576 && readInt2 <= 1048576) {
                    byte[] bArr = new byte[readInt2];
                    dataInputStream.readFully(bArr);
                    int i2 = readInt - readInt2;
                    byte[] bArr2 = new byte[i2];
                    dataInputStream.readFully(bArr2);
                    c.a.u.a.h.e.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i2);
                    c(bVar, bArr, bArr2);
                    return bVar;
                }
                c.a.u.a.h.e.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            return bVar;
        }
        return (c.a.u.a.c.b) invokeL.objValue;
    }

    public final c.a.u.a.c.b c(c.a.u.a.c.b bVar, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bArr, bArr2)) == null) {
            RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
            if (parseFrom.getCompressType() == 1) {
                bArr2 = d(bArr2);
                c.a.u.a.h.e.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
            }
            bVar.f27024f = bArr2;
            if (parseFrom.hasNotify()) {
                RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
                bVar.f27021c = 0;
                bVar.f27022d = "notify";
                bVar.f27026h = notify.getServiceId();
                bVar.f27027i = notify.getMethodId();
                bVar.n = notify.getLogId();
                bVar.f27023e = true;
            } else if (parseFrom.hasResponse()) {
                RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
                bVar.f27021c = response.getErrorCode();
                bVar.f27022d = response.getErrorText();
                bVar.f27026h = response.getServiceId();
                bVar.f27027i = response.getMethodId();
                bVar.n = response.getLogId();
                bVar.f27023e = false;
                if (bVar.f27021c == 0 && bVar.f27026h == 1) {
                    a(bVar, bArr2);
                    return bVar;
                }
            } else if (parseFrom.hasRequest()) {
                RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
                bVar.f27026h = request.getServiceId();
                bVar.f27027i = request.getMethodId();
                c.a.u.a.h.e.a("PbProcessor", "parseRpcMeta requestMeta");
                a(bVar, bArr2);
            }
            return bVar;
        }
        return (c.a.u.a.c.b) invokeLLL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x003b: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:18:0x003b */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        IOException e2;
        GZIPInputStream gZIPInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream3 = null;
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
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e3) {
                        c.a.u.a.h.e.c("SocketTransceiver", "Exception ", e3);
                    }
                    return byteArray;
                } catch (IOException e4) {
                    e2 = e4;
                    c.a.u.a.h.e.c("SocketTransceiver", "unzip exception :", e2);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e5) {
                            c.a.u.a.h.e.c("SocketTransceiver", "Exception ", e5);
                            return bArr;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream3 = gZIPInputStream2;
                if (gZIPInputStream3 != null) {
                    try {
                        gZIPInputStream3.close();
                    } catch (Exception e6) {
                        c.a.u.a.h.e.c("SocketTransceiver", "Exception ", e6);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            gZIPInputStream = null;
            e2 = e7;
        } catch (Throwable th2) {
            th = th2;
            if (gZIPInputStream3 != null) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
