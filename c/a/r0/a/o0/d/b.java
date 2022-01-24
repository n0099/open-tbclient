package c.a.r0.a.o0.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8168b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.f.a f8169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8170h;

        public a(b bVar, c.a.r0.a.h0.f.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8169g = aVar;
            this.f8170h = str;
        }

        @Override // c.a.r0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8169g.isDestroyed()) {
                    if (b.f8168b) {
                        Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + this.f8170h));
                        return;
                    }
                    return;
                }
                this.f8169g.evaluateJavascript(this.f8170h, null);
                c.a.r0.a.u1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
            }
        }
    }

    /* renamed from: c.a.r0.a.o0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0495b extends c.a.r0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.f.a f8171g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8172h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8173i;

        public C0495b(b bVar, c.a.r0.a.h0.f.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8173i = bVar;
            this.f8171g = aVar;
            this.f8172h = str;
        }

        @Override // c.a.r0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8173i.l(this.f8171g, this.f8172h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1032464071, "Lc/a/r0/a/o0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1032464071, "Lc/a/r0/a/o0/d/b;");
                return;
            }
        }
        f8168b = k.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.put("type", this.a);
            } catch (JSONException e2) {
                if (f8168b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String c(c.a.r0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? d("event", aVar) : (String) invokeL.objValue;
    }

    public String d(String str, c.a.r0.a.h0.f.a aVar) {
        InterceptResult invokeLL;
        String format;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                str = "event";
            }
            Locale locale = Locale.getDefault();
            if (aVar.isWebView()) {
                format = String.format(locale, "var %s = new Event('%s');", str, this.a);
                b2 = "";
            } else {
                format = String.format(locale, "var %s = new Object();", str);
                b2 = c.a.r0.a.o0.a.b(str, "type", this.a);
            }
            return format + (b2 + o(str)) + String.format(locale, "%s.dispatchEvent(%s);", c.a.r0.a.o0.a.c(aVar), str);
        }
        return (String) invokeLL.objValue;
    }

    public JSEvent e(c.a.r0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            JSEvent jSEvent = new JSEvent(this.a);
            JSONObject jSONObject = new JSONObject();
            try {
                n(jSONObject);
            } catch (Exception e2) {
                if (f8168b) {
                    e2.printStackTrace();
                }
            }
            b(jSONObject);
            jSEvent.data = jSONObject;
            return jSEvent;
        }
        return (JSEvent) invokeL.objValue;
    }

    public boolean f(c.a.r0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar == null || aVar.isWebView() || !(aVar instanceof c.a.r0.a.l0.c)) ? false : true : invokeL.booleanValue;
    }

    public void g(c.a.r0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.r0.a.u1.g.a("postMessage", "dispatchJSEvent start.");
        if (c.a.r0.a.o0.d.a.f8167b) {
            r(aVar);
        } else {
            q(aVar);
        }
        c.a.r0.a.u1.g.a("postMessage", "dispatchJSEvent buildEvent");
    }

    public void h(c.a.r0.a.h0.f.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        if (f8168b) {
            r0 = "dispatch event - " + this.a + " on v8";
        }
        JSEvent e2 = e(aVar);
        if (e2 == null) {
            return;
        }
        j(aVar, e2);
        if (f8168b) {
            str = "dispatchJSEvent action - " + e2.type + " on v8 : " + e2.data;
        }
    }

    public void i(c.a.r0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null) {
            return;
        }
        if (f8168b) {
            String str = "dispatch event - " + this.a + " on webView";
        }
        String c2 = c(aVar);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c2);
        k(aVar, format);
        if (f8168b) {
            String str2 = "dispatchJSEvent action on webView: " + format;
        }
    }

    public void j(c.a.r0.a.h0.f.a aVar, JSEvent jSEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, jSEvent) == null) || aVar.isDestroyed()) {
            return;
        }
        if (aVar instanceof c.a.r0.a.l0.c) {
            ((c.a.r0.a.l0.c) aVar).dispatchEvent(jSEvent);
        }
        c.a.r0.a.u1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public void k(c.a.r0.a.h0.f.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, aVar, str) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.a.o0.b.b().c(new a(this, aVar, str), null);
    }

    public final void l(c.a.r0.a.h0.f.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, aVar, str) == null) {
            if (aVar.isDestroyed()) {
                if (f8168b) {
                    Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str));
                    return;
                }
                return;
            }
            aVar.evaluateJavascript(str, null);
            c.a.r0.a.u1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }

    public abstract void m(Map<String, Object> map);

    public void n(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            m(hashMap);
            for (String str : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = hashMap.get(str);
                    if (p(obj)) {
                        jSONObject.put(str, obj);
                    }
                }
            }
        }
    }

    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Map<String, Object> hashMap = new HashMap<>();
            m(hashMap);
            StringBuilder sb = new StringBuilder();
            for (String str2 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = hashMap.get(str2);
                    if (p(obj)) {
                        if (obj instanceof String) {
                            obj = JSONObject.quote((String) obj);
                        }
                        sb.append(str);
                        sb.append(".");
                        sb.append(str2);
                        sb.append("=");
                        sb.append(obj);
                        sb.append(";");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean p(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof String) {
                return !TextUtils.isEmpty((String) obj);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(c.a.r0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            String c2 = c(aVar);
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c2);
            if (f8168b) {
                String str = "dispatchJSEvent action: " + format;
            }
            if (aVar.isWebView()) {
                c.a.r0.a.o0.b.b().c(new C0495b(this, aVar, format), null);
            } else {
                l(aVar, format);
            }
        }
    }

    public final void r(@NonNull c.a.r0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f(aVar)) {
                h(aVar);
            } else {
                i(aVar);
            }
        }
    }
}
