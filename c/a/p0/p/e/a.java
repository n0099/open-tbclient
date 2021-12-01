package c.a.p0.p.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.p.c.c;
import c.a.p0.p.c.d;
import c.a.p0.p.c.e;
import c.a.p0.p.c.f;
import c.a.p0.p.c.g;
import c.a.p0.p.c.h;
import c.a.p0.p.c.i;
import c.a.p0.p.c.j;
import c.a.p0.p.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes5.dex */
public class a extends HttpManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10682b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f10683c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f10684d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: c.a.p0.p.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0699a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0699a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) ? response : invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-929705300, "Lc/a/p0/p/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-929705300, "Lc/a/p0/p/e/a;");
                return;
            }
        }
        f10682b = c.a.p0.p.b.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(c.a.p0.p.b.b().getAppContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.a = c.a.p0.p.b.a();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10683c == null) {
                synchronized (a.class) {
                    if (f10683c == null) {
                        f10683c = new a();
                        f10683c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return f10683c;
        }
        return (a) invokeV.objValue;
    }

    public static a h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? g() : (a) invokeL.objValue;
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f10684d == null) {
                synchronized (a.class) {
                    if (f10684d == null) {
                        f10684d = new a();
                        f10684d.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return f10684d;
        }
        return (a) invokeV.objValue;
    }

    public c.a.p0.p.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.p0.p.c.a(this) : (c.a.p0.p.c.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public c.a.p0.p.c.b deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c.a.p0.p.c.b(this) : (c.a.p0.p.c.b) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void d(c.a.p0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.f10670b = "GET";
            t(aVar);
        }
    }

    public void e(c.a.p0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            aVar.f10670b = "POST";
            t(aVar);
        }
    }

    public void f(c.a.p0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            aVar.f10670b = HttpPut.METHOD_NAME;
            t(aVar);
        }
    }

    public OkHttpClient.Builder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getOkHttpClient().newBuilder() : (OkHttpClient.Builder) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            OkHttpClient initClient = super.initClient();
            List<Interceptor> l = c.a.p0.p.b.b().l();
            if (l == null || l.size() <= 0) {
                return initClient;
            }
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : l) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            if (c.a.p0.p.b.b().i()) {
                try {
                    Iterator<Interceptor> it = newBuilder.interceptors().iterator();
                    while (it.hasNext()) {
                        String obj = it.next().toString();
                        if (obj.contains("RequestFilter") || obj.contains("SimCardFreeHeader")) {
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    if (f10682b) {
                        th.printStackTrace();
                    }
                }
            }
            c.a.p0.p.a b2 = c.a.p0.p.b.b();
            if (b2 != null && b2.k() > 0) {
                newBuilder.connectionPool(new ConnectionPool(b2.k(), 5L, TimeUnit.MINUTES));
            }
            return newBuilder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: j */
    public c getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new c(this) : (c) invokeV.objValue;
    }

    public final ResponseCallback k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new C0699a(this) : (ResponseCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: m */
    public d headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new d(this) : (d) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f10682b;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public e o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new e(this) : (e) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public g postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new g(this) : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public f postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new f(this) : (f) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public h postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new h(this) : (h) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: s */
    public i putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new i(this) : (i) invokeV.objValue;
    }

    public void t(@NonNull c.a.p0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (aVar.f10673e == null) {
                aVar.f10673e = k();
            }
            if (n(aVar.a)) {
                aVar.f10673e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a = b.a(aVar);
            u(a, aVar);
            a.build().executeAsync(aVar.f10673e);
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder, c.a.p0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, aVar) == null) {
            if (httpRequestBuilder != null && aVar != null) {
                httpRequestBuilder.url(aVar.a);
                Map<String, String> map = aVar.f10671c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(aVar.f10671c);
                }
                if (aVar.f10674f) {
                    httpRequestBuilder.userAgent(c.a.p0.p.b.b().a());
                }
                if (aVar.f10675g) {
                    httpRequestBuilder.cookieManager(c.a.p0.p.b.b().f());
                }
                if (aVar.f10676h) {
                    a.C0698a b2 = aVar.b();
                    if (b2 == null) {
                        v(httpRequestBuilder);
                    } else {
                        x(httpRequestBuilder, b2);
                    }
                }
                Object obj = aVar.f10677i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (aVar.f10679k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(aVar.f10678j);
                    httpRequestBuilder.requestSubFrom(aVar.f10679k);
                    return;
                }
                return;
            }
            boolean z = f10682b;
        }
    }

    public void v(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int m = c.a.p0.p.b.b().m();
            if (m > 0) {
                httpRequestBuilder.connectionTimeout(m);
            }
            int readTimeout = c.a.p0.p.b.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int g2 = c.a.p0.p.b.b().g();
            if (g2 > 0) {
                httpRequestBuilder.writeTimeout(g2);
            }
        }
    }

    public void w(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int m = c.a.p0.p.b.b().m();
            if (m > 0) {
                builder.connectTimeout(m, TimeUnit.MILLISECONDS);
            }
            int readTimeout = c.a.p0.p.b.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int g2 = c.a.p0.p.b.b().g();
            if (g2 > 0) {
                builder.writeTimeout(g2, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void x(HttpRequestBuilder httpRequestBuilder, @NonNull a.C0698a c0698a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, c0698a) == null) {
            int i2 = c0698a.a;
            if (i2 <= 0) {
                i2 = c.a.p0.p.b.b().m();
            }
            if (i2 > 0) {
                httpRequestBuilder.connectionTimeout(i2);
            }
            int i3 = c0698a.f10680b;
            if (i3 <= 0) {
                i3 = c.a.p0.p.b.b().getReadTimeout();
            }
            if (i3 > 0) {
                httpRequestBuilder.readTimeout(i3);
            }
            int i4 = c0698a.f10681c;
            if (i4 <= 0) {
                i4 = c.a.p0.p.b.b().g();
            }
            if (i4 > 0) {
                httpRequestBuilder.writeTimeout(i4);
            }
        }
    }

    public j y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new j(this) : (j) invokeV.objValue;
    }
}
