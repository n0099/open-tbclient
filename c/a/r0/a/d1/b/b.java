package c.a.r0.a.d1.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.e0.d;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
import c.a.r0.a.l;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.u.e.i.e;
import c.a.r0.a.u.f.b.g.c;
import c.a.r0.q.k.i.q;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2118466895, "Lc/a/r0/a/d1/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2118466895, "Lc/a/r0/a/d1/b/b;");
                return;
            }
        }
        a = k.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(c.a.r0.a.h0.f.a aVar) {
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
            d.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + c.a.r0.a.p0.h.c.a.r(b2));
            jSONObject.put("sdkExtension", b2);
            jSONObject.put("gameSdkExtension", b(c.a.r0.a.c1.b.i().t()));
            jSONObject.put("isDebugSdk", a);
            if ((aVar instanceof NgWebView) && ((NgWebView) aVar).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", h.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = h.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && c.a.r0.a.x1.a.a.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i2 = c.a.r0.a.c1.a.o().i();
            if (!TextUtils.isEmpty(i2)) {
                jSONObject.put("hostName", i2);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = c.a.r0.a.q2.c.a.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", c.a.r0.a.r0.a.USER_DATA_PATH);
            jSONObject.put("preloadId", g.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.f38633d.h());
            jSONObject.put("ttsExtractJSUrl", q.b().a());
            jSONObject.put("coreJSPath", g.U().c0());
            if (e.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) c.d()));
            }
            jSONObject.put("swanNativeVersion", l.a());
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
