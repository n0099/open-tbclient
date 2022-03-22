package c.a.q.a.a;

import c.a.q.a.a.e.c;
import c.a.q.a.a.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.okhttp.converters.RequestConverter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.ProxySelector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
/* loaded from: classes3.dex */
public class b implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* renamed from: b  reason: collision with root package name */
    public String f20991b;

    /* renamed from: c  reason: collision with root package name */
    public EventListener f20992c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q.a.a.f.b f20993d;

    /* loaded from: classes3.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallFactoryParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttpClient f20994b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f20995c;

        /* renamed from: c.a.q.a.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1566a implements c.a.q.a.a.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1566a(a aVar, Request request) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, request};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public a(b bVar, CallFactoryParams callFactoryParams, OkHttpClient okHttpClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callFactoryParams, okHttpClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20995c = bVar;
            this.a = callFactoryParams;
            this.f20994b = okHttpClient;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                Request e2 = this.f20995c.e(request);
                if (this.f20995c.h(e2, this.a)) {
                    OkHttpClient.Builder newBuilder = this.f20994b.newBuilder();
                    if (e2.getConnectionTimeout() > 0) {
                        newBuilder.connectTimeout(e2.getConnectionTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e2.getReadTimeout() > 0) {
                        newBuilder.readTimeout(e2.getReadTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e2.getWriteTimeout() > 0) {
                        newBuilder.writeTimeout(e2.getWriteTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e2.getCookieManager() != null && e2.getCookieManager() != this.a.getCookieManager()) {
                        newBuilder.cookieJar(new c.a.q.a.a.c.a(e2.getCookieManager()));
                    }
                    if (!e2.isFollowSslRedirects()) {
                        newBuilder.followSslRedirects(e2.isFollowSslRedirects());
                    }
                    if (!e2.isFollowRedirects()) {
                        newBuilder.followRedirects(e2.isFollowRedirects());
                    }
                    newBuilder.eventListener(new c.a.q.a.a.d.a(this.f20995c.f20992c));
                    if (this.f20995c.f20993d != null) {
                        Dns a = this.f20995c.f20993d.a(e2, new C1566a(this, e2));
                        newBuilder.dns(a);
                        newBuilder.addNetworkInterceptor(new c.a.q.a.a.e.b(a));
                    }
                    return new c.a.q.a.a.a(e2, RequestConverter.toOks(e2), newBuilder.build());
                }
                return new c.a.q.a.a.a(e2, RequestConverter.toOks(e2), this.f20994b);
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* renamed from: c.a.q.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1567b {
        public static /* synthetic */ Interceptable $ic;
        public static List<Class<? extends Interceptor>> o;
        public static List<Class<? extends Interceptor>> p;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f20996b;

        /* renamed from: c  reason: collision with root package name */
        public int f20997c;

        /* renamed from: d  reason: collision with root package name */
        public int f20998d;

        /* renamed from: e  reason: collision with root package name */
        public int f20999e;

        /* renamed from: f  reason: collision with root package name */
        public ConnectionPool f21000f;

        /* renamed from: g  reason: collision with root package name */
        public Dns f21001g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f21002h;
        public int i;
        public CookieManager j;
        public boolean k;
        public String l;
        public EventListener m;
        public c.a.q.a.a.f.b n;

        public C1567b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20997c = 30000;
            this.f20998d = 30000;
            this.f20999e = 30000;
            this.k = true;
        }

        public final void m(OkHttpClient.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
                List<Class<? extends Interceptor>> list = o;
                if (list != null) {
                    try {
                        for (Class<? extends Interceptor> cls : list) {
                            builder.addNetworkInterceptor(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                List<Class<? extends Interceptor>> list2 = p;
                if (list2 != null) {
                    try {
                        for (Class<? extends Interceptor> cls2 : list2) {
                            builder.addInterceptor(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }

        public b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a == null) {
                    if (this.f20996b == null) {
                        this.f20996b = new OkHttpClient.Builder();
                    }
                    o();
                    this.a = this.f20996b.build();
                }
                return new b(this, null);
            }
            return (b) invokeV.objValue;
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.f20996b.connectTimeout(this.f20997c, TimeUnit.MILLISECONDS).readTimeout(this.f20998d, TimeUnit.MILLISECONDS).writeTimeout(this.f20999e, TimeUnit.MILLISECONDS);
                    if (this.f21000f == null) {
                        this.f21000f = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                    }
                    this.f20996b.connectionPool(this.f21000f);
                    if (this.f21001g != null && (this.f21001g instanceof Dns)) {
                        this.f20996b.dns(this.f21001g);
                    }
                    this.f20996b.addNetworkInterceptor(new c.a.q.a.a.e.a());
                    this.f20996b.addInterceptor(new c());
                    m(this.f20996b);
                    if (this.f21002h != null) {
                        this.f20996b.proxySelector(this.f21002h);
                    }
                    if (this.j != null) {
                        this.f20996b.cookieJar(new c.a.q.a.a.c.a(this.j));
                    }
                    this.f20996b.followRedirects(this.k);
                    this.f20996b.eventListener(new c.a.q.a.a.d.a(this.m));
                } catch (Exception unused) {
                }
            }
        }

        public C1567b p(OkHttpClient okHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, okHttpClient)) == null) {
                this.a = okHttpClient;
                return this;
            }
            return (C1567b) invokeL.objValue;
        }
    }

    public /* synthetic */ b(C1567b c1567b, a aVar) {
        this(c1567b);
    }

    public final Request e(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? !Util.isTextEmpty(g()) ? request.newBuilder().header("User-Agent", g()).build() : request : (Request) invokeL.objValue;
    }

    public final void f(OkHttpClient.Builder builder, CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, builder, callFactoryParams) == null) {
            builder.dispatcher(new Dispatcher(this.a.dispatcher().executorService()));
            if (callFactoryParams != null) {
                if (callFactoryParams.getConnectTimeoutMs() > 0) {
                    builder.connectTimeout(callFactoryParams.getConnectTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getReadTimeoutMs() > 0) {
                    builder.readTimeout(callFactoryParams.getReadTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getWriteTimeoutMs() > 0) {
                    builder.writeTimeout(callFactoryParams.getWriteTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getConnectionPoolMaxIdleConnections() > 0) {
                    builder.connectionPool(new ConnectionPool(callFactoryParams.getConnectionPoolMaxIdleConnections(), callFactoryParams.getConnectionPoolKeepAliveDurationNs(), callFactoryParams.getConnectionPoolTimeUnit()));
                }
                if (callFactoryParams.getProxySelector() != null) {
                    builder.proxySelector(callFactoryParams.getProxySelector());
                }
                if (callFactoryParams.getCookieManager() != null) {
                    builder.cookieJar(new c.a.q.a.a.c.a(callFactoryParams.getCookieManager()));
                }
            }
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20991b : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public String getEngineName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? EngineName.OKHTTP : (String) invokeV.objValue;
    }

    public final boolean h(Request request, CallFactoryParams callFactoryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, request, callFactoryParams)) == null) ? (request.getConnectionTimeout() <= 0 && request.getWriteTimeout() <= 0 && request.getReadTimeout() <= 0 && request.getHeaders() == null && request.getNetworkStatRecord() == null && request.isFollowRedirects() && request.isFollowSslRedirects() && this.f20993d == null && (request.getCookieManager() == null || request.getCookieManager() == callFactoryParams.getCookieManager())) ? false : true : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public CallFactory produceCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callFactoryParams)) == null) {
            OkHttpClient.Builder newBuilder = this.a.newBuilder();
            newBuilder.addNetworkInterceptor(new d());
            f(newBuilder, callFactoryParams);
            return new a(this, callFactoryParams, newBuilder.build());
        }
        return (CallFactory) invokeL.objValue;
    }

    public b(C1567b c1567b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1567b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c1567b.a;
        int unused = c1567b.f20997c;
        int unused2 = c1567b.f20998d;
        Dns unused3 = c1567b.f21001g;
        ConnectionPool unused4 = c1567b.f21000f;
        int unused5 = c1567b.f20999e;
        ProxySelector unused6 = c1567b.f21002h;
        boolean unused7 = c1567b.k;
        int unused8 = c1567b.i;
        this.f20991b = c1567b.l;
        this.f20992c = c1567b.m;
        this.f20993d = c1567b.n;
    }
}
