package c.i.b.a.a0.u;

import c.i.b.a.a0.f;
import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32994a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32995b;

        public a(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32994a = i2;
            this.f32995b = j2;
        }

        public static a a(f fVar, l lVar) throws IOException, InterruptedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fVar, lVar)) == null) {
                fVar.c(lVar.f33839a, 0, 8);
                lVar.J(0);
                return new a(lVar.i(), lVar.n());
            }
            return (a) invokeLL.objValue;
        }
    }

    public static b a(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fVar)) == null) {
            c.i.b.a.i0.a.e(fVar);
            l lVar = new l(16);
            if (a.a(fVar, lVar).f32994a != v.q(com.baidu.wallet.base.audio.b.f60395e)) {
                return null;
            }
            fVar.c(lVar.f33839a, 0, 4);
            lVar.J(0);
            int i2 = lVar.i();
            if (i2 != v.q(com.baidu.wallet.base.audio.b.f60396f)) {
                String str = "Unsupported RIFF format: " + i2;
                return null;
            }
            a a2 = a.a(fVar, lVar);
            while (a2.f32994a != v.q(com.baidu.wallet.base.audio.b.f60397g)) {
                fVar.g((int) a2.f32995b);
                a2 = a.a(fVar, lVar);
            }
            c.i.b.a.i0.a.f(a2.f32995b >= 16);
            fVar.c(lVar.f33839a, 0, 16);
            lVar.J(0);
            int p = lVar.p();
            int p2 = lVar.p();
            int o = lVar.o();
            int o2 = lVar.o();
            int p3 = lVar.p();
            int p4 = lVar.p();
            int i3 = (p2 * p4) / 8;
            if (p3 == i3) {
                int r = v.r(p4);
                if (r == 0) {
                    r0 = "Unsupported WAV bit depth: " + p4;
                    return null;
                } else if (p != 1 && p != 65534) {
                    String str2 = "Unsupported WAV format type: " + p;
                    return null;
                } else {
                    fVar.g(((int) a2.f32995b) - 16);
                    return new b(p2, o, o2, p3, p4, r);
                }
            }
            throw new ParserException("Expected block alignment: " + i3 + "; got: " + p3);
        }
        return (b) invokeL.objValue;
    }

    public static void b(f fVar, b bVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fVar, bVar) == null) {
            c.i.b.a.i0.a.e(fVar);
            c.i.b.a.i0.a.e(bVar);
            fVar.e();
            l lVar = new l(8);
            a a2 = a.a(fVar, lVar);
            while (a2.f32994a != v.q("data")) {
                String str = "Ignoring unknown WAV chunk: " + a2.f32994a;
                long j2 = a2.f32995b + 8;
                if (a2.f32994a == v.q(com.baidu.wallet.base.audio.b.f60395e)) {
                    j2 = 12;
                }
                if (j2 <= 2147483647L) {
                    fVar.h((int) j2);
                    a2 = a.a(fVar, lVar);
                } else {
                    throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a2.f32994a);
                }
            }
            fVar.h(8);
            bVar.j(fVar.getPosition(), a2.f32995b);
        }
    }
}
