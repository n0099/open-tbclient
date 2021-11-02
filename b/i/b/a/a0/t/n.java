package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
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
    public final b.i.b.a.i0.l f31758a;

    /* renamed from: b  reason: collision with root package name */
    public final b.i.b.a.a0.j f31759b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31760c;

    /* renamed from: d  reason: collision with root package name */
    public String f31761d;

    /* renamed from: e  reason: collision with root package name */
    public b.i.b.a.a0.m f31762e;

    /* renamed from: f  reason: collision with root package name */
    public int f31763f;

    /* renamed from: g  reason: collision with root package name */
    public int f31764g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31765h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31766i;
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

    public final void a(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            byte[] bArr = lVar.f32635a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f31766i && (bArr[c2] & 224) == 224;
                this.f31766i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f31766i = false;
                    this.f31758a.f32635a[1] = bArr[c2];
                    this.f31764g = 2;
                    this.f31763f = 1;
                    return;
                }
            }
            lVar.J(d2);
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31763f = 0;
            this.f31764g = 0;
            this.f31766i = false;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f31763f;
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

    @Override // b.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.l = j;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f31761d = dVar.b();
            this.f31762e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f31764g);
            this.f31762e.a(lVar, min);
            int i2 = this.f31764g + min;
            this.f31764g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f31762e.c(this.l, 1, i3, 0, null);
            this.l += this.j;
            this.f31764g = 0;
            this.f31763f = 0;
        }
    }

    public final void h(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f31764g);
            lVar.g(this.f31758a.f32635a, this.f31764g, min);
            int i2 = this.f31764g + min;
            this.f31764g = i2;
            if (i2 < 4) {
                return;
            }
            this.f31758a.J(0);
            if (!b.i.b.a.a0.j.b(this.f31758a.i(), this.f31759b)) {
                this.f31764g = 0;
                this.f31763f = 1;
                return;
            }
            b.i.b.a.a0.j jVar = this.f31759b;
            this.k = jVar.f31368c;
            if (!this.f31765h) {
                int i3 = jVar.f31369d;
                this.j = (jVar.f31372g * 1000000) / i3;
                this.f31762e.b(Format.createAudioSampleFormat(this.f31761d, jVar.f31367b, null, -1, 4096, jVar.f31370e, i3, null, null, 0, this.f31760c));
                this.f31765h = true;
            }
            this.f31758a.J(0);
            this.f31762e.a(this.f31758a, 4);
            this.f31763f = 2;
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
        this.f31763f = 0;
        b.i.b.a.i0.l lVar = new b.i.b.a.i0.l(4);
        this.f31758a = lVar;
        lVar.f32635a[0] = -1;
        this.f31759b = new b.i.b.a.a0.j();
        this.f31760c = str;
    }
}
