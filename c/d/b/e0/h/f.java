package c.d.b.e0.h;

import androidx.core.view.InputDeviceCompat;
import c.d.b.d0;
import c.d.b.e0.h.e;
import c.d.b.j;
import c.d.b.p;
import c.d.b.t;
import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.duxiaoman.okhttp3.internal.http2.StreamResetException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static ScheduledExecutorService s;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.d.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public e.a f27746b;

    /* renamed from: c  reason: collision with root package name */
    public d0 f27747c;

    /* renamed from: d  reason: collision with root package name */
    public final j f27748d;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.b.e f27749e;

    /* renamed from: f  reason: collision with root package name */
    public final p f27750f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f27751g;

    /* renamed from: h  reason: collision with root package name */
    public final e f27752h;

    /* renamed from: i  reason: collision with root package name */
    public int f27753i;

    /* renamed from: j  reason: collision with root package name */
    public c f27754j;
    public boolean k;
    public boolean l;
    public boolean m;
    public c.d.b.e0.i.c n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f27755e;

        /* renamed from: f  reason: collision with root package name */
        public final int f27756f;

        /* renamed from: g  reason: collision with root package name */
        public final int f27757g;

        /* renamed from: h  reason: collision with root package name */
        public final int f27758h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f27759i;

        /* renamed from: j  reason: collision with root package name */
        public final c f27760j;
        public volatile boolean k;
        public final BlockingQueue<a> l;
        public RuntimeException m;
        public final /* synthetic */ f n;

        public a(f fVar, c cVar, BlockingQueue<a> blockingQueue, int i2, int i3, int i4, int i5, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, cVar, blockingQueue, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = fVar;
            this.f27755e = i2;
            this.l = blockingQueue;
            this.f27756f = i3;
            this.f27757g = i4;
            this.f27758h = i5;
            this.f27759i = z;
            this.f27760j = cVar;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k = true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
            if (r9.k != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
            r9.f27760j.c();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
            r9.l.put(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
            if (r9.k == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            try {
                try {
                    try {
                        if (this.k) {
                            try {
                                if (this.k) {
                                    this.f27760j.c();
                                } else {
                                    this.l.put(this);
                                }
                                return;
                            } catch (InterruptedException unused) {
                                return;
                            }
                        }
                        this.f27760j.d(this.f27755e, this.f27756f, this.f27757g, this.f27758h, this.f27759i, this.n.f27749e, this.n.f27750f);
                    } catch (RuntimeException e2) {
                        this.m = e2;
                    }
                } catch (InterruptedException unused2) {
                }
            } catch (Throwable th) {
                try {
                    if (this.k) {
                        this.f27760j.c();
                    } else {
                        this.l.put(this);
                    }
                } catch (InterruptedException unused3) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends WeakReference<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, Object obj) {
            super(fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1090494032, "Lc/d/b/e0/h/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1090494032, "Lc/d/b/e0/h/f;");
        }
    }

    public f(j jVar, c.d.b.a aVar, c.d.b.e eVar, p pVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, aVar, eVar, pVar, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27748d = jVar;
        this.a = aVar;
        this.f27749e = eVar;
        this.f27750f = pVar;
        this.f27752h = new e(aVar, u(), eVar, pVar);
        this.f27751g = obj;
    }

    public void a(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cVar, z) == null) {
            if (this.f27754j == null) {
                this.f27754j = cVar;
                this.k = z;
                cVar.n.add(new b(this, this.f27751g));
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void b() {
        c.d.b.e0.i.c cVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f27748d) {
                this.m = true;
                cVar = this.n;
                cVar2 = this.f27754j;
            }
            if (cVar != null) {
                cVar.cancel();
            } else if (cVar2 != null) {
                cVar2.c();
            }
        }
    }

    public c.d.b.e0.i.c c() {
        InterceptResult invokeV;
        c.d.b.e0.i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f27748d) {
                cVar = this.n;
            }
            return cVar;
        }
        return (c.d.b.e0.i.c) invokeV.objValue;
    }

    public synchronized c d() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                cVar = this.f27754j;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final Socket e(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Socket socket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z3) {
                this.n = null;
            }
            if (z2) {
                this.l = true;
            }
            c cVar = this.f27754j;
            if (cVar != null) {
                if (z) {
                    cVar.k = true;
                }
                if (this.n == null) {
                    if (this.l || this.f27754j.k) {
                        q(this.f27754j);
                        if (this.f27754j.n.isEmpty()) {
                            this.f27754j.o = System.nanoTime();
                            if (c.d.b.e0.a.a.e(this.f27748d, this.f27754j)) {
                                socket = this.f27754j.o();
                                this.f27754j = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f27754j = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (Socket) invokeCommon.objValue;
    }

    public final c f(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Socket s2;
        Socket socket;
        c cVar;
        c cVar2;
        boolean z2;
        d0 d0Var;
        boolean z3;
        boolean z4;
        c cVar3;
        e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            synchronized (this.f27748d) {
                if (!this.l) {
                    if (this.n == null) {
                        if (!this.m) {
                            c cVar4 = this.f27754j;
                            s2 = s();
                            socket = null;
                            if (this.f27754j != null) {
                                cVar2 = this.f27754j;
                                cVar = null;
                            } else {
                                cVar = cVar4;
                                cVar2 = null;
                            }
                            if (!this.k) {
                                cVar = null;
                            }
                            z2 = false;
                            if (cVar2 == null) {
                                c.d.b.e0.a.a.h(this.f27748d, this.a, this, null);
                                if (this.f27754j != null) {
                                    cVar2 = this.f27754j;
                                    d0Var = null;
                                    z3 = true;
                                } else {
                                    d0Var = this.f27747c;
                                }
                            } else {
                                d0Var = null;
                            }
                            z3 = false;
                        } else {
                            throw new IOException(ResponseException.CANCELED);
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            }
            c.d.b.e0.e.g(s2);
            if (cVar != null) {
                this.f27750f.connectionReleased(this.f27749e, cVar);
            }
            if (z3) {
                this.f27750f.connectionAcquired(this.f27749e, cVar2);
            }
            if (cVar2 != null) {
                this.f27747c = this.f27754j.route();
                return cVar2;
            }
            if (d0Var != null || ((aVar = this.f27746b) != null && aVar.b())) {
                z4 = false;
            } else {
                this.f27746b = this.f27752h.e();
                z4 = true;
            }
            synchronized (this.f27748d) {
                if (this.m) {
                    throw new IOException(ResponseException.CANCELED);
                }
                if (z4) {
                    List<d0> a2 = this.f27746b.a();
                    int size = a2.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            break;
                        }
                        d0 d0Var2 = a2.get(i6);
                        c.d.b.e0.a.a.h(this.f27748d, this.a, this, d0Var2);
                        if (this.f27754j != null) {
                            cVar2 = this.f27754j;
                            this.f27747c = d0Var2;
                            z3 = true;
                            break;
                        }
                        i6++;
                    }
                }
                if (!z3) {
                    if (d0Var == null) {
                        d0Var = this.f27746b.d();
                    }
                    this.f27747c = d0Var;
                    this.f27753i = 0;
                    cVar2 = new c(this.f27748d, d0Var);
                    a(cVar2, false);
                }
                cVar3 = cVar2;
            }
            if (z3) {
                this.f27750f.connectionAcquired(this.f27749e, cVar3);
                return cVar3;
            }
            if (this.f27746b == null) {
                this.f27746b = this.f27752h.e();
            }
            d0 h2 = h();
            if (this.o > 0 && k(cVar3.route()) && h2 != null && this.q) {
                z2 = true;
            }
            if (z2) {
                this.r = true;
                cVar3 = i(i2, i3, i4, i5, z, cVar3, h2);
            } else {
                cVar3.d(i2, i3, i4, i5, z, this.f27749e, this.f27750f);
            }
            u().a(cVar3.route());
            synchronized (this.f27748d) {
                this.k = true;
                c.d.b.e0.a.a.j(this.f27748d, cVar3);
                if (cVar3.m()) {
                    socket = c.d.b.e0.a.a.f(this.f27748d, this.a, this);
                    cVar3 = this.f27754j;
                }
            }
            c.d.b.e0.e.g(socket);
            this.f27750f.connectionAcquired(this.f27749e, cVar3);
            return cVar3;
        }
        return (c) invokeCommon.objValue;
    }

    public final c g(int i2, int i3, int i4, int i5, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (c) invokeCommon.objValue;
        }
        while (true) {
            c f2 = f(i2, i3, i4, i5, z);
            synchronized (this.f27748d) {
                if (f2.l == 0 && !f2.m()) {
                    return f2;
                }
                if (f2.l(z2)) {
                    return f2;
                }
                o();
            }
        }
    }

    public final d0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            for (int i2 = 0; i2 < this.f27746b.a().size(); i2++) {
                d0 d0Var = this.f27746b.a().get(i2);
                if (d0Var.d().getAddress() instanceof Inet4Address) {
                    return d0Var;
                }
            }
            return null;
        }
        return (d0) invokeV.objValue;
    }

    public final c i(int i2, int i3, int i4, int i5, boolean z, c cVar, d0 d0Var) {
        InterceptResult invokeCommon;
        a aVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), cVar, d0Var})) == null) {
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            synchronized (this.f27748d) {
                if (s == null) {
                    s = Executors.newScheduledThreadPool(2);
                }
            }
            a aVar2 = new a(this, cVar, synchronousQueue, i2, i3, i4, i5, z);
            a aVar3 = new a(this, new c(this.f27748d, d0Var), synchronousQueue, i2, i3, i4, i5, z);
            s.execute(aVar2);
            s.schedule(aVar3, this.o, TimeUnit.MILLISECONDS);
            c cVar3 = null;
            try {
                aVar = (a) synchronousQueue.take();
                cVar2 = aVar.f27760j;
            } catch (InterruptedException unused) {
            }
            try {
                this.f27747c = cVar2.route();
                if (aVar == aVar2) {
                    aVar3.cancel();
                } else {
                    aVar2.cancel();
                    this.p = true;
                    this.f27746b.c();
                }
                if (aVar.m != null) {
                    throw aVar.m;
                }
                synchronized (this.f27748d) {
                    q(this.f27754j);
                    this.f27754j = null;
                    a(cVar2, false);
                }
                return cVar2;
            } catch (InterruptedException unused2) {
                cVar3 = cVar2;
                return cVar3;
            }
        }
        return (c) invokeCommon.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        e.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27747c != null || ((aVar = this.f27746b) != null && aVar.b()) || this.f27752h.c() : invokeV.booleanValue;
    }

    public final boolean k(d0 d0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, d0Var)) == null) ? d0Var != null && (d0Var.d().getAddress() instanceof Inet6Address) : invokeL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public c.d.b.e0.i.c n(w wVar, t.a aVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048589, this, wVar, aVar, z)) == null) {
            int connectTimeoutMillis = aVar.connectTimeoutMillis();
            int readTimeoutMillis = aVar.readTimeoutMillis();
            int writeTimeoutMillis = aVar.writeTimeoutMillis();
            int w = wVar.w();
            boolean C = wVar.C();
            this.o = wVar.n();
            this.q = wVar.r();
            try {
                c.d.b.e0.i.c n = g(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, w, C, z).n(wVar, aVar, this);
                synchronized (this.f27748d) {
                    this.n = n;
                }
                return n;
            } catch (IOException e2) {
                throw new RouteException(e2);
            }
        }
        return (c.d.b.e0.i.c) invokeLLZ.objValue;
    }

    public void o() {
        c cVar;
        Socket e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f27748d) {
                cVar = this.f27754j;
                e2 = e(true, false, false);
                if (this.f27754j != null) {
                    cVar = null;
                }
            }
            c.d.b.e0.e.g(e2);
            if (cVar != null) {
                this.f27750f.connectionReleased(this.f27749e, cVar);
            }
        }
    }

    public void p() {
        c cVar;
        Socket e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.f27748d) {
                cVar = this.f27754j;
                e2 = e(false, true, false);
                if (this.f27754j != null) {
                    cVar = null;
                }
            }
            c.d.b.e0.e.g(e2);
            if (cVar != null) {
                c.d.b.e0.a.a.l(this.f27749e, null);
                this.f27750f.connectionReleased(this.f27749e, cVar);
                this.f27750f.callEnd(this.f27749e);
            }
        }
    }

    public final void q(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            int size = cVar.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (cVar.n.get(i2).get() == this) {
                    cVar.n.remove(i2);
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public Socket r(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cVar)) == null) {
            if (this.n == null && this.f27754j.n.size() == 1) {
                Socket e2 = e(true, false, false);
                this.f27754j = cVar;
                cVar.n.add(this.f27754j.n.get(0));
                return e2;
            }
            throw new IllegalStateException();
        }
        return (Socket) invokeL.objValue;
    }

    public final Socket s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c cVar = this.f27754j;
            if (cVar == null || !cVar.k) {
                return null;
            }
            return e(false, false, true);
        }
        return (Socket) invokeV.objValue;
    }

    public d0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f27747c : (d0) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            c d2 = d();
            return d2 != null ? d2.toString() : this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    public final d u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? c.d.b.e0.a.a.k(this.f27748d) : (d) invokeV.objValue;
    }

    public void v(IOException iOException) {
        c cVar;
        boolean z;
        Socket e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iOException) == null) {
            synchronized (this.f27748d) {
                cVar = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i2 = this.f27753i + 1;
                        this.f27753i = i2;
                        if (i2 > 1) {
                            this.f27747c = null;
                            z = true;
                        }
                        z = false;
                    } else {
                        if (errorCode != ErrorCode.CANCEL) {
                            this.f27747c = null;
                            z = true;
                        }
                        z = false;
                    }
                } else {
                    if (this.f27754j != null && (!this.f27754j.m() || (iOException instanceof ConnectionShutdownException))) {
                        if (this.f27754j.l == 0) {
                            if (this.f27747c != null && iOException != null) {
                                this.f27752h.a(this.f27747c, iOException);
                            }
                            this.f27747c = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                c cVar2 = this.f27754j;
                e2 = e(z, false, true);
                if (this.f27754j == null && this.k) {
                    cVar = cVar2;
                }
            }
            c.d.b.e0.e.g(e2);
            if (cVar != null) {
                this.f27750f.connectionReleased(this.f27749e, cVar);
            }
        }
    }

    public void w(boolean z, c.d.b.e0.i.c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket e2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), cVar, Long.valueOf(j2), iOException}) == null) {
            this.f27750f.responseBodyEnd(this.f27749e, j2);
            synchronized (this.f27748d) {
                if (cVar != null) {
                    if (cVar == this.n) {
                        if (!z) {
                            this.f27754j.l++;
                        }
                        cVar2 = this.f27754j;
                        e2 = e(z, false, true);
                        if (this.f27754j != null) {
                            cVar2 = null;
                        }
                        z2 = this.l;
                    }
                }
                throw new IllegalStateException("expected " + this.n + " but was " + cVar);
            }
            c.d.b.e0.e.g(e2);
            if (cVar2 != null) {
                this.f27750f.connectionReleased(this.f27749e, cVar2);
            }
            if (iOException != null) {
                this.f27750f.callFailed(this.f27749e, c.d.b.e0.a.a.l(this.f27749e, iOException));
            } else if (z2) {
                c.d.b.e0.a.a.l(this.f27749e, null);
                this.f27750f.callEnd(this.f27749e);
            }
        }
    }
}
