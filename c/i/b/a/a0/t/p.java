package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
/* loaded from: classes9.dex */
public final class p implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.k f28928b;

    /* renamed from: c  reason: collision with root package name */
    public int f28929c;

    /* renamed from: d  reason: collision with root package name */
    public int f28930d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.i0.s f28931e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28932f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28933g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28934h;

    /* renamed from: i  reason: collision with root package name */
    public int f28935i;

    /* renamed from: j  reason: collision with root package name */
    public int f28936j;
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
        this.a = hVar;
        this.f28928b = new c.i.b.a.i0.k(new byte[10]);
        this.f28929c = 0;
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f28931e = sVar;
            this.a.f(gVar, dVar);
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28929c = 0;
            this.f28930d = 0;
            this.f28934h = false;
            this.a.b();
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void c(c.i.b.a.i0.l lVar, boolean z) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            if (z) {
                if (this.f28929c == 3) {
                    if (this.f28936j != -1) {
                        String str = "Unexpected start indicator: expected " + this.f28936j + " more bytes";
                    }
                    this.a.d();
                }
                g(1);
            }
            while (lVar.a() > 0) {
                int i2 = this.f28929c;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (d(lVar, this.f28928b.a, Math.min(10, this.f28935i)) && d(lVar, null, this.f28935i)) {
                                f();
                                this.a.e(this.l, this.k);
                                g(3);
                            }
                        } else if (i2 == 3) {
                            int a = lVar.a();
                            int i3 = this.f28936j;
                            int i4 = i3 != -1 ? a - i3 : 0;
                            if (i4 > 0) {
                                a -= i4;
                                lVar.I(lVar.c() + a);
                            }
                            this.a.c(lVar);
                            int i5 = this.f28936j;
                            if (i5 != -1) {
                                int i6 = i5 - a;
                                this.f28936j = i6;
                                if (i6 == 0) {
                                    this.a.d();
                                    g(1);
                                }
                            }
                        }
                    } else if (d(lVar, this.f28928b.a, 9)) {
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
            int min = Math.min(lVar.a(), i2 - this.f28930d);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                lVar.K(min);
            } else {
                lVar.g(bArr, this.f28930d, min);
            }
            int i3 = this.f28930d + min;
            this.f28930d = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f28928b.l(0);
            int g2 = this.f28928b.g(24);
            if (g2 != 1) {
                r0 = "Unexpected start code prefix: " + g2;
                this.f28936j = -1;
                return false;
            }
            this.f28928b.n(8);
            int g3 = this.f28928b.g(16);
            this.f28928b.n(5);
            this.k = this.f28928b.f();
            this.f28928b.n(2);
            this.f28932f = this.f28928b.f();
            this.f28933g = this.f28928b.f();
            this.f28928b.n(6);
            int g4 = this.f28928b.g(8);
            this.f28935i = g4;
            if (g3 == 0) {
                this.f28936j = -1;
            } else {
                this.f28936j = ((g3 + 6) - 9) - g4;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28928b.l(0);
            this.l = -9223372036854775807L;
            if (this.f28932f) {
                this.f28928b.n(4);
                this.f28928b.n(1);
                this.f28928b.n(1);
                long g2 = (this.f28928b.g(3) << 30) | (this.f28928b.g(15) << 15) | this.f28928b.g(15);
                this.f28928b.n(1);
                if (!this.f28934h && this.f28933g) {
                    this.f28928b.n(4);
                    this.f28928b.n(1);
                    this.f28928b.n(1);
                    this.f28928b.n(1);
                    this.f28931e.b((this.f28928b.g(3) << 30) | (this.f28928b.g(15) << 15) | this.f28928b.g(15));
                    this.f28934h = true;
                }
                this.l = this.f28931e.b(g2);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f28929c = i2;
            this.f28930d = 0;
        }
    }
}
