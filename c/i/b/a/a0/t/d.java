package c.i.b.a.a0.t;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes9.dex */
public final class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.k f29729b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f29730c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29731d;

    /* renamed from: e  reason: collision with root package name */
    public String f29732e;

    /* renamed from: f  reason: collision with root package name */
    public c.i.b.a.a0.m f29733f;

    /* renamed from: g  reason: collision with root package name */
    public c.i.b.a.a0.m f29734g;

    /* renamed from: h  reason: collision with root package name */
    public int f29735h;

    /* renamed from: i  reason: collision with root package name */
    public int f29736i;

    /* renamed from: j  reason: collision with root package name */
    public int f29737j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f29738k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public c.i.b.a.a0.m p;
    public long q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445032007, "Lc/i/b/a/a0/t/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445032007, "Lc/i/b/a/a0/t/d;");
                return;
            }
        }
        r = new byte[]{73, 68, 51};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(boolean z) {
        this(z, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final boolean a(c.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f29736i);
            lVar.g(bArr, this.f29736i, min);
            int i3 = this.f29736i + min;
            this.f29736i = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k();
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f29735h;
                if (i2 == 0) {
                    g(lVar);
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        if (a(lVar, this.f29729b.a, this.f29738k ? 7 : 5)) {
                            h();
                        }
                    } else if (i2 == 3) {
                        j(lVar);
                    }
                } else if (a(lVar, this.f29730c.a, 10)) {
                    i();
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
            this.o = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f29732e = dVar.b();
            this.f29733f = gVar.a(dVar.c(), 1);
            if (this.a) {
                dVar.a();
                c.i.b.a.a0.m a = gVar.a(dVar.c(), 4);
                this.f29734g = a;
                a.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
                return;
            }
            this.f29734g = new c.i.b.a.a0.d();
        }
    }

    public final void g(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            byte[] bArr = lVar.a;
            int c2 = lVar.c();
            int d2 = lVar.d();
            while (c2 < d2) {
                int i2 = c2 + 1;
                int i3 = bArr[c2] & 255;
                if (this.f29737j == 512 && i3 >= 240 && i3 != 255) {
                    this.f29738k = (i3 & 1) == 0;
                    l();
                    lVar.J(i2);
                    return;
                }
                int i4 = this.f29737j;
                int i5 = i3 | i4;
                if (i5 == 329) {
                    this.f29737j = 768;
                } else if (i5 == 511) {
                    this.f29737j = 512;
                } else if (i5 == 836) {
                    this.f29737j = 1024;
                } else if (i5 == 1075) {
                    m();
                    lVar.J(i2);
                    return;
                } else if (i4 != 256) {
                    this.f29737j = 256;
                    i2--;
                }
                c2 = i2;
            }
            lVar.J(c2);
        }
    }

    public final void h() throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f29729b.l(0);
            if (!this.l) {
                int g2 = this.f29729b.g(2) + 1;
                if (g2 != 2) {
                    String str = "Detected audio object type: " + g2 + ", but assuming AAC LC.";
                    g2 = 2;
                }
                int g3 = this.f29729b.g(4);
                this.f29729b.n(1);
                byte[] a = c.i.b.a.i0.c.a(g2, g3, this.f29729b.g(3));
                Pair<Integer, Integer> i2 = c.i.b.a.i0.c.i(a);
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f29732e, "audio/mp4a-latm", null, -1, -1, ((Integer) i2.second).intValue(), ((Integer) i2.first).intValue(), Collections.singletonList(a), null, 0, this.f29731d);
                this.m = 1024000000 / createAudioSampleFormat.sampleRate;
                this.f29733f.b(createAudioSampleFormat);
                this.l = true;
            } else {
                this.f29729b.n(10);
            }
            this.f29729b.n(4);
            int g4 = (this.f29729b.g(13) - 2) - 5;
            if (this.f29738k) {
                g4 -= 2;
            }
            n(this.f29733f, this.m, 0, g4);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f29734g.a(this.f29730c, 10);
            this.f29730c.J(6);
            n(this.f29734g, 0L, 10, this.f29730c.w() + 10);
        }
    }

    public final void j(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.n - this.f29736i);
            this.p.a(lVar, min);
            int i2 = this.f29736i + min;
            this.f29736i = i2;
            int i3 = this.n;
            if (i2 == i3) {
                this.p.c(this.o, 1, i3, 0, null);
                this.o += this.q;
                k();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f29735h = 0;
            this.f29736i = 0;
            this.f29737j = 256;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f29735h = 2;
            this.f29736i = 0;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f29735h = 1;
            this.f29736i = r.length;
            this.n = 0;
            this.f29730c.J(0);
        }
    }

    public final void n(c.i.b.a.a0.m mVar, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{mVar, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.f29735h = 3;
            this.f29736i = i2;
            this.p = mVar;
            this.q = j2;
            this.n = i3;
        }
    }

    public d(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f29729b = new c.i.b.a.i0.k(new byte[7]);
        this.f29730c = new c.i.b.a.i0.l(Arrays.copyOf(r, 10));
        k();
        this.a = z;
        this.f29731d = str;
    }
}
