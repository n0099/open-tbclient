package b.i.b.a.a0.t;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.t.w;
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
/* loaded from: classes6.dex */
public final class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31658a;

    /* renamed from: b  reason: collision with root package name */
    public final b.i.b.a.i0.k f31659b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.i0.l f31660c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31661d;

    /* renamed from: e  reason: collision with root package name */
    public String f31662e;

    /* renamed from: f  reason: collision with root package name */
    public b.i.b.a.a0.m f31663f;

    /* renamed from: g  reason: collision with root package name */
    public b.i.b.a.a0.m f31664g;

    /* renamed from: h  reason: collision with root package name */
    public int f31665h;

    /* renamed from: i  reason: collision with root package name */
    public int f31666i;
    public int j;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public b.i.b.a.a0.m p;
    public long q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952583816, "Lb/i/b/a/a0/t/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952583816, "Lb/i/b/a/a0/t/d;");
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

    public final boolean a(b.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f31666i);
            lVar.g(bArr, this.f31666i, min);
            int i3 = this.f31666i + min;
            this.f31666i = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k();
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f31665h;
                if (i2 == 0) {
                    g(lVar);
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        if (a(lVar, this.f31659b.f32631a, this.k ? 7 : 5)) {
                            h();
                        }
                    } else if (i2 == 3) {
                        j(lVar);
                    }
                } else if (a(lVar, this.f31660c.f32635a, 10)) {
                    i();
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
            this.o = j;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f31662e = dVar.b();
            this.f31663f = gVar.a(dVar.c(), 1);
            if (this.f31658a) {
                dVar.a();
                b.i.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
                this.f31664g = a2;
                a2.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
                return;
            }
            this.f31664g = new b.i.b.a.a0.d();
        }
    }

    public final void g(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            byte[] bArr = lVar.f32635a;
            int c2 = lVar.c();
            int d2 = lVar.d();
            while (c2 < d2) {
                int i2 = c2 + 1;
                int i3 = bArr[c2] & 255;
                if (this.j == 512 && i3 >= 240 && i3 != 255) {
                    this.k = (i3 & 1) == 0;
                    l();
                    lVar.J(i2);
                    return;
                }
                int i4 = this.j;
                int i5 = i3 | i4;
                if (i5 == 329) {
                    this.j = 768;
                } else if (i5 == 511) {
                    this.j = 512;
                } else if (i5 == 836) {
                    this.j = 1024;
                } else if (i5 == 1075) {
                    m();
                    lVar.J(i2);
                    return;
                } else if (i4 != 256) {
                    this.j = 256;
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
            this.f31659b.l(0);
            if (!this.l) {
                int g2 = this.f31659b.g(2) + 1;
                if (g2 != 2) {
                    String str = "Detected audio object type: " + g2 + ", but assuming AAC LC.";
                    g2 = 2;
                }
                int g3 = this.f31659b.g(4);
                this.f31659b.n(1);
                byte[] a2 = b.i.b.a.i0.c.a(g2, g3, this.f31659b.g(3));
                Pair<Integer, Integer> i2 = b.i.b.a.i0.c.i(a2);
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f31662e, "audio/mp4a-latm", null, -1, -1, ((Integer) i2.second).intValue(), ((Integer) i2.first).intValue(), Collections.singletonList(a2), null, 0, this.f31661d);
                this.m = 1024000000 / createAudioSampleFormat.sampleRate;
                this.f31663f.b(createAudioSampleFormat);
                this.l = true;
            } else {
                this.f31659b.n(10);
            }
            this.f31659b.n(4);
            int g4 = (this.f31659b.g(13) - 2) - 5;
            if (this.k) {
                g4 -= 2;
            }
            n(this.f31663f, this.m, 0, g4);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f31664g.a(this.f31660c, 10);
            this.f31660c.J(6);
            n(this.f31664g, 0L, 10, this.f31660c.w() + 10);
        }
    }

    public final void j(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.n - this.f31666i);
            this.p.a(lVar, min);
            int i2 = this.f31666i + min;
            this.f31666i = i2;
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
            this.f31665h = 0;
            this.f31666i = 0;
            this.j = 256;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f31665h = 2;
            this.f31666i = 0;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f31665h = 1;
            this.f31666i = r.length;
            this.n = 0;
            this.f31660c.J(0);
        }
    }

    public final void n(b.i.b.a.a0.m mVar, long j, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{mVar, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.f31665h = 3;
            this.f31666i = i2;
            this.p = mVar;
            this.q = j;
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
        this.f31659b = new b.i.b.a.i0.k(new byte[7]);
        this.f31660c = new b.i.b.a.i0.l(Arrays.copyOf(r, 10));
        k();
        this.f31658a = z;
        this.f31661d = str;
    }
}
