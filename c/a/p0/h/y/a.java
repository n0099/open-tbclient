package c.a.p0.h.y;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.d;
import c.a.p0.a.a2.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
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
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f11586i;

    /* renamed from: j  reason: collision with root package name */
    public static final Set<String> f11587j;
    public static final Set<String> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f11588e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11589f;

    /* renamed from: g  reason: collision with root package name */
    public String f11590g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.l0.c f11591h;

    /* renamed from: c.a.p0.h.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0602a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f11592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11593f;

        public RunnableC0602a(a aVar, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11593f = aVar;
            this.f11592e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.super.dispatchEvent(this.f11592e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f11594e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11595f;

        public b(a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11595f = aVar;
            this.f11594e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.m0.c.a(this.f11595f.f11589f, true, this.f11594e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f11597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f11598g;

        public c(a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11598g = aVar;
            this.f11596e = str;
            this.f11597f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.y.f.b bVar = new c.a.p0.h.y.f.b();
                bVar.errMsg = this.f11596e;
                bVar.statusCode = this.f11597f;
                c.a.p0.h.m0.c.a(this.f11598g.f11589f, false, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158142688, "Lc/a/p0/h/y/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158142688, "Lc/a/p0/h/y/a;");
                return;
            }
        }
        f11586i = k.f7077a;
        f11587j = Sets.newHashSet("REFERER", "USER-AGENT");
        k = Sets.newHashSet("localhost", "127.0.0.1");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.l0.c cVar, c.a.p0.a.y.b.a aVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11588e = 0;
        this.f11591h = cVar;
        this.f11590g = y();
        this.f11589f = aVar;
    }

    public static void F(@NonNull Request.Builder builder, c.a.p0.a.y.b.a aVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, builder, aVar, map) == null) || aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str) && !f11587j.contains(str.toUpperCase(Locale.US))) {
                String f2 = q0.f(aVar.I(str));
                if (!TextUtils.isEmpty(f2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(Locale.US), f2);
                    }
                    builder.header(str, f2);
                }
            }
        }
    }

    public boolean A(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) ? (httpUrl == null || k.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true : invokeL.booleanValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e i2 = e.i();
            return i2 != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", i2.D(), i2.K()) : "";
        }
        return (String) invokeV.objValue;
    }

    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) {
            this.f11591h.postOnJSThread(new c(this, str2, i2));
        }
    }

    public void D(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.f11591h.postOnJSThread(new b(this, obj));
        }
    }

    public HttpUrl E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (d.g().x() == null) {
                if (A(parse)) {
                    return parse;
                }
                return null;
            } else if ((f11586i && c.a.p0.a.u1.a.a.o()) || A(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void G(@NonNull Request.Builder builder, c.a.p0.a.y.b.a aVar, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{builder, aVar, map, Boolean.valueOf(z)}) == null) {
            F(builder, aVar, map);
            if (z) {
                builder.header("Referer", B());
            }
        }
    }

    public void H(c.a.p0.a.y.b.a aVar) {
        c.a.p0.a.y.b.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || (aVar2 = this.f11589f) == null) {
            return;
        }
        aVar2.H("success", aVar.v("success"));
        this.f11589f.H(com.baidu.pass.biometrics.face.liveness.b.a.g0, aVar.v(com.baidu.pass.biometrics.face.liveness.b.a.g0));
        this.f11589f.H(XAdRemoteEvent.COMPLETE, aVar.v(XAdRemoteEvent.COMPLETE));
    }

    public JSONObject I(Headers headers) throws JSONException {
        InterceptResult invokeL;
        List<String> values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(values.get(i2));
                        if (i2 == size - 1) {
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f11589f == null || e.i() == null) {
            return;
        }
        e.i().X().cancelTag(this.f11590g);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSEvent)) == null) {
            this.f11591h.postOnJSThread(new RunnableC0602a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String V = e.V();
            if (TextUtils.isEmpty(V)) {
                return "";
            }
            return V + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String C = this.f11589f.C("url");
            if (this.f11589f != null && !TextUtils.isEmpty(this.f11590g)) {
                if (TextUtils.isEmpty(C)) {
                    C("", -1, "request:url is invalid");
                    return null;
                } else if (e.i() == null) {
                    C("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl E = E(C);
                    if (E == null) {
                        C(C, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = E.url().toString();
                    int c2 = c.a.p0.a.b2.a.b.c("request", url, "");
                    if (c2 != 0) {
                        if (c2 == 1) {
                            C(url, -1, "request:host not in white list");
                            return null;
                        } else if (c2 != 2) {
                            C(url, -1, "request:host not in white list");
                            return null;
                        } else {
                            C(url, -1, "request:url header must be https or wss");
                            return null;
                        }
                    }
                    return url;
                }
            }
            C("", 0, "request:swanApp is null");
            return null;
        }
        return (String) invokeV.objValue;
    }
}
