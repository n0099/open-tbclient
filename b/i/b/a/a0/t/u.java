package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class u implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.i.b.a.i0.s f31804a;

    /* renamed from: b  reason: collision with root package name */
    public b.i.b.a.a0.m f31805b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31806c;

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

    @Override // b.i.b.a.a0.t.r
    public void a(b.i.b.a.i0.s sVar, b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f31804a = sVar;
            dVar.a();
            b.i.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f31805b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/x-scte35", null, -1, null));
        }
    }

    @Override // b.i.b.a.a0.t.r
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (!this.f31806c) {
                if (this.f31804a.e() == -9223372036854775807L) {
                    return;
                }
                this.f31805b.b(Format.createSampleFormat(null, "application/x-scte35", this.f31804a.e()));
                this.f31806c = true;
            }
            int a2 = lVar.a();
            this.f31805b.a(lVar, a2);
            this.f31805b.c(this.f31804a.d(), 1, a2, 0, null);
        }
    }
}
