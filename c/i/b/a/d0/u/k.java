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
/* loaded from: classes4.dex */
public final class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final d f33067i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f33068j;
    public volatile boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, Format format, int i2, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.i.b.a.h0.e) objArr2[0], (c.i.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33067i = dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.i.b.a.h0.g b2 = this.f33034a.b(this.f33068j);
            try {
                c.i.b.a.a0.b bVar = new c.i.b.a.a0.b(this.f33041h, b2.f33595c, this.f33041h.a(b2));
                if (this.f33068j == 0) {
                    this.f33067i.d(null);
                }
                c.i.b.a.a0.e eVar = this.f33067i.f33042e;
                int i2 = 0;
                while (i2 == 0 && !this.k) {
                    i2 = eVar.e(bVar, null);
                }
                c.i.b.a.i0.a.f(i2 != 1);
                this.f33068j = (int) (bVar.getPosition() - this.f33034a.f33595c);
            } finally {
                v.h(this.f33041h);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // c.i.b.a.d0.u.c
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33068j : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = true;
        }
    }
}
