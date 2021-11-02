package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class l implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.i0.l f31743a;

    /* renamed from: b  reason: collision with root package name */
    public b.i.b.a.a0.m f31744b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31745c;

    /* renamed from: d  reason: collision with root package name */
    public long f31746d;

    /* renamed from: e  reason: collision with root package name */
    public int f31747e;

    /* renamed from: f  reason: collision with root package name */
    public int f31748f;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31743a = new b.i.b.a.i0.l(10);
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31745c = false;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && this.f31745c) {
            int a2 = lVar.a();
            int i2 = this.f31748f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(lVar.f32635a, lVar.c(), this.f31743a.f32635a, this.f31748f, min);
                if (this.f31748f + min == 10) {
                    this.f31743a.J(0);
                    if (73 == this.f31743a.x() && 68 == this.f31743a.x() && 51 == this.f31743a.x()) {
                        this.f31743a.K(3);
                        this.f31747e = this.f31743a.w() + 10;
                    } else {
                        this.f31745c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f31747e - this.f31748f);
            this.f31744b.a(lVar, min2);
            this.f31748f += min2;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void d() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f31745c && (i2 = this.f31747e) != 0 && this.f31748f == i2) {
            this.f31744b.c(this.f31746d, 1, i2, 0, null);
            this.f31745c = false;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && z) {
            this.f31745c = true;
            this.f31746d = j;
            this.f31747e = 0;
            this.f31748f = 0;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            b.i.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f31744b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
        }
    }
}
