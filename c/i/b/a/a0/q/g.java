package c.i.b.a.a0.q;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.q.a;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes9.dex */
public final class g implements c.i.b.a.a0.e, c.i.b.a.a0.l {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f28942b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f28943c;

    /* renamed from: d  reason: collision with root package name */
    public final c.i.b.a.i0.l f28944d;

    /* renamed from: e  reason: collision with root package name */
    public final Stack<a.C1662a> f28945e;

    /* renamed from: f  reason: collision with root package name */
    public int f28946f;

    /* renamed from: g  reason: collision with root package name */
    public int f28947g;

    /* renamed from: h  reason: collision with root package name */
    public long f28948h;

    /* renamed from: i  reason: collision with root package name */
    public int f28949i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.i0.l f28950j;
    public int k;
    public int l;
    public c.i.b.a.a0.g m;
    public a[] n;
    public long o;
    public boolean p;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final j a;

        /* renamed from: b  reason: collision with root package name */
        public final m f28951b;

        /* renamed from: c  reason: collision with root package name */
        public final c.i.b.a.a0.m f28952c;

        /* renamed from: d  reason: collision with root package name */
        public int f28953d;

        public a(j jVar, m mVar, c.i.b.a.a0.m mVar2) {
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
            this.a = jVar;
            this.f28951b = mVar;
            this.f28952c = mVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445121287, "Lc/i/b/a/a0/q/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445121287, "Lc/i/b/a/a0/q/g;");
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
        this.a = i2;
        this.f28944d = new c.i.b.a.i0.l(16);
        this.f28945e = new Stack<>();
        this.f28942b = new c.i.b.a.i0.l(c.i.b.a.i0.j.a);
        this.f28943c = new c.i.b.a.i0.l(4);
    }

