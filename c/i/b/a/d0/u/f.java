package c.i.b.a.d0.u;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.b;
import c.i.b.a.d0.n;
import c.i.b.a.d0.o;
import c.i.b.a.d0.p;
import c.i.b.a.d0.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class f<T extends g> implements o, p, Loader.a<c>, Loader.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f29650e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f29651f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean[] f29652g;

    /* renamed from: h  reason: collision with root package name */
    public final T f29653h;

    /* renamed from: i  reason: collision with root package name */
    public final p.a<f<T>> f29654i;

    /* renamed from: j  reason: collision with root package name */
    public final b.a f29655j;

    /* renamed from: k  reason: collision with root package name */
    public final int f29656k;
    public final Loader l;
    public final e m;
    public final LinkedList<c.i.b.a.d0.u.a> n;
    public final n o;
    public final n[] p;
    public final b q;
    public Format r;
    public long s;
    public long t;
    public boolean u;

    /* loaded from: classes7.dex */
    public final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final f<T> f29657e;

        /* renamed from: f  reason: collision with root package name */
        public final n f29658f;

        /* renamed from: g  reason: collision with root package name */
        public final int f29659g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f29660h;

        public a(f fVar, f<T> fVar2, n nVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2, nVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29660h = fVar;
            this.f29657e = fVar2;
            this.f29658f = nVar;
            this.f29659g = i2;
        }

        @Override // c.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.i.b.a.i0.a.f(this.f29660h.f29652g[this.f29659g]);
                this.f29660h.f29652g[this.f29659g] = false;
            }
        }

        @Override // c.i.b.a.d0.o
        public int f(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, eVar, z)) == null) {
                if (this.f29660h.x()) {
                    return -3;
                }
                n nVar = this.f29658f;
                f fVar = this.f29660h;
                return nVar.w(lVar, eVar, z, fVar.u, fVar.t);
            }
            return invokeLLZ.intValue;
        }

        @Override // c.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                f fVar = this.f29660h;
                return fVar.u || (!fVar.x() && this.f29658f.s());
            }
            return invokeV.booleanValue;
        }

        @Override // c.i.b.a.d0.o
        public int j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (this.f29660h.u && j2 > this.f29658f.o()) {
                    return this.f29658f.g();
                }
                int f2 = this.f29658f.f(j2, true, true);
                if (f2 == -1) {
                    return 0;
                }
                return f2;
            }
            return invokeJ.intValue;
        }
    }

    public f(int i2, int[] iArr, T t, p.a<f<T>> aVar, c.i.b.a.h0.b bVar, long j2, int i3, b.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iArr, t, aVar, bVar, Long.valueOf(j2), Integer.valueOf(i3), aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29650e = i2;
        this.f29651f = iArr;
        this.f29653h = t;
        this.f29654i = aVar;
        this.f29655j = aVar2;
        this.f29656k = i3;
        this.l = new Loader("Loader:ChunkSampleStream");
        this.m = new e();
        LinkedList<c.i.b.a.d0.u.a> linkedList = new LinkedList<>();
        this.n = linkedList;
        Collections.unmodifiableList(linkedList);
        int i6 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.p = new n[length];
        this.f29652g = new boolean[length];
        int i7 = length + 1;
        int[] iArr2 = new int[i7];
        n[] nVarArr = new n[i7];
        n nVar = new n(bVar);
        this.o = nVar;
        iArr2[0] = i2;
        nVarArr[0] = nVar;
        while (i6 < length) {
            n nVar2 = new n(bVar);
            this.p[i6] = nVar2;
            int i8 = i6 + 1;
            nVarArr[i8] = nVar2;
            iArr2[i8] = iArr[i6];
            i6 = i8;
        }
        this.q = new b(iArr2, nVarArr);
        this.s = j2;
        this.t = j2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: A */
    public int n(c cVar, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            long b2 = cVar.b();
            boolean w = w(cVar);
            boolean z2 = (b2 != 0 && w && v()) ? false : true;
            if (this.f29653h.d(cVar, z2, iOException) && z2) {
                if (w) {
                    c.i.b.a.d0.u.a removeLast = this.n.removeLast();
                    c.i.b.a.i0.a.f(removeLast == cVar);
                    this.o.m(removeLast.f(0));
                    int i2 = 0;
                    while (true) {
                        n[] nVarArr = this.p;
                        if (i2 >= nVarArr.length) {
                            break;
                        }
                        n nVar = nVarArr[i2];
                        i2++;
                        nVar.m(removeLast.f(i2));
                    }
                    if (this.n.isEmpty()) {
                        this.s = this.t;
                    }
                }
                z = true;
            } else {
                z = false;
            }
            this.f29655j.j(cVar.a, cVar.f29631b, this.f29650e, cVar.f29632c, cVar.f29633d, cVar.f29634e, cVar.f29635f, cVar.f29636g, j2, j3, b2, iOException, z);
            if (z) {
                this.f29654i.j(this);
                return 2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l.j(this)) {
            return;
        }
        this.o.k();
        for (n nVar : this.p) {
            nVar.k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(long j2) {
        boolean z;
        n[] nVarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) != null) {
            return;
        }
        this.t = j2;
        if (!x()) {
            if (this.o.f(j2, true, j2 < d()) != -1) {
                z = true;
                if (!z) {
                    s(this.o.p());
                    this.o.l();
                    for (n nVar : this.p) {
                        nVar.C();
                        nVar.j(j2, true, false);
                    }
                    return;
                }
                this.s = j2;
                this.u = false;
                this.n.clear();
                if (this.l.g()) {
                    this.l.f();
                    return;
                }
                this.o.A();
                for (n nVar2 : this.p) {
                    nVar2.A();
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public f<T>.a D(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            for (int i3 = 0; i3 < this.p.length; i3++) {
                if (this.f29651f[i3] == i2) {
                    c.i.b.a.i0.a.f(!this.f29652g[i3]);
                    this.f29652g[i3] = true;
                    this.p[i3].C();
                    this.p[i3].f(j2, true, true);
                    return new a(this, this, this.p[i3], i3);
                }
            }
            throw new IllegalStateException();
        }
        return (a) invokeCommon.objValue;
    }

    @Override // c.i.b.a.d0.o
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.a();
            if (this.l.g()) {
                return;
            }
            this.f29653h.a();
        }
    }

    @Override // c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        c.i.b.a.d0.u.a last;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (this.u || this.l.g()) {
                return false;
            }
            if (x()) {
                last = null;
                j3 = this.s;
            } else {
                last = this.n.getLast();
                j3 = last.f29636g;
            }
            this.f29653h.f(last, j2, j3, this.m);
            e eVar = this.m;
            boolean z = eVar.f29649b;
            c cVar = eVar.a;
            eVar.a();
            if (z) {
                this.s = -9223372036854775807L;
                this.u = true;
                return true;
            } else if (cVar == null) {
                return false;
            } else {
                if (w(cVar)) {
                    this.s = -9223372036854775807L;
                    c.i.b.a.d0.u.a aVar = (c.i.b.a.d0.u.a) cVar;
                    aVar.h(this.q);
                    this.n.add(aVar);
                }
                this.f29655j.l(cVar.a, cVar.f29631b, this.f29650e, cVar.f29632c, cVar.f29633d, cVar.f29634e, cVar.f29635f, cVar.f29636g, this.l.k(cVar, this, this.f29656k));
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.u) {
                return Long.MIN_VALUE;
            }
            if (x()) {
                return this.s;
            }
            long j2 = this.t;
            c.i.b.a.d0.u.a last = this.n.getLast();
            if (!last.e()) {
                if (this.n.size() > 1) {
                    LinkedList<c.i.b.a.d0.u.a> linkedList = this.n;
                    last = linkedList.get(linkedList.size() - 2);
                } else {
                    last = null;
                }
            }
            if (last != null) {
                j2 = Math.max(j2, last.f29636g);
            }
            return Math.max(j2, this.o.o());
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (x()) {
                return this.s;
            }
            if (this.u) {
                return Long.MIN_VALUE;
            }
            return this.n.getLast().f29636g;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.o
    public int f(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar, eVar, z)) == null) {
            if (x()) {
                return -3;
            }
            s(this.o.p());
            int w = this.o.w(lVar, eVar, z, this.u, this.t);
            if (w == -4) {
                this.o.l();
            }
            return w;
        }
        return invokeLLZ.intValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o.A();
            for (n nVar : this.p) {
                nVar.A();
            }
        }
    }

    @Override // c.i.b.a.d0.o
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u || (!x() && this.o.s()) : invokeV.booleanValue;
    }

    @Override // c.i.b.a.d0.o
    public int j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            int i2 = 0;
            if (x()) {
                return 0;
            }
            if (this.u && j2 > this.o.o()) {
                i2 = this.o.g();
            } else {
                int f2 = this.o.f(j2, true, true);
                if (f2 != -1) {
                    i2 = f2;
                }
            }
            if (i2 > 0) {
                this.o.l();
            }
            return i2;
        }
        return invokeJ.intValue;
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.n.isEmpty()) {
            return;
        }
        while (this.n.size() > 1 && this.n.get(1).f(0) <= i2) {
            this.n.removeFirst();
        }
        c.i.b.a.d0.u.a first = this.n.getFirst();
        Format format = first.f29632c;
        if (!format.equals(this.r)) {
            this.f29655j.e(this.f29650e, format, first.f29633d, first.f29634e, first.f29635f);
        }
        this.r = format;
    }

    public void t(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048592, this, j2) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.p;
            if (i2 >= nVarArr.length) {
                return;
            }
            nVarArr[i2].j(j2, true, this.f29652g[i2]);
            i2++;
        }
    }

    public T u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f29653h : (T) invokeV.objValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        int p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.i.b.a.d0.u.a last = this.n.getLast();
            if (this.o.p() > last.f(0)) {
                return true;
            }
            int i2 = 0;
            do {
                n[] nVarArr = this.p;
                if (i2 >= nVarArr.length) {
                    return false;
                }
                p = nVarArr[i2].p();
                i2++;
            } while (p <= last.f(i2));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean w(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cVar)) == null) ? cVar instanceof c.i.b.a.d0.u.a : invokeL.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.s != -9223372036854775807L : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: y */
    public void l(c cVar, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.f29655j.f(cVar.a, cVar.f29631b, this.f29650e, cVar.f29632c, cVar.f29633d, cVar.f29634e, cVar.f29635f, cVar.f29636g, j2, j3, cVar.b());
            if (z) {
                return;
            }
            this.o.A();
            for (n nVar : this.p) {
                nVar.A();
            }
            this.f29654i.j(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: z */
    public void m(c cVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29653h.c(cVar);
            this.f29655j.h(cVar.a, cVar.f29631b, this.f29650e, cVar.f29632c, cVar.f29633d, cVar.f29634e, cVar.f29635f, cVar.f29636g, j2, j3, cVar.b());
            this.f29654i.j(this);
        }
    }
}
