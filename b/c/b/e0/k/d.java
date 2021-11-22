package b.c.b.e0.k;

import android.net.http.Headers;
import b.c.b.b0;
import b.c.b.c0;
import b.c.b.r;
import b.c.b.t;
import b.c.b.w;
import b.c.b.z;
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
/* loaded from: classes6.dex */
public final class d implements b.c.b.e0.i.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final List<String> f31198f;

    /* renamed from: g  reason: collision with root package name */
    public static final List<String> f31199g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t.a f31200a;

    /* renamed from: b  reason: collision with root package name */
    public final b.c.b.e0.h.f f31201b;

    /* renamed from: c  reason: collision with root package name */
    public final e f31202c;

    /* renamed from: d  reason: collision with root package name */
    public g f31203d;

    /* renamed from: e  reason: collision with root package name */
    public final Protocol f31204e;

    /* loaded from: classes6.dex */
    public class a extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31205e;

        /* renamed from: f  reason: collision with root package name */
        public long f31206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f31207g;

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
            this.f31207g = dVar;
            this.f31205e = false;
            this.f31206f = 0L;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || this.f31205e) {
                return;
            }
            this.f31205e = true;
            d dVar = this.f31207g;
            dVar.f31201b.w(false, dVar, this.f31206f, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j)) == null) {
                try {
                    long read = delegate().read(buffer, j);
                    if (read > 0) {
                        this.f31206f += read;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999949645, "Lb/c/b/e0/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999949645, "Lb/c/b/e0/k/d;");
                return;
            }
        }
        f31198f = b.c.b.e0.e.t("connection", "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
        f31199g = b.c.b.e0.e.t("connection", "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade");
    }

    public d(w wVar, t.a aVar, b.c.b.e0.h.f fVar, e eVar) {
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
        this.f31200a = aVar;
        this.f31201b = fVar;
        this.f31202c = eVar;
        if (wVar.x().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f31204e = protocol;
    }

    public static List<b.c.b.e0.k.a> d(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zVar)) == null) {
            r d2 = zVar.d();
            ArrayList arrayList = new ArrayList(d2.g() + 4);
            arrayList.add(new b.c.b.e0.k.a(b.c.b.e0.k.a.f31168f, zVar.f()));
            arrayList.add(new b.c.b.e0.k.a(b.c.b.e0.k.a.f31169g, b.c.b.e0.i.i.c(zVar.h())));
            String c2 = zVar.c("Host");
            if (c2 != null) {
                arrayList.add(new b.c.b.e0.k.a(b.c.b.e0.k.a.f31171i, c2));
            }
            arrayList.add(new b.c.b.e0.k.a(b.c.b.e0.k.a.f31170h, zVar.h().A()));
            int g2 = d2.g();
            for (int i2 = 0; i2 < g2; i2++) {
                ByteString encodeUtf8 = ByteString.encodeUtf8(d2.e(i2).toLowerCase(Locale.US));
                if (!f31198f.contains(encodeUtf8.utf8())) {
                    arrayList.add(new b.c.b.e0.k.a(encodeUtf8, d2.h(i2)));
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
            b.c.b.e0.i.k kVar = null;
            for (int i2 = 0; i2 < g2; i2++) {
                String e2 = rVar.e(i2);
                String h2 = rVar.h(i2);
                if (e2.equals(":status")) {
                    kVar = b.c.b.e0.i.k.b("HTTP/1.1 " + h2);
                } else if (!f31199g.contains(e2)) {
                    b.c.b.e0.a.f31044a.b(aVar, e2, h2);
                }
            }
            if (kVar != null) {
                b0.a aVar2 = new b0.a();
                aVar2.n(protocol);
                aVar2.g(kVar.f31144b);
                aVar2.k(kVar.f31145c);
                aVar2.j(aVar.d());
                return aVar2;
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        return (b0.a) invokeLL.objValue;
    }

    @Override // b.c.b.e0.i.c
    public c0 a(b0 b0Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b0Var)) == null) {
            b.c.b.e0.h.f fVar = this.f31201b;
            fVar.f31112f.responseBodyStart(fVar.f31111e);
            return new b.c.b.e0.i.h(b0Var.g("Content-Type"), b.c.b.e0.i.e.b(b0Var), Okio.buffer(new a(this, this.f31203d.k())));
        }
        return (c0) invokeL.objValue;
    }

    @Override // b.c.b.e0.i.c
    public void b(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) && this.f31203d == null) {
            g t = this.f31202c.t(d(zVar), zVar.a() != null);
            this.f31203d = t;
            t.n().timeout(this.f31200a.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f31203d.u().timeout(this.f31200a.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // b.c.b.e0.i.c
    public Sink c(z zVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, zVar, j)) == null) ? this.f31203d.j() : (Sink) invokeLJ.objValue;
    }

    @Override // b.c.b.e0.i.c
    public void cancel() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f31203d) == null) {
            return;
        }
        gVar.h(ErrorCode.CANCEL);
    }

    @Override // b.c.b.e0.i.c
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31203d.j().close();
        }
    }

    @Override // b.c.b.e0.i.c
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31202c.flush();
        }
    }

    @Override // b.c.b.e0.i.c
    public b0.a readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            b0.a e2 = e(this.f31203d.s(), this.f31204e);
            if (z && b.c.b.e0.a.f31044a.d(e2) == 100) {
                return null;
            }
            return e2;
        }
        return (b0.a) invokeZ.objValue;
    }
}
