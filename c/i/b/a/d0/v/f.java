package c.i.b.a.d0.v;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.l;
import c.i.b.a.d0.u.h;
import c.i.b.a.d0.u.k;
import c.i.b.a.d0.u.m;
import c.i.b.a.d0.v.a;
import c.i.b.a.d0.v.g.g;
import c.i.b.a.h0.e;
import c.i.b.a.h0.n;
import c.i.b.a.i0.i;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements c.i.b.a.d0.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f33235a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f33236b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.f0.f f33237c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33238d;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.h0.e f33239e;

    /* renamed from: f  reason: collision with root package name */
    public final long f33240f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33241g;

    /* renamed from: h  reason: collision with root package name */
    public final b[] f33242h;

    /* renamed from: i  reason: collision with root package name */
    public c.i.b.a.d0.v.g.b f33243i;

    /* renamed from: j  reason: collision with root package name */
    public int f33244j;
    public IOException k;
    public boolean l;
    public long m;

    /* loaded from: classes4.dex */
    public static final class a implements a.InterfaceC1484a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f33245a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33246b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(e.a aVar) {
            this(aVar, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((e.a) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.i.b.a.d0.v.a.InterfaceC1484a
        public c.i.b.a.d0.v.a a(n nVar, c.i.b.a.d0.v.g.b bVar, int i2, int[] iArr, c.i.b.a.f0.f fVar, int i3, long j2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new f(nVar, bVar, i2, iArr, fVar, i3, this.f33245a.a(), j2, this.f33246b, z, z2) : (c.i.b.a.d0.v.a) invokeCommon.objValue;
        }

        public a(e.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33245a = aVar;
            this.f33246b = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.d0.u.d f33247a;

        /* renamed from: b  reason: collision with root package name */
        public g f33248b;

        /* renamed from: c  reason: collision with root package name */
        public d f33249c;

        /* renamed from: d  reason: collision with root package name */
        public long f33250d;

        /* renamed from: e  reason: collision with root package name */
        public int f33251e;

        public b(long j2, int i2, g gVar, boolean z, boolean z2) {
            c.i.b.a.a0.e eVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33250d = j2;
            this.f33248b = gVar;
            String str = gVar.f33287a.containerMimeType;
            if (g(str)) {
                this.f33247a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new c.i.b.a.a0.s.a(gVar.f33287a);
                } else if (h(str)) {
                    eVar = new c.i.b.a.a0.o.d(1);
                } else {
                    int i5 = z ? 4 : 0;
                    eVar = new c.i.b.a.a0.q.e(z2 ? i5 | 8 : i5);
                }
                this.f33247a = new c.i.b.a.d0.u.d(eVar, i2, gVar.f33287a);
            }
            this.f33249c = gVar.i();
        }

        public static boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? i.h(str) || "application/ttml+xml".equals(str) : invokeL.booleanValue;
        }

        public static boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") : invokeL.booleanValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33249c.d() + this.f33251e : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33249c.c(this.f33250d) : invokeV.intValue;
        }

        public long c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? e(i2) + this.f33249c.a(i2 - this.f33251e, this.f33250d) : invokeI.longValue;
        }

        public int d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? this.f33249c.b(j2, this.f33250d) + this.f33251e : invokeJ.intValue;
        }

        public long e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f33249c.f(i2 - this.f33251e) : invokeI.longValue;
        }

        public c.i.b.a.d0.v.g.f f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f33249c.e(i2 - this.f33251e) : (c.i.b.a.d0.v.g.f) invokeI.objValue;
        }

        public void i(long j2, g gVar) throws BehindLiveWindowException {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j2, gVar) == null) {
                d i2 = this.f33248b.i();
                d i3 = gVar.i();
                this.f33250d = j2;
                this.f33248b = gVar;
                if (i2 == null) {
                    return;
                }
                this.f33249c = i3;
                if (i2.g() && (c2 = i2.c(this.f33250d)) != 0) {
                    int d2 = (i2.d() + c2) - 1;
                    long f2 = i2.f(d2) + i2.a(d2, this.f33250d);
                    int d3 = i3.d();
                    long f3 = i3.f(d3);
                    int i4 = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
                    if (i4 == 0) {
                        this.f33251e += (d2 + 1) - d3;
                    } else if (i4 >= 0) {
                        this.f33251e += i2.b(f3, this.f33250d) - d3;
                    } else {
                        throw new BehindLiveWindowException();
                    }
                }
            }
        }
    }

    public f(n nVar, c.i.b.a.d0.v.g.b bVar, int i2, int[] iArr, c.i.b.a.f0.f fVar, int i3, c.i.b.a.h0.e eVar, long j2, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), eVar, Long.valueOf(j2), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33235a = nVar;
        this.f33243i = bVar;
        this.f33236b = iArr;
        this.f33237c = fVar;
        this.f33238d = i3;
        this.f33239e = eVar;
        this.f33244j = i2;
        this.f33240f = j2;
        this.f33241g = i4;
        long d2 = bVar.d(i2);
        this.m = -9223372036854775807L;
        ArrayList<g> h2 = h();
        this.f33242h = new b[fVar.length()];
        for (int i7 = 0; i7 < this.f33242h.length; i7++) {
            this.f33242h[i7] = new b(d2, i3, h2.get(fVar.b(i7)), z, z2);
        }
    }

    public static c.i.b.a.d0.u.c i(b bVar, c.i.b.a.h0.e eVar, Format format, int i2, Object obj, c.i.b.a.d0.v.g.f fVar, c.i.b.a.d0.v.g.f fVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bVar, eVar, format, Integer.valueOf(i2), obj, fVar, fVar2})) == null) {
            String str = bVar.f33248b.f33288b;
            if (fVar == null || (fVar2 = fVar.a(fVar2, str)) != null) {
                fVar = fVar2;
            }
            return new k(eVar, new c.i.b.a.h0.g(fVar.b(str), fVar.f33283a, fVar.f33284b, bVar.f33248b.h()), format, i2, obj, bVar.f33247a);
        }
        return (c.i.b.a.d0.u.c) invokeCommon.objValue;
    }

    public static c.i.b.a.d0.u.c j(b bVar, c.i.b.a.h0.e eVar, int i2, Format format, int i3, Object obj, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bVar, eVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            g gVar = bVar.f33248b;
            long e2 = bVar.e(i4);
            c.i.b.a.d0.v.g.f f2 = bVar.f(i4);
            String str = gVar.f33288b;
            if (bVar.f33247a == null) {
                return new m(eVar, new c.i.b.a.h0.g(f2.b(str), f2.f33283a, f2.f33284b, gVar.h()), format, i3, obj, e2, bVar.c(i4), i4, i2, format);
            }
            int i6 = 1;
            int i7 = 1;
            while (i6 < i5) {
                c.i.b.a.d0.v.g.f a2 = f2.a(bVar.f(i4 + i6), str);
                if (a2 == null) {
                    break;
                }
                i7++;
                i6++;
                f2 = a2;
            }
            return new c.i.b.a.d0.u.i(eVar, new c.i.b.a.h0.g(f2.b(str), f2.f33283a, f2.f33284b, gVar.h()), format, i3, obj, e2, bVar.c((i4 + i7) - 1), i4, i7, -gVar.f33289c, bVar.f33247a);
        }
        return (c.i.b.a.d0.u.c) invokeCommon.objValue;
    }

    @Override // c.i.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                this.f33235a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // c.i.b.a.d0.u.g
    public void c(c.i.b.a.d0.u.c cVar) {
        l c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && (cVar instanceof k)) {
            b bVar = this.f33242h[this.f33237c.k(((k) cVar).f33168c)];
            if (bVar.f33249c != null || (c2 = bVar.f33247a.c()) == null) {
                return;
            }
            bVar.f33249c = new e((c.i.b.a.a0.a) c2);
        }
    }

    @Override // c.i.b.a.d0.u.g
    public boolean d(c.i.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        b bVar;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                if (!this.f33243i.f33259c && (cVar instanceof c.i.b.a.d0.u.l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (b2 = (bVar = this.f33242h[this.f33237c.k(cVar.f33168c)]).b()) != -1 && b2 != 0 && ((c.i.b.a.d0.u.l) cVar).e() > (bVar.a() + b2) - 1) {
                    this.l = true;
                    return true;
                }
                c.i.b.a.f0.f fVar = this.f33237c;
                return h.a(fVar, fVar.k(cVar.f33168c), exc);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.d0.v.a
    public void e(c.i.b.a.d0.v.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) {
            try {
                this.f33243i = bVar;
                this.f33244j = i2;
                long d2 = bVar.d(i2);
                ArrayList<g> h2 = h();
                for (int i3 = 0; i3 < this.f33242h.length; i3++) {
                    this.f33242h[i3].i(d2, h2.get(this.f33237c.b(i3)));
                }
            } catch (BehindLiveWindowException e2) {
                this.k = e2;
            }
        }
    }

    @Override // c.i.b.a.d0.u.g
    public void f(c.i.b.a.d0.u.l lVar, long j2, long j3, c.i.b.a.d0.u.e eVar) {
        int i2;
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j2), Long.valueOf(j3), eVar}) == null) && this.k == null) {
            this.f33237c.i(j2, j3 - j2, k(j2));
            b bVar = this.f33242h[this.f33237c.a()];
            c.i.b.a.d0.u.d dVar = bVar.f33247a;
            if (dVar != null) {
                g gVar = bVar.f33248b;
                c.i.b.a.d0.v.g.f k = dVar.b() == null ? gVar.k() : null;
                c.i.b.a.d0.v.g.f j4 = bVar.f33249c == null ? gVar.j() : null;
                if (k != null || j4 != null) {
                    eVar.f33185a = i(bVar, this.f33239e, this.f33237c.f(), this.f33237c.l(), this.f33237c.j(), k, j4);
                    return;
                }
            }
            int b2 = bVar.b();
            boolean z = false;
            if (b2 == 0) {
                c.i.b.a.d0.v.g.b bVar2 = this.f33243i;
                eVar.f33186b = (!bVar2.f33259c || this.f33244j < bVar2.b() - 1) ? true : true;
                return;
            }
            int a2 = bVar.a();
            if (b2 == -1) {
                long g2 = (g() - c.i.b.a.b.a(this.f33243i.f33257a)) - c.i.b.a.b.a(this.f33243i.a(this.f33244j).f33281b);
                long j5 = this.f33243i.f33261e;
                if (j5 != -9223372036854775807L) {
                    a2 = Math.max(a2, bVar.d(g2 - c.i.b.a.b.a(j5)));
                }
                i2 = bVar.d(g2);
            } else {
                i2 = b2 + a2;
            }
            int i3 = i2 - 1;
            l(bVar, i3);
            if (lVar == null) {
                e2 = v.k(bVar.d(j3), a2, i3);
            } else {
                e2 = lVar.e();
                if (e2 < a2) {
                    this.k = new BehindLiveWindowException();
                    return;
                }
            }
            int i4 = e2;
            if (i4 <= i3 && (!this.l || i4 < i3)) {
                eVar.f33185a = j(bVar, this.f33239e, this.f33238d, this.f33237c.f(), this.f33237c.l(), this.f33237c.j(), i4, Math.min(this.f33241g, (i3 - i4) + 1));
                return;
            }
            c.i.b.a.d0.v.g.b bVar3 = this.f33243i;
            eVar.f33186b = (!bVar3.f33259c || this.f33244j < bVar3.b() - 1) ? true : true;
        }
    }

    public final long g() {
        InterceptResult invokeV;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f33240f != 0) {
                currentTimeMillis = SystemClock.elapsedRealtime() + this.f33240f;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            return currentTimeMillis * 1000;
        }
        return invokeV.longValue;
    }

    public final ArrayList<g> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<c.i.b.a.d0.v.g.a> list = this.f33243i.a(this.f33244j).f33282c;
            ArrayList<g> arrayList = new ArrayList<>();
            for (int i2 : this.f33236b) {
                arrayList.addAll(list.get(i2).f33254c);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final long k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            if (this.f33243i.f33259c && this.m != -9223372036854775807L) {
                return this.m - j2;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public final void l(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) {
            this.m = this.f33243i.f33259c ? bVar.c(i2) : -9223372036854775807L;
        }
    }
}
