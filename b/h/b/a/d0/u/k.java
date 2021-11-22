package b.h.b.a.d0.u;

import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final d f32894i;
    public volatile int j;
    public volatile boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(b.h.b.a.h0.e eVar, b.h.b.a.h0.g gVar, Format format, int i2, Object obj, d dVar) {
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
                super((b.h.b.a.h0.e) objArr2[0], (b.h.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32894i = dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.h.b.a.h0.g b2 = this.f32864a.b(this.j);
            try {
                b.h.b.a.a0.b bVar = new b.h.b.a.a0.b(this.f32871h, b2.f33389c, this.f32871h.a(b2));
                if (this.j == 0) {
                    this.f32894i.d(null);
                }
                b.h.b.a.a0.e eVar = this.f32894i.f32872e;
                int i2 = 0;
                while (i2 == 0 && !this.k) {
                    i2 = eVar.e(bVar, null);
                }
                b.h.b.a.i0.a.f(i2 != 1);
                this.j = (int) (bVar.getPosition() - this.f32864a.f33389c);
            } finally {
                v.h(this.f32871h);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // b.h.b.a.d0.u.c
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = true;
        }
    }
}
