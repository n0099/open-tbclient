package c.i.b.a.a0.p;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.e;
import c.i.b.a.a0.f;
import c.i.b.a.a0.g;
import c.i.b.a.a0.i;
import c.i.b.a.a0.j;
import c.i.b.a.a0.k;
import c.i.b.a.a0.m;
import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
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
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29078b;

    /* renamed from: c  reason: collision with root package name */
    public final l f29079c;

    /* renamed from: d  reason: collision with root package name */
    public final j f29080d;

    /* renamed from: e  reason: collision with root package name */
    public final i f29081e;

    /* renamed from: f  reason: collision with root package name */
    public g f29082f;

    /* renamed from: g  reason: collision with root package name */
    public m f29083g;

    /* renamed from: h  reason: collision with root package name */
    public int f29084h;

    /* renamed from: i  reason: collision with root package name */
    public Metadata f29085i;

    /* renamed from: j  reason: collision with root package name */
    public a f29086j;

    /* renamed from: k  reason: collision with root package name */
    public long f29087k;
    public long l;
    public int m;

    /* loaded from: classes7.dex */
    public interface a extends c.i.b.a.a0.l {
        long g(long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445151233, "Lc/i/b/a/a0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445151233, "Lc/i/b/a/a0/p/b;");
                return;
            }
        }
        n = v.q("Xing");
        o = v.q("Info");
        p = v.q("VBRI");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i2) {
        this(i2, -9223372036854775807L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int c(l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, lVar, i2)) == null) {
            if (lVar.d() >= i2 + 4) {
                lVar.J(i2);
                int i3 = lVar.i();
                if (i3 == n || i3 == o) {
                    return i3;
                }
            }
            if (lVar.d() >= 40) {
                lVar.J(36);
                int i4 = lVar.i();
                int i5 = p;
                if (i4 == i5) {
                    return i5;
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static boolean g(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? ((long) (i2 & (-128000))) == (j2 & (-128000)) : invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29084h = 0;
            this.f29087k = -9223372036854775807L;
            this.l = 0L;
            this.m = 0;
        }
    }

    public final a b(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            fVar.c(this.f29079c.a, 0, 4);
            this.f29079c.J(0);
            j.b(this.f29079c.i(), this.f29080d);
            return new c.i.b.a.a0.p.a(fVar.getPosition(), this.f29080d.f29020f, fVar.getLength());
        }
        return (a) invokeL.objValue;
    }

    @Override // c.i.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? k(fVar, true) : invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, kVar)) == null) {
            if (this.f29084h == 0) {
                try {
                    k(fVar, false);
                } catch (EOFException unused) {
                    return -1;
                }
            }
            if (this.f29086j == null) {
                a h2 = h(fVar);
                this.f29086j = h2;
                if (h2 == null || (!h2.b() && (this.a & 1) != 0)) {
                    this.f29086j = b(fVar);
                }
                this.f29082f.p(this.f29086j);
                m mVar = this.f29083g;
                j jVar = this.f29080d;
                String str = jVar.f29016b;
                int i2 = jVar.f29019e;
                int i3 = jVar.f29018d;
                i iVar = this.f29081e;
                mVar.b(Format.createAudioSampleFormat(null, str, null, -1, 4096, i2, i3, -1, iVar.a, iVar.f29011b, null, null, 0, null, (this.a & 2) != 0 ? null : this.f29085i));
            }
            return j(fVar);
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.f29082f = gVar;
            this.f29083g = gVar.a(0, 1);
            this.f29082f.j();
        }
    }

    public final a h(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            l lVar = new l(this.f29080d.f29017c);
            fVar.c(lVar.a, 0, this.f29080d.f29017c);
            j jVar = this.f29080d;
            int i3 = jVar.a & 1;
            int i4 = jVar.f29019e;
            if (i3 != 0) {
                if (i4 != 1) {
                    i2 = 36;
                }
                i2 = 21;
            } else {
                if (i4 == 1) {
                    i2 = 13;
                }
                i2 = 21;
            }
            int c2 = c(lVar, i2);
            if (c2 != n && c2 != o) {
                if (c2 == p) {
                    c a2 = c.a(this.f29080d, lVar, fVar.getPosition(), fVar.getLength());
                    fVar.h(this.f29080d.f29017c);
                    return a2;
                }
                fVar.e();
                return null;
            }
            d a3 = d.a(this.f29080d, lVar, fVar.getPosition(), fVar.getLength());
            if (a3 != null && !this.f29081e.a()) {
                fVar.e();
                fVar.g(i2 + 141);
                fVar.c(this.f29079c.a, 0, 3);
                this.f29079c.J(0);
                this.f29081e.d(this.f29079c.A());
            }
            fVar.h(this.f29080d.f29017c);
            return (a3 == null || a3.b() || c2 != o) ? a3 : b(fVar);
        }
        return (a) invokeL.objValue;
    }

    public final void i(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, fVar) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            fVar.c(this.f29079c.a, 0, 10);
            this.f29079c.J(0);
            if (this.f29079c.A() != c.i.b.a.c0.g.a.f29476b) {
                fVar.e();
                fVar.g(i2);
                return;
            }
            this.f29079c.K(3);
            int w = this.f29079c.w();
            int i3 = w + 10;
            if (this.f29085i == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f29079c.a, 0, bArr, 0, 10);
                fVar.c(bArr, 10, w);
                Metadata c2 = new c.i.b.a.c0.g.a((this.a & 2) != 0 ? i.f29009c : null).c(bArr, i3);
                this.f29085i = c2;
                if (c2 != null) {
                    this.f29081e.c(c2);
                }
            } else {
                fVar.g(w);
            }
            i2 += i3;
        }
    }

    public final int j(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            if (this.m == 0) {
                fVar.e();
                if (!fVar.d(this.f29079c.a, 0, 4, true)) {
                    return -1;
                }
                this.f29079c.J(0);
                int i2 = this.f29079c.i();
                if (g(i2, this.f29084h) && j.a(i2) != -1) {
                    j.b(i2, this.f29080d);
                    if (this.f29087k == -9223372036854775807L) {
                        this.f29087k = this.f29086j.g(fVar.getPosition());
                        if (this.f29078b != -9223372036854775807L) {
                            this.f29087k += this.f29078b - this.f29086j.g(0L);
                        }
                    }
                    this.m = this.f29080d.f29017c;
                } else {
                    fVar.h(1);
                    this.f29084h = 0;
                    return 0;
                }
            }
            int d2 = this.f29083g.d(fVar, this.m, true);
            if (d2 == -1) {
                return -1;
            }
            int i3 = this.m - d2;
            this.m = i3;
            if (i3 > 0) {
                return 0;
            }
            this.f29083g.c(this.f29087k + ((this.l * 1000000) / jVar.f29018d), 1, this.f29080d.f29017c, 0, null);
            this.l += this.f29080d.f29021g;
            this.m = 0;
            return 0;
        }
        return invokeL.intValue;
    }

    public final boolean k(f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        int i2;
        int i3;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, z)) == null) {
            int i4 = z ? 16384 : 131072;
            fVar.e();
            if (fVar.getPosition() == 0) {
                i(fVar);
                i3 = (int) fVar.f();
                if (!z) {
                    fVar.h(i3);
                }
                i2 = 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (!fVar.d(this.f29079c.a, 0, 4, i2 > 0)) {
                    break;
                }
                this.f29079c.J(0);
                int i7 = this.f29079c.i();
                if ((i5 == 0 || g(i7, i5)) && (a2 = j.a(i7)) != -1) {
                    i2++;
                    if (i2 != 1) {
                        if (i2 == 4) {
                            break;
                        }
                    } else {
                        j.b(i7, this.f29080d);
                        i5 = i7;
                    }
                    fVar.g(a2 - 4);
                } else {
                    int i8 = i6 + 1;
                    if (i6 == i4) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("Searched too many bytes.");
                    }
                    if (z) {
                        fVar.e();
                        fVar.g(i3 + i8);
                    } else {
                        fVar.h(1);
                    }
                    i6 = i8;
                    i2 = 0;
                    i5 = 0;
                }
            }
            if (z) {
                fVar.h(i3 + i6);
            } else {
                fVar.e();
            }
            this.f29084h = i5;
            return true;
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public b(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f29078b = j2;
        this.f29079c = new l(10);
        this.f29080d = new j();
        this.f29081e = new i();
        this.f29087k = -9223372036854775807L;
    }
}
