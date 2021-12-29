package c.i.b.a.d0.u;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class m extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int l;
    public final Format m;
    public volatile int n;
    public volatile boolean o;
    public volatile boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, Format format, int i2, Object obj, long j2, long j3, int i3, int i4, Format format2) {
        super(eVar, gVar, format, i2, obj, j2, j3, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), format2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.i.b.a.h0.e) objArr2[0], (c.i.b.a.h0.g) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = i4;
        this.m = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // c.i.b.a.d0.u.c
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = true;
        }
    }

    @Override // c.i.b.a.d0.u.l
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                long a = this.f30085h.a(this.a.b(this.n));
                if (a != -1) {
                    a += this.n;
                }
                c.i.b.a.a0.b bVar = new c.i.b.a.a0.b(this.f30085h, this.n, a);
                b g2 = g();
                g2.c(0L);
                c.i.b.a.a0.m a2 = g2.a(0, this.l);
                a2.b(this.m);
                for (int i2 = 0; i2 != -1; i2 = a2.d(bVar, Integer.MAX_VALUE, true)) {
                    this.n += i2;
                }
                a2.c(this.f30083f, 1, this.n, 0, null);
                v.h(this.f30085h);
                this.p = true;
            } catch (Throwable th) {
                v.h(this.f30085h);
                throw th;
            }
        }
    }
}
