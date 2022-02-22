package c.i.b.a.d0.w;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.b;
import c.i.b.a.d0.n;
import c.i.b.a.d0.o;
import c.i.b.a.d0.p;
import c.i.b.a.d0.s;
import c.i.b.a.d0.t;
import c.i.b.a.d0.w.d;
import c.i.b.a.d0.w.o.a;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public final class l implements Loader.a<c.i.b.a.d0.u.c>, Loader.d, p, c.i.b.a.a0.g, n.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean[] A;
    public boolean[] B;
    public long C;
    public long D;
    public long E;
    public boolean F;
    public boolean G;
    public boolean H;

    /* renamed from: e  reason: collision with root package name */
    public final int f29539e;

    /* renamed from: f  reason: collision with root package name */
    public final b f29540f;

    /* renamed from: g  reason: collision with root package name */
    public final d f29541g;

    /* renamed from: h  reason: collision with root package name */
    public final c.i.b.a.h0.b f29542h;

    /* renamed from: i  reason: collision with root package name */
    public final Format f29543i;

    /* renamed from: j  reason: collision with root package name */
    public final int f29544j;
    public final Loader k;
    public final b.a l;
    public final d.b m;
    public final LinkedList<h> n;
    public final Runnable o;
    public final Handler p;
    public c.i.b.a.d0.n[] q;
    public int[] r;
    public boolean s;
    public boolean t;
    public int u;
    public Format v;
    public boolean w;
    public t x;
    public int y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f29545e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29545e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29545e.F();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b extends p.a<l> {
        void i(a.C1670a c1670a);

        void onPrepared();
    }

    public l(int i2, b bVar, d dVar, c.i.b.a.h0.b bVar2, long j2, Format format, int i3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bVar, dVar, bVar2, Long.valueOf(j2), format, Integer.valueOf(i3), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29539e = i2;
        this.f29540f = bVar;
        this.f29541g = dVar;
        this.f29542h = bVar2;
        this.f29543i = format;
        this.f29544j = i3;
        this.l = aVar;
        this.k = new Loader("Loader:HlsSampleStreamWrapper");
        this.m = new d.b();
        this.r = new int[0];
        this.q = new c.i.b.a.d0.n[0];
        this.n = new LinkedList<>();
        this.o = new a(this);
        this.p = new Handler();
        this.D = j2;
        this.E = j2;
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? z(str, 2) : (String) invokeL.objValue;
    }

    public static Format v(Format format, Format format2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, format, format2)) == null) {
            if (format == null) {
                return format2;
            }
            String str = null;
            int d2 = c.i.b.a.i0.i.d(format2.sampleMimeType);
            if (d2 == 1) {
                str = y(format.codecs);
            } else if (d2 == 2) {
                str = A(format.codecs);
            }
            return format2.copyWithContainerInfo(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return (Format) invokeLL.objValue;
    }

    public static String y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? z(str, 1) : (String) invokeL.objValue;
    }

    public static String z(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                if (i2 == c.i.b.a.i0.i.e(str2)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public void B(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (c.i.b.a.d0.n nVar : this.q) {
                nVar.F(i2);
            }
            if (z) {
                for (c.i.b.a.d0.n nVar2 : this.q) {
                    nVar2.G();
                }
            }
        }
    }

    public final boolean C(c.i.b.a.d0.u.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? cVar instanceof h : invokeL.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E != -9223372036854775807L : invokeV.booleanValue;
    }

    public boolean E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.H || (!D() && this.q[i2].s()) : invokeI.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.w || this.t || !this.s) {
            return;
        }
        for (c.i.b.a.d0.n nVar : this.q) {
            if (nVar.q() == null) {
                return;
            }
        }
        t();
        this.t = true;
        this.f29540f.onPrepared();
    }

    public void G() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.a();
            this.f29541g.e();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: H */
    public void l(c.i.b.a.d0.u.c cVar, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.l.f(cVar.a, cVar.f29381b, this.f29539e, cVar.f29382c, cVar.f29383d, cVar.f29384e, cVar.f29385f, cVar.f29386g, j2, j3, cVar.b());
            if (z) {
                return;
            }
            O();
            if (this.u > 0) {
                this.f29540f.j(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: I */
    public void m(c.i.b.a.d0.u.c cVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29541g.g(cVar);
            this.l.h(cVar.a, cVar.f29381b, this.f29539e, cVar.f29382c, cVar.f29383d, cVar.f29384e, cVar.f29385f, cVar.f29386g, j2, j3, cVar.b());
            if (!this.t) {
                b(this.D);
            } else {
                this.f29540f.j(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: J */
    public int n(c.i.b.a.d0.u.c cVar, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            long b2 = cVar.b();
            boolean C = C(cVar);
            boolean z = true;
            if (!this.f29541g.h(cVar, !C || b2 == 0, iOException)) {
                z = false;
            } else if (C) {
                c.i.b.a.i0.a.f(this.n.removeLast() == cVar);
                if (this.n.isEmpty()) {
                    this.E = this.D;
                }
            }
            this.l.j(cVar.a, cVar.f29381b, this.f29539e, cVar.f29382c, cVar.f29383d, cVar.f29384e, cVar.f29385f, cVar.f29386g, j2, j3, cVar.b(), iOException, z);
            if (z) {
                if (!this.t) {
                    b(this.D);
                    return 2;
                }
                this.f29540f.j(this);
                return 2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public void K(a.C1670a c1670a, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, c1670a, j2) == null) {
            this.f29541g.i(c1670a, j2);
        }
    }

    public void L(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, format) == null) {
            a(0, -1).b(format);
            this.s = true;
            F();
        }
    }

    public int M(int i2, c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), lVar, eVar, Boolean.valueOf(z)})) == null) {
            if (D()) {
                return -3;
            }
            int w = this.q[i2].w(lVar, eVar, z, this.H, this.D);
            if (w == -4) {
                w();
            }
            return w;
        }
        return invokeCommon.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean j2 = this.k.j(this);
            if (this.t && !j2) {
                for (c.i.b.a.d0.n nVar : this.q) {
                    nVar.k();
                }
            }
            this.p.removeCallbacksAndMessages(null);
            this.w = true;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (c.i.b.a.d0.n nVar : this.q) {
                nVar.B(this.F);
            }
            this.F = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048590, this, j2)) != null) {
            return invokeJ.booleanValue;
        }
        int length = this.q.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            c.i.b.a.d0.n nVar = this.q[i2];
            nVar.C();
            if ((nVar.f(j2, true, false) != -1) || (!this.B[i2] && this.z)) {
                nVar.l();
                i2++;
            }
        }
    }

    public boolean Q(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            this.D = j2;
            if (z || D() || !P(j2)) {
                this.E = j2;
                this.H = false;
                this.n.clear();
                if (this.k.g()) {
                    this.k.f();
                    return true;
                }
                O();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean R(c.i.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            c.i.b.a.i0.a.f(this.t);
            int i2 = this.u;
            int i3 = 0;
            for (int i4 = 0; i4 < fVarArr.length; i4++) {
                if (oVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                    U(((k) oVarArr[i4]).f29537e, false);
                    oVarArr[i4] = null;
                }
            }
            boolean z4 = z || (!this.G ? j2 == this.D : i2 != 0);
            c.i.b.a.f0.f d2 = this.f29541g.d();
            boolean z5 = z4;
            c.i.b.a.f0.f fVar = d2;
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                if (oVarArr[i5] == null && fVarArr[i5] != null) {
                    c.i.b.a.f0.f fVar2 = fVarArr[i5];
                    int b2 = this.x.b(fVar2.d());
                    U(b2, true);
                    if (b2 == this.y) {
                        this.f29541g.l(fVar2);
                        fVar = fVar2;
                    }
                    oVarArr[i5] = new k(this, b2);
                    zArr2[i5] = true;
                    if (!z5) {
                        c.i.b.a.d0.n nVar = this.q[b2];
                        nVar.C();
                        z5 = nVar.f(j2, true, true) == -1 && nVar.p() != 0;
                    }
                }
            }
            if (this.u == 0) {
                this.f29541g.j();
                this.v = null;
                this.n.clear();
                if (this.k.g()) {
                    c.i.b.a.d0.n[] nVarArr = this.q;
                    int length = nVarArr.length;
                    while (i3 < length) {
                        nVarArr[i3].k();
                        i3++;
                    }
                    this.k.f();
                } else {
                    O();
                }
            } else {
                if (!this.n.isEmpty() && !v.a(fVar, d2)) {
                    if (!this.G) {
                        fVar.i(j2, j2 < 0 ? -j2 : 0L, -9223372036854775807L);
                        if (fVar.e() == this.f29541g.c().b(this.n.getLast().f29382c)) {
                            z3 = false;
                            if (z3) {
                                this.F = true;
                                z2 = true;
                                z5 = true;
                                if (z5) {
                                    Q(j2, z2);
                                    while (i3 < oVarArr.length) {
                                        if (oVarArr[i3] != null) {
                                            zArr2[i3] = true;
                                        }
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                z2 = z;
                if (z5) {
                }
            }
            this.G = true;
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f29541g.n(z);
        }
    }

    public void T(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.C = j2;
            for (c.i.b.a.d0.n nVar : this.q) {
                nVar.D(j2);
            }
        }
    }

    public final void U(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.i.b.a.i0.a.f(this.A[i2] != z);
            this.A[i2] = z;
            this.u += z ? 1 : -1;
        }
    }

    public int V(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = 0;
            if (D()) {
                return 0;
            }
            c.i.b.a.d0.n nVar = this.q[i2];
            if (this.H && j2 > nVar.o()) {
                i3 = nVar.g();
            } else {
                int f2 = nVar.f(j2, true, true);
                if (f2 != -1) {
                    i3 = f2;
                }
            }
            if (i3 > 0) {
                w();
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.a0.g
    /* renamed from: W */
    public c.i.b.a.d0.n a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i2, i3)) == null) {
            int length = this.q.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.r[i4] == i2) {
                    return this.q[i4];
                }
            }
            c.i.b.a.d0.n nVar = new c.i.b.a.d0.n(this.f29542h);
            nVar.D(this.C);
            nVar.E(this);
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.r, i5);
            this.r = copyOf;
            copyOf[length] = i2;
            c.i.b.a.d0.n[] nVarArr = (c.i.b.a.d0.n[]) Arrays.copyOf(this.q, i5);
            this.q = nVarArr;
            nVarArr[length] = nVar;
            return nVar;
        }
        return (c.i.b.a.d0.n) invokeII.objValue;
    }

    @Override // c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        h last;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            if (this.H || this.k.g()) {
                return false;
            }
            if (D()) {
                last = null;
                j3 = this.E;
            } else {
                last = this.n.getLast();
                j3 = last.f29386g;
            }
            this.f29541g.b(last, j2, j3, this.m);
            d.b bVar = this.m;
            boolean z = bVar.f29521b;
            c.i.b.a.d0.u.c cVar = bVar.a;
            a.C1670a c1670a = bVar.f29522c;
            bVar.a();
            if (z) {
                this.E = -9223372036854775807L;
                this.H = true;
                return true;
            } else if (cVar == null) {
                if (c1670a != null) {
                    this.f29540f.i(c1670a);
                }
                return false;
            } else {
                if (C(cVar)) {
                    this.E = -9223372036854775807L;
                    h hVar = (h) cVar;
                    hVar.g(this);
                    this.n.add(hVar);
                }
                this.l.l(cVar.a, cVar.f29381b, this.f29539e, cVar.f29382c, cVar.f29383d, cVar.f29384e, cVar.f29385f, cVar.f29386g, this.k.k(cVar, this, this.f29544j));
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        LinkedList<h> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.H) {
                return Long.MIN_VALUE;
            }
            if (D()) {
                return this.E;
            }
            long j2 = this.D;
            h last = this.n.getLast();
            if (!last.e()) {
                last = this.n.size() > 1 ? this.n.get(linkedList.size() - 2) : null;
            }
            if (last != null) {
                j2 = Math.max(j2, last.f29386g);
            }
            for (c.i.b.a.d0.n nVar : this.q) {
                j2 = Math.max(j2, nVar.o());
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (D()) {
                return this.E;
            }
            if (this.H) {
                return Long.MIN_VALUE;
            }
            return this.n.getLast().f29386g;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.n.b
    public void f(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, format) == null) {
            this.p.post(this.o);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            O();
        }
    }

    @Override // c.i.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.s = true;
            this.p.post(this.o);
        }
    }

    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x : (t) invokeV.objValue;
    }

    @Override // c.i.b.a.a0.g
    public void p(c.i.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, lVar) == null) {
        }
    }

    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            G();
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j2) == null) {
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.q[i2].j(j2, false, this.A[i2]);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int length = this.q.length;
            int i2 = 0;
            char c2 = 0;
            int i3 = -1;
            while (true) {
                char c3 = 3;
                if (i2 >= length) {
                    break;
                }
                String str = this.q[i2].q().sampleMimeType;
                if (!c.i.b.a.i0.i.i(str)) {
                    if (c.i.b.a.i0.i.g(str)) {
                        c3 = 2;
                    } else {
                        c3 = c.i.b.a.i0.i.h(str) ? (char) 1 : (char) 0;
                    }
                }
                if (c3 > c2) {
                    i3 = i2;
                    c2 = c3;
                } else if (c3 == c2 && i3 != -1) {
                    i3 = -1;
                }
                i2++;
            }
            s c4 = this.f29541g.c();
            int i4 = c4.a;
            this.y = -1;
            this.A = new boolean[length];
            this.B = new boolean[length];
            s[] sVarArr = new s[length];
            for (int i5 = 0; i5 < length; i5++) {
                Format q = this.q[i5].q();
                String str2 = q.sampleMimeType;
                boolean z = c.i.b.a.i0.i.i(str2) || c.i.b.a.i0.i.g(str2);
                this.B[i5] = z;
                this.z = z | this.z;
                if (i5 == i3) {
                    Format[] formatArr = new Format[i4];
                    for (int i6 = 0; i6 < i4; i6++) {
                        formatArr[i6] = v(c4.a(i6), q);
                    }
                    sVarArr[i5] = new s(formatArr);
                    this.y = i5;
                } else {
                    sVarArr[i5] = new s(v((c2 == 3 && c.i.b.a.i0.i.g(q.sampleMimeType)) ? this.f29543i : null, q));
                }
            }
            this.x = new t(sVarArr);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.t) {
            return;
        }
        b(this.D);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.n.isEmpty()) {
            return;
        }
        while (this.n.size() > 1 && x(this.n.getFirst())) {
            this.n.removeFirst();
        }
        h first = this.n.getFirst();
        Format format = first.f29382c;
        if (!format.equals(this.v)) {
            this.l.e(this.f29539e, format, first.f29383d, first.f29384e, first.f29385f);
        }
        this.v = format;
    }

    public final boolean x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048615, this, hVar)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = hVar.f29524j;
        int i3 = 0;
        while (true) {
            c.i.b.a.d0.n[] nVarArr = this.q;
            if (i3 >= nVarArr.length) {
                return true;
            }
            if (this.A[i3] && nVarArr[i3].t() == i2) {
                return false;
            }
            i3++;
        }
    }
}