    public static boolean l(c.i.b.a.i0.l lVar) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == c.i.b.a.a0.q.a.C || i2 == c.i.b.a.a0.q.a.E || i2 == c.i.b.a.a0.q.a.F || i2 == c.i.b.a.a0.q.a.G || i2 == c.i.b.a.a0.q.a.H || i2 == c.i.b.a.a0.q.a.Q : invokeI.booleanValue;
    }

    public static boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == c.i.b.a.a0.q.a.S || i2 == c.i.b.a.a0.q.a.D || i2 == c.i.b.a.a0.q.a.T || i2 == c.i.b.a.a0.q.a.U || i2 == c.i.b.a.a0.q.a.m0 || i2 == c.i.b.a.a0.q.a.n0 || i2 == c.i.b.a.a0.q.a.o0 || i2 == c.i.b.a.a0.q.a.R || i2 == c.i.b.a.a0.q.a.p0 || i2 == c.i.b.a.a0.q.a.q0 || i2 == c.i.b.a.a0.q.a.r0 || i2 == c.i.b.a.a0.q.a.s0 || i2 == c.i.b.a.a0.q.a.t0 || i2 == c.i.b.a.a0.q.a.P || i2 == c.i.b.a.a0.q.a.f28876b || i2 == c.i.b.a.a0.q.a.A0 : invokeI.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f28945e.clear();
            this.f28949i = 0;
            this.k = 0;
            this.l = 0;
            if (j2 == 0) {
                i();
            } else if (this.n != null) {
                s(j3);
            }
        }
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            long j3 = Long.MAX_VALUE;
            for (a aVar : this.n) {
                m mVar = aVar.f28951b;
                int a2 = mVar.a(j2);
                if (a2 == -1) {
                    a2 = mVar.b(j2);
                }
                long j4 = mVar.f28975b[a2];
                if (j4 < j3) {
                    j3 = j4;
                }
            }
            return j3;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.e
    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? i.d(fVar) : invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f28946f;
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

    @Override // c.i.b.a.a0.e
    public void f(c.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.m = gVar;
        }
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.longValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28946f = 0;
            this.f28949i = 0;
        }
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.n;
            if (i3 >= aVarArr.length) {
                return i2;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.f28953d;
            m mVar = aVar.f28951b;
            if (i4 != mVar.a) {
                long j3 = mVar.f28975b[i4];
                if (j3 < j2) {
                    i2 = i3;
                    j2 = j3;
                }
            }
            i3++;
        }
    }

    public final void k(long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            while (!this.f28945e.isEmpty() && this.f28945e.peek().P0 == j2) {
                a.C1662a pop = this.f28945e.pop();
                if (pop.a == c.i.b.a.a0.q.a.C) {
                    m(pop);
                    this.f28945e.clear();
                    this.f28946f = 2;
                } else if (!this.f28945e.isEmpty()) {
                    this.f28945e.peek().d(pop);
                }
            }
            if (this.f28946f != 2) {
                i();
            }
        }
    }

    public final void m(a.C1662a c1662a) throws ParserException {
        Metadata metadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c1662a) == null) {
            ArrayList arrayList = new ArrayList();
            c.i.b.a.a0.i iVar = new c.i.b.a.a0.i();
            a.b g2 = c1662a.g(c.i.b.a.a0.q.a.A0);
            if (g2 != null) {
                metadata = b.u(g2, this.p);
                if (metadata != null) {
                    iVar.c(metadata);
                }
            } else {
                metadata = null;
            }
            long j2 = -9223372036854775807L;
            long j3 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < c1662a.R0.size(); i2++) {
                a.C1662a c1662a2 = c1662a.R0.get(i2);
                if (c1662a2.a == c.i.b.a.a0.q.a.E) {
                    j t = b.t(c1662a2, c1662a.g(c.i.b.a.a0.q.a.D), -9223372036854775807L, null, (this.a & 1) != 0, this.p);
                    if (t != null) {
                        m p = b.p(t, c1662a2.f(c.i.b.a.a0.q.a.F).f(c.i.b.a.a0.q.a.G).f(c.i.b.a.a0.q.a.H), iVar);
                        if (p.a != 0) {
                            a aVar = new a(t, p, this.m.a(i2, t.f28954b));
                            Format copyWithMaxInputSize = t.f28958f.copyWithMaxInputSize(p.f28977d + 30);
                            if (t.f28954b == 1) {
                                if (iVar.a()) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(iVar.a, iVar.f28797b);
                                }
                                if (metadata != null) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                                }
                            }
                            aVar.f28952c.b(copyWithMaxInputSize);
                            long max = Math.max(j2, t.f28957e);
                            arrayList.add(aVar);
                            long j4 = p.f28975b[0];
                            if (j4 < j3) {
                                j2 = max;
                                j3 = j4;
                            } else {
                                j2 = max;
                            }
                        }
                    }
                }
            }
            this.o = j2;
            this.n = (a[]) arrayList.toArray(new a[arrayList.size()]);
            this.m.j();
            this.m.p(this);
        }
    }

    public final boolean n(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
            if (this.f28949i == 0) {
                if (!fVar.a(this.f28944d.a, 0, 8, true)) {
                    return false;
                }
                this.f28949i = 8;
                this.f28944d.J(0);
                this.f28948h = this.f28944d.z();
                this.f28947g = this.f28944d.i();
            }
            long j2 = this.f28948h;
            if (j2 == 1) {
                fVar.readFully(this.f28944d.a, 8, 8);
                this.f28949i += 8;
                this.f28948h = this.f28944d.C();
            } else if (j2 == 0) {
                long length = fVar.getLength();
                if (length == -1 && !this.f28945e.isEmpty()) {
                    length = this.f28945e.peek().P0;
                }
                if (length != -1) {
                    this.f28948h = (length - fVar.getPosition()) + this.f28949i;
                }
            }
            if (this.f28948h >= this.f28949i) {
                if (q(this.f28947g)) {
                    long position = (fVar.getPosition() + this.f28948h) - this.f28949i;
                    this.f28945e.add(new a.C1662a(this.f28947g, position));
                    if (this.f28948h == this.f28949i) {
                        k(position);
                    } else {
                        i();
                    }
                } else if (r(this.f28947g)) {
                    c.i.b.a.i0.a.f(this.f28949i == 8);
                    c.i.b.a.i0.a.f(this.f28948h <= 2147483647L);
                    c.i.b.a.i0.l lVar = new c.i.b.a.i0.l((int) this.f28948h);
                    this.f28950j = lVar;
                    System.arraycopy(this.f28944d.a, 0, lVar.a, 0, 8);
                    this.f28946f = 1;
                } else {
                    this.f28950j = null;
                    this.f28946f = 1;
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    public final boolean o(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048588, this, fVar, kVar)) != null) {
            return invokeLL.booleanValue;
        }
        long j2 = this.f28948h - this.f28949i;
        long position = fVar.getPosition() + j2;
        c.i.b.a.i0.l lVar = this.f28950j;
        if (lVar != null) {
            fVar.readFully(lVar.a, this.f28949i, (int) j2);
            if (this.f28947g == c.i.b.a.a0.q.a.f28876b) {
                this.p = l(this.f28950j);
            } else if (!this.f28945e.isEmpty()) {
                this.f28945e.peek().e(new a.b(this.f28947g, this.f28950j));
            }
        } else if (j2 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.h((int) j2);
        } else {
            kVar.a = fVar.getPosition() + j2;
            z = true;
            k(position);
            return (z || this.f28946f == 2) ? false : true;
        }
        z = false;
        k(position);
        if (z) {
        }
    }

    public final int p(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, fVar, kVar)) == null) {
            int j2 = j();
            if (j2 == -1) {
                return -1;
            }
            a aVar = this.n[j2];
            c.i.b.a.a0.m mVar = aVar.f28952c;
            int i2 = aVar.f28953d;
            m mVar2 = aVar.f28951b;
            long j3 = mVar2.f28975b[i2];
            int i3 = mVar2.f28976c[i2];
            if (aVar.a.f28959g == 1) {
                j3 += 8;
                i3 -= 8;
            }
            long position = (j3 - fVar.getPosition()) + this.k;
            if (position >= 0 && position < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                fVar.h((int) position);
                int i4 = aVar.a.f28962j;
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
                    byte[] bArr = this.f28943c.a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i6 = 4 - i4;
                    while (this.k < i3) {
                        int i7 = this.l;
                        if (i7 == 0) {
                            fVar.readFully(this.f28943c.a, i6, i4);
                            this.f28943c.J(0);
                            this.l = this.f28943c.B();
                            this.f28942b.J(0);
                            mVar.a(this.f28942b, 4);
                            this.k += 4;
                            i3 += i6;
                        } else {
                            int d3 = mVar.d(fVar, i7, false);
                            this.k += d3;
                            this.l -= d3;
                        }
                    }
                }
                m mVar3 = aVar.f28951b;
                mVar.c(mVar3.f28978e[i2], mVar3.f28979f[i2], i3, 0, null);
                aVar.f28953d++;
                this.k = 0;
                this.l = 0;
                return 0;
            }
            kVar.a = j3;
            return 1;
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void s(long j2) {
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            for (a aVar : this.n) {
                m mVar = aVar.f28951b;
                int a2 = mVar.a(j2);
                if (a2 == -1) {
                    a2 = mVar.b(j2);
                }
                aVar.f28953d = a2;
            }
        }
    }
}
