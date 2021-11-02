package b.i.b.a.d0.v;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.l;
import b.i.b.a.d0.u.h;
import b.i.b.a.d0.u.k;
import b.i.b.a.d0.u.m;
import b.i.b.a.d0.v.a;
import b.i.b.a.d0.v.g.g;
import b.i.b.a.h0.e;
import b.i.b.a.h0.n;
import b.i.b.a.i0.i;
import b.i.b.a.i0.v;
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
/* loaded from: classes6.dex */
public class f implements b.i.b.a.d0.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f32069a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32070b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.f0.f f32071c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32072d;

    /* renamed from: e  reason: collision with root package name */
    public final b.i.b.a.h0.e f32073e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32074f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32075g;

    /* renamed from: h  reason: collision with root package name */
    public final b[] f32076h;

    /* renamed from: i  reason: collision with root package name */
    public b.i.b.a.d0.v.g.b f32077i;
    public int j;
    public IOException k;
    public boolean l;
    public long m;

    /* loaded from: classes6.dex */
    public static final class a implements a.InterfaceC1480a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f32078a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32079b;

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

        @Override // b.i.b.a.d0.v.a.InterfaceC1480a
        public b.i.b.a.d0.v.a a(n nVar, b.i.b.a.d0.v.g.b bVar, int i2, int[] iArr, b.i.b.a.f0.f fVar, int i3, long j, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new f(nVar, bVar, i2, iArr, fVar, i3, this.f32078a.a(), j, this.f32079b, z, z2) : (b.i.b.a.d0.v.a) invokeCommon.objValue;
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
            this.f32078a = aVar;
            this.f32079b = i2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.i.b.a.d0.u.d f32080a;

        /* renamed from: b  reason: collision with root package name */
        public g f32081b;

        /* renamed from: c  reason: collision with root package name */
        public d f32082c;

        /* renamed from: d  reason: collision with root package name */
        public long f32083d;

        /* renamed from: e  reason: collision with root package name */
        public int f32084e;

        public b(long j, int i2, g gVar, boolean z, boolean z2) {
            b.i.b.a.a0.e eVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32083d = j;
            this.f32081b = gVar;
            String str = gVar.f32120a.containerMimeType;
            if (g(str)) {
                this.f32080a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new b.i.b.a.a0.s.a(gVar.f32120a);
                } else if (h(str)) {
                    eVar = new b.i.b.a.a0.o.d(1);
                } else {
                    int i5 = z ? 4 : 0;
                    eVar = new b.i.b.a.a0.q.e(z2 ? i5 | 8 : i5);
                }
                this.f32080a = new b.i.b.a.d0.u.d(eVar, i2, gVar.f32120a);
            }
            this.f32082c = gVar.i();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32082c.d() + this.f32084e : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32082c.c(this.f32083d) : invokeV.intValue;
        }

        public long c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? e(i2) + this.f32082c.a(i2 - this.f32084e, this.f32083d) : invokeI.longValue;
        }

        public int d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f32082c.b(j, this.f32083d) + this.f32084e : invokeJ.intValue;
        }

        public long e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f32082c.f(i2 - this.f32084e) : invokeI.longValue;
        }

        public b.i.b.a.d0.v.g.f f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f32082c.e(i2 - this.f32084e) : (b.i.b.a.d0.v.g.f) invokeI.objValue;
        }

        public void i(long j, g gVar) throws BehindLiveWindowException {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, gVar) == null) {
                d i2 = this.f32081b.i();
                d i3 = gVar.i();
                this.f32083d = j;
                this.f32081b = gVar;
                if (i2 == null) {
                    return;
                }
                this.f32082c = i3;
                if (i2.g() && (c2 = i2.c(this.f32083d)) != 0) {
                    int d2 = (i2.d() + c2) - 1;
                    long f2 = i2.f(d2) + i2.a(d2, this.f32083d);
                    int d3 = i3.d();
                    long f3 = i3.f(d3);
                    int i4 = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
                    if (i4 == 0) {
                        this.f32084e += (d2 + 1) - d3;
                    } else if (i4 >= 0) {
                        this.f32084e += i2.b(f3, this.f32083d) - d3;
                    } else {
                        throw new BehindLiveWindowException();
                    }
                }
            }
        }
    }

    public f(n nVar, b.i.b.a.d0.v.g.b bVar, int i2, int[] iArr, b.i.b.a.f0.f fVar, int i3, b.i.b.a.h0.e eVar, long j, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), eVar, Long.valueOf(j), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32069a = nVar;
        this.f32077i = bVar;
        this.f32070b = iArr;
        this.f32071c = fVar;
        this.f32072d = i3;
        this.f32073e = eVar;
        this.j = i2;
        this.f32074f = j;
        this.f32075g = i4;
        long d2 = bVar.d(i2);
        this.m = -9223372036854775807L;
        ArrayList<g> h2 = h();
        this.f32076h = new b[fVar.length()];
        for (int i7 = 0; i7 < this.f32076h.length; i7++) {
            this.f32076h[i7] = new b(d2, i3, h2.get(fVar.b(i7)), z, z2);
        }
    }

    public static b.i.b.a.d0.u.c i(b bVar, b.i.b.a.h0.e eVar, Format format, int i2, Object obj, b.i.b.a.d0.v.g.f fVar, b.i.b.a.d0.v.g.f fVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bVar, eVar, format, Integer.valueOf(i2), obj, fVar, fVar2})) == null) {
            String str = bVar.f32081b.f32121b;
            if (fVar == null || (fVar2 = fVar.a(fVar2, str)) != null) {
                fVar = fVar2;
            }
            return new k(eVar, new b.i.b.a.h0.g(fVar.b(str), fVar.f32116a, fVar.f32117b, bVar.f32081b.h()), format, i2, obj, bVar.f32080a);
        }
        return (b.i.b.a.d0.u.c) invokeCommon.objValue;
    }

    public static b.i.b.a.d0.u.c j(b bVar, b.i.b.a.h0.e eVar, int i2, Format format, int i3, Object obj, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bVar, eVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            g gVar = bVar.f32081b;
            long e2 = bVar.e(i4);
            b.i.b.a.d0.v.g.f f2 = bVar.f(i4);
            String str = gVar.f32121b;
            if (bVar.f32080a == null) {
                return new m(eVar, new b.i.b.a.h0.g(f2.b(str), f2.f32116a, f2.f32117b, gVar.h()), format, i3, obj, e2, bVar.c(i4), i4, i2, format);
            }
            int i6 = 1;
            int i7 = 1;
            while (i6 < i5) {
                b.i.b.a.d0.v.g.f a2 = f2.a(bVar.f(i4 + i6), str);
                if (a2 == null) {
                    break;
                }
                i7++;
                i6++;
                f2 = a2;
            }
            return new b.i.b.a.d0.u.i(eVar, new b.i.b.a.h0.g(f2.b(str), f2.f32116a, f2.f32117b, gVar.h()), format, i3, obj, e2, bVar.c((i4 + i7) - 1), i4, i7, -gVar.f32122c, bVar.f32080a);
        }
        return (b.i.b.a.d0.u.c) invokeCommon.objValue;
    }

    @Override // b.i.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                this.f32069a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // b.i.b.a.d0.u.g
    public void c(b.i.b.a.d0.u.c cVar) {
        l c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && (cVar instanceof k)) {
            b bVar = this.f32076h[this.f32071c.k(((k) cVar).f32008c)];
            if (bVar.f32082c != null || (c2 = bVar.f32080a.c()) == null) {
                return;
            }
            bVar.f32082c = new e((b.i.b.a.a0.a) c2);
        }
    }

    @Override // b.i.b.a.d0.u.g
    public boolean d(b.i.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        b bVar;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                if (!this.f32077i.f32092c && (cVar instanceof b.i.b.a.d0.u.l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (b2 = (bVar = this.f32076h[this.f32071c.k(cVar.f32008c)]).b()) != -1 && b2 != 0 && ((b.i.b.a.d0.u.l) cVar).e() > (bVar.a() + b2) - 1) {
                    this.l = true;
                    return true;
                }
                b.i.b.a.f0.f fVar = this.f32071c;
                return h.a(fVar, fVar.k(cVar.f32008c), exc);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.i.b.a.d0.v.a
    public void e(b.i.b.a.d0.v.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) {
            try {
                this.f32077i = bVar;
                this.j = i2;
                long d2 = bVar.d(i2);
                ArrayList<g> h2 = h();
                for (int i3 = 0; i3 < this.f32076h.length; i3++) {
                    this.f32076h[i3].i(d2, h2.get(this.f32071c.b(i3)));
                }
            } catch (BehindLiveWindowException e2) {
                this.k = e2;
            }
        }
    }

    @Override // b.i.b.a.d0.u.g
    public void f(b.i.b.a.d0.u.l lVar, long j, long j2, b.i.b.a.d0.u.e eVar) {
        int i2;
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.k == null) {
            this.f32071c.i(j, j2 - j, k(j));
            b bVar = this.f32076h[this.f32071c.a()];
            b.i.b.a.d0.u.d dVar = bVar.f32080a;
            if (dVar != null) {
                g gVar = bVar.f32081b;
                b.i.b.a.d0.v.g.f k = dVar.b() == null ? gVar.k() : null;
                b.i.b.a.d0.v.g.f j3 = bVar.f32082c == null ? gVar.j() : null;
                if (k != null || j3 != null) {
                    eVar.f32024a = i(bVar, this.f32073e, this.f32071c.f(), this.f32071c.l(), this.f32071c.j(), k, j3);
                    return;
                }
            }
            int b2 = bVar.b();
            boolean z = false;
            if (b2 == 0) {
                b.i.b.a.d0.v.g.b bVar2 = this.f32077i;
                eVar.f32025b = (!bVar2.f32092c || this.j < bVar2.b() - 1) ? true : true;
                return;
            }
            int a2 = bVar.a();
            if (b2 == -1) {
                long g2 = (g() - b.i.b.a.b.a(this.f32077i.f32090a)) - b.i.b.a.b.a(this.f32077i.a(this.j).f32114b);
                long j4 = this.f32077i.f32094e;
                if (j4 != -9223372036854775807L) {
                    a2 = Math.max(a2, bVar.d(g2 - b.i.b.a.b.a(j4)));
                }
                i2 = bVar.d(g2);
            } else {
                i2 = b2 + a2;
            }
            int i3 = i2 - 1;
            l(bVar, i3);
            if (lVar == null) {
                e2 = v.k(bVar.d(j2), a2, i3);
            } else {
                e2 = lVar.e();
                if (e2 < a2) {
                    this.k = new BehindLiveWindowException();
                    return;
                }
            }
            int i4 = e2;
            if (i4 <= i3 && (!this.l || i4 < i3)) {
                eVar.f32024a = j(bVar, this.f32073e, this.f32072d, this.f32071c.f(), this.f32071c.l(), this.f32071c.j(), i4, Math.min(this.f32075g, (i3 - i4) + 1));
                return;
            }
            b.i.b.a.d0.v.g.b bVar3 = this.f32077i;
            eVar.f32025b = (!bVar3.f32092c || this.j < bVar3.b() - 1) ? true : true;
        }
    }

    public final long g() {
        InterceptResult invokeV;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f32074f != 0) {
                currentTimeMillis = SystemClock.elapsedRealtime() + this.f32074f;
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
            List<b.i.b.a.d0.v.g.a> list = this.f32077i.a(this.j).f32115c;
            ArrayList<g> arrayList = new ArrayList<>();
            for (int i2 : this.f32070b) {
                arrayList.addAll(list.get(i2).f32087c);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final long k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (this.f32077i.f32092c && this.m != -9223372036854775807L) {
                return this.m - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public final void l(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) {
            this.m = this.f32077i.f32092c ? bVar.c(i2) : -9223372036854775807L;
        }
    }
}
