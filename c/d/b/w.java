package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.p;
import c.d.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes3.dex */
public class w implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Protocol> I;
    public static final List<k> J;
    public static int K;
    public static boolean L;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;

    /* renamed from: e  reason: collision with root package name */
    public final int f28143e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f28144f;

    /* renamed from: g  reason: collision with root package name */
    public final n f28145g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f28146h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Protocol> f28147i;

    /* renamed from: j  reason: collision with root package name */
    public final List<k> f28148j;
    public final List<t> k;
    public final List<t> l;
    public final p.c m;
    public final ProxySelector n;
    public final m o;
    @Nullable
    public final c p;
    @Nullable
    public final c.d.b.e0.g.e q;
    public final SocketFactory r;
    public final SSLSocketFactory s;
    public final c.d.b.e0.p.c t;
    public final HostnameVerifier u;
    public final g v;
    public final c.d.b.b w;
    public final c.d.b.b x;
    public final j y;
    public final o z;

    /* loaded from: classes3.dex */
    public class a extends c.d.b.e0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.d.b.e0.a
        public void a(r.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
                aVar.b(str);
            }
        }

        @Override // c.d.b.e0.a
        public void b(r.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, str2) == null) {
                aVar.c(str, str2);
            }
        }

        @Override // c.d.b.e0.a
        public void c(k kVar, SSLSocket sSLSocket, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, kVar, sSLSocket, z) == null) {
                kVar.a(sSLSocket, z);
            }
        }

        @Override // c.d.b.e0.a
        public int d(b0.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? aVar.f27760c : invokeL.intValue;
        }

        @Override // c.d.b.e0.a
        public boolean e(j jVar, c.d.b.e0.h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jVar, cVar)) == null) ? jVar.b(cVar) : invokeLL.booleanValue;
        }

        @Override // c.d.b.e0.a
        public Socket f(j jVar, c.d.b.a aVar, c.d.b.e0.h.f fVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, jVar, aVar, fVar)) == null) ? jVar.c(aVar, fVar) : (Socket) invokeLLL.objValue;
        }

        @Override // c.d.b.e0.a
        public boolean g(c.d.b.a aVar, c.d.b.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, aVar2)) == null) ? aVar.d(aVar2) : invokeLL.booleanValue;
        }

        @Override // c.d.b.e0.a
        public c.d.b.e0.h.c h(j jVar, c.d.b.a aVar, c.d.b.e0.h.f fVar, d0 d0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, jVar, aVar, fVar, d0Var)) == null) ? jVar.d(aVar, fVar, d0Var) : (c.d.b.e0.h.c) invokeLLLL.objValue;
        }

        @Override // c.d.b.e0.a
        public boolean i(IllegalArgumentException illegalArgumentException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, illegalArgumentException)) == null) ? illegalArgumentException.getMessage().startsWith("Invalid URL host") : invokeL.booleanValue;
        }

        @Override // c.d.b.e0.a
        public void j(j jVar, c.d.b.e0.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, jVar, cVar) == null) {
                jVar.f(cVar);
            }
        }

        @Override // c.d.b.e0.a
        public c.d.b.e0.h.d k(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jVar)) == null) ? jVar.f28088e : (c.d.b.e0.h.d) invokeL.objValue;
        }

        @Override // c.d.b.e0.a
        @Nullable
        public IOException l(e eVar, @Nullable IOException iOException) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, eVar, iOException)) == null) ? ((y) eVar).h(iOException) : (IOException) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810732620, "Lc/d/b/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810732620, "Lc/d/b/w;");
                return;
            }
        }
        I = c.d.b.e0.e.t(Protocol.HTTP_2, Protocol.HTTP_1_1);
        J = c.d.b.e0.e.t(k.f28093g, k.f28094h);
        c.d.b.e0.a.a = new a();
        K = 300;
        L = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w() {
        this(new b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static SSLSocketFactory v(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509TrustManager)) == null) {
            try {
                SSLContext o = c.d.b.e0.n.g.m().o();
                o.init(null, new TrustManager[]{x509TrustManager}, null);
                return o.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                throw c.d.b.e0.e.b("No System TLS", e2);
            }
        }
        return (SSLSocketFactory) invokeL.objValue;
    }

    public ProxySelector A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (ProxySelector) invokeV.objValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.F : invokeV.intValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public SocketFactory D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (SocketFactory) invokeV.objValue;
    }

    public SSLSocketFactory E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : (SSLSocketFactory) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.G : invokeV.intValue;
    }

    public c.d.b.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (c.d.b.b) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : invokeV.intValue;
    }

    public g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (g) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.E : invokeV.intValue;
    }

    public j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.y : (j) invokeV.objValue;
    }

    public List<k> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28148j : (List) invokeV.objValue;
    }

    public m h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (m) invokeV.objValue;
    }

    public n i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f28145g : (n) invokeV.objValue;
    }

    public o j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.z : (o) invokeV.objValue;
    }

    public p.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : (p.c) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f28143e : invokeV.intValue;
    }

    public HostnameVerifier o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u : (HostnameVerifier) invokeV.objValue;
    }

    public List<t> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public c.d.b.e0.g.e q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c cVar = this.p;
            return cVar != null ? cVar.f27768e : this.q;
        }
        return (c.d.b.e0.g.e) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f28144f : invokeV.booleanValue;
    }

    public List<t> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? new b(this) : (b) invokeV.objValue;
    }

    public e u(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, zVar)) == null) ? y.f(this, zVar, false) : (e) invokeL.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.H : invokeV.intValue;
    }

    public List<Protocol> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f28147i : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f28146h : (Proxy) invokeV.objValue;
    }

    public c.d.b.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.w : (c.d.b.b) invokeV.objValue;
    }

    public w(b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28145g = bVar.a;
        this.f28146h = bVar.f28149b;
        this.f28147i = bVar.f28150c;
        this.f28148j = bVar.f28151d;
        this.k = c.d.b.e0.e.s(bVar.f28152e);
        this.l = c.d.b.e0.e.s(bVar.f28153f);
        this.m = bVar.f28154g;
        this.n = bVar.f28155h;
        this.o = bVar.f28156i;
        this.p = bVar.f28157j;
        this.q = bVar.k;
        this.r = bVar.l;
        loop0: while (true) {
            for (k kVar : this.f28148j) {
                z = z || kVar.d();
            }
        }
        if (bVar.m == null && z) {
            X509TrustManager B = c.d.b.e0.e.B();
            this.s = v(B);
            this.t = c.d.b.e0.p.c.b(B);
        } else {
            this.s = bVar.m;
            this.t = bVar.n;
        }
        if (this.s != null) {
            c.d.b.e0.n.g.m().g(this.s);
        }
        this.u = bVar.o;
        this.v = bVar.p.f(this.t);
        this.w = bVar.q;
        this.x = bVar.r;
        this.y = bVar.s;
        this.z = bVar.t;
        this.A = bVar.u;
        this.B = bVar.v;
        this.C = bVar.w;
        this.D = bVar.x;
        this.E = bVar.y;
        this.F = bVar.z;
        this.G = bVar.A;
        this.H = bVar.B;
        this.f28143e = bVar.C;
        this.f28144f = bVar.D;
        if (!this.k.contains(null)) {
            if (this.l.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.l);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.k);
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int A;
        public int B;
        public int C;
        public boolean D;
        public n a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Proxy f28149b;

        /* renamed from: c  reason: collision with root package name */
        public List<Protocol> f28150c;

        /* renamed from: d  reason: collision with root package name */
        public List<k> f28151d;

        /* renamed from: e  reason: collision with root package name */
        public final List<t> f28152e;

        /* renamed from: f  reason: collision with root package name */
        public final List<t> f28153f;

        /* renamed from: g  reason: collision with root package name */
        public p.c f28154g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f28155h;

        /* renamed from: i  reason: collision with root package name */
        public m f28156i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public c f28157j;
        @Nullable
        public c.d.b.e0.g.e k;
        public SocketFactory l;
        @Nullable
        public SSLSocketFactory m;
        @Nullable
        public c.d.b.e0.p.c n;
        public HostnameVerifier o;
        public g p;
        public c.d.b.b q;
        public c.d.b.b r;
        public j s;
        public o t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28152e = new ArrayList();
            this.f28153f = new ArrayList();
            this.a = new n();
            this.f28150c = w.I;
            this.f28151d = w.J;
            this.f28154g = p.factory(p.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f28155h = proxySelector;
            if (proxySelector == null) {
                this.f28155h = new c.d.b.e0.o.a();
            }
            this.f28156i = m.a;
            this.l = SocketFactory.getDefault();
            this.o = c.d.b.e0.p.d.a;
            this.p = g.f28070c;
            c.d.b.b bVar = c.d.b.b.a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
            this.C = w.K;
            this.D = w.L;
        }

        public w a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new w(this) : (w) invokeV.objValue;
        }

        public b b(@Nullable c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.f28157j = cVar;
                this.k = null;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit)) == null) {
                this.y = c.d.b.e0.e.d(com.alipay.sdk.data.a.O, j2, timeUnit);
                return this;
            }
            return (b) invokeJL.objValue;
        }

        public b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.C = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b e(m mVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mVar)) == null) {
                if (mVar != null) {
                    this.f28156i = mVar;
                    return this;
                }
                throw new NullPointerException("cookieJar == null");
            }
            return (b) invokeL.objValue;
        }

        public b f(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nVar)) == null) {
                if (nVar != null) {
                    this.a = nVar;
                    return this;
                }
                throw new IllegalArgumentException("dispatcher == null");
            }
            return (b) invokeL.objValue;
        }

        public b g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.D = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b h(p.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
                if (cVar != null) {
                    this.f28154g = cVar;
                    return this;
                }
                throw new NullPointerException("eventListenerFactory == null");
            }
            return (b) invokeL.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.v = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b j(HostnameVerifier hostnameVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hostnameVerifier)) == null) {
                if (hostnameVerifier != null) {
                    this.o = hostnameVerifier;
                    return this;
                }
                throw new NullPointerException("hostnameVerifier == null");
            }
            return (b) invokeL.objValue;
        }

        public List<t> k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28152e : (List) invokeV.objValue;
        }

        public List<t> l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28153f : (List) invokeV.objValue;
        }

        public b m(@Nullable Proxy proxy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, proxy)) == null) {
                this.f28149b = proxy;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j2, timeUnit)) == null) {
                this.z = c.d.b.e0.e.d(com.alipay.sdk.data.a.O, j2, timeUnit);
                return this;
            }
            return (b) invokeJL.objValue;
        }

        public b o(SSLSocketFactory sSLSocketFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, sSLSocketFactory)) == null) {
                if (sSLSocketFactory != null) {
                    this.m = sSLSocketFactory;
                    this.n = c.d.b.e0.n.g.m().c(sSLSocketFactory);
                    return this;
                }
                throw new NullPointerException("sslSocketFactory == null");
            }
            return (b) invokeL.objValue;
        }

        public b(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28152e = new ArrayList();
            this.f28153f = new ArrayList();
            this.a = wVar.f28145g;
            this.f28149b = wVar.f28146h;
            this.f28150c = wVar.f28147i;
            this.f28151d = wVar.f28148j;
            this.f28152e.addAll(wVar.k);
            this.f28153f.addAll(wVar.l);
            this.f28154g = wVar.m;
            this.f28155h = wVar.n;
            this.f28156i = wVar.o;
            this.k = wVar.q;
            this.f28157j = wVar.p;
            this.l = wVar.r;
            this.m = wVar.s;
            this.n = wVar.t;
            this.o = wVar.u;
            this.p = wVar.v;
            this.q = wVar.w;
            this.r = wVar.x;
            this.s = wVar.y;
            this.t = wVar.z;
            this.u = wVar.A;
            this.v = wVar.B;
            this.w = wVar.C;
            this.x = wVar.D;
            this.y = wVar.E;
            this.z = wVar.F;
            this.A = wVar.G;
            this.B = wVar.H;
            this.C = wVar.f28143e;
            this.D = wVar.f28144f;
        }
    }
}
