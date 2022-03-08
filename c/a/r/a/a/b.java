package c.a.r.a.a;

import c.a.r.a.a.e.c;
import c.a.r.a.a.e.d;
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
/* loaded from: classes2.dex */
public class b implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* renamed from: b  reason: collision with root package name */
    public String f14119b;

    /* renamed from: c  reason: collision with root package name */
    public EventListener f14120c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r.a.a.f.b f14121d;

    /* loaded from: classes2.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallFactoryParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttpClient f14122b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f14123c;

        /* renamed from: c.a.r.a.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0907a implements c.a.r.a.a.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0907a(a aVar, Request request) {
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
            this.f14123c = bVar;
            this.a = callFactoryParams;
            this.f14122b = okHttpClient;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                Request e2 = this.f14123c.e(request);
                if (this.f14123c.h(e2, this.a)) {
                    OkHttpClient.Builder newBuilder = this.f14122b.newBuilder();
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
                        newBuilder.cookieJar(new c.a.r.a.a.c.a(e2.getCookieManager()));
                    }
                    if (!e2.isFollowSslRedirects()) {
                        newBuilder.followSslRedirects(e2.isFollowSslRedirects());
                    }
                    if (!e2.isFollowRedirects()) {
                        newBuilder.followRedirects(e2.isFollowRedirects());
                    }
                    newBuilder.eventListener(new c.a.r.a.a.d.a(this.f14123c.f14120c));
                    if (this.f14123c.f14121d != null) {
                        Dns a = this.f14123c.f14121d.a(e2, new C0907a(this, e2));
                        newBuilder.dns(a);
                        newBuilder.addNetworkInterceptor(new c.a.r.a.a.e.b(a));
                    }
                    return new c.a.r.a.a.a(e2, RequestConverter.toOks(e2), newBuilder.build());
                }
                return new c.a.r.a.a.a(e2, RequestConverter.toOks(e2), this.f14122b);
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* renamed from: c.a.r.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0908b {
        public static /* synthetic */ Interceptable $ic;
        public static List<Class<? extends Interceptor>> o;
        public static List<Class<? extends Interceptor>> p;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f14124b;

        /* renamed from: c  reason: collision with root package name */
        public int f14125c;

        /* renamed from: d  reason: collision with root package name */
        public int f14126d;

        /* renamed from: e  reason: collision with root package name */
        public int f14127e;

        /* renamed from: f  reason: collision with root package name */
        public ConnectionPool f14128f;

        /* renamed from: g  reason: collision with root package name */
        public Dns f14129g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f14130h;

        /* renamed from: i  reason: collision with root package name */
        public int f14131i;

        /* renamed from: j  reason: collision with root package name */
        public CookieManager f14132j;
        public boolean k;
        public String l;
        public EventListener m;
        public c.a.r.a.a.f.b n;

        public C0908b() {
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
            this.f14125c = 30000;
            this.f14126d = 30000;
            this.f14127e = 30000;
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
                    if (this.f14124b == null) {
                        this.f14124b = new OkHttpClient.Builder();
                    }
                    o();
                    this.a = this.f14124b.build();
                }
                return new b(this, null);
            }
            return (b) invokeV.objValue;
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.f14124b.connectTimeout(this.f14125c, TimeUnit.MILLISECONDS).readTimeout(this.f14126d, TimeUnit.MILLISECONDS).writeTimeout(this.f14127e, TimeUnit.MILLISECONDS);
                    if (this.f14128f == null) {
                        this.f14128f = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                    }
                    this.f14124b.connectionPool(this.f14128f);
                    if (this.f14129g != null && (this.f14129g instanceof Dns)) {
                        this.f14124b.dns(this.f14129g);
                    }
                    this.f14124b.addNetworkInterceptor(new c.a.r.a.a.e.a());
                    this.f14124b.addInterceptor(new c());
                    m(this.f14124b);
                    if (this.f14130h != null) {
                        this.f14124b.proxySelector(this.f14130h);
                    }
                    if (this.f14132j != null) {
                        this.f14124b.cookieJar(new c.a.r.a.a.c.a(this.f14132j));
                    }
                    this.f14124b.followRedirects(this.k);
                    this.f14124b.eventListener(new c.a.r.a.a.d.a(this.m));
                } catch (Exception unused) {
                }
            }
        }

        public C0908b p(OkHttpClient okHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, okHttpClient)) == null) {
                this.a = okHttpClient;
                return this;
            }
            return (C0908b) invokeL.objValue;
        }
    }

    public /* synthetic */ b(C0908b c0908b, a aVar) {
        this(c0908b);
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
                    builder.cookieJar(new c.a.r.a.a.c.a(callFactoryParams.getCookieManager()));
                }
            }
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14119b : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, request, callFactoryParams)) == null) ? (request.getConnectionTimeout() <= 0 && request.getWriteTimeout() <= 0 && request.getReadTimeout() <= 0 && request.getHeaders() == null && request.getNetworkStatRecord() == null && request.isFollowRedirects() && request.isFollowSslRedirects() && this.f14121d == null && (request.getCookieManager() == null || request.getCookieManager() == callFactoryParams.getCookieManager())) ? false : true : invokeLL.booleanValue;
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

    public b(C0908b c0908b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0908b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0908b.a;
        int unused = c0908b.f14125c;
        int unused2 = c0908b.f14126d;
        Dns unused3 = c0908b.f14129g;
        ConnectionPool unused4 = c0908b.f14128f;
        int unused5 = c0908b.f14127e;
        ProxySelector unused6 = c0908b.f14130h;
        boolean unused7 = c0908b.k;
        int unused8 = c0908b.f14131i;
        this.f14119b = c0908b.l;
        this.f14120c = c0908b.m;
        this.f14121d = c0908b.n;
    }
}
