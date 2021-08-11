package c.i.b.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.k;
import c.i.b.a.d0.l;
import c.i.b.a.f0.h;
import c.i.b.a.g;
import c.i.b.a.n;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class j implements Handler.Callback, k.a, h.a, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public long F;
    public int G;
    public int H;
    public c I;
    public long J;
    public a K;
    public a L;
    public a M;

    /* renamed from: e  reason: collision with root package name */
    public final r[] f33632e;

    /* renamed from: f  reason: collision with root package name */
    public final s[] f33633f;

    /* renamed from: g  reason: collision with root package name */
    public final c.i.b.a.f0.h f33634g;

    /* renamed from: h  reason: collision with root package name */
    public final m f33635h;

    /* renamed from: i  reason: collision with root package name */
    public final c.i.b.a.i0.q f33636i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f33637j;
    public final HandlerThread k;
    public final Handler l;
    public final g m;
    public final w.c n;
    public final w.b o;
    public final n p;
    public o q;
    public p r;
    public r s;
    public c.i.b.a.i0.h t;
    public c.i.b.a.d0.l u;
    public r[] v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.d0.k f33638a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f33639b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33640c;

        /* renamed from: d  reason: collision with root package name */
        public final c.i.b.a.d0.o[] f33641d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f33642e;

        /* renamed from: f  reason: collision with root package name */
        public final long f33643f;

        /* renamed from: g  reason: collision with root package name */
        public n.b f33644g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f33645h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f33646i;

        /* renamed from: j  reason: collision with root package name */
        public a f33647j;
        public c.i.b.a.f0.i k;
        public final r[] l;
        public final s[] m;
        public final c.i.b.a.f0.h n;
        public final m o;
        public final c.i.b.a.d0.l p;
        public c.i.b.a.f0.i q;

        public a(r[] rVarArr, s[] sVarArr, long j2, c.i.b.a.f0.h hVar, m mVar, c.i.b.a.d0.l lVar, Object obj, int i2, n.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVarArr, sVarArr, Long.valueOf(j2), hVar, mVar, lVar, obj, Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = rVarArr;
            this.m = sVarArr;
            this.f33643f = j2;
            this.n = hVar;
            this.o = mVar;
            this.p = lVar;
            c.i.b.a.i0.a.e(obj);
            this.f33639b = obj;
            this.f33640c = i2;
            this.f33644g = bVar;
            this.f33641d = new c.i.b.a.d0.o[rVarArr.length];
            this.f33642e = new boolean[rVarArr.length];
            c.i.b.a.d0.k d2 = lVar.d(bVar.f33713a, mVar.e());
            if (bVar.f33715c != Long.MIN_VALUE) {
                c.i.b.a.d0.c cVar = new c.i.b.a.d0.c(d2, true);
                cVar.f(0L, bVar.f33715c);
                d2 = cVar;
            }
            this.f33638a = d2;
        }

        public final void a(c.i.b.a.d0.o[] oVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, oVarArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                s[] sVarArr = this.m;
                if (i2 >= sVarArr.length) {
                    return;
                }
                if (sVarArr[i2].e() == 5 && this.k.f33459b[i2]) {
                    oVarArr[i2] = new c.i.b.a.d0.g();
                }
                i2++;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f33638a.b(k(j2));
            }
        }

        public final void c(c.i.b.a.d0.o[] oVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVarArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                s[] sVarArr = this.m;
                if (i2 >= sVarArr.length) {
                    return;
                }
                if (sVarArr[i2].e() == 5) {
                    oVarArr[i2] = null;
                }
                i2++;
            }
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33640c == 0 ? this.f33643f : this.f33643f - this.f33644g.f33714b : invokeV.longValue;
        }

        public void e() throws ExoPlaybackException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f33645h = true;
                i();
                this.f33644g = this.f33644g.b(m(this.f33644g.f33714b, false));
            }
        }

        public boolean f(boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                long c2 = !this.f33645h ? this.f33644g.f33714b : this.f33638a.c();
                if (c2 == Long.MIN_VALUE) {
                    n.b bVar = this.f33644g;
                    if (bVar.f33719g) {
                        return true;
                    }
                    c2 = bVar.f33717e;
                }
                return this.o.d(c2 - k(j2), z);
            }
            return invokeCommon.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33645h && (!this.f33646i || this.f33638a.c() == Long.MIN_VALUE) : invokeV.booleanValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                try {
                    if (this.f33644g.f33715c != Long.MIN_VALUE) {
                        this.p.e(((c.i.b.a.d0.c) this.f33638a).f32811e);
                    } else {
                        this.p.e(this.f33638a);
                    }
                } catch (RuntimeException unused) {
                }
            }
        }

        public boolean i() throws ExoPlaybackException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                c.i.b.a.f0.i c2 = this.n.c(this.m, this.f33638a.k());
                if (c2.a(this.q)) {
                    return false;
                }
                this.k = c2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                long d2 = !this.f33645h ? 0L : this.f33638a.d();
                if (d2 == Long.MIN_VALUE) {
                    return false;
                }
                return this.o.c(d2 - k(j2));
            }
            return invokeJ.booleanValue;
        }

        public long k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? j2 - d() : invokeJ.longValue;
        }

        public long l(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) ? j2 + d() : invokeJ.longValue;
        }

        public long m(long j2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? n(j2, z, new boolean[this.l.length]) : invokeCommon.longValue;
        }

        public long n(long j2, boolean z, boolean[] zArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), zArr})) != null) {
                return invokeCommon.longValue;
            }
            c.i.b.a.f0.g gVar = this.k.f33460c;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= gVar.f33455a) {
                    break;
                }
                boolean[] zArr2 = this.f33642e;
                if (z || !this.k.b(this.q, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            c(this.f33641d);
            long e2 = this.f33638a.e(gVar.b(), this.f33642e, this.f33641d, zArr, j2);
            a(this.f33641d);
            this.q = this.k;
            this.f33646i = false;
            int i3 = 0;
            while (true) {
                c.i.b.a.d0.o[] oVarArr = this.f33641d;
                if (i3 < oVarArr.length) {
                    if (oVarArr[i3] != null) {
                        c.i.b.a.i0.a.f(this.k.f33459b[i3]);
                        if (this.m[i3].e() != 5) {
                            this.f33646i = true;
                        }
                    } else {
                        c.i.b.a.i0.a.f(gVar.a(i3) == null);
                    }
                    i3++;
                } else {
                    this.o.a(this.l, this.k.f33458a, gVar);
                    return e2;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.d0.l f33648a;

        /* renamed from: b  reason: collision with root package name */
        public final w f33649b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f33650c;

        public b(c.i.b.a.d0.l lVar, w wVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, wVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33648a = lVar;
            this.f33649b = wVar;
            this.f33650c = obj;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final w f33651a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33652b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33653c;

        public c(w wVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33651a = wVar;
            this.f33652b = i2;
            this.f33653c = j2;
        }
    }

    public j(r[] rVarArr, c.i.b.a.f0.h hVar, m mVar, boolean z, int i2, boolean z2, Handler handler, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVarArr, hVar, mVar, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), handler, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33632e = rVarArr;
        this.f33634g = hVar;
        this.f33635h = mVar;
        this.x = z;
        this.B = i2;
        this.C = z2;
        this.l = handler;
        this.A = 1;
        this.m = gVar;
        this.q = new o(null, null, 0, -9223372036854775807L);
        this.f33633f = new s[rVarArr.length];
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            rVarArr[i5].setIndex(i5);
            this.f33633f[i5] = rVarArr[i5].p();
        }
        this.f33636i = new c.i.b.a.i0.q();
        this.v = new r[0];
        this.n = new w.c();
        this.o = new w.b();
        this.p = new n();
        hVar.a(this);
        this.r = p.f33727d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.k = handlerThread;
        handlerThread.start();
        this.f33637j = new Handler(this.k.getLooper(), this);
    }

    @NonNull
    public static Format[] h(c.i.b.a.f0.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            int length = fVar != null ? fVar.length() : 0;
            Format[] formatArr = new Format[length];
            for (int i2 = 0; i2 < length; i2++) {
                formatArr[i2] = fVar.h(i2);
            }
            return formatArr;
        }
        return (Format[]) invokeL.objValue;
    }

    public final void A(c.i.b.a.d0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, lVar, z) == null) {
            this.G++;
            G(true);
            this.f33635h.onPrepared();
            if (z) {
                this.q = new o(null, null, 0, -9223372036854775807L);
            } else {
                o oVar = this.q;
                this.q = new o(null, null, oVar.f33722c, oVar.f33725f, this.q.f33724e);
            }
            this.u = lVar;
            lVar.a(this.m, true, this);
            a0(2);
            this.f33637j.sendEmptyMessage(2);
        }
    }

    public synchronized void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.w) {
                    return;
                }
                this.f33637j.sendEmptyMessage(6);
                boolean z = false;
                while (!this.w) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            G(true);
            this.f33635h.b();
            a0(1);
            this.k.quit();
            synchronized (this) {
                this.w = true;
                notifyAll();
            }
        }
    }

    public final void D(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            while (aVar != null) {
                aVar.h();
                aVar = aVar.f33647j;
            }
        }
    }

    public final boolean E(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
            a aVar = this.L.f33647j;
            return aVar != null && aVar.f33645h && rVar.f();
        }
        return invokeL.booleanValue;
    }

    public final void F() throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.M) == null) {
            return;
        }
        boolean z = true;
        for (aVar = this.M; aVar != null && aVar.f33645h; aVar = aVar.f33647j) {
            if (aVar.i()) {
                if (z) {
                    boolean z2 = this.L != this.M;
                    D(this.M.f33647j);
                    a aVar2 = this.M;
                    aVar2.f33647j = null;
                    this.K = aVar2;
                    this.L = aVar2;
                    boolean[] zArr = new boolean[this.f33632e.length];
                    long n = aVar2.n(this.q.f33725f, z2, zArr);
                    if (this.A != 4 && n != this.q.f33725f) {
                        o oVar = this.q;
                        o e2 = oVar.e(oVar.f33722c, n, oVar.f33724e);
                        this.q = e2;
                        this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
                        H(n);
                    }
                    boolean[] zArr2 = new boolean[this.f33632e.length];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        r[] rVarArr = this.f33632e;
                        if (i2 >= rVarArr.length) {
                            break;
                        }
                        r rVar = rVarArr[i2];
                        zArr2[i2] = rVar.getState() != 0;
                        c.i.b.a.d0.o oVar2 = this.M.f33641d[i2];
                        if (oVar2 != null) {
                            i3++;
                        }
                        if (zArr2[i2]) {
                            if (oVar2 != rVar.getStream()) {
                                b(rVar);
                            } else if (zArr[i2]) {
                                rVar.l(this.J);
                            }
                        }
                        i2++;
                    }
                    this.l.obtainMessage(2, aVar.k).sendToTarget();
                    f(zArr2, i3);
                } else {
                    this.K = aVar;
                    for (a aVar3 = aVar.f33647j; aVar3 != null; aVar3 = aVar3.f33647j) {
                        aVar3.h();
                    }
                    a aVar4 = this.K;
                    aVar4.f33647j = null;
                    if (aVar4.f33645h) {
                        this.K.m(Math.max(aVar4.f33644g.f33714b, aVar4.k(this.J)), false);
                    }
                }
                if (this.A != 4) {
                    s();
                    i0();
                    this.f33637j.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (aVar == this.L) {
                z = false;
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f33637j.removeMessages(2);
            this.y = false;
            this.f33636i.e();
            this.J = 60000000L;
            for (r rVar : this.v) {
                try {
                    b(rVar);
                } catch (ExoPlaybackException | RuntimeException unused) {
                }
            }
            this.v = new r[0];
            a aVar = this.M;
            if (aVar == null) {
                aVar = this.K;
            }
            D(aVar);
            this.K = null;
            this.L = null;
            this.M = null;
            Q(false);
            if (z) {
                c.i.b.a.d0.l lVar = this.u;
                if (lVar != null) {
                    lVar.f();
                    this.u = null;
                }
                this.p.n(null);
                this.q = this.q.c(null, null);
            }
        }
    }

    public final void H(long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            a aVar = this.M;
            long l = aVar == null ? j2 + 60000000 : aVar.l(j2);
            this.J = l;
            this.f33636i.a(l);
            for (r rVar : this.v) {
                rVar.l(this.J);
            }
        }
    }

    public final Pair<Integer, Long> I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            w wVar = this.q.f33720a;
            w wVar2 = cVar.f33651a;
            if (wVar2.p()) {
                wVar2 = wVar;
            }
            try {
                Pair<Integer, Long> i2 = wVar2.i(this.n, this.o, cVar.f33652b, cVar.f33653c);
                if (wVar == wVar2) {
                    return i2;
                }
                int b2 = wVar.b(wVar2.g(((Integer) i2.first).intValue(), this.o, true).f33746b);
                if (b2 != -1) {
                    return Pair.create(Integer.valueOf(b2), i2.second);
                }
                int J = J(((Integer) i2.first).intValue(), wVar2, wVar);
                if (J != -1) {
                    return k(wVar, wVar.f(J, this.o).f33747c, -9223372036854775807L);
                }
                return null;
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalSeekPositionException(wVar, cVar.f33652b, cVar.f33653c);
            }
        }
        return (Pair) invokeL.objValue;
    }

    public final int J(int i2, w wVar, w wVar2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, wVar, wVar2)) == null) {
            int h2 = wVar.h();
            int i3 = i2;
            int i4 = -1;
            for (int i5 = 0; i5 < h2 && i4 == -1; i5++) {
                i3 = wVar.d(i3, this.o, this.n, this.B, this.C);
                if (i3 == -1) {
                    break;
                }
                i4 = wVar2.b(wVar.g(i3, this.o, true).f33746b);
            }
            return i4;
        }
        return invokeILL.intValue;
    }

    public final void K(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f33637j.removeMessages(2);
            long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.f33637j.sendEmptyMessage(2);
            } else {
                this.f33637j.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }

    public void L(w wVar, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{wVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.f33637j.obtainMessage(3, new c(wVar, i2, j2)).sendToTarget();
        }
    }

    public final void M(c cVar) throws ExoPlaybackException {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            w wVar = this.q.f33720a;
            if (wVar == null) {
                this.H++;
                this.I = cVar;
                return;
            }
            Pair<Integer, Long> I = I(cVar);
            if (I == null) {
                int i3 = wVar.p() ? 0 : wVar.l(wVar.a(this.C), this.n).f33760f;
                this.q = this.q.d(i3, -9223372036854775807L, -9223372036854775807L);
                a0(4);
                this.l.obtainMessage(3, 1, 0, this.q.d(i3, 0L, -9223372036854775807L)).sendToTarget();
                G(false);
                return;
            }
            int i4 = cVar.f33653c == -9223372036854775807L ? 1 : 0;
            int intValue = ((Integer) I.first).intValue();
            long longValue = ((Long) I.second).longValue();
            l.b k = this.p.k(intValue, longValue);
            if (k.b()) {
                j2 = 0;
                i2 = 1;
            } else {
                i2 = i4;
                j2 = longValue;
            }
            try {
                if (k.equals(this.q.f33722c) && j2 / 1000 == this.q.f33725f / 1000) {
                    return;
                }
                long N = N(k, j2);
                int i5 = i2 | (j2 != N ? 1 : 0);
                o e2 = this.q.e(k, N, longValue);
                this.q = e2;
                this.l.obtainMessage(3, i5, 0, e2).sendToTarget();
            } finally {
                o e3 = this.q.e(k, j2, longValue);
                this.q = e3;
                this.l.obtainMessage(3, i2, 0, e3).sendToTarget();
            }
        }
    }

    public final long N(l.b bVar, long j2) throws ExoPlaybackException {
        InterceptResult invokeLJ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, bVar, j2)) == null) {
            f0();
            this.y = false;
            a0(2);
            a aVar2 = this.M;
            if (aVar2 == null) {
                a aVar3 = this.K;
                if (aVar3 != null) {
                    aVar3.h();
                }
                aVar = null;
            } else {
                aVar = null;
                while (aVar2 != null) {
                    if (aVar == null && b0(bVar, j2, aVar2)) {
                        aVar = aVar2;
                    } else {
                        aVar2.h();
                    }
                    aVar2 = aVar2.f33647j;
                }
            }
            a aVar4 = this.M;
            if (aVar4 != aVar || aVar4 != this.L) {
                for (r rVar : this.v) {
                    b(rVar);
                }
                this.v = new r[0];
                this.M = null;
            }
            if (aVar != null) {
                aVar.f33647j = null;
                this.K = aVar;
                this.L = aVar;
                V(aVar);
                a aVar5 = this.M;
                if (aVar5.f33646i) {
                    j2 = aVar5.f33638a.g(j2);
                }
                H(j2);
                s();
            } else {
                this.K = null;
                this.L = null;
                this.M = null;
                H(j2);
            }
            this.f33637j.sendEmptyMessage(2);
            return j2;
        }
        return invokeLJ.longValue;
    }

    public void O(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVarArr) == null) || this.w) {
            return;
        }
        this.D++;
        this.f33637j.obtainMessage(11, bVarArr).sendToTarget();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void P(g.b[] bVarArr) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVarArr) == null) {
            try {
                for (g.b bVar : bVarArr) {
                    bVar.f33463a.h(bVar.f33464b, bVar.f33465c);
                }
                if (this.A == 3 || this.A == 2) {
                    this.f33637j.sendEmptyMessage(2);
                }
                synchronized (this) {
                    this.E++;
                    notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.E++;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.z == z) {
            return;
        }
        this.z = z;
        this.l.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f33637j.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void S(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.y = false;
            this.x = z;
            if (!z) {
                f0();
                i0();
                return;
            }
            int i2 = this.A;
            if (i2 == 3) {
                c0();
                this.f33637j.sendEmptyMessage(2);
            } else if (i2 == 2) {
                this.f33637j.sendEmptyMessage(2);
            }
        }
    }

    public void T(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.f33637j.obtainMessage(4, pVar).sendToTarget();
        }
    }

    public final void U(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pVar) == null) {
            c.i.b.a.i0.h hVar = this.t;
            if (hVar != null) {
                pVar = hVar.c(pVar);
            }
            this.f33636i.c(pVar);
            this.r = pVar;
            this.l.obtainMessage(6, pVar).sendToTarget();
        }
    }

    public final void V(a aVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) || this.M == aVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f33632e.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            r[] rVarArr = this.f33632e;
            if (i2 < rVarArr.length) {
                r rVar = rVarArr[i2];
                zArr[i2] = rVar.getState() != 0;
                if (aVar.k.f33459b[i2]) {
                    i3++;
                }
                if (zArr[i2] && (!aVar.k.f33459b[i2] || (rVar.j() && rVar.getStream() == this.M.f33641d[i2]))) {
                    b(rVar);
                }
                i2++;
            } else {
                this.M = aVar;
                this.l.obtainMessage(2, aVar.k).sendToTarget();
                f(zArr, i3);
                return;
            }
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f33637j.obtainMessage(12, i2, 0).sendToTarget();
        }
    }

    public final void X(int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.B = i2;
            this.p.l(i2);
            j0();
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f33637j.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void Z(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.C = z;
            this.p.m(z);
            j0();
        }
    }

    public synchronized void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVarArr) == null) {
            synchronized (this) {
                if (this.w) {
                    return;
                }
                int i2 = this.D;
                this.D = i2 + 1;
                this.f33637j.obtainMessage(11, bVarArr).sendToTarget();
                boolean z = false;
                while (this.E <= i2) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void a0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.A == i2) {
            return;
        }
        this.A = i2;
        this.l.obtainMessage(0, i2, 0).sendToTarget();
    }

    public final void b(r rVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, rVar) == null) {
            if (rVar == this.s) {
                this.t = null;
                this.s = null;
            }
            g(rVar);
            rVar.i();
        }
    }

    public final boolean b0(l.b bVar, long j2, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{bVar, Long.valueOf(j2), aVar})) == null) {
            if (bVar.equals(aVar.f33644g.f33713a) && aVar.f33645h) {
                this.q.f33720a.f(aVar.f33644g.f33713a.f32876a, this.o);
                int d2 = this.o.d(j2);
                return d2 == -1 || this.o.f(d2) == aVar.f33644g.f33715c;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.d0.l.a
    public void c(c.i.b.a.d0.l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, lVar, wVar, obj) == null) {
            this.f33637j.obtainMessage(7, new b(lVar, wVar, obj)).sendToTarget();
        }
    }

    public final void c0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.y = false;
            this.f33636i.b();
            for (r rVar : this.v) {
                rVar.start();
            }
        }
    }

    public final void d() throws ExoPlaybackException, IOException {
        r[] rVarArr;
        boolean r;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            h0();
            if (this.M == null) {
                t();
                K(elapsedRealtime, 10L);
                return;
            }
            c.i.b.a.i0.t.a("doSomeWork");
            i0();
            this.M.f33638a.r(this.q.f33725f);
            boolean z = true;
            boolean z2 = true;
            for (r rVar : this.v) {
                rVar.k(this.J, this.F);
                z2 = z2 && rVar.b();
                boolean z3 = rVar.isReady() || rVar.b() || E(rVar);
                if (!z3) {
                    rVar.o();
                }
                z = z && z3;
            }
            if (!z) {
                t();
            }
            c.i.b.a.i0.h hVar = this.t;
            if (hVar != null) {
                p d2 = hVar.d();
                if (!d2.equals(this.r)) {
                    this.r = d2;
                    this.f33636i.c(d2);
                    this.l.obtainMessage(6, d2).sendToTarget();
                }
            }
            long j2 = this.M.f33644g.f33717e;
            if (z2 && ((j2 == -9223372036854775807L || j2 <= this.q.f33725f) && this.M.f33644g.f33719g)) {
                a0(4);
                f0();
            } else {
                int i3 = this.A;
                if (i3 == 2) {
                    if (this.v.length > 0) {
                        r = z && this.K.f(this.y, this.J);
                    } else {
                        r = r(j2);
                    }
                    if (r) {
                        a0(3);
                        if (this.x) {
                            c0();
                        }
                    }
                } else if (i3 == 3) {
                    if (this.v.length <= 0) {
                        z = r(j2);
                    }
                    if (!z) {
                        this.y = this.x;
                        a0(2);
                        f0();
                    }
                }
            }
            if (this.A == 2) {
                for (r rVar2 : this.v) {
                    rVar2.o();
                }
            }
            if ((this.x && this.A == 3) || (i2 = this.A) == 2) {
                K(elapsedRealtime, 10L);
            } else if (this.v.length != 0 && i2 != 4) {
                K(elapsedRealtime, 1000L);
            } else {
                this.f33637j.removeMessages(2);
            }
            c.i.b.a.i0.t.c();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f33637j.sendEmptyMessage(5);
        }
    }

    public final void e(int i2, boolean z, int i3) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            r rVar = this.f33632e[i2];
            this.v[i3] = rVar;
            if (rVar.getState() == 0) {
                c.i.b.a.f0.i iVar = this.M.k;
                t tVar = iVar.f33462e[i2];
                Format[] h2 = h(iVar.f33460c.a(i2));
                boolean z2 = this.x && this.A == 3;
                boolean z3 = !z && z2;
                a aVar = this.M;
                rVar.g(tVar, h2, aVar.f33641d[i2], this.J, z3, aVar.d());
                c.i.b.a.i0.h m = rVar.m();
                if (m != null) {
                    if (this.t == null) {
                        this.t = m;
                        this.s = rVar;
                        m.c(this.r);
                    } else {
                        throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                    }
                }
                if (z2) {
                    rVar.start();
                }
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            G(true);
            this.f33635h.f();
            a0(1);
        }
    }

    public final void f(boolean[] zArr, int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, zArr, i2) == null) {
            this.v = new r[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < this.f33632e.length; i4++) {
                if (this.M.k.f33459b[i4]) {
                    e(i4, zArr[i4], i3);
                    i3++;
                }
            }
        }
    }

    public final void f0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f33636i.e();
            for (r rVar : this.v) {
                g(rVar);
            }
        }
    }

    public final void g(r rVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, rVar) == null) && rVar.getState() == 2) {
            rVar.stop();
        }
    }

    public final a g0(a aVar, int i2) {
        a aVar2;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, aVar, i2)) == null) {
            while (true) {
                n.b g2 = this.p.g(aVar.f33644g, i2);
                aVar.f33644g = g2;
                if (g2.f33718f || (aVar2 = aVar.f33647j) == null) {
                    break;
                }
                aVar = aVar2;
            }
            return aVar;
        }
        return (a) invokeLI.objValue;
    }

    public final void h0() throws ExoPlaybackException, IOException {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048616, this) != null) {
            return;
        }
        if (this.q.f33720a == null) {
            this.u.b();
            return;
        }
        u();
        a aVar2 = this.K;
        int i2 = 0;
        if (aVar2 != null && !aVar2.g()) {
            if (this.K != null && !this.z) {
                s();
            }
        } else {
            Q(false);
        }
        if (this.M == null) {
            return;
        }
        while (this.x && (aVar = this.M) != this.L && this.J >= aVar.f33647j.f33643f) {
            aVar.h();
            V(this.M.f33647j);
            o oVar = this.q;
            n.b bVar = this.M.f33644g;
            this.q = oVar.e(bVar.f33713a, bVar.f33714b, bVar.f33716d);
            i0();
            this.l.obtainMessage(4, 0, 0, this.q).sendToTarget();
        }
        a aVar3 = this.L;
        if (aVar3.f33644g.f33719g) {
            while (true) {
                r[] rVarArr = this.f33632e;
                if (i2 >= rVarArr.length) {
                    return;
                }
                r rVar = rVarArr[i2];
                c.i.b.a.d0.o oVar2 = this.L.f33641d[i2];
                if (oVar2 != null && rVar.getStream() == oVar2 && rVar.f()) {
                    rVar.n();
                }
                i2++;
            }
        } else {
            a aVar4 = aVar3.f33647j;
            if (aVar4 == null || !aVar4.f33645h) {
                return;
            }
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f33632e;
                if (i3 < rVarArr2.length) {
                    r rVar2 = rVarArr2[i3];
                    c.i.b.a.d0.o oVar3 = this.L.f33641d[i3];
                    if (rVar2.getStream() != oVar3) {
                        return;
                    }
                    if (oVar3 != null && !rVar2.f()) {
                        return;
                    }
                    i3++;
                } else {
                    a aVar5 = this.L;
                    c.i.b.a.f0.i iVar = aVar5.k;
                    a aVar6 = aVar5.f33647j;
                    this.L = aVar6;
                    c.i.b.a.f0.i iVar2 = aVar6.k;
                    boolean z = aVar6.f33638a.h() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        r[] rVarArr3 = this.f33632e;
                        if (i4 >= rVarArr3.length) {
                            return;
                        }
                        r rVar3 = rVarArr3[i4];
                        if (iVar.f33459b[i4]) {
                            if (z) {
                                rVar3.n();
                            } else if (!rVar3.j()) {
                                c.i.b.a.f0.f a2 = iVar2.f33460c.a(i4);
                                boolean z2 = iVar2.f33459b[i4];
                                boolean z3 = this.f33633f[i4].e() == 5;
                                t tVar = iVar.f33462e[i4];
                                t tVar2 = iVar2.f33462e[i4];
                                if (z2 && tVar2.equals(tVar) && !z3) {
                                    Format[] h2 = h(a2);
                                    a aVar7 = this.L;
                                    rVar3.s(h2, aVar7.f33641d[i4], aVar7.d());
                                } else {
                                    rVar3.n();
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, message)) == null) {
            try {
                switch (message.what) {
                    case 0:
                        A((c.i.b.a.d0.l) message.obj, message.arg1 != 0);
                        return true;
                    case 1:
                        S(message.arg1 != 0);
                        return true;
                    case 2:
                        d();
                        return true;
                    case 3:
                        M((c) message.obj);
                        return true;
                    case 4:
                        U((p) message.obj);
                        return true;
                    case 5:
                        e0();
                        return true;
                    case 6:
                        C();
                        return true;
                    case 7:
                        q((b) message.obj);
                        return true;
                    case 8:
                        n((c.i.b.a.d0.k) message.obj);
                        return true;
                    case 9:
                        m((c.i.b.a.d0.k) message.obj);
                        return true;
                    case 10:
                        F();
                        return true;
                    case 11:
                        P((g.b[]) message.obj);
                        return true;
                    case 12:
                        X(message.arg1);
                        return true;
                    case 13:
                        Z(message.arg1 != 0);
                        return true;
                    default:
                        return false;
                }
            } catch (ExoPlaybackException e2) {
                this.l.obtainMessage(7, e2).sendToTarget();
                e0();
                return true;
            } catch (IOException e3) {
                this.l.obtainMessage(7, ExoPlaybackException.createForSource(e3)).sendToTarget();
                e0();
                return true;
            } catch (RuntimeException e4) {
                this.l.obtainMessage(7, ExoPlaybackException.createForUnexpected(e4)).sendToTarget();
                e0();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void i0() throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (aVar = this.M) == null) {
            return;
        }
        long h2 = aVar.f33638a.h();
        if (h2 != -9223372036854775807L) {
            H(h2);
            o oVar = this.q;
            o e2 = oVar.e(oVar.f33722c, h2, oVar.f33724e);
            this.q = e2;
            this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
        } else {
            r rVar = this.s;
            if (rVar != null && !rVar.b() && (this.s.isReady() || !E(this.s))) {
                long q = this.t.q();
                this.J = q;
                this.f33636i.a(q);
            } else {
                this.J = this.f33636i.q();
            }
            h2 = this.M.k(this.J);
        }
        this.q.f33725f = h2;
        this.F = SystemClock.elapsedRealtime() * 1000;
        long c2 = this.v.length == 0 ? Long.MIN_VALUE : this.M.f33638a.c();
        o oVar2 = this.q;
        if (c2 == Long.MIN_VALUE) {
            c2 = this.M.f33644g.f33717e;
        }
        oVar2.f33726g = c2;
    }

    public final void j0() throws ExoPlaybackException {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            a aVar3 = this.M;
            if (aVar3 == null) {
                aVar3 = this.K;
            }
            if (aVar3 == null) {
                return;
            }
            while (true) {
                int d2 = this.q.f33720a.d(aVar3.f33644g.f33713a.f32876a, this.o, this.n, this.B, this.C);
                while (true) {
                    a aVar4 = aVar3.f33647j;
                    if (aVar4 == null || aVar3.f33644g.f33718f) {
                        break;
                    }
                    aVar3 = aVar4;
                }
                if (d2 == -1 || (aVar2 = aVar3.f33647j) == null || aVar2.f33644g.f33713a.f32876a != d2) {
                    break;
                }
                aVar3 = aVar2;
            }
            int i2 = this.K.f33640c;
            a aVar5 = this.L;
            int i3 = aVar5 != null ? aVar5.f33640c : -1;
            a aVar6 = aVar3.f33647j;
            if (aVar6 != null) {
                D(aVar6);
                aVar3.f33647j = null;
            }
            aVar3.f33644g = this.p.f(aVar3.f33644g);
            boolean z = true;
            if (!(i2 <= aVar3.f33640c)) {
                this.K = aVar3;
            }
            if (((i3 == -1 || i3 > aVar3.f33640c) ? false : false) || (aVar = this.M) == null) {
                return;
            }
            l.b bVar = aVar.f33644g.f33713a;
            long N = N(bVar, this.q.f33725f);
            if (N != this.q.f33725f) {
                o oVar = this.q;
                o e2 = oVar.e(bVar, N, oVar.f33724e);
                this.q = e2;
                this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
            }
        }
    }

    public final Pair<Integer, Long> k(w wVar, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{wVar, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? wVar.i(this.n, this.o, i2, j2) : (Pair) invokeCommon.objValue;
    }

    @Override // c.i.b.a.d0.k.a
    public void l(c.i.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, kVar) == null) {
            this.f33637j.obtainMessage(8, kVar).sendToTarget();
        }
    }

    public final void m(c.i.b.a.d0.k kVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, kVar) == null) && (aVar = this.K) != null && aVar.f33638a == kVar) {
            s();
        }
    }

    public final void n(c.i.b.a.d0.k kVar) throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) && (aVar = this.K) != null && aVar.f33638a == kVar) {
            aVar.e();
            if (this.M == null) {
                a aVar2 = this.K;
                this.L = aVar2;
                H(aVar2.f33644g.f33714b);
                V(this.L);
            }
            s();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            p(0, 0);
        }
    }

    public final void p(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i2, i3) == null) {
            w wVar = this.q.f33720a;
            int i4 = wVar.p() ? 0 : wVar.l(wVar.a(this.C), this.n).f33760f;
            this.q = this.q.d(i4, -9223372036854775807L, -9223372036854775807L);
            a0(4);
            x(i2, i3, this.q.d(i4, 0L, -9223372036854775807L));
            G(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e0, code lost:
        r3 = r20.L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e2, code lost:
        if (r3 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e8, code lost:
        if (r3.f33640c >= r2.f33640c) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ea, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01eb, code lost:
        if (r11 != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ed, code lost:
        r6 = N(r20.M.f33644g.f33713a, r20.q.f33725f);
        r4 = r20.q;
        r20.q = r4.e(r20.M.f33644g.f33713a, r6, r4.f33724e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020c, code lost:
        r20.K = r1;
        r1.f33647j = null;
        D(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(b bVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, bVar) == null) && bVar.f33648a == this.u) {
            w wVar = this.q.f33720a;
            w wVar2 = bVar.f33649b;
            Object obj = bVar.f33650c;
            this.p.n(wVar2);
            o c2 = this.q.c(wVar2, obj);
            this.q = c2;
            boolean z = false;
            if (wVar == null) {
                int i2 = this.G;
                this.G = 0;
                if (this.H > 0) {
                    Pair<Integer, Long> I = I(this.I);
                    int i3 = this.H;
                    this.H = 0;
                    this.I = null;
                    if (I == null) {
                        p(i2, i3);
                        return;
                    }
                    int intValue = ((Integer) I.first).intValue();
                    long longValue = ((Long) I.second).longValue();
                    l.b k = this.p.k(intValue, longValue);
                    this.q = this.q.e(k, k.b() ? 0L : longValue, longValue);
                    w(i2, i3);
                    return;
                } else if (c2.f33723d == -9223372036854775807L) {
                    if (wVar2.p()) {
                        p(i2, 0);
                        return;
                    }
                    Pair<Integer, Long> k2 = k(wVar2, wVar2.a(this.C), -9223372036854775807L);
                    int intValue2 = ((Integer) k2.first).intValue();
                    long longValue2 = ((Long) k2.second).longValue();
                    l.b k3 = this.p.k(intValue2, longValue2);
                    this.q = this.q.e(k3, k3.b() ? 0L : longValue2, longValue2);
                    w(i2, 0);
                    return;
                } else {
                    w(i2, 0);
                    return;
                }
            }
            int i4 = c2.f33722c.f32876a;
            a aVar = this.M;
            if (aVar == null) {
                aVar = this.K;
            }
            if (aVar == null && i4 >= wVar.h()) {
                v();
                return;
            }
            int b2 = wVar2.b(aVar == null ? wVar.g(i4, this.o, true).f33746b : aVar.f33639b);
            if (b2 == -1) {
                int J = J(i4, wVar, wVar2);
                if (J == -1) {
                    o();
                    return;
                }
                Pair<Integer, Long> k4 = k(wVar2, wVar2.f(J, this.o).f33747c, -9223372036854775807L);
                int intValue3 = ((Integer) k4.first).intValue();
                long longValue3 = ((Long) k4.second).longValue();
                wVar2.g(intValue3, this.o, true);
                if (aVar != null) {
                    Object obj2 = this.o.f33746b;
                    aVar.f33644g = aVar.f33644g.a(-1);
                    while (true) {
                        aVar = aVar.f33647j;
                        if (aVar == null) {
                            break;
                        } else if (aVar.f33639b.equals(obj2)) {
                            aVar.f33644g = this.p.g(aVar.f33644g, intValue3);
                        } else {
                            aVar.f33644g = aVar.f33644g.a(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.q = this.q.e(bVar2, N(bVar2, longValue3), -9223372036854775807L);
                v();
                return;
            }
            if (b2 != i4) {
                this.q = this.q.b(b2);
            }
            if (this.q.f33722c.b()) {
                l.b k5 = this.p.k(b2, this.q.f33724e);
                if (!k5.b() || k5.f32878c != this.q.f33722c.f32878c) {
                    this.q = this.q.e(k5, N(k5, this.q.f33724e), k5.b() ? this.q.f33724e : -9223372036854775807L);
                    v();
                    return;
                }
            }
            if (aVar == null) {
                v();
                return;
            }
            a g0 = g0(aVar, b2);
            int i5 = b2;
            while (true) {
                a aVar2 = g0.f33647j;
                if (aVar2 == null) {
                    break;
                }
                i5 = wVar2.d(i5, this.o, this.n, this.B, this.C);
                if (i5 == -1 || !aVar2.f33639b.equals(wVar2.g(i5, this.o, true).f33746b)) {
                    break;
                }
                g0 = g0(aVar2, i5);
            }
            v();
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j2)) == null) ? j2 == -9223372036854775807L || this.q.f33725f < j2 || ((aVar = this.M.f33647j) != null && (aVar.f33645h || aVar.f33644g.f33713a.b())) : invokeJ.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            boolean j2 = this.K.j(this.J);
            Q(j2);
            if (j2) {
                this.K.b(this.J);
            }
        }
    }

    public final void t() throws IOException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (aVar = this.K) == null || aVar.f33645h) {
            return;
        }
        a aVar2 = this.L;
        if (aVar2 == null || aVar2.f33647j == aVar) {
            for (r rVar : this.v) {
                if (!rVar.f()) {
                    return;
                }
            }
            this.K.f33638a.q();
        }
    }

    public final void u() throws IOException {
        n.b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            a aVar = this.K;
            if (aVar == null) {
                e2 = this.p.a(this.q);
            } else if (aVar.f33644g.f33719g || !aVar.g()) {
                return;
            } else {
                a aVar2 = this.K;
                if (aVar2.f33644g.f33717e == -9223372036854775807L) {
                    return;
                }
                a aVar3 = this.M;
                if (aVar3 != null && aVar2.f33640c - aVar3.f33640c == 100) {
                    return;
                }
                n nVar = this.p;
                a aVar4 = this.K;
                e2 = nVar.e(aVar4.f33644g, aVar4.d(), this.J);
            }
            if (e2 == null) {
                this.u.b();
                return;
            }
            a aVar5 = this.K;
            long d2 = aVar5 == null ? 60000000L : aVar5.d() + this.K.f33644g.f33717e;
            a aVar6 = this.K;
            a aVar7 = new a(this.f33632e, this.f33633f, d2, this.f33634g, this.f33635h, this.u, this.q.f33720a.g(e2.f33713a.f32876a, this.o, true).f33746b, aVar6 == null ? 0 : aVar6.f33640c + 1, e2);
            a aVar8 = this.K;
            if (aVar8 != null) {
                aVar8.f33647j = aVar7;
            }
            this.K = aVar7;
            aVar7.f33638a.o(this, e2.f33714b);
            Q(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            w(0, 0);
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            x(i2, i3, this.q);
        }
    }

    public final void x(int i2, int i3, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048634, this, i2, i3, oVar) == null) {
            this.l.obtainMessage(5, i2, i3, oVar).sendToTarget();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.d0.p.a
    /* renamed from: y */
    public void j(c.i.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, kVar) == null) {
            this.f33637j.obtainMessage(9, kVar).sendToTarget();
        }
    }

    public void z(c.i.b.a.d0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, lVar, z) == null) {
            this.f33637j.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
        }
    }
}
