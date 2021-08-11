package c.d.b.e0.h;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.d0;
import c.d.b.e0.k.e;
import c.d.b.e0.k.g;
import c.d.b.i;
import c.d.b.j;
import c.d.b.k;
import c.d.b.p;
import c.d.b.q;
import c.d.b.s;
import c.d.b.t;
import c.d.b.w;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.RealConnection;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public final class c extends e.j implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final j f31578b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f31579c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f31580d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f31581e;

    /* renamed from: f  reason: collision with root package name */
    public q f31582f;

    /* renamed from: g  reason: collision with root package name */
    public Protocol f31583g;

    /* renamed from: h  reason: collision with root package name */
    public c.d.b.e0.k.e f31584h;

    /* renamed from: i  reason: collision with root package name */
    public BufferedSource f31585i;

    /* renamed from: j  reason: collision with root package name */
    public BufferedSink f31586j;
    public boolean k;
    public int l;
    public int m;
    public final List<Reference<f>> n;
    public long o;

    public c(j jVar, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = new ArrayList();
        this.o = Long.MAX_VALUE;
        this.f31578b = jVar;
        this.f31579c = d0Var;
    }

    @Override // c.d.b.e0.k.e.j
    public void a(c.d.b.e0.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            synchronized (this.f31578b) {
                this.m = eVar.v();
            }
        }
    }

    @Override // c.d.b.e0.k.e.j
    public void b(g gVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            gVar.f(ErrorCode.REFUSED_STREAM);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.d.b.e0.e.g(this.f31580d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[Catch: IOException -> 0x00fd, TRY_LEAVE, TryCatch #2 {IOException -> 0x00fd, blocks: (B:20:0x008c, B:22:0x0094), top: B:75:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146 A[EDGE_INSN: B:82:0x0146->B:63:0x0146 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i2, int i3, int i4, int i5, boolean z, c.d.b.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), eVar, pVar}) == null) {
            if (this.f31583g == null) {
                List<k> b2 = this.f31579c.a().b();
                b bVar = new b(b2);
                if (this.f31579c.a().k() == null) {
                    if (b2.contains(k.f31874h)) {
                        String l = this.f31579c.a().l().l();
                        if (!c.d.b.e0.m.g.m().s(l)) {
                            throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + l + " not permitted by network security policy"));
                        }
                    } else {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                    }
                } else if (this.f31579c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
                }
                RouteException routeException = null;
                do {
                    try {
                        try {
                            if (this.f31579c.c()) {
                                g(i2, i3, i4, eVar, pVar);
                                if (this.f31580d == null) {
                                    if (!this.f31579c.c() && this.f31580d == null) {
                                        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                                    }
                                    if (this.f31584h == null) {
                                        synchronized (this.f31578b) {
                                            this.m = this.f31584h.v();
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                try {
                                    e(i2, i3, eVar, pVar);
                                } catch (IOException e2) {
                                    e = e2;
                                    c.d.b.e0.e.g(this.f31581e);
                                    c.d.b.e0.e.g(this.f31580d);
                                    this.f31581e = null;
                                    this.f31580d = null;
                                    this.f31585i = null;
                                    this.f31586j = null;
                                    this.f31582f = null;
                                    this.f31583g = null;
                                    this.f31584h = null;
                                    pVar.connectFailed(eVar, this.f31579c.d(), this.f31579c.b(), null, e);
                                    if (routeException != null) {
                                    }
                                    if (!z || bVar.b(e)) {
                                    }
                                    do {
                                        if (this.f31579c.c()) {
                                        }
                                        j(bVar, i5, eVar, pVar);
                                        pVar.connectEnd(eVar, this.f31579c.d(), this.f31579c.b(), this.f31583g);
                                        if (!this.f31579c.c()) {
                                        }
                                        if (this.f31584h == null) {
                                        }
                                    } while (bVar.b(e));
                                    throw routeException;
                                }
                            }
                            j(bVar, i5, eVar, pVar);
                            pVar.connectEnd(eVar, this.f31579c.d(), this.f31579c.b(), this.f31583g);
                            if (!this.f31579c.c()) {
                            }
                            if (this.f31584h == null) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            c.d.b.e0.e.g(this.f31581e);
                            c.d.b.e0.e.g(this.f31580d);
                            this.f31581e = null;
                            this.f31580d = null;
                            this.f31585i = null;
                            this.f31586j = null;
                            this.f31582f = null;
                            this.f31583g = null;
                            this.f31584h = null;
                            pVar.connectFailed(eVar, this.f31579c.d(), this.f31579c.b(), null, e);
                            if (routeException != null) {
                                routeException = new RouteException(e);
                            } else {
                                routeException.addConnectException(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw routeException;
                            }
                            do {
                                if (this.f31579c.c()) {
                                }
                                j(bVar, i5, eVar, pVar);
                                pVar.connectEnd(eVar, this.f31579c.d(), this.f31579c.b(), this.f31583g);
                                if (!this.f31579c.c()) {
                                }
                                if (this.f31584h == null) {
                                }
                            } while (bVar.b(e));
                            throw routeException;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } while (bVar.b(e));
                throw routeException;
            }
            throw new IllegalStateException("already connected");
        }
    }

    public final void e(int i2, int i3, c.d.b.e eVar, p pVar) throws IOException {
        Socket createSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, pVar}) == null) {
            Proxy b2 = this.f31579c.b();
            c.d.b.a a2 = this.f31579c.a();
            if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(b2);
            } else {
                createSocket = a2.j().createSocket();
            }
            this.f31580d = createSocket;
            pVar.connectStart(eVar, this.f31579c.d(), b2);
            this.f31580d.setSoTimeout(i3);
            try {
                c.d.b.e0.m.g.m().i(this.f31580d, this.f31579c.d(), i2);
                try {
                    this.f31585i = Okio.buffer(Okio.source(this.f31580d));
                    this.f31586j = Okio.buffer(Okio.sink(this.f31580d));
                } catch (NullPointerException e2) {
                    if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.f31579c.d());
                connectException.initCause(e3);
                throw connectException;
            }
        }
    }

    public final void f(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            c.d.b.a a2 = this.f31579c.a();
            SSLSocket sSLSocket2 = null;
            try {
                try {
                    sSLSocket = (SSLSocket) a2.k().createSocket(this.f31580d, a2.l().l(), a2.l().w(), true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
            try {
                k a3 = bVar.a(sSLSocket);
                if (a3.f()) {
                    c.d.b.e0.m.g.m().h(sSLSocket, a2.l().l(), a2.f());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                q b2 = q.b(session);
                if (!a2.e().verify(a2.l().l(), session)) {
                    List<Certificate> e3 = b2.e();
                    if (!e3.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) e3.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a2.l().l() + " not verified:\n    certificate: " + c.d.b.g.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + c.d.b.e0.o.d.a(x509Certificate));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + a2.l().l() + " not verified (no certificates)");
                }
                a2.a().a(a2.l().l(), b2.e());
                String p = a3.f() ? c.d.b.e0.m.g.m().p(sSLSocket) : null;
                this.f31581e = sSLSocket;
                this.f31585i = Okio.buffer(Okio.source(sSLSocket));
                this.f31586j = Okio.buffer(Okio.sink(this.f31581e));
                this.f31582f = b2;
                if (p != null) {
                    protocol = Protocol.get(p);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.f31583g = protocol;
                if (sSLSocket != null) {
                    c.d.b.e0.m.g.m().a(sSLSocket);
                }
            } catch (AssertionError e4) {
                e = e4;
                if (!c.d.b.e0.e.z(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                sSLSocket2 = sSLSocket;
                if (sSLSocket2 != null) {
                    c.d.b.e0.m.g.m().a(sSLSocket2);
                }
                c.d.b.e0.e.g(sSLSocket2);
                throw th;
            }
        }
    }

    public final void g(int i2, int i3, int i4, c.d.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, pVar}) == null) {
            z i5 = i();
            s h2 = i5.h();
            for (int i6 = 0; i6 < 21; i6++) {
                e(i2, i3, eVar, pVar);
                i5 = h(i3, i4, i5, h2);
                if (i5 == null) {
                    return;
                }
                c.d.b.e0.e.g(this.f31580d);
                this.f31580d = null;
                this.f31586j = null;
                this.f31585i = null;
                pVar.connectEnd(eVar, this.f31579c.d(), this.f31579c.b(), null);
            }
        }
    }

    public final z h(int i2, int i3, z zVar, s sVar) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), zVar, sVar})) != null) {
            return (z) invokeCommon.objValue;
        }
        String str = "CONNECT " + c.d.b.e0.e.r(sVar, true) + " HTTP/1.1";
        while (true) {
            c.d.b.e0.j.a aVar = new c.d.b.e0.j.a(null, null, this.f31585i, this.f31586j);
            this.f31585i.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            this.f31586j.timeout().timeout(i3, TimeUnit.MILLISECONDS);
            aVar.l(zVar.d(), str);
            aVar.finishRequest();
            b0.a readResponseHeaders = aVar.readResponseHeaders(false);
            readResponseHeaders.p(zVar);
            b0 c2 = readResponseHeaders.c();
            long b2 = c.d.b.e0.i.e.b(c2);
            if (b2 == -1) {
                b2 = 0;
            }
            Source h2 = aVar.h(b2);
            c.d.b.e0.e.C(h2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            h2.close();
            int code = c2.code();
            if (code == 200) {
                if (this.f31585i.buffer().exhausted() && this.f31586j.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code == 407) {
                z a2 = this.f31579c.a().h().a(this.f31579c, c2);
                if (a2 != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(c2.s(HTTP.CONN_DIRECTIVE))) {
                        return a2;
                    }
                    zVar = a2;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + c2.code());
            }
        }
    }

    @Override // c.d.b.i
    public q handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31582f : (q) invokeV.objValue;
    }

    public final z i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            z.a aVar = new z.a();
            aVar.g(this.f31579c.a().l());
            aVar.e("CONNECT", null);
            aVar.c("Host", c.d.b.e0.e.r(this.f31579c.a().l(), true));
            aVar.c("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
            aVar.c("User-Agent", c.d.b.e0.f.a());
            z b2 = aVar.b();
            b0.a aVar2 = new b0.a();
            aVar2.p(b2);
            aVar2.n(Protocol.HTTP_1_1);
            aVar2.g(407);
            aVar2.k("Preemptive Authenticate");
            aVar2.b(c.d.b.e0.e.f31548c);
            aVar2.q(-1L);
            aVar2.o(-1L);
            aVar2.i(AUTH.PROXY_AUTH, "OkHttp-Preemptive");
            z a2 = this.f31579c.a().h().a(this.f31579c, aVar2.c());
            return a2 != null ? a2 : b2;
        }
        return (z) invokeV.objValue;
    }

    public final void j(b bVar, int i2, c.d.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048586, this, bVar, i2, eVar, pVar) == null) {
            if (this.f31579c.a().k() == null) {
                if (this.f31579c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    this.f31581e = this.f31580d;
                    this.f31583g = Protocol.H2_PRIOR_KNOWLEDGE;
                    p(i2);
                    return;
                }
                this.f31581e = this.f31580d;
                this.f31583g = Protocol.HTTP_1_1;
                return;
            }
            pVar.secureConnectStart(eVar);
            f(bVar);
            pVar.secureConnectEnd(eVar, this.f31582f);
            if (this.f31583g == Protocol.HTTP_2) {
                p(i2);
            }
        }
    }

    public boolean k(c.d.b.a aVar, @Nullable d0 d0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, aVar, d0Var)) == null) {
            if (this.n.size() >= this.m || this.k || !c.d.b.e0.a.f31543a.g(this.f31579c.a(), aVar)) {
                return false;
            }
            if (aVar.l().l().equals(route().a().l().l())) {
                return true;
            }
            if (this.f31584h != null && d0Var != null && d0Var.b().type() == Proxy.Type.DIRECT && this.f31579c.b().type() == Proxy.Type.DIRECT && this.f31579c.d().equals(d0Var.d()) && d0Var.a().e() == c.d.b.e0.o.d.f31844a && q(aVar.l())) {
                try {
                    aVar.a().a(aVar.l().l(), handshake().e());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            if (this.f31581e.isClosed() || this.f31581e.isInputShutdown() || this.f31581e.isOutputShutdown()) {
                return false;
            }
            c.d.b.e0.k.e eVar = this.f31584h;
            if (eVar != null) {
                return eVar.u(System.nanoTime());
            }
            if (z) {
                try {
                    int soTimeout = this.f31581e.getSoTimeout();
                    this.f31581e.setSoTimeout(1);
                    if (this.f31585i.exhausted()) {
                        this.f31581e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f31581e.setSoTimeout(soTimeout);
                    return true;
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31584h != null : invokeV.booleanValue;
    }

    public c.d.b.e0.i.c n(w wVar, t.a aVar, f fVar) throws SocketException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, wVar, aVar, fVar)) == null) {
            if (this.f31584h != null) {
                return new c.d.b.e0.k.d(wVar, aVar, fVar, this.f31584h);
            }
            this.f31581e.setSoTimeout(aVar.readTimeoutMillis());
            this.f31585i.timeout().timeout(aVar.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f31586j.timeout().timeout(aVar.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            return new c.d.b.e0.j.a(wVar, fVar, this.f31585i, this.f31586j);
        }
        return (c.d.b.e0.i.c) invokeLLL.objValue;
    }

    public Socket o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f31581e : (Socket) invokeV.objValue;
    }

    public final void p(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f31581e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.d(this.f31581e, this.f31579c.a().l().l(), this.f31585i, this.f31586j);
            hVar.b(this);
            hVar.c(i2);
            c.d.b.e0.k.e a2 = hVar.a();
            this.f31584h = a2;
            a2.H();
        }
    }

    @Override // c.d.b.i
    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f31583g : (Protocol) invokeV.objValue;
    }

    public boolean q(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, sVar)) == null) {
            if (sVar.w() != this.f31579c.a().l().w()) {
                return false;
            }
            if (sVar.l().equals(this.f31579c.a().l().l())) {
                return true;
            }
            return this.f31582f != null && c.d.b.e0.o.d.f31844a.c(sVar.l(), (X509Certificate) this.f31582f.e().get(0));
        }
        return invokeL.booleanValue;
    }

    @Override // c.d.b.i
    public d0 route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f31579c : (d0) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connection{");
            sb.append(this.f31579c.a().l().l());
            sb.append(":");
            sb.append(this.f31579c.a().l().w());
            sb.append(", proxy=");
            sb.append(this.f31579c.b());
            sb.append(" hostAddress=");
            sb.append(this.f31579c.d());
            sb.append(" cipherSuite=");
            q qVar = this.f31582f;
            sb.append(qVar != null ? qVar.a() : "none");
            sb.append(" protocol=");
            sb.append(this.f31583g);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
