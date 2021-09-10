package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public final class n implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.i0.l f32875a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.a0.j f32876b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32877c;

    /* renamed from: d  reason: collision with root package name */
    public String f32878d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.a0.m f32879e;

    /* renamed from: f  reason: collision with root package name */
    public int f32880f;

    /* renamed from: g  reason: collision with root package name */
    public int f32881g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32882h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32883i;

    /* renamed from: j  reason: collision with root package name */
    public long f32884j;
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

    public final void a(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            byte[] bArr = lVar.f33812a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f32883i && (bArr[c2] & 224) == 224;
                this.f32883i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f32883i = false;
                    this.f32875a.f33812a[1] = bArr[c2];
                    this.f32881g = 2;
                    this.f32880f = 1;
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
            this.f32880f = 0;
            this.f32881g = 0;
            this.f32883i = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32880f;
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
            this.f32878d = dVar.b();
            this.f32879e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f32881g);
            this.f32879e.a(lVar, min);
            int i2 = this.f32881g + min;
            this.f32881g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f32879e.c(this.l, 1, i3, 0, null);
            this.l += this.f32884j;
            this.f32881g = 0;
            this.f32880f = 0;
        }
    }

    public final void h(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f32881g);
            lVar.g(this.f32875a.f33812a, this.f32881g, min);
            int i2 = this.f32881g + min;
            this.f32881g = i2;
            if (i2 < 4) {
                return;
            }
            this.f32875a.J(0);
            if (!c.i.b.a.a0.j.b(this.f32875a.i(), this.f32876b)) {
                this.f32881g = 0;
                this.f32880f = 1;
                return;
            }
            c.i.b.a.a0.j jVar = this.f32876b;
            this.k = jVar.f32463c;
            if (!this.f32882h) {
                int i3 = jVar.f32464d;
                this.f32884j = (jVar.f32467g * 1000000) / i3;
                this.f32879e.b(Format.createAudioSampleFormat(this.f32878d, jVar.f32462b, null, -1, 4096, jVar.f32465e, i3, null, null, 0, this.f32877c));
                this.f32882h = true;
            }
            this.f32875a.J(0);
            this.f32879e.a(this.f32875a, 4);
            this.f32880f = 2;
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
        this.f32880f = 0;
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(4);
        this.f32875a = lVar;
        lVar.f33812a[0] = -1;
        this.f32876b = new c.i.b.a.a0.j();
        this.f32877c = str;
    }
}
