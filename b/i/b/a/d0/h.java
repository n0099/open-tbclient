package b.i.b.a.d0;

import android.net.Uri;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.i;
import b.i.b.a.d0.k;
import b.i.b.a.d0.n;
import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements k, b.i.b.a.a0.g, Loader.a<d>, Loader.d, n.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public t D;
    public long E;
    public boolean[] F;
    public boolean[] G;
    public boolean H;
    public long I;
    public long J;
    public long K;
    public int L;
    public boolean M;
    public boolean N;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f31929e;

    /* renamed from: f  reason: collision with root package name */
    public final b.i.b.a.h0.e f31930f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31931g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f31932h;

    /* renamed from: i  reason: collision with root package name */
    public final i.a f31933i;
    public final f j;
    public final b.i.b.a.h0.b k;
    public final String l;
    public final long m;
    public final Loader n;
    public final e o;
    public final b.i.b.a.i0.e p;
    public final Runnable q;
    public final Runnable r;
    public final Handler s;
    public k.a t;
    public b.i.b.a.a0.l u;
    public n[] v;
    public int[] w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f31934e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31934e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31934e.H();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f31935e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31935e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31935e.N) {
                return;
            }
            this.f31935e.t.j(this.f31935e);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IOException f31936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f31937f;

        public c(h hVar, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, iOException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31937f = hVar;
            this.f31936e = iOException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31937f.f31933i.a(this.f31936e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class d implements Loader.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Uri f31938a;

        /* renamed from: b  reason: collision with root package name */
        public final b.i.b.a.h0.e f31939b;

        /* renamed from: c  reason: collision with root package name */
        public final e f31940c;

        /* renamed from: d  reason: collision with root package name */
        public final b.i.b.a.i0.e f31941d;

        /* renamed from: e  reason: collision with root package name */
        public final b.i.b.a.a0.k f31942e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f31943f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31944g;

        /* renamed from: h  reason: collision with root package name */
        public long f31945h;

        /* renamed from: i  reason: collision with root package name */
        public long f31946i;
        public final /* synthetic */ h j;

        public d(h hVar, Uri uri, b.i.b.a.h0.e eVar, e eVar2, b.i.b.a.i0.e eVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, uri, eVar, eVar2, eVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hVar;
            b.i.b.a.i0.a.e(uri);
            this.f31938a = uri;
            b.i.b.a.i0.a.e(eVar);
            this.f31939b = eVar;
            b.i.b.a.i0.a.e(eVar2);
            this.f31940c = eVar2;
            this.f31941d = eVar3;
            this.f31942e = new b.i.b.a.a0.k();
            this.f31944g = true;
            this.f31946i = -1L;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void a() throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = 0;
                while (i2 == 0 && !this.f31943f) {
                    b.i.b.a.a0.b bVar = null;
                    try {
                        long j = this.f31942e.f31373a;
                        long a2 = this.f31939b.a(new b.i.b.a.h0.g(this.f31938a, j, -1L, this.j.l));
                        this.f31946i = a2;
                        if (a2 != -1) {
                            this.f31946i = a2 + j;
                        }
                        b.i.b.a.a0.b bVar2 = new b.i.b.a.a0.b(this.f31939b, j, this.f31946i);
                        try {
                            b.i.b.a.a0.e b2 = this.f31940c.b(bVar2, this.f31939b.getUri());
                            if (this.f31944g) {
                                b2.a(j, this.f31945h);
                                this.f31944g = false;
                            }
                            while (i2 == 0 && !this.f31943f) {
                                this.f31941d.a();
                                i2 = b2.e(bVar2, this.f31942e);
                                if (bVar2.getPosition() > this.j.m + j) {
                                    j = bVar2.getPosition();
                                    this.f31941d.b();
                                    this.j.s.post(this.j.r);
                                }
                            }
                            if (i2 == 1) {
                                i2 = 0;
                            } else {
                                this.f31942e.f31373a = bVar2.getPosition();
                            }
                            v.h(this.f31939b);
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (i2 != 1 && bVar != null) {
                                this.f31942e.f31373a = bVar.getPosition();
                            }
                            v.h(this.f31939b);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31943f : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f31943f = true;
            }
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f31942e.f31373a = j;
                this.f31945h = j2;
                this.f31944g = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.i.b.a.a0.e[] f31947a;

        /* renamed from: b  reason: collision with root package name */
        public final b.i.b.a.a0.g f31948b;

        /* renamed from: c  reason: collision with root package name */
        public b.i.b.a.a0.e f31949c;

        public e(b.i.b.a.a0.e[] eVarArr, b.i.b.a.a0.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVarArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31947a = eVarArr;
            this.f31948b = gVar;
        }

        public void a() {
            b.i.b.a.a0.e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f31949c) == null) {
                return;
            }
            eVar.release();
            this.f31949c = null;
        }

        public b.i.b.a.a0.e b(b.i.b.a.a0.f fVar, Uri uri) throws IOException, InterruptedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, uri)) == null) {
                b.i.b.a.a0.e eVar = this.f31949c;
                if (eVar != null) {
                    return eVar;
                }
                b.i.b.a.a0.e[] eVarArr = this.f31947a;
                int length = eVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    b.i.b.a.a0.e eVar2 = eVarArr[i2];
                    try {
                    } catch (EOFException unused) {
                    } catch (Throwable th) {
                        fVar.e();
                        throw th;
                    }
                    if (eVar2.d(fVar)) {
                        this.f31949c = eVar2;
                        fVar.e();
                        break;
                    }
                    continue;
                    fVar.e();
                    i2++;
                }
                b.i.b.a.a0.e eVar3 = this.f31949c;
                if (eVar3 != null) {
                    eVar3.f(this.f31948b);
                    return this.f31949c;
                }
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.o(this.f31947a) + ") could read the stream.", uri);
            }
            return (b.i.b.a.a0.e) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void c(long j, boolean z);
    }

    /* loaded from: classes6.dex */
    public final class g implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f31950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f31951f;

        public g(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31951f = hVar;
            this.f31950e = i2;
        }

        @Override // b.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31951f.I();
            }
        }

        @Override // b.i.b.a.d0.o
        public int f(b.i.b.a.l lVar, b.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, eVar, z)) == null) ? this.f31951f.N(this.f31950e, lVar, eVar, z) : invokeLLZ.intValue;
        }

        @Override // b.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31951f.G(this.f31950e) : invokeV.booleanValue;
        }

        @Override // b.i.b.a.d0.o
        public int j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f31951f.Q(this.f31950e, j) : invokeJ.intValue;
        }
    }

    public h(Uri uri, b.i.b.a.h0.e eVar, b.i.b.a.a0.e[] eVarArr, int i2, Handler handler, i.a aVar, f fVar, b.i.b.a.h0.b bVar, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, eVar, eVarArr, Integer.valueOf(i2), handler, aVar, fVar, bVar, str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31929e = uri;
        this.f31930f = eVar;
        this.f31931g = i2;
        this.f31932h = handler;
        this.f31933i = aVar;
        this.j = fVar;
        this.k = bVar;
        this.l = str;
        this.m = i3;
        this.n = new Loader("Loader:ExtractorMediaPeriod");
        this.o = new e(eVarArr, this);
        this.p = new b.i.b.a.i0.e();
        this.q = new a(this);
        this.r = new b(this);
        this.s = new Handler();
        this.w = new int[0];
        this.v = new n[0];
        this.K = -9223372036854775807L;
        this.I = -1L;
        this.z = i2 == -1 ? 3 : i2;
    }

    public final void A(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && this.I == -1) {
            b.i.b.a.a0.l lVar = this.u;
            if (lVar == null || lVar.h() == -9223372036854775807L) {
                this.J = 0L;
                this.B = this.y;
                for (n nVar : this.v) {
                    nVar.A();
                }
                dVar.d(0L, 0L);
            }
        }
    }

    public final void B(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) && this.I == -1) {
            this.I = dVar.f31946i;
        }
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = 0;
            for (n nVar : this.v) {
                i2 += nVar.r();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = Long.MIN_VALUE;
            for (n nVar : this.v) {
                j = Math.max(j, nVar.o());
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final boolean E(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iOException)) == null) ? iOException instanceof UnrecognizedInputFormatException : invokeL.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.K != -9223372036854775807L : invokeV.booleanValue;
    }

    public boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? !S() && (this.M || this.v[i2].s()) : invokeI.booleanValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.N || this.y || this.u == null || !this.x) {
            return;
        }
        for (n nVar : this.v) {
            if (nVar.q() == null) {
                return;
            }
        }
        this.p.b();
        int length = this.v.length;
        s[] sVarArr = new s[length];
        this.G = new boolean[length];
        this.F = new boolean[length];
        this.E = this.u.h();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            Format q = this.v[i2].q();
            sVarArr[i2] = new s(q);
            String str = q.sampleMimeType;
            if (!b.i.b.a.i0.i.i(str) && !b.i.b.a.i0.i.g(str)) {
                z = false;
            }
            this.G[i2] = z;
            this.H = z | this.H;
            i2++;
        }
        this.D = new t(sVarArr);
        if (this.f31931g == -1 && this.I == -1 && this.u.h() == -9223372036854775807L) {
            this.z = 6;
        }
        this.y = true;
        this.j.c(this.E, this.u.b());
        this.t.l(this);
    }

    public void I() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n.h(this.z);
        }
    }

    public final void J(IOException iOException) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iOException) == null) || (handler = this.f31932h) == null || this.f31933i == null) {
            return;
        }
        handler.post(new c(this, iOException));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: K */
    public void l(d dVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{dVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) || z) {
            return;
        }
        B(dVar);
        for (n nVar : this.v) {
            nVar.A();
        }
        if (this.C > 0) {
            this.t.j(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: L */
    public void m(d dVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{dVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            B(dVar);
            this.M = true;
            if (this.E == -9223372036854775807L) {
                long D = D();
                long j3 = D == Long.MIN_VALUE ? 0L : D + 10000;
                this.E = j3;
                this.j.c(j3, this.u.b());
            }
            this.t.j(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: M */
    public int n(d dVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{dVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            B(dVar);
            J(iOException);
            if (E(iOException)) {
                return 3;
            }
            int i2 = C() > this.L ? 1 : 0;
            A(dVar);
            this.L = C();
            return i2;
        }
        return invokeCommon.intValue;
    }

    public int N(int i2, b.i.b.a.l lVar, b.i.b.a.y.e eVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), lVar, eVar, Boolean.valueOf(z)})) == null) {
            if (S()) {
                return -3;
            }
            return this.v[i2].w(lVar, eVar, z, this.M, this.J);
        }
        return invokeCommon.intValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean j = this.n.j(this);
            if (this.y && !j) {
                for (n nVar : this.v) {
                    nVar.k();
                }
            }
            this.s.removeCallbacksAndMessages(null);
            this.N = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048591, this, j)) != null) {
            return invokeJ.booleanValue;
        }
        int length = this.v.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            n nVar = this.v[i2];
            nVar.C();
            if ((nVar.f(j, true, false) != -1) || (!this.G[i2] && this.H)) {
                nVar.l();
                i2++;
            }
        }
    }

    public int Q(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (S()) {
                return 0;
            }
            n nVar = this.v[i2];
            if (this.M && j > nVar.o()) {
                return nVar.g();
            }
            int f2 = nVar.f(j, true, true);
            if (f2 == -1) {
                return 0;
            }
            return f2;
        }
        return invokeCommon.intValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d dVar = new d(this, this.f31929e, this.f31930f, this.o, this.p);
            if (this.y) {
                b.i.b.a.i0.a.f(F());
                long j = this.E;
                if (j != -9223372036854775807L && this.K >= j) {
                    this.M = true;
                    this.K = -9223372036854775807L;
                    return;
                }
                dVar.d(this.u.c(this.K), this.K);
                this.K = -9223372036854775807L;
            }
            this.L = C();
            this.n.k(dVar, this, this.z);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.B || F() : invokeV.booleanValue;
    }

    @Override // b.i.b.a.a0.g
    public b.i.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            int length = this.v.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.w[i4] == i2) {
                    return this.v[i4];
                }
            }
            n nVar = new n(this.k);
            nVar.E(this);
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.w, i5);
            this.w = copyOf;
            copyOf[length] = i2;
            n[] nVarArr = (n[]) Arrays.copyOf(this.v, i5);
            this.v = nVarArr;
            nVarArr[length] = nVar;
            return nVar;
        }
        return (b.i.b.a.a0.m) invokeII.objValue;
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
            if (this.M) {
                return false;
            }
            if (this.y && this.C == 0) {
                return false;
            }
            boolean c2 = this.p.c();
            if (this.n.g()) {
                return c2;
            }
            R();
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        long D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.M) {
                return Long.MIN_VALUE;
            }
            if (F()) {
                return this.K;
            }
            if (this.H) {
                D = Long.MAX_VALUE;
                int length = this.v.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.G[i2]) {
                        D = Math.min(D, this.v[i2].o());
                    }
                }
            } else {
                D = D();
            }
            return D == Long.MIN_VALUE ? this.J : D;
        }
        return invokeV.longValue;
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.C == 0) {
                return Long.MIN_VALUE;
            }
            return c();
        }
        return invokeV.longValue;
    }

    @Override // b.i.b.a.d0.k
    public long e(b.i.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            b.i.b.a.i0.a.f(this.y);
            int i2 = this.C;
            int i3 = 0;
            for (int i4 = 0; i4 < fVarArr.length; i4++) {
                if (oVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                    int i5 = ((g) oVarArr[i4]).f31950e;
                    b.i.b.a.i0.a.f(this.F[i5]);
                    this.C--;
                    this.F[i5] = false;
                    oVarArr[i4] = null;
                }
            }
            boolean z = !this.A ? j == 0 : i2 != 0;
            for (int i6 = 0; i6 < fVarArr.length; i6++) {
                if (oVarArr[i6] == null && fVarArr[i6] != null) {
                    b.i.b.a.f0.f fVar = fVarArr[i6];
                    b.i.b.a.i0.a.f(fVar.length() == 1);
                    b.i.b.a.i0.a.f(fVar.b(0) == 0);
                    int b2 = this.D.b(fVar.d());
                    b.i.b.a.i0.a.f(!this.F[b2]);
                    this.C++;
                    this.F[b2] = true;
                    oVarArr[i6] = new g(this, b2);
                    zArr2[i6] = true;
                    if (!z) {
                        n nVar = this.v[b2];
                        nVar.C();
                        z = nVar.f(j, true, true) == -1 && nVar.p() != 0;
                    }
                }
            }
            if (this.C == 0) {
                this.B = false;
                if (this.n.g()) {
                    n[] nVarArr = this.v;
                    int length = nVarArr.length;
                    while (i3 < length) {
                        nVarArr[i3].k();
                        i3++;
                    }
                    this.n.f();
                } else {
                    n[] nVarArr2 = this.v;
                    int length2 = nVarArr2.length;
                    while (i3 < length2) {
                        nVarArr2[i3].A();
                        i3++;
                    }
                }
            } else if (z) {
                j = g(j);
                while (i3 < oVarArr.length) {
                    if (oVarArr[i3] != null) {
                        zArr2[i3] = true;
                    }
                    i3++;
                }
            }
            this.A = true;
            return j;
        }
        return invokeCommon.longValue;
    }

    @Override // b.i.b.a.d0.n.b
    public void f(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, format) == null) {
            this.s.post(this.q);
        }
    }

    @Override // b.i.b.a.d0.k
    public long g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
            if (!this.u.b()) {
                j = 0;
            }
            this.J = j;
            this.B = false;
            if (F() || !P(j)) {
                this.K = j;
                this.M = false;
                if (this.n.g()) {
                    this.n.f();
                } else {
                    for (n nVar : this.v) {
                        nVar.A();
                    }
                }
                return j;
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // b.i.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.B) {
                this.B = false;
                return this.J;
            }
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.o.a();
            for (n nVar : this.v) {
                nVar.A();
            }
        }
    }

    @Override // b.i.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.x = true;
            this.s.post(this.q);
        }
    }

    @Override // b.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.D : (t) invokeV.objValue;
    }

    @Override // b.i.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048609, this, aVar, j) == null) {
            this.t = aVar;
            this.p.c();
            R();
        }
    }

    @Override // b.i.b.a.a0.g
    public void p(b.i.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, lVar) == null) {
            this.u = lVar;
            this.s.post(this.q);
        }
    }

    @Override // b.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            I();
        }
    }

    @Override // b.i.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            int length = this.v.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.v[i2].j(j, false, this.F[i2]);
            }
        }
    }
}
