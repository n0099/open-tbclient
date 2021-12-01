package c.d.b.e0.k;

import android.net.http.Headers;
import c.d.b.b0;
import c.d.b.c0;
import c.d.b.r;
import c.d.b.t;
import c.d.b.w;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
/* loaded from: classes7.dex */
public final class d implements c.d.b.e0.i.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final List<String> f28230f;

    /* renamed from: g  reason: collision with root package name */
    public static final List<String> f28231g;
    public transient /* synthetic */ FieldHolder $fh;
    public final t.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.h.f f28232b;

    /* renamed from: c  reason: collision with root package name */
    public final e f28233c;

    /* renamed from: d  reason: collision with root package name */
    public g f28234d;

    /* renamed from: e  reason: collision with root package name */
    public final Protocol f28235e;

    /* loaded from: classes7.dex */
    public class a extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28236e;

        /* renamed from: f  reason: collision with root package name */
        public long f28237f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f28238g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Source source) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Source) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28238g = dVar;
            this.f28236e = false;
            this.f28237f = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                endOfInput(null);
            }
        }

        public final void endOfInput(IOException iOException) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || this.f28236e) {
                return;
            }
            this.f28236e = true;
            d dVar = this.f28238g;
            dVar.f28232b.w(false, dVar, this.f28237f, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j2)) == null) {
                try {
                    long read = delegate().read(buffer, j2);
                    if (read > 0) {
                        this.f28237f += read;
                    }
                    return read;
                } catch (IOException e2) {
                    endOfInput(e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404721, "Lc/d/b/e0/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404721, "Lc/d/b/e0/k/d;");
                return;
            }
        }
        f28230f = c.d.b.e0.e.t("connection", "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
        f28231g = c.d.b.e0.e.t("connection", "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade");
    }

    public d(w wVar, t.a aVar, c.d.b.e0.h.f fVar, e eVar) {
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, aVar, fVar, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f28232b = fVar;
        this.f28233c = eVar;
        if (wVar.x().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f28235e = protocol;
    }

    public static List<c.d.b.e0.k.a> d(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zVar)) == null) {
            r d2 = zVar.d();
            ArrayList arrayList = new ArrayList(d2.g() + 4);
            arrayList.add(new c.d.b.e0.k.a(c.d.b.e0.k.a.f28205f, zVar.f()));
            arrayList.add(new c.d.b.e0.k.a(c.d.b.e0.k.a.f28206g, c.d.b.e0.i.i.c(zVar.h())));
            String c2 = zVar.c("Host");
            if (c2 != null) {
                arrayList.add(new c.d.b.e0.k.a(c.d.b.e0.k.a.f28208i, c2));
            }
            arrayList.add(new c.d.b.e0.k.a(c.d.b.e0.k.a.f28207h, zVar.h().A()));
            int g2 = d2.g();
            for (int i2 = 0; i2 < g2; i2++) {
                ByteString encodeUtf8 = ByteString.encodeUtf8(d2.e(i2).toLowerCase(Locale.US));
                if (!f28230f.contains(encodeUtf8.utf8())) {
                    arrayList.add(new c.d.b.e0.k.a(encodeUtf8, d2.h(i2)));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static b0.a e(r rVar, Protocol protocol) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, rVar, protocol)) == null) {
            r.a aVar = new r.a();
            int g2 = rVar.g();
            c.d.b.e0.i.k kVar = null;
            for (int i2 = 0; i2 < g2; i2++) {
                String e2 = rVar.e(i2);
                String h2 = rVar.h(i2);
                if (e2.equals(":status")) {
                    kVar = c.d.b.e0.i.k.b("HTTP/1.1 " + h2);
                } else if (!f28231g.contains(e2)) {
                    c.d.b.e0.a.a.b(aVar, e2, h2);
                }
            }
            if (kVar != null) {
                b0.a aVar2 = new b0.a();
                aVar2.n(protocol);
                aVar2.g(kVar.f28180b);
                aVar2.k(kVar.f28181c);
                aVar2.j(aVar.d());
                return aVar2;
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        return (b0.a) invokeLL.objValue;
    }

    @Override // c.d.b.e0.i.c
    public c0 a(b0 b0Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b0Var)) == null) {
            c.d.b.e0.h.f fVar = this.f28232b;
            fVar.f28149f.responseBodyStart(fVar.f28148e);
            return new c.d.b.e0.i.h(b0Var.g("Content-Type"), c.d.b.e0.i.e.b(b0Var), Okio.buffer(new a(this, this.f28234d.k())));
        }
        return (c0) invokeL.objValue;
    }

    @Override // c.d.b.e0.i.c
    public void b(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) && this.f28234d == null) {
            g t = this.f28233c.t(d(zVar), zVar.a() != null);
            this.f28234d = t;
            t.n().timeout(this.a.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f28234d.u().timeout(this.a.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // c.d.b.e0.i.c
    public Sink c(z zVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, zVar, j2)) == null) ? this.f28234d.j() : (Sink) invokeLJ.objValue;
    }

    @Override // c.d.b.e0.i.c
    public void cancel() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f28234d) == null) {
            return;
        }
        gVar.h(ErrorCode.CANCEL);
    }

    @Override // c.d.b.e0.i.c
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f28234d.j().close();
        }
    }

    @Override // c.d.b.e0.i.c
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28233c.flush();
        }
    }

    @Override // c.d.b.e0.i.c
    public b0.a readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            b0.a e2 = e(this.f28234d.s(), this.f28235e);
            if (z && c.d.b.e0.a.a.d(e2) == 100) {
                return null;
            }
            return e2;
        }
        return (b0.a) invokeZ.objValue;
    }
}
