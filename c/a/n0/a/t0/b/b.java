package c.a.n0.a.t0.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.k.e.i.e;
import c.a.n0.a.k.f.b.g.c;
import c.a.n0.a.u.d;
import c.a.n0.a.x.u.g;
import c.a.n0.q.j.i.q;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1406303420, "Lc/a/n0/a/t0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1406303420, "Lc/a/n0/a/t0/b/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(c.a.n0.a.x.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (aVar != null) {
                try {
                    jSONObject.put("containerId", aVar.getContainerId());
                    jSONObject.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, BdZeusUtil.isWebkitLoaded());
                } catch (JSONException e2) {
                    if (!a) {
                        e2.printStackTrace();
                    } else {
                        throw new RuntimeException(e2);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b2 = b(g.U().T());
            d.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + c.a.n0.a.f0.h.c.a.r(b2));
            jSONObject.put("sdkExtension", b2);
            jSONObject.put("gameSdkExtension", b(c.a.n0.a.s0.b.i().t()));
            jSONObject.put("isDebugSdk", a);
            if ((aVar instanceof NgWebView) && ((NgWebView) aVar).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", h.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = h.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && c.a.n0.a.n1.a.a.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = c.a.n0.a.s0.a.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = c.a.n0.a.g2.c.a.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", c.a.n0.a.h0.a.USER_DATA_PATH);
            jSONObject.put("preloadId", g.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.f28743d.h());
            jSONObject.put("ttsExtractJSUrl", q.b().a());
            jSONObject.put("coreJSPath", g.U().c0());
            if (e.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) c.d()));
            }
            jSONObject.put("swanNativeVersion", c.a.n0.a.b.a());
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, extensionCore)) == null) ? (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) ? "" : extensionCore.extensionCorePath : (String) invokeL.objValue;
    }
}
