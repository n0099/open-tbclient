package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes7.dex */
public final class n implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.i0.l a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.a0.j f29386b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29387c;

    /* renamed from: d  reason: collision with root package name */
    public String f29388d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.a0.m f29389e;

    /* renamed from: f  reason: collision with root package name */
    public int f29390f;

    /* renamed from: g  reason: collision with root package name */
    public int f29391g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29392h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29393i;

    /* renamed from: j  reason: collision with root package name */
    public long f29394j;

    /* renamed from: k  reason: collision with root package name */
    public int f29395k;
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

    public final void a(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            byte[] bArr = lVar.a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f29393i && (bArr[c2] & 224) == 224;
                this.f29393i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f29393i = false;
                    this.a.a[1] = bArr[c2];
                    this.f29391g = 2;
                    this.f29390f = 1;
                    return;
                }
            }
            lVar.J(d2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29390f = 0;
            this.f29391g = 0;
            this.f29393i = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f29390f;
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

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.l = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f29388d = dVar.b();
            this.f29389e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.f29395k - this.f29391g);
            this.f29389e.a(lVar, min);
            int i2 = this.f29391g + min;
            this.f29391g = i2;
            int i3 = this.f29395k;
            if (i2 < i3) {
                return;
            }
            this.f29389e.c(this.l, 1, i3, 0, null);
            this.l += this.f29394j;
            this.f29391g = 0;
            this.f29390f = 0;
        }
    }

    public final void h(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f29391g);
            lVar.g(this.a.a, this.f29391g, min);
            int i2 = this.f29391g + min;
            this.f29391g = i2;
            if (i2 < 4) {
                return;
            }
            this.a.J(0);
            if (!c.i.b.a.a0.j.b(this.a.i(), this.f29386b)) {
                this.f29391g = 0;
                this.f29390f = 1;
                return;
            }
            c.i.b.a.a0.j jVar = this.f29386b;
            this.f29395k = jVar.f29017c;
            if (!this.f29392h) {
                int i3 = jVar.f29018d;
                this.f29394j = (jVar.f29021g * 1000000) / i3;
                this.f29389e.b(Format.createAudioSampleFormat(this.f29388d, jVar.f29016b, null, -1, 4096, jVar.f29019e, i3, null, null, 0, this.f29387c));
                this.f29392h = true;
            }
            this.a.J(0);
            this.f29389e.a(this.a, 4);
            this.f29390f = 2;
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
        this.f29390f = 0;
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(4);
        this.a = lVar;
        lVar.a[0] = -1;
        this.f29386b = new c.i.b.a.a0.j();
        this.f29387c = str;
    }
}
