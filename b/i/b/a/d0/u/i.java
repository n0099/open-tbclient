package b.i.b.a.d0.u;

import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int l;
    public final long m;
    public final d n;
    public volatile int o;
    public volatile boolean p;
    public volatile boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.i.b.a.h0.e eVar, b.i.b.a.h0.g gVar, Format format, int i2, Object obj, long j, long j2, int i3, int i4, long j3, d dVar) {
        super(eVar, gVar, format, i2, obj, j, j2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b.i.b.a.h0.e) objArr2[0], (b.i.b.a.h0.g) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = i4;
        this.m = j3;
        this.n = dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.i.b.a.h0.g b2 = this.f32006a.b(this.o);
            try {
                b.i.b.a.a0.b bVar = new b.i.b.a.a0.b(this.f32013h, b2.f32531c, this.f32013h.a(b2));
                if (this.o == 0) {
                    b h2 = h();
                    h2.c(this.m);
                    this.n.d(h2);
                }
                b.i.b.a.a0.e eVar = this.n.f32014e;
                int i2 = 0;
                while (i2 == 0 && !this.p) {
                    i2 = eVar.e(bVar, null);
                }
                b.i.b.a.i0.a.f(i2 != 1);
                this.o = (int) (bVar.getPosition() - this.f32006a.f32531c);
                v.h(this.f32013h);
                this.q = true;
            } catch (Throwable th) {
                v.h(this.f32013h);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // b.i.b.a.d0.u.c
    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.p = true;
        }
    }

    @Override // b.i.b.a.d0.u.l
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32037i + this.l : invokeV.intValue;
    }

    @Override // b.i.b.a.d0.u.l
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }
}
