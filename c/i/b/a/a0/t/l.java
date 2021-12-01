package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes7.dex */
public final class l implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.i0.l a;

    /* renamed from: b  reason: collision with root package name */
    public c.i.b.a.a0.m f29371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29372c;

    /* renamed from: d  reason: collision with root package name */
    public long f29373d;

    /* renamed from: e  reason: collision with root package name */
    public int f29374e;

    /* renamed from: f  reason: collision with root package name */
    public int f29375f;

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
        this.a = new c.i.b.a.i0.l(10);
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29372c = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && this.f29372c) {
            int a = lVar.a();
            int i2 = this.f29375f;
            if (i2 < 10) {
                int min = Math.min(a, 10 - i2);
                System.arraycopy(lVar.a, lVar.c(), this.a.a, this.f29375f, min);
                if (this.f29375f + min == 10) {
                    this.a.J(0);
                    if (73 == this.a.x() && 68 == this.a.x() && 51 == this.a.x()) {
                        this.a.K(3);
                        this.f29374e = this.a.w() + 10;
                    } else {
                        this.f29372c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a, this.f29374e - this.f29375f);
            this.f29371b.a(lVar, min2);
            this.f29375f += min2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f29372c && (i2 = this.f29374e) != 0 && this.f29375f == i2) {
            this.f29371b.c(this.f29373d, 1, i2, 0, null);
            this.f29372c = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) && z) {
            this.f29372c = true;
            this.f29373d = j2;
            this.f29374e = 0;
            this.f29375f = 0;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            c.i.b.a.a0.m a = gVar.a(dVar.c(), 4);
            this.f29371b = a;
            a.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
        }
    }
}
