package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes9.dex */
public final class u implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.i.b.a.i0.s a;

    /* renamed from: b  reason: collision with root package name */
    public c.i.b.a.a0.m f29190b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29191c;

    public u() {
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

    @Override // c.i.b.a.a0.t.r
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.a = sVar;
            dVar.a();
            c.i.b.a.a0.m a = gVar.a(dVar.c(), 4);
            this.f29190b = a;
            a.b(Format.createSampleFormat(dVar.b(), "application/x-scte35", null, -1, null));
        }
    }

    @Override // c.i.b.a.a0.t.r
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (!this.f29191c) {
                if (this.a.e() == -9223372036854775807L) {
                    return;
                }
                this.f29190b.b(Format.createSampleFormat(null, "application/x-scte35", this.a.e()));
                this.f29191c = true;
            }
            int a = lVar.a();
            this.f29190b.a(lVar, a);
            this.f29190b.c(this.a.d(), 1, a, 0, null);
        }
    }
}
