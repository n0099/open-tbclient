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
    public final h f32913a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.k f32914b;

    /* renamed from: c  reason: collision with root package name */
    public int f32915c;

    /* renamed from: d  reason: collision with root package name */
    public int f32916d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.i0.s f32917e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32918f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32919g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32920h;

    /* renamed from: i  reason: collision with root package name */
    public int f32921i;

    /* renamed from: j  reason: collision with root package name */
    public int f32922j;
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
        this.f32913a = hVar;
        this.f32914b = new c.i.b.a.i0.k(new byte[10]);
        this.f32915c = 0;
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f32917e = sVar;
            this.f32913a.f(gVar, dVar);
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32915c = 0;
            this.f32916d = 0;
            this.f32920h = false;
            this.f32913a.b();
        }
    }

    @Override // c.i.b.a.a0.t.w
    public final void c(c.i.b.a.i0.l lVar, boolean z) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            if (z) {
                if (this.f32915c == 3) {
                    if (this.f32922j != -1) {
                        String str = "Unexpected start indicator: expected " + this.f32922j + " more bytes";
                    }
                    this.f32913a.d();
                }
                g(1);
            }
            while (lVar.a() > 0) {
                int i2 = this.f32915c;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (d(lVar, this.f32914b.f33831a, Math.min(10, this.f32921i)) && d(lVar, null, this.f32921i)) {
                                f();
                                this.f32913a.e(this.l, this.k);
                                g(3);
                            }
                        } else if (i2 == 3) {
                            int a2 = lVar.a();
                            int i3 = this.f32922j;
                            int i4 = i3 != -1 ? a2 - i3 : 0;
                            if (i4 > 0) {
                                a2 -= i4;
                                lVar.I(lVar.c() + a2);
                            }
                            this.f32913a.c(lVar);
                            int i5 = this.f32922j;
                            if (i5 != -1) {
                                int i6 = i5 - a2;
                                this.f32922j = i6;
                                if (i6 == 0) {
                                    this.f32913a.d();
                                    g(1);
                                }
                            }
                        }
                    } else if (d(lVar, this.f32914b.f33831a, 9)) {
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
            int min = Math.min(lVar.a(), i2 - this.f32916d);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                lVar.K(min);
            } else {
                lVar.g(bArr, this.f32916d, min);
            }
            int i3 = this.f32916d + min;
            this.f32916d = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f32914b.l(0);
            int g2 = this.f32914b.g(24);
            if (g2 != 1) {
                r0 = "Unexpected start code prefix: " + g2;
                this.f32922j = -1;
                return false;
            }
            this.f32914b.n(8);
            int g3 = this.f32914b.g(16);
            this.f32914b.n(5);
            this.k = this.f32914b.f();
            this.f32914b.n(2);
            this.f32918f = this.f32914b.f();
            this.f32919g = this.f32914b.f();
            this.f32914b.n(6);
            int g4 = this.f32914b.g(8);
            this.f32921i = g4;
            if (g3 == 0) {
                this.f32922j = -1;
            } else {
                this.f32922j = ((g3 + 6) - 9) - g4;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f32914b.l(0);
            this.l = -9223372036854775807L;
            if (this.f32918f) {
                this.f32914b.n(4);
                this.f32914b.n(1);
                this.f32914b.n(1);
                long g2 = (this.f32914b.g(3) << 30) | (this.f32914b.g(15) << 15) | this.f32914b.g(15);
                this.f32914b.n(1);
                if (!this.f32920h && this.f32919g) {
                    this.f32914b.n(4);
                    this.f32914b.n(1);
                    this.f32914b.n(1);
                    this.f32914b.n(1);
                    this.f32917e.b((this.f32914b.g(3) << 30) | (this.f32914b.g(15) << 15) | this.f32914b.g(15));
                    this.f32920h = true;
                }
                this.l = this.f32917e.b(g2);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f32915c = i2;
            this.f32916d = 0;
        }
    }
}
