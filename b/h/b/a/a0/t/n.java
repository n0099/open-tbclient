package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class n implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.i0.l f32616a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.a0.j f32617b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32618c;

    /* renamed from: d  reason: collision with root package name */
    public String f32619d;

    /* renamed from: e  reason: collision with root package name */
    public b.h.b.a.a0.m f32620e;

    /* renamed from: f  reason: collision with root package name */
    public int f32621f;

    /* renamed from: g  reason: collision with root package name */
    public int f32622g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32623h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32624i;
    public long j;
    public int k;
    public long l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            byte[] bArr = lVar.f33493a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f32624i && (bArr[c2] & 224) == 224;
                this.f32624i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f32624i = false;
                    this.f32616a.f33493a[1] = bArr[c2];
                    this.f32622g = 2;
                    this.f32621f = 1;
                    return;
                }
            }
            lVar.J(d2);
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32621f = 0;
            this.f32622g = 0;
            this.f32624i = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32621f;
                if (i2 == 0) {
                    a(lVar);
                } else if (i2 == 1) {
                    h(lVar);
                } else if (i2 == 2) {
                    g(lVar);
                }
            }
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.l = j;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32619d = dVar.b();
            this.f32620e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f32622g);
            this.f32620e.a(lVar, min);
            int i2 = this.f32622g + min;
            this.f32622g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f32620e.c(this.l, 1, i3, 0, null);
            this.l += this.j;
            this.f32622g = 0;
            this.f32621f = 0;
        }
    }

    public final void h(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f32622g);
            lVar.g(this.f32616a.f33493a, this.f32622g, min);
            int i2 = this.f32622g + min;
            this.f32622g = i2;
            if (i2 < 4) {
                return;
            }
            this.f32616a.J(0);
            if (!b.h.b.a.a0.j.b(this.f32616a.i(), this.f32617b)) {
                this.f32622g = 0;
                this.f32621f = 1;
                return;
            }
            b.h.b.a.a0.j jVar = this.f32617b;
            this.k = jVar.f32226c;
            if (!this.f32623h) {
                int i3 = jVar.f32227d;
                this.j = (jVar.f32230g * 1000000) / i3;
                this.f32620e.b(Format.createAudioSampleFormat(this.f32619d, jVar.f32225b, null, -1, 4096, jVar.f32228e, i3, null, null, 0, this.f32618c));
                this.f32623h = true;
            }
            this.f32616a.J(0);
            this.f32620e.a(this.f32616a, 4);
            this.f32621f = 2;
        }
    }

    public n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32621f = 0;
        b.h.b.a.i0.l lVar = new b.h.b.a.i0.l(4);
        this.f32616a = lVar;
        lVar.f33493a[0] = -1;
        this.f32617b = new b.h.b.a.a0.j();
        this.f32618c = str;
    }
}
