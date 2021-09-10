package c.i.b.a.a0.t;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
/* loaded from: classes4.dex */
public final class m implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f32865a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f32866b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.k f32867c;

    /* renamed from: d  reason: collision with root package name */
    public c.i.b.a.a0.m f32868d;

    /* renamed from: e  reason: collision with root package name */
    public Format f32869e;

    /* renamed from: f  reason: collision with root package name */
    public String f32870f;

    /* renamed from: g  reason: collision with root package name */
    public int f32871g;

    /* renamed from: h  reason: collision with root package name */
    public int f32872h;

    /* renamed from: i  reason: collision with root package name */
    public int f32873i;

    /* renamed from: j  reason: collision with root package name */
    public int f32874j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public int u;

    public m(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32865a = str;
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(1024);
        this.f32866b = lVar;
        this.f32867c = new c.i.b.a.i0.k(lVar.f33812a);
    }

    public static long a(c.i.b.a.i0.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kVar)) == null) ? kVar.g((kVar.g(2) + 1) * 8) : invokeL.longValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f32871g = 0;
            this.l = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32871g;
                if (i2 != 0) {
                    if (i2 == 1) {
                        int x = lVar.x();
                        if ((x & 224) == 224) {
                            this.f32874j = x;
                            this.f32871g = 2;
                        } else if (x != 86) {
                            this.f32871g = 0;
                        }
                    } else if (i2 == 2) {
                        int x2 = ((this.f32874j & (-225)) << 8) | lVar.x();
                        this.f32873i = x2;
                        if (x2 > this.f32866b.f33812a.length) {
                            m(x2);
                        }
                        this.f32872h = 0;
                        this.f32871g = 3;
                    } else if (i2 == 3) {
                        int min = Math.min(lVar.a(), this.f32873i - this.f32872h);
                        lVar.g(this.f32867c.f33808a, this.f32872h, min);
                        int i3 = this.f32872h + min;
                        this.f32872h = i3;
                        if (i3 == this.f32873i) {
                            this.f32867c.l(0);
                            g(this.f32867c);
                            this.f32871g = 0;
                        }
                    }
                } else if (lVar.x() == 86) {
                    this.f32871g = 1;
                }
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.k = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            this.f32868d = gVar.a(dVar.c(), 1);
            this.f32870f = dVar.b();
        }
    }

    public final void g(c.i.b.a.i0.k kVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            if (!kVar.f()) {
                this.l = true;
                l(kVar);
            } else if (!this.l) {
                return;
            }
            if (this.n == 0) {
                if (this.o == 0) {
                    k(kVar, j(kVar));
                    if (this.q) {
                        kVar.n((int) this.r);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    public final int h(c.i.b.a.i0.k kVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kVar)) == null) {
            int b2 = kVar.b();
            Pair<Integer, Integer> h2 = c.i.b.a.i0.c.h(kVar, true);
            this.s = ((Integer) h2.first).intValue();
            this.u = ((Integer) h2.second).intValue();
            return b2 - kVar.b();
        }
        return invokeL.intValue;
    }

    public final void i(c.i.b.a.i0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kVar) == null) {
            int g2 = kVar.g(3);
            this.p = g2;
            if (g2 == 0) {
                kVar.n(8);
            } else if (g2 == 1) {
                kVar.n(9);
            } else if (g2 == 3 || g2 == 4 || g2 == 5) {
                kVar.n(6);
            } else if (g2 == 6 || g2 == 7) {
                kVar.n(1);
            }
        }
    }

    public final int j(c.i.b.a.i0.k kVar) throws ParserException {
        InterceptResult invokeL;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar)) == null) {
            if (this.p == 0) {
                int i2 = 0;
                do {
                    g2 = kVar.g(8);
                    i2 += g2;
                } while (g2 == 255);
                return i2;
            }
            throw new ParserException();
        }
        return invokeL.intValue;
    }

    public final void k(c.i.b.a.i0.k kVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, kVar, i2) == null) {
            int e2 = kVar.e();
            if ((e2 & 7) == 0) {
                this.f32866b.J(e2 >> 3);
            } else {
                kVar.h(this.f32866b.f33812a, 0, i2 * 8);
                this.f32866b.J(0);
            }
            this.f32868d.a(this.f32866b, i2);
            this.f32868d.c(this.k, 1, i2, 0, null);
            this.k += this.t;
        }
    }

    public final void l(c.i.b.a.i0.k kVar) throws ParserException {
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            int g2 = kVar.g(1);
            this.m = g2;
            int g3 = g2 == 1 ? kVar.g(1) : 0;
            this.n = g3;
            if (g3 == 0) {
                if (this.m == 1) {
                    a(kVar);
                }
                if (kVar.f()) {
                    this.o = kVar.g(6);
                    int g4 = kVar.g(4);
                    int g5 = kVar.g(3);
                    if (g4 == 0 && g5 == 0) {
                        if (this.m == 0) {
                            int e2 = kVar.e();
                            int h2 = h(kVar);
                            kVar.l(e2);
                            byte[] bArr = new byte[(h2 + 7) / 8];
                            kVar.h(bArr, 0, h2);
                            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f32870f, "audio/mp4a-latm", null, -1, -1, this.u, this.s, Collections.singletonList(bArr), null, 0, this.f32865a);
                            if (!createAudioSampleFormat.equals(this.f32869e)) {
                                this.f32869e = createAudioSampleFormat;
                                this.t = 1024000000 / createAudioSampleFormat.sampleRate;
                                this.f32868d.b(createAudioSampleFormat);
                            }
                        } else {
                            kVar.n(((int) a(kVar)) - h(kVar));
                        }
                        i(kVar);
                        boolean f3 = kVar.f();
                        this.q = f3;
                        this.r = 0L;
                        if (f3) {
                            if (this.m == 1) {
                                this.r = a(kVar);
                            } else {
                                do {
                                    f2 = kVar.f();
                                    this.r = (this.r << 8) + kVar.g(8);
                                } while (f2);
                            }
                        }
                        if (kVar.f()) {
                            kVar.n(8);
                            return;
                        }
                        return;
                    }
                    throw new ParserException();
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f32866b.G(i2);
            this.f32867c.j(this.f32866b.f33812a);
        }
    }
}
