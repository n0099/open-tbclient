package b.d.b.e0.i;

import b.d.b.b0;
import b.d.b.t;
import b.d.b.z;
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
/* loaded from: classes6.dex */
public final class b implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f30265a;

    /* loaded from: classes6.dex */
    public static final class a extends ForwardingSink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f30266e;

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
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, buffer, j) == null) {
                super.write(buffer, j);
                this.f30266e += j;
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
        this.f30265a = z;
    }

    @Override // b.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        b0 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            g gVar = (g) aVar;
            c c3 = gVar.c();
            b.d.b.e0.h.f e2 = gVar.e();
            b.d.b.e0.h.c cVar = (b.d.b.e0.h.c) gVar.connection();
            z request = gVar.request();
            long currentTimeMillis = System.currentTimeMillis();
            gVar.b().requestHeadersStart(gVar.call());
            c3.b(request);
            gVar.b().requestHeadersEnd(gVar.call(), request);
            b0.a aVar2 = null;
            if (f.b(request.f()) && request.a() != null) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(request.c(HTTP.EXPECT_DIRECTIVE))) {
                    c3.flushRequest();
                    gVar.b().responseHeadersStart(gVar.call());
                    aVar2 = c3.readResponseHeaders(true);
                }
                if (aVar2 == null) {
                    gVar.b().requestBodyStart(gVar.call());
                    a aVar3 = new a(c3.c(request, request.a().a()));
                    BufferedSink buffer = Okio.buffer(aVar3);
                    request.a().e(buffer);
                    buffer.close();
                    gVar.b().requestBodyEnd(gVar.call(), aVar3.f30266e);
                } else if (!cVar.m()) {
                    e2.o();
                }
            }
            c3.finishRequest();
            if (aVar2 == null) {
                gVar.b().responseHeadersStart(gVar.call());
                aVar2 = c3.readResponseHeaders(false);
            }
            aVar2.p(request);
            aVar2.h(e2.d().handshake());
            aVar2.q(currentTimeMillis);
            aVar2.o(System.currentTimeMillis());
            b0 c4 = aVar2.c();
            int code = c4.code();
            if (code == 100) {
                b0.a readResponseHeaders = c3.readResponseHeaders(false);
                readResponseHeaders.p(request);
                readResponseHeaders.h(e2.d().handshake());
                readResponseHeaders.q(currentTimeMillis);
                readResponseHeaders.o(System.currentTimeMillis());
                c4 = readResponseHeaders.c();
                code = c4.code();
            }
            gVar.b().responseHeadersEnd(gVar.call(), c4);
            if (this.f30265a && code == 101) {
                b0.a n = c4.n();
                n.b(b.d.b.e0.e.f30191c);
                c2 = n.c();
            } else {
                b0.a n2 = c4.n();
                n2.b(c3.a(c4));
                c2 = n2.c();
            }
            if (IntentConfig.CLOSE.equalsIgnoreCase(c2.r().c(HTTP.CONN_DIRECTIVE)) || IntentConfig.CLOSE.equalsIgnoreCase(c2.g(HTTP.CONN_DIRECTIVE))) {
                e2.o();
            }
            if ((code == 204 || code == 205) && c2.a().c() > 0) {
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + c2.a().c());
            }
            return c2;
        }
        return (b0) invokeL.objValue;
    }
}
