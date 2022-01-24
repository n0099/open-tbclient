package c.a.t0.x3.n0;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.t0.x3.n0.d.e;
import c.a.t0.x3.n0.d.f;
import c.a.t0.x3.n0.d.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<b> a;

    /* renamed from: b  reason: collision with root package name */
    public f f25188b;

    public a() {
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
        this.a = new ArrayList<>();
        this.f25188b = new f();
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar != null) {
                this.a.add(bVar);
            }
            if (this.f25188b == null || bVar == null || bVar.getClass().getAnnotation(c.a.f.a.a.class) == null) {
                return;
            }
            try {
                this.f25188b.a((c.a.t0.x3.n0.d.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + c.a.t0.x3.n0.d.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                e(webView, str);
                return false;
            }
            return c(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return d(optString, optString2, optString3, jsPromptResult);
                }
            } catch (JSONException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<b> it = this.a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void e(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) || this.f25188b == null) {
            return;
        }
        e eVar = new e();
        c.a.t0.x3.n0.d.c cVar = new c.a.t0.x3.n0.d.c();
        String a = g.a(str);
        eVar.f(a);
        String d2 = g.d(str);
        eVar.h(d2);
        String b2 = g.b(str);
        cVar.v(b2);
        if (m.isEmpty(a) || m.isEmpty(d2) || m.isEmpty(b2)) {
            cVar.y(101);
        }
        try {
            eVar.j(g.f(str));
        } catch (JSONException unused) {
            eVar.j(new JSONObject());
            cVar.y(101);
        }
        eVar.i(g.e(str));
        eVar.g(g.c(str));
        c.a.t0.x3.n0.d.c c2 = this.f25188b.c(eVar, cVar);
        if (c2.g()) {
            this.f25188b.d(webView, c2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.clear();
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.a.remove(bVar);
    }

    public void h(WebView webView, String str, @Nullable HashMap hashMap) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, webView, str, hashMap) == null) || (fVar = this.f25188b) == null) {
            return;
        }
        this.f25188b.e(webView, fVar.f(str, hashMap));
    }
}
