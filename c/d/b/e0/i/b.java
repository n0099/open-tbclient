package c.d.b.e0.i;

import c.d.b.b0;
import c.d.b.t;
import c.d.b.z;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public final class b implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31852a;

    /* loaded from: classes4.dex */
    public static final class a extends ForwardingSink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f31853e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Sink sink) {
            super(sink);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Sink) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, buffer, j2) == null) {
                super.write(buffer, j2);
                this.f31853e += j2;
            }
        }
    }

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31852a = z;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        b0 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            g gVar = (g) aVar;
            c d2 = gVar.d();
            c.d.b.e0.h.f f2 = gVar.f();
            c.d.b.e0.h.c cVar = (c.d.b.e0.h.c) gVar.connection();
            z request = gVar.request();
            long currentTimeMillis = System.currentTimeMillis();
            gVar.c().requestHeadersStart(gVar.b());
            d2.b(request);
            gVar.c().requestHeadersEnd(gVar.b(), request);
            b0.a aVar2 = null;
            if (f.b(request.f()) && request.a() != null) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(request.c(HTTP.EXPECT_DIRECTIVE))) {
                    d2.flushRequest();
                    gVar.c().responseHeadersStart(gVar.b());
                    aVar2 = d2.readResponseHeaders(true);
                }
                if (aVar2 == null) {
                    gVar.c().requestBodyStart(gVar.b());
                    a aVar3 = new a(d2.c(request, request.a().a()));
                    BufferedSink buffer = Okio.buffer(aVar3);
                    request.a().e(buffer);
                    buffer.close();
                    gVar.c().requestBodyEnd(gVar.b(), aVar3.f31853e);
                } else if (!cVar.m()) {
                    f2.o();
                }
            }
            d2.finishRequest();
            if (aVar2 == null) {
                gVar.c().responseHeadersStart(gVar.b());
                aVar2 = d2.readResponseHeaders(false);
            }
            aVar2.p(request);
            aVar2.h(f2.d().handshake());
            aVar2.q(currentTimeMillis);
            aVar2.o(System.currentTimeMillis());
            b0 c3 = aVar2.c();
            int code = c3.code();
            if (code == 100) {
                b0.a readResponseHeaders = d2.readResponseHeaders(false);
                readResponseHeaders.p(request);
                readResponseHeaders.h(f2.d().handshake());
                readResponseHeaders.q(currentTimeMillis);
                readResponseHeaders.o(System.currentTimeMillis());
                c3 = readResponseHeaders.c();
                code = c3.code();
            }
            gVar.c().responseHeadersEnd(gVar.b(), c3);
            if (this.f31852a && code == 101) {
                b0.a z = c3.z();
                z.b(c.d.b.e0.e.f31784c);
                c2 = z.c();
            } else {
                b0.a z2 = c3.z();
                z2.b(d2.a(c3));
                c2 = z2.c();
            }
            if (IntentConfig.CLOSE.equalsIgnoreCase(c2.D().c(HTTP.CONN_DIRECTIVE)) || IntentConfig.CLOSE.equalsIgnoreCase(c2.s(HTTP.CONN_DIRECTIVE))) {
                f2.o();
            }
            if ((code == 204 || code == 205) && c2.g().n() > 0) {
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + c2.g().n());
            }
            return c2;
        }
        return (b0) invokeL.objValue;
    }
}
