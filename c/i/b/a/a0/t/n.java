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
    public final c.i.b.a.i0.l f32766a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.a0.j f32767b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32768c;

    /* renamed from: d  reason: collision with root package name */
    public String f32769d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.a0.m f32770e;

    /* renamed from: f  reason: collision with root package name */
    public int f32771f;

    /* renamed from: g  reason: collision with root package name */
    public int f32772g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32773h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32774i;

    /* renamed from: j  reason: collision with root package name */
    public long f32775j;
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
            byte[] bArr = lVar.f33703a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f32774i && (bArr[c2] & 224) == 224;
                this.f32774i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f32774i = false;
                    this.f32766a.f33703a[1] = bArr[c2];
                    this.f32772g = 2;
                    this.f32771f = 1;
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
            this.f32771f = 0;
            this.f32772g = 0;
            this.f32774i = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32771f;
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
            this.f32769d = dVar.b();
            this.f32770e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f32772g);
            this.f32770e.a(lVar, min);
            int i2 = this.f32772g + min;
            this.f32772g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f32770e.c(this.l, 1, i3, 0, null);
            this.l += this.f32775j;
            this.f32772g = 0;
            this.f32771f = 0;
        }
    }

    public final void h(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f32772g);
            lVar.g(this.f32766a.f33703a, this.f32772g, min);
            int i2 = this.f32772g + min;
            this.f32772g = i2;
            if (i2 < 4) {
                return;
            }
            this.f32766a.J(0);
            if (!c.i.b.a.a0.j.b(this.f32766a.i(), this.f32767b)) {
                this.f32772g = 0;
                this.f32771f = 1;
                return;
            }
            c.i.b.a.a0.j jVar = this.f32767b;
            this.k = jVar.f32354c;
            if (!this.f32773h) {
                int i3 = jVar.f32355d;
                this.f32775j = (jVar.f32358g * 1000000) / i3;
                this.f32770e.b(Format.createAudioSampleFormat(this.f32769d, jVar.f32353b, null, -1, 4096, jVar.f32356e, i3, null, null, 0, this.f32768c));
                this.f32773h = true;
            }
            this.f32766a.J(0);
            this.f32770e.a(this.f32766a, 4);
            this.f32771f = 2;
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
        this.f32771f = 0;
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(4);
        this.f32766a = lVar;
        lVar.f33703a[0] = -1;
        this.f32767b = new c.i.b.a.a0.j();
        this.f32768c = str;
    }
}
