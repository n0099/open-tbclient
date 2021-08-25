package c.a.u.a.e;

import android.content.Context;
import c.a.u.a.a.g;
import c.a.u.a.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public final byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) ? i2 == 1 ? g(bArr) : bArr : (byte[]) invokeLI.objValue;
    }

    public c.a.u.a.c.b b(c.a.u.a.c.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, z)) == null) {
            bVar.o = z;
            h(bVar, f(bVar.f30086h, bVar.f30087i, bVar.n, d(false)), a(bVar.f30079a, d(false)));
            return bVar;
        }
        return (c.a.u.a.c.b) invokeLZ.objValue;
    }

    public c.a.u.a.c.b c(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j2)) == null) {
            long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
            c.a.u.a.c.b bVar = new c.a.u.a.c.b();
            bVar.n = random;
            bVar.o = true;
            bVar.f30086h = 1L;
            bVar.f30087i = j2;
            bVar.l = j2 == 1;
            bVar.k = j2 == 3;
            h(bVar, f(1L, j2, random, d(false)), a(e(context, random, j2), d(false)));
            return bVar;
        }
        return (c.a.u.a.c.b) invokeLJ.objValue;
    }

    public final int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public final byte[] e(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        LcmPb$LcmRequest build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j3 == 4) {
                LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder();
                newBuilder.w(j2);
                newBuilder.v(2);
                LcmPb$LcmNotify build2 = newBuilder.build();
                LcmPb$RpcData.b newBuilder2 = LcmPb$RpcData.newBuilder();
                newBuilder2.D(build2);
                return newBuilder2.build().toByteArray();
            }
            if (j3 == 1) {
                try {
                    LcmPb$Common lcmPb$Common = (LcmPb$Common) c.a.u.a.h.b.c(context, false);
                    LcmPb$LcmRequest.b newBuilder3 = LcmPb$LcmRequest.newBuilder();
                    newBuilder3.z(j2);
                    newBuilder3.x(lcmPb$Common);
                    newBuilder3.C(f.j(context));
                    newBuilder3.B(System.currentTimeMillis());
                    newBuilder3.A(g.c(context));
                    newBuilder3.y(f.d(context));
                    build = newBuilder3.build();
                    c.a.u.a.h.e.a("PbProcessor", "cuid :" + lcmPb$Common.getCuid() + ", device :" + lcmPb$Common.getDeviceType() + ", os:" + lcmPb$Common.getOsVersion() + ", man :" + lcmPb$Common.getManufacture() + ", model :" + lcmPb$Common.getModelType() + ", appId :" + lcmPb$Common.getAppId() + ", app :" + lcmPb$Common.getAppVersion() + ", sdk :" + lcmPb$Common.getSdkVersion() + ", token :" + build.getToken() + ", net :" + lcmPb$Common.getNetwork() + ", rom :" + lcmPb$Common.getRomVersion() + ", start :" + build.getStartType() + "，connType :" + build.getConnType());
                } catch (Exception unused) {
                    LcmPb$LcmRequest.b newBuilder4 = LcmPb$LcmRequest.newBuilder();
                    newBuilder4.z(j2);
                    newBuilder4.C(f.j(context));
                    newBuilder4.B(System.currentTimeMillis());
                    newBuilder4.A(g.c(context));
                    newBuilder4.y(f.d(context));
                    build = newBuilder4.build();
                }
            } else if (j3 == 2) {
                LcmPb$LcmRequest.b newBuilder5 = LcmPb$LcmRequest.newBuilder();
                newBuilder5.z(j2);
                newBuilder5.B(System.currentTimeMillis());
                build = newBuilder5.build();
            } else {
                LcmPb$LcmRequest.b newBuilder6 = LcmPb$LcmRequest.newBuilder();
                newBuilder6.z(j2);
                newBuilder6.B(System.currentTimeMillis());
                build = newBuilder6.build();
            }
            c.a.u.a.h.e.f("PbProcessor", "logId :" + j2 + ", requestTime :" + build.getTimestamp() + "，methodId :" + j3);
            LcmPb$RpcData.b newBuilder7 = LcmPb$RpcData.newBuilder();
            newBuilder7.E(build);
            return newBuilder7.build().toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] f(long j2, long j3, long j4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)})) == null) {
            RpcMetaPb$RpcRequestMeta.b newBuilder = RpcMetaPb$RpcRequestMeta.newBuilder();
            newBuilder.u(j4);
            newBuilder.x(j2);
            newBuilder.v(j3);
            newBuilder.w(1);
            RpcMetaPb$RpcRequestMeta build = newBuilder.build();
            RpcMetaPb$RpcMeta.b newBuilder2 = RpcMetaPb$RpcMeta.newBuilder();
            newBuilder2.F(build);
            newBuilder2.E(j4);
            newBuilder2.D(i2);
            newBuilder2.A(1);
            return newBuilder2.build().toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public final c.a.u.a.c.b h(c.a.u.a.c.b bVar, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, bVar, bArr, bArr2)) == null) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + bArr2.length);
                allocate.put((byte) 108);
                allocate.put((byte) 99);
                allocate.put((byte) 112);
                allocate.put((byte) 1);
                allocate.putInt(bArr.length + bArr2.length);
                allocate.putInt(bArr.length);
                allocate.put(bArr);
                allocate.put(bArr2);
                bVar.f30079a = allocate.array();
            } catch (Exception unused) {
            }
            return bVar;
        }
        return (c.a.u.a.c.b) invokeLLL.objValue;
    }
}
