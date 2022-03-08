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
/* loaded from: classes3.dex */
public final class c extends e.j implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final j f27839b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f27840c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f27841d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f27842e;

    /* renamed from: f  reason: collision with root package name */
    public q f27843f;

    /* renamed from: g  reason: collision with root package name */
    public Protocol f27844g;

    /* renamed from: h  reason: collision with root package name */
    public c.d.b.e0.k.e f27845h;

    /* renamed from: i  reason: collision with root package name */
    public BufferedSource f27846i;

    /* renamed from: j  reason: collision with root package name */
    public BufferedSink f27847j;
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
        this.f27839b = jVar;
        this.f27840c = d0Var;
    }

    @Override // c.d.b.e0.k.e.j
    public void a(c.d.b.e0.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            synchronized (this.f27839b) {
                this.m = eVar.r();
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
            c.d.b.e0.e.g(this.f27841d);
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
            if (this.f27844g == null) {
                List<k> b2 = this.f27840c.a().b();
                b bVar = new b(b2);
                if (this.f27840c.a().k() == null) {
                    if (b2.contains(k.f28094h)) {
                        String l = this.f27840c.a().l().l();
                        if (!c.d.b.e0.n.g.m().s(l)) {
                            throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + l + " not permitted by network security policy"));
                        }
                    } else {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                    }
                } else if (this.f27840c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
                }
                RouteException routeException = null;
                do {
                    try {
                        try {
                            if (this.f27840c.c()) {
                                g(i2, i3, i4, eVar, pVar);
                                if (this.f27841d == null) {
                                    if (!this.f27840c.c() && this.f27841d == null) {
                                        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                                    }
                                    if (this.f27845h == null) {
                                        synchronized (this.f27839b) {
                                            this.m = this.f27845h.r();
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
                                    c.d.b.e0.e.g(this.f27842e);
                                    c.d.b.e0.e.g(this.f27841d);
                                    this.f27842e = null;
                                    this.f27841d = null;
                                    this.f27846i = null;
                                    this.f27847j = null;
                                    this.f27843f = null;
                                    this.f27844g = null;
                                    this.f27845h = null;
                                    pVar.connectFailed(eVar, this.f27840c.d(), this.f27840c.b(), null, e);
                                    if (routeException != null) {
                                    }
                                    if (!z || bVar.b(e)) {
                                    }
                                    do {
                                        if (this.f27840c.c()) {
                                        }
                                        j(bVar, i5, eVar, pVar);
                                        pVar.connectEnd(eVar, this.f27840c.d(), this.f27840c.b(), this.f27844g);
                                        if (!this.f27840c.c()) {
                                        }
                                        if (this.f27845h == null) {
                                        }
                                    } while (bVar.b(e));
                                    throw routeException;
                                }
                            }
                            j(bVar, i5, eVar, pVar);
                            pVar.connectEnd(eVar, this.f27840c.d(), this.f27840c.b(), this.f27844g);
                            if (!this.f27840c.c()) {
                            }
                            if (this.f27845h == null) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            c.d.b.e0.e.g(this.f27842e);
                            c.d.b.e0.e.g(this.f27841d);
                            this.f27842e = null;
                            this.f27841d = null;
                            this.f27846i = null;
                            this.f27847j = null;
                            this.f27843f = null;
                            this.f27844g = null;
                            this.f27845h = null;
                            pVar.connectFailed(eVar, this.f27840c.d(), this.f27840c.b(), null, e);
                            if (routeException != null) {
                                routeException = new RouteException(e);
                            } else {
                                routeException.addConnectException(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw routeException;
                            }
                            do {
                                if (this.f27840c.c()) {
                                }
                                j(bVar, i5, eVar, pVar);
                                pVar.connectEnd(eVar, this.f27840c.d(), this.f27840c.b(), this.f27844g);
                                if (!this.f27840c.c()) {
                                }
                                if (this.f27845h == null) {
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
            Proxy b2 = this.f27840c.b();
            c.d.b.a a = this.f27840c.a();
            if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(b2);
            } else {
                createSocket = a.j().createSocket();
            }
            this.f27841d = createSocket;
            pVar.connectStart(eVar, this.f27840c.d(), b2);
            this.f27841d.setSoTimeout(i3);
            try {
                c.d.b.e0.n.g.m().i(this.f27841d, this.f27840c.d(), i2);
                try {
                    this.f27846i = Okio.buffer(Okio.source(this.f27841d));
                    this.f27847j = Okio.buffer(Okio.sink(this.f27841d));
                } catch (NullPointerException e2) {
                    if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.f27840c.d());
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
            c.d.b.a a = this.f27840c.a();
            SSLSocket sSLSocket2 = null;
            try {
                try {
                    sSLSocket = (SSLSocket) a.k().createSocket(this.f27841d, a.l().l(), a.l().w(), true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
            try {
                k a2 = bVar.a(sSLSocket);
                if (a2.f()) {
                    c.d.b.e0.n.g.m().h(sSLSocket, a.l().l(), a.f());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                q b2 = q.b(session);
                if (!a.e().verify(a.l().l(), session)) {
                    List<Certificate> e3 = b2.e();
                    if (!e3.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) e3.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a.l().l() + " not verified:\n    certificate: " + c.d.b.g.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + c.d.b.e0.p.d.a(x509Certificate));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + a.l().l() + " not verified (no certificates)");
                }
                a.a().a(a.l().l(), b2.e());
                String p = a2.f() ? c.d.b.e0.n.g.m().p(sSLSocket) : null;
                this.f27842e = sSLSocket;
                this.f27846i = Okio.buffer(Okio.source(sSLSocket));
                this.f27847j = Okio.buffer(Okio.sink(this.f27842e));
                this.f27843f = b2;
                if (p != null) {
                    protocol = Protocol.get(p);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.f27844g = protocol;
                if (sSLSocket != null) {
                    c.d.b.e0.n.g.m().a(sSLSocket);
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
                    c.d.b.e0.n.g.m().a(sSLSocket2);
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
                c.d.b.e0.e.g(this.f27841d);
                this.f27841d = null;
                this.f27847j = null;
                this.f27846i = null;
                pVar.connectEnd(eVar, this.f27840c.d(), this.f27840c.b(), null);
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
            c.d.b.e0.j.a aVar = new c.d.b.e0.j.a(null, null, this.f27846i, this.f27847j);
            this.f27846i.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            this.f27847j.timeout().timeout(i3, TimeUnit.MILLISECONDS);
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
                if (this.f27846i.buffer().exhausted() && this.f27847j.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code == 407) {
                z a = this.f27840c.a().h().a(this.f27840c, c2);
                if (a != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(c2.g(HTTP.CONN_DIRECTIVE))) {
                        return a;
                    }
                    zVar = a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27843f : (q) invokeV.objValue;
    }

    public final z i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            z.a aVar = new z.a();
            aVar.g(this.f27840c.a().l());
            aVar.e("CONNECT", null);
            aVar.c("Host", c.d.b.e0.e.r(this.f27840c.a().l(), true));
            aVar.c("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
            aVar.c("User-Agent", c.d.b.e0.f.a());
            z b2 = aVar.b();
            b0.a aVar2 = new b0.a();
            aVar2.p(b2);
            aVar2.n(Protocol.HTTP_1_1);
            aVar2.g(407);
            aVar2.k("Preemptive Authenticate");
            aVar2.b(c.d.b.e0.e.f27804c);
            aVar2.q(-1L);
            aVar2.o(-1L);
            aVar2.i(AUTH.PROXY_AUTH, "OkHttp-Preemptive");
            z a = this.f27840c.a().h().a(this.f27840c, aVar2.c());
            return a != null ? a : b2;
        }
        return (z) invokeV.objValue;
    }

    public final void j(b bVar, int i2, c.d.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048586, this, bVar, i2, eVar, pVar) == null) {
            if (this.f27840c.a().k() == null) {
                if (this.f27840c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    this.f27842e = this.f27841d;
                    this.f27844g = Protocol.H2_PRIOR_KNOWLEDGE;
                    p(i2);
                    return;
                }
                this.f27842e = this.f27841d;
                this.f27844g = Protocol.HTTP_1_1;
                return;
            }
            pVar.secureConnectStart(eVar);
            f(bVar);
            pVar.secureConnectEnd(eVar, this.f27843f);
            if (this.f27844g == Protocol.HTTP_2) {
                p(i2);
            }
        }
    }

    public boolean k(c.d.b.a aVar, @Nullable d0 d0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, aVar, d0Var)) == null) {
            if (this.n.size() >= this.m || this.k || !c.d.b.e0.a.a.g(this.f27840c.a(), aVar)) {
                return false;
            }
            if (aVar.l().l().equals(route().a().l().l())) {
                return true;
            }
            if (this.f27845h != null && d0Var != null && d0Var.b().type() == Proxy.Type.DIRECT && this.f27840c.b().type() == Proxy.Type.DIRECT && this.f27840c.d().equals(d0Var.d()) && d0Var.a().e() == c.d.b.e0.p.d.a && q(aVar.l())) {
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
            if (this.f27842e.isClosed() || this.f27842e.isInputShutdown() || this.f27842e.isOutputShutdown()) {
                return false;
            }
            c.d.b.e0.k.e eVar = this.f27845h;
            if (eVar != null) {
                return eVar.q(System.nanoTime());
            }
            if (z) {
                try {
                    int soTimeout = this.f27842e.getSoTimeout();
                    this.f27842e.setSoTimeout(1);
                    if (this.f27846i.exhausted()) {
                        this.f27842e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f27842e.setSoTimeout(soTimeout);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f27845h != null : invokeV.booleanValue;
    }

    public c.d.b.e0.i.c n(w wVar, t.a aVar, f fVar) throws SocketException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, wVar, aVar, fVar)) == null) {
            if (this.f27845h != null) {
                return new c.d.b.e0.k.d(wVar, aVar, fVar, this.f27845h);
            }
            this.f27842e.setSoTimeout(aVar.readTimeoutMillis());
            this.f27846i.timeout().timeout(aVar.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f27847j.timeout().timeout(aVar.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            return new c.d.b.e0.j.a(wVar, fVar, this.f27846i, this.f27847j);
        }
        return (c.d.b.e0.i.c) invokeLLL.objValue;
    }

    public Socket o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f27842e : (Socket) invokeV.objValue;
    }

    public final void p(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f27842e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.d(this.f27842e, this.f27840c.a().l().l(), this.f27846i, this.f27847j);
            hVar.b(this);
            hVar.c(i2);
            c.d.b.e0.k.e a = hVar.a();
            this.f27845h = a;
            a.D();
        }
    }

    @Override // c.d.b.i
    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f27844g : (Protocol) invokeV.objValue;
    }

    public boolean q(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, sVar)) == null) {
            if (sVar.w() != this.f27840c.a().l().w()) {
                return false;
            }
            if (sVar.l().equals(this.f27840c.a().l().l())) {
                return true;
            }
            return this.f27843f != null && c.d.b.e0.p.d.a.c(sVar.l(), (X509Certificate) this.f27843f.e().get(0));
        }
        return invokeL.booleanValue;
    }

    @Override // c.d.b.i
    public d0 route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f27840c : (d0) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connection{");
            sb.append(this.f27840c.a().l().l());
            sb.append(":");
            sb.append(this.f27840c.a().l().w());
            sb.append(", proxy=");
            sb.append(this.f27840c.b());
            sb.append(" hostAddress=");
            sb.append(this.f27840c.d());
            sb.append(" cipherSuite=");
            q qVar = this.f27843f;
            sb.append(qVar != null ? qVar.a() : "none");
            sb.append(" protocol=");
            sb.append(this.f27844g);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
