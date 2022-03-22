package c.a.n0.j.z;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8961e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f8962f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f8963g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.o.b.a f8964b;

    /* renamed from: c  reason: collision with root package name */
    public String f8965c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.b0.c f8966d;

    /* renamed from: c.a.n0.j.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0740a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8967b;

        public RunnableC0740a(a aVar, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8967b = aVar;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.super.dispatchEvent(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8968b;

        public b(a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8968b = aVar;
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.j.n0.c.call(this.f8968b.f8964b, true, this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f8969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8970c;

        public c(a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8970c = aVar;
            this.a = str;
            this.f8969b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.j.z.f.b bVar = new c.a.n0.j.z.f.b();
                bVar.errMsg = this.a;
                bVar.statusCode = this.f8969b;
                c.a.n0.j.n0.c.call(this.f8970c.f8964b, false, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780912965, "Lc/a/n0/j/z/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780912965, "Lc/a/n0/j/z/a;");
                return;
            }
        }
        f8961e = c.a.n0.a.a.a;
        f8962f = Sets.newHashSet("REFERER", "USER-AGENT");
        f8963g = Sets.newHashSet("localhost", "127.0.0.1");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.b0.c cVar, c.a.n0.a.o.b.a aVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f8966d = cVar;
        this.f8965c = z();
        this.f8964b = aVar;
    }

    public static void G(@NonNull Request.Builder builder, c.a.n0.a.o.b.a aVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, builder, aVar, map) == null) || aVar == null || aVar.k() < 1) {
            return;
        }
        for (String str : aVar.j()) {
            if (!TextUtils.isEmpty(str) && !f8962f.contains(str.toUpperCase(Locale.US))) {
                String f2 = q0.f(aVar.H(str));
                if (!TextUtils.isEmpty(f2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(Locale.US), f2);
                    }
                    builder.header(str, f2);
                }
            }
        }
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String B = this.f8964b.B("url");
            if (this.f8964b != null && !TextUtils.isEmpty(this.f8965c)) {
                if (TextUtils.isEmpty(B)) {
                    D("", -1, "request:url is invalid");
                    return null;
                } else if (e.L() == null) {
                    D("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl F = F(B);
                    if (F == null) {
                        D(B, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = F.url().toString();
                    int c2 = c.a.n0.a.u1.a.b.c("request", url, "");
                    if (c2 != 0) {
                        if (c2 == 1) {
                            D(url, -1, "request:host not in white list");
                            return null;
                        } else if (c2 != 2) {
                            D(url, -1, "request:host not in white list");
                            return null;
                        } else {
                            D(url, -1, "request:url header must be https or wss");
                            return null;
                        }
                    }
                    return url;
                }
            }
            D("", 0, "request:swanApp is null");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean B(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl)) == null) ? (httpUrl == null || f8963g.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true : invokeL.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e L = e.L();
            return L != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", L.N(), L.U()) : "";
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            this.f8966d.postOnJSThread(new c(this, str2, i));
        }
    }

    public void E(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f8966d.postOnJSThread(new b(this, obj));
        }
    }

    public HttpUrl F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (d.J().x() == null) {
                if (B(parse)) {
                    return parse;
                }
                return null;
            } else if ((f8961e && c.a.n0.a.n1.a.a.o()) || B(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void H(@NonNull Request.Builder builder, c.a.n0.a.o.b.a aVar, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{builder, aVar, map, Boolean.valueOf(z)}) == null) {
            G(builder, aVar, map);
            if (z) {
                builder.header("Referer", C());
            }
        }
    }

    public void I(c.a.n0.a.o.b.a aVar) {
        c.a.n0.a.o.b.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (aVar2 = this.f8964b) == null) {
            return;
        }
        aVar2.G("success", aVar.u("success"));
        this.f8964b.G(com.baidu.pass.biometrics.face.liveness.b.a.g0, aVar.u(com.baidu.pass.biometrics.face.liveness.b.a.g0));
        this.f8964b.G(TaskProcessData.keyComplete, aVar.u(TaskProcessData.keyComplete));
    }

    public JSONObject J(Headers headers) throws JSONException {
        InterceptResult invokeL;
        List<String> values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(values.get(i));
                        if (i == size - 1) {
                            break;
                        }
                        sb.append(",");
                    }
                    jSONObject.put(str, sb.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @JavascriptInterface
    public void abort() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f8964b == null || e.L() == null) {
            return;
        }
        e.L().h0().cancelTag(this.f8965c);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSEvent)) == null) {
            this.f8966d.postOnJSThread(new RunnableC0740a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String f0 = e.f0();
            if (TextUtils.isEmpty(f0)) {
                return "";
            }
            return f0 + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }
}
