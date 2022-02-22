package c.a.s.a.a;

import c.a.s.a.a.e.c;
import c.a.s.a.a.e.d;
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
/* loaded from: classes.dex */
public class b implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* renamed from: b  reason: collision with root package name */
    public String f5278b;

    /* renamed from: c  reason: collision with root package name */
    public EventListener f5279c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s.a.a.f.b f5280d;

    /* loaded from: classes.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallFactoryParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttpClient f5281b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5282c;

        /* renamed from: c.a.s.a.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0276a implements c.a.s.a.a.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0276a(a aVar, Request request) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, request};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5282c = bVar;
            this.a = callFactoryParams;
            this.f5281b = okHttpClient;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                Request e2 = this.f5282c.e(request);
                if (this.f5282c.h(e2, this.a)) {
                    OkHttpClient.Builder newBuilder = this.f5281b.newBuilder();
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
                        newBuilder.cookieJar(new c.a.s.a.a.c.a(e2.getCookieManager()));
                    }
                    if (!e2.isFollowSslRedirects()) {
                        newBuilder.followSslRedirects(e2.isFollowSslRedirects());
                    }
                    if (!e2.isFollowRedirects()) {
                        newBuilder.followRedirects(e2.isFollowRedirects());
                    }
                    newBuilder.eventListener(new c.a.s.a.a.d.a(this.f5282c.f5279c));
                    if (this.f5282c.f5280d != null) {
                        Dns a = this.f5282c.f5280d.a(e2, new C0276a(this, e2));
                        newBuilder.dns(a);
                        newBuilder.addNetworkInterceptor(new c.a.s.a.a.e.b(a));
                    }
                    return new c.a.s.a.a.a(e2, RequestConverter.toOks(e2), newBuilder.build());
                }
                return new c.a.s.a.a.a(e2, RequestConverter.toOks(e2), this.f5281b);
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* renamed from: c.a.s.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0277b {
        public static /* synthetic */ Interceptable $ic;
        public static List<Class<? extends Interceptor>> o;
        public static List<Class<? extends Interceptor>> p;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f5283b;

        /* renamed from: c  reason: collision with root package name */
        public int f5284c;

        /* renamed from: d  reason: collision with root package name */
        public int f5285d;

        /* renamed from: e  reason: collision with root package name */
        public int f5286e;

        /* renamed from: f  reason: collision with root package name */
        public ConnectionPool f5287f;

        /* renamed from: g  reason: collision with root package name */
        public Dns f5288g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f5289h;

        /* renamed from: i  reason: collision with root package name */
        public int f5290i;

        /* renamed from: j  reason: collision with root package name */
        public CookieManager f5291j;
        public boolean k;
        public String l;
        public EventListener m;
        public c.a.s.a.a.f.b n;

        public C0277b() {
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
            this.f5284c = 30000;
            this.f5285d = 30000;
            this.f5286e = 30000;
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
                    if (this.f5283b == null) {
                        this.f5283b = new OkHttpClient.Builder();
                    }
                    o();
                    this.a = this.f5283b.build();
                }
                return new b(this, null);
            }
            return (b) invokeV.objValue;
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.f5283b.connectTimeout(this.f5284c, TimeUnit.MILLISECONDS).readTimeout(this.f5285d, TimeUnit.MILLISECONDS).writeTimeout(this.f5286e, TimeUnit.MILLISECONDS);
                    if (this.f5287f == null) {
                        this.f5287f = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                    }
                    this.f5283b.connectionPool(this.f5287f);
                    if (this.f5288g != null && (this.f5288g instanceof Dns)) {
                        this.f5283b.dns(this.f5288g);
                    }
                    this.f5283b.addNetworkInterceptor(new c.a.s.a.a.e.a());
                    this.f5283b.addInterceptor(new c());
                    m(this.f5283b);
                    if (this.f5289h != null) {
                        this.f5283b.proxySelector(this.f5289h);
                    }
                    if (this.f5291j != null) {
                        this.f5283b.cookieJar(new c.a.s.a.a.c.a(this.f5291j));
                    }
                    this.f5283b.followRedirects(this.k);
                    this.f5283b.eventListener(new c.a.s.a.a.d.a(this.m));
                } catch (Exception unused) {
                }
            }
        }

        public C0277b p(OkHttpClient okHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, okHttpClient)) == null) {
                this.a = okHttpClient;
                return this;
            }
            return (C0277b) invokeL.objValue;
        }
    }

    public /* synthetic */ b(C0277b c0277b, a aVar) {
        this(c0277b);
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
                    builder.cookieJar(new c.a.s.a.a.c.a(callFactoryParams.getCookieManager()));
                }
            }
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5278b : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, request, callFactoryParams)) == null) ? (request.getConnectionTimeout() <= 0 && request.getWriteTimeout() <= 0 && request.getReadTimeout() <= 0 && request.getHeaders() == null && request.getNetworkStatRecord() == null && request.isFollowRedirects() && request.isFollowSslRedirects() && this.f5280d == null && (request.getCookieManager() == null || request.getCookieManager() == callFactoryParams.getCookieManager())) ? false : true : invokeLL.booleanValue;
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

    public b(C0277b c0277b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0277b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0277b.a;
        int unused = c0277b.f5284c;
        int unused2 = c0277b.f5285d;
        Dns unused3 = c0277b.f5288g;
        ConnectionPool unused4 = c0277b.f5287f;
        int unused5 = c0277b.f5286e;
        ProxySelector unused6 = c0277b.f5289h;
        boolean unused7 = c0277b.k;
        int unused8 = c0277b.f5290i;
        this.f5278b = c0277b.l;
        this.f5279c = c0277b.m;
        this.f5280d = c0277b.n;
    }
}
