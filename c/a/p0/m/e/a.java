package c.a.p0.m.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.m.c.c;
import c.a.p0.m.c.d;
import c.a.p0.m.c.e;
import c.a.p0.m.c.f;
import c.a.p0.m.c.g;
import c.a.p0.m.c.h;
import c.a.p0.m.c.i;
import c.a.p0.m.c.j;
import c.a.p0.m.d.a;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class a extends HttpManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11861b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f11862c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11863a;

    /* renamed from: c.a.p0.m.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0619a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0619a(a aVar) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1015592753, "Lc/a/p0/m/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1015592753, "Lc/a/p0/m/e/a;");
                return;
            }
        }
        f11861b = c.a.p0.m.b.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(c.a.p0.m.b.b().getAppContext());
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
        this.f11863a = true;
        this.f11863a = c.a.p0.m.b.a();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11862c == null) {
                synchronized (a.class) {
                    if (f11862c == null) {
                        f11862c = new a();
                        f11862c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return f11862c;
        }
        return (a) invokeV.objValue;
    }

    public static a h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? g() : (a) invokeL.objValue;
    }

    public c.a.p0.m.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.p0.m.c.a(this) : (c.a.p0.m.c.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public c.a.p0.m.c.b deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c.a.p0.m.c.b(this) : (c.a.p0.m.c.b) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11863a : invokeV.booleanValue;
    }

    public void d(c.a.p0.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.f11849b = "GET";
            s(aVar);
        }
    }

    public void e(c.a.p0.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            aVar.f11849b = "POST";
            s(aVar);
        }
    }

    public void f(c.a.p0.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            aVar.f11849b = HttpPut.METHOD_NAME;
            s(aVar);
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
            List<Interceptor> k = c.a.p0.m.b.b().k();
            if (k == null || k.size() <= 0) {
                return initClient;
            }
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : k) {
                newBuilder.addNetworkInterceptor(interceptor);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new C0619a(this) : (ResponseCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: l */
    public d headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new d(this) : (d) invokeV.objValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f11861b;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new e(this) : (e) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: o */
    public g postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new g(this) : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public f postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f(this) : (f) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public h postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new h(this) : (h) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public i putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new i(this) : (i) invokeV.objValue;
    }

    public void s(@NonNull c.a.p0.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (aVar.f11852e == null) {
                aVar.f11852e = k();
            }
            if (m(aVar.f11848a)) {
                aVar.f11852e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a2 = b.a(aVar);
            t(a2, aVar);
            a2.build().executeAsync(aVar.f11852e);
        }
    }

    public void t(HttpRequestBuilder httpRequestBuilder, c.a.p0.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, aVar) == null) {
            if (httpRequestBuilder != null && aVar != null) {
                httpRequestBuilder.url(aVar.f11848a);
                Map<String, String> map = aVar.f11850c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(aVar.f11850c);
                }
                if (aVar.f11853f) {
                    httpRequestBuilder.userAgent(c.a.p0.m.b.b().a());
                }
                if (aVar.f11854g) {
                    httpRequestBuilder.cookieManager(c.a.p0.m.b.b().g());
                }
                if (aVar.f11855h) {
                    a.C0618a b2 = aVar.b();
                    if (b2 == null) {
                        u(httpRequestBuilder);
                    } else {
                        w(httpRequestBuilder, b2);
                    }
                }
                Object obj = aVar.f11856i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (aVar.k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(aVar.f11857j);
                    httpRequestBuilder.requestSubFrom(aVar.k);
                    return;
                }
                return;
            }
            boolean z = f11861b;
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int l = c.a.p0.m.b.b().l();
            if (l > 0) {
                httpRequestBuilder.connectionTimeout(l);
            }
            int readTimeout = c.a.p0.m.b.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int h2 = c.a.p0.m.b.b().h();
            if (h2 > 0) {
                httpRequestBuilder.writeTimeout(h2);
            }
        }
    }

    public void v(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int l = c.a.p0.m.b.b().l();
            if (l > 0) {
                builder.connectTimeout(l, TimeUnit.MILLISECONDS);
            }
            int readTimeout = c.a.p0.m.b.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int h2 = c.a.p0.m.b.b().h();
            if (h2 > 0) {
                builder.writeTimeout(h2, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void w(HttpRequestBuilder httpRequestBuilder, @NonNull a.C0618a c0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, c0618a) == null) {
            int i2 = c0618a.f11858a;
            if (i2 <= 0) {
                i2 = c.a.p0.m.b.b().l();
            }
            if (i2 > 0) {
                httpRequestBuilder.connectionTimeout(i2);
            }
            int i3 = c0618a.f11859b;
            if (i3 <= 0) {
                i3 = c.a.p0.m.b.b().getReadTimeout();
            }
            if (i3 > 0) {
                httpRequestBuilder.readTimeout(i3);
            }
            int i4 = c0618a.f11860c;
            if (i4 <= 0) {
                i4 = c.a.p0.m.b.b().h();
            }
            if (i4 > 0) {
                httpRequestBuilder.writeTimeout(i4);
            }
        }
    }

    public j x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new j(this) : (j) invokeV.objValue;
    }
}
