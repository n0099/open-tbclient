package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
/* loaded from: classes4.dex */
public final class p implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f32917a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.k f32918b;

    /* renamed from: c  reason: collision with root package name */
    public int f32919c;

    /* renamed from: d  reason: collision with root package name */
    public int f32920d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.i0.s f32921e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32922f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32923g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32924h;

    /* renamed from: i  reason: collision with root package name */
    public int f32925i;

    /* renamed from: j  reason: collision with root package name */
    public int f32926j;
    public boolean k;
    public long l;

    public p(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32917a = hVar;
        this.f32918b = new c.i.b.a.i0.k(new byte[10]);
        this.f32919c = 0;
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f32921e = sVar;
            this.f32917a.f(gVar, dVar);
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32919c = 0;
            this.f32920d = 0;
            this.f32924h = false;
            this.f32917a.b();
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void c(c.i.b.a.i0.l lVar, boolean z) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            if (z) {
                if (this.f32919c == 3) {
                    if (this.f32926j != -1) {
                        String str = "Unexpected start indicator: expected " + this.f32926j + " more bytes";
                    }
                    this.f32917a.d();
                }
                g(1);
            }
            while (lVar.a() > 0) {
                int i2 = this.f32919c;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (d(lVar, this.f32918b.f33835a, Math.min(10, this.f32925i)) && d(lVar, null, this.f32925i)) {
                                f();
                                this.f32917a.e(this.l, this.k);
                                g(3);
                            }
                        } else if (i2 == 3) {
                            int a2 = lVar.a();
                            int i3 = this.f32926j;
                            int i4 = i3 != -1 ? a2 - i3 : 0;
                            if (i4 > 0) {
                                a2 -= i4;
                                lVar.I(lVar.c() + a2);
                            }
                            this.f32917a.c(lVar);
                            int i5 = this.f32926j;
                            if (i5 != -1) {
                                int i6 = i5 - a2;
                                this.f32926j = i6;
                                if (i6 == 0) {
                                    this.f32917a.d();
                                    g(1);
                                }
                            }
                        }
                    } else if (d(lVar, this.f32918b.f33835a, 9)) {
                        g(e() ? 2 : 0);
                    }
                } else {
                    lVar.K(lVar.a());
                }
            }
        }
    }

    public final boolean d(c.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f32920d);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                lVar.K(min);
            } else {
                lVar.g(bArr, this.f32920d, min);
            }
            int i3 = this.f32920d + min;
            this.f32920d = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f32918b.l(0);
            int g2 = this.f32918b.g(24);
            if (g2 != 1) {
                r0 = "Unexpected start code prefix: " + g2;
                this.f32926j = -1;
                return false;
            }
            this.f32918b.n(8);
            int g3 = this.f32918b.g(16);
            this.f32918b.n(5);
            this.k = this.f32918b.f();
            this.f32918b.n(2);
            this.f32922f = this.f32918b.f();
            this.f32923g = this.f32918b.f();
            this.f32918b.n(6);
            int g4 = this.f32918b.g(8);
            this.f32925i = g4;
            if (g3 == 0) {
                this.f32926j = -1;
            } else {
                this.f32926j = ((g3 + 6) - 9) - g4;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f32918b.l(0);
            this.l = -9223372036854775807L;
            if (this.f32922f) {
                this.f32918b.n(4);
                this.f32918b.n(1);
                this.f32918b.n(1);
                long g2 = (this.f32918b.g(3) << 30) | (this.f32918b.g(15) << 15) | this.f32918b.g(15);
                this.f32918b.n(1);
                if (!this.f32924h && this.f32923g) {
                    this.f32918b.n(4);
                    this.f32918b.n(1);
                    this.f32918b.n(1);
                    this.f32918b.n(1);
                    this.f32921e.b((this.f32918b.g(3) << 30) | (this.f32918b.g(15) << 15) | this.f32918b.g(15));
                    this.f32924h = true;
                }
                this.l = this.f32921e.b(g2);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f32919c = i2;
            this.f32920d = 0;
        }
    }
}
