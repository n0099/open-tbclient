package b.h.b.a.a0.q;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.a0.q.a;
import b.h.b.a.i0.v;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class g implements b.h.b.a.a0.e, b.h.b.a.a0.l {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32387a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.i0.l f32388b;

    /* renamed from: c  reason: collision with root package name */
    public final b.h.b.a.i0.l f32389c;

    /* renamed from: d  reason: collision with root package name */
    public final b.h.b.a.i0.l f32390d;

    /* renamed from: e  reason: collision with root package name */
    public final Stack<a.C1516a> f32391e;

    /* renamed from: f  reason: collision with root package name */
    public int f32392f;

    /* renamed from: g  reason: collision with root package name */
    public int f32393g;

    /* renamed from: h  reason: collision with root package name */
    public long f32394h;

    /* renamed from: i  reason: collision with root package name */
    public int f32395i;
    public b.h.b.a.i0.l j;
    public int k;
    public int l;
    public b.h.b.a.a0.g m;
    public a[] n;
    public long o;
    public boolean p;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final j f32396a;

        /* renamed from: b  reason: collision with root package name */
        public final m f32397b;

        /* renamed from: c  reason: collision with root package name */
        public final b.h.b.a.a0.m f32398c;

        /* renamed from: d  reason: collision with root package name */
        public int f32399d;

        public a(j jVar, m mVar, b.h.b.a.a0.m mVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, mVar, mVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32396a = jVar;
            this.f32397b = mVar;
            this.f32398c = mVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1659270089, "Lb/h/b/a/a0/q/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1659270089, "Lb/h/b/a/a0/q/g;");
                return;
            }
        }
        q = v.q("qt  ");
    }

    public g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32387a = i2;
        this.f32390d = new b.h.b.a.i0.l(16);
        this.f32391e = new Stack<>();
        this.f32388b = new b.h.b.a.i0.l(b.h.b.a.i0.j.f33473a);
        this.f32389c = new b.h.b.a.i0.l(4);
    }

    public static boolean l(b.h.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            lVar.J(8);
            if (lVar.i() == q) {
                return true;
            }
            lVar.K(4);
            while (lVar.a() > 0) {
                if (lVar.i() == q) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == b.h.b.a.a0.q.a.C || i2 == b.h.b.a.a0.q.a.E || i2 == b.h.b.a.a0.q.a.F || i2 == b.h.b.a.a0.q.a.G || i2 == b.h.b.a.a0.q.a.H || i2 == b.h.b.a.a0.q.a.Q : invokeI.booleanValue;
    }

    public static boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == b.h.b.a.a0.q.a.S || i2 == b.h.b.a.a0.q.a.D || i2 == b.h.b.a.a0.q.a.T || i2 == b.h.b.a.a0.q.a.U || i2 == b.h.b.a.a0.q.a.m0 || i2 == b.h.b.a.a0.q.a.n0 || i2 == b.h.b.a.a0.q.a.o0 || i2 == b.h.b.a.a0.q.a.R || i2 == b.h.b.a.a0.q.a.p0 || i2 == b.h.b.a.a0.q.a.q0 || i2 == b.h.b.a.a0.q.a.r0 || i2 == b.h.b.a.a0.q.a.s0 || i2 == b.h.b.a.a0.q.a.t0 || i2 == b.h.b.a.a0.q.a.P || i2 == b.h.b.a.a0.q.a.f32311b || i2 == b.h.b.a.a0.q.a.A0 : invokeI.booleanValue;
    }

    @Override // b.h.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f32391e.clear();
            this.f32395i = 0;
            this.k = 0;
            this.l = 0;
            if (j == 0) {
                i();
            } else if (this.n != null) {
                s(j2);
            }
        }
    }

    @Override // b.h.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.h.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            long j2 = Long.MAX_VALUE;
            for (a aVar : this.n) {
                m mVar = aVar.f32397b;
                int a2 = mVar.a(j);
                if (a2 == -1) {
                    a2 = mVar.b(j);
                }
                long j3 = mVar.f32425b[a2];
                if (j3 < j2) {
                    j2 = j3;
                }
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // b.h.b.a.a0.e
    public boolean d(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? i.d(fVar) : invokeL.booleanValue;
    }

    @Override // b.h.b.a.a0.e
    public int e(b.h.b.a.a0.f fVar, b.h.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f32392f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return p(fVar, kVar);
                    }
                    throw new IllegalStateException();
                } else if (o(fVar, kVar)) {
                    return 1;
                }
            } else if (!n(fVar)) {
                return -1;
            }
        }
    }

    @Override // b.h.b.a.a0.e
    public void f(b.h.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.m = gVar;
        }
    }

    @Override // b.h.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.longValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f32392f = 0;
            this.f32395i = 0;
        }
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = -1;
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.n;
            if (i3 >= aVarArr.length) {
                return i2;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.f32399d;
            m mVar = aVar.f32397b;
            if (i4 != mVar.f32424a) {
                long j2 = mVar.f32425b[i4];
                if (j2 < j) {
                    i2 = i3;
                    j = j2;
                }
            }
            i3++;
        }
    }

    public final void k(long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            while (!this.f32391e.isEmpty() && this.f32391e.peek().P0 == j) {
                a.C1516a pop = this.f32391e.pop();
                if (pop.f32319a == b.h.b.a.a0.q.a.C) {
                    m(pop);
                    this.f32391e.clear();
                    this.f32392f = 2;
                } else if (!this.f32391e.isEmpty()) {
                    this.f32391e.peek().d(pop);
                }
            }
            if (this.f32392f != 2) {
                i();
            }
        }
    }

    public final void m(a.C1516a c1516a) throws ParserException {
        Metadata metadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c1516a) == null) {
            ArrayList arrayList = new ArrayList();
            b.h.b.a.a0.i iVar = new b.h.b.a.a0.i();
            a.b g2 = c1516a.g(b.h.b.a.a0.q.a.A0);
            if (g2 != null) {
                metadata = b.u(g2, this.p);
                if (metadata != null) {
                    iVar.c(metadata);
                }
            } else {
                metadata = null;
            }
            long j = -9223372036854775807L;
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < c1516a.R0.size(); i2++) {
                a.C1516a c1516a2 = c1516a.R0.get(i2);
                if (c1516a2.f32319a == b.h.b.a.a0.q.a.E) {
                    j t = b.t(c1516a2, c1516a.g(b.h.b.a.a0.q.a.D), -9223372036854775807L, null, (this.f32387a & 1) != 0, this.p);
                    if (t != null) {
                        m p = b.p(t, c1516a2.f(b.h.b.a.a0.q.a.F).f(b.h.b.a.a0.q.a.G).f(b.h.b.a.a0.q.a.H), iVar);
                        if (p.f32424a != 0) {
                            a aVar = new a(t, p, this.m.a(i2, t.f32403b));
                            Format copyWithMaxInputSize = t.f32407f.copyWithMaxInputSize(p.f32427d + 30);
                            if (t.f32403b == 1) {
                                if (iVar.a()) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(iVar.f32220a, iVar.f32221b);
                                }
                                if (metadata != null) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                                }
                            }
                            aVar.f32398c.b(copyWithMaxInputSize);
                            long max = Math.max(j, t.f32406e);
                            arrayList.add(aVar);
                            long j3 = p.f32425b[0];
                            if (j3 < j2) {
                                j = max;
                                j2 = j3;
                            } else {
                                j = max;
                            }
                        }
                    }
                }
            }
            this.o = j;
            this.n = (a[]) arrayList.toArray(new a[arrayList.size()]);
            this.m.j();
            this.m.p(this);
        }
    }

    public final boolean n(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
            if (this.f32395i == 0) {
                if (!fVar.a(this.f32390d.f33493a, 0, 8, true)) {
                    return false;
                }
                this.f32395i = 8;
                this.f32390d.J(0);
                this.f32394h = this.f32390d.z();
                this.f32393g = this.f32390d.i();
            }
            long j = this.f32394h;
            if (j == 1) {
                fVar.readFully(this.f32390d.f33493a, 8, 8);
                this.f32395i += 8;
                this.f32394h = this.f32390d.C();
            } else if (j == 0) {
                long length = fVar.getLength();
                if (length == -1 && !this.f32391e.isEmpty()) {
                    length = this.f32391e.peek().P0;
                }
                if (length != -1) {
                    this.f32394h = (length - fVar.getPosition()) + this.f32395i;
                }
            }
            if (this.f32394h >= this.f32395i) {
                if (q(this.f32393g)) {
                    long position = (fVar.getPosition() + this.f32394h) - this.f32395i;
                    this.f32391e.add(new a.C1516a(this.f32393g, position));
                    if (this.f32394h == this.f32395i) {
                        k(position);
                    } else {
                        i();
                    }
                } else if (r(this.f32393g)) {
                    b.h.b.a.i0.a.f(this.f32395i == 8);
                    b.h.b.a.i0.a.f(this.f32394h <= 2147483647L);
                    b.h.b.a.i0.l lVar = new b.h.b.a.i0.l((int) this.f32394h);
                    this.j = lVar;
                    System.arraycopy(this.f32390d.f33493a, 0, lVar.f33493a, 0, 8);
                    this.f32392f = 1;
                } else {
                    this.j = null;
                    this.f32392f = 1;
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    public final boolean o(b.h.b.a.a0.f fVar, b.h.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048588, this, fVar, kVar)) != null) {
            return invokeLL.booleanValue;
        }
        long j = this.f32394h - this.f32395i;
        long position = fVar.getPosition() + j;
        b.h.b.a.i0.l lVar = this.j;
        if (lVar != null) {
            fVar.readFully(lVar.f33493a, this.f32395i, (int) j);
            if (this.f32393g == b.h.b.a.a0.q.a.f32311b) {
                this.p = l(this.j);
            } else if (!this.f32391e.isEmpty()) {
                this.f32391e.peek().e(new a.b(this.f32393g, this.j));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.h((int) j);
        } else {
            kVar.f32231a = fVar.getPosition() + j;
            z = true;
            k(position);
            return (z || this.f32392f == 2) ? false : true;
        }
        z = false;
        k(position);
        if (z) {
        }
    }

    public final int p(b.h.b.a.a0.f fVar, b.h.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, fVar, kVar)) == null) {
            int j = j();
            if (j == -1) {
                return -1;
            }
            a aVar = this.n[j];
            b.h.b.a.a0.m mVar = aVar.f32398c;
            int i2 = aVar.f32399d;
            m mVar2 = aVar.f32397b;
            long j2 = mVar2.f32425b[i2];
            int i3 = mVar2.f32426c[i2];
            if (aVar.f32396a.f32408g == 1) {
                j2 += 8;
                i3 -= 8;
            }
            long position = (j2 - fVar.getPosition()) + this.k;
            if (position >= 0 && position < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                fVar.h((int) position);
                int i4 = aVar.f32396a.j;
                if (i4 == 0) {
                    while (true) {
                        int i5 = this.k;
                        if (i5 >= i3) {
                            break;
                        }
                        int d2 = mVar.d(fVar, i3 - i5, false);
                        this.k += d2;
                        this.l -= d2;
                    }
                } else {
                    byte[] bArr = this.f32389c.f33493a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i6 = 4 - i4;
                    while (this.k < i3) {
                        int i7 = this.l;
                        if (i7 == 0) {
                            fVar.readFully(this.f32389c.f33493a, i6, i4);
                            this.f32389c.J(0);
                            this.l = this.f32389c.B();
                            this.f32388b.J(0);
                            mVar.a(this.f32388b, 4);
                            this.k += 4;
                            i3 += i6;
                        } else {
                            int d3 = mVar.d(fVar, i7, false);
                            this.k += d3;
                            this.l -= d3;
                        }
                    }
                }
                m mVar3 = aVar.f32397b;
                mVar.c(mVar3.f32428e[i2], mVar3.f32429f[i2], i3, 0, null);
                aVar.f32399d++;
                this.k = 0;
                this.l = 0;
                return 0;
            }
            kVar.f32231a = j2;
            return 1;
        }
        return invokeLL.intValue;
    }

    @Override // b.h.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void s(long j) {
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            for (a aVar : this.n) {
                m mVar = aVar.f32397b;
                int a2 = mVar.a(j);
                if (a2 == -1) {
                    a2 = mVar.b(j);
                }
                aVar.f32399d = a2;
            }
        }
    }
}
