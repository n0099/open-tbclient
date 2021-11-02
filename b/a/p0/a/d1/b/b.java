package b.a.p0.a.d1.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.e0.d;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.a.s.a.f;
import b.a.p0.n.j.i.n;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4525a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1924131662, "Lb/a/p0/a/d1/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1924131662, "Lb/a/p0/a/d1/b/b;");
                return;
            }
        }
        f4525a = k.f6397a;
    }

    @NonNull
    public static String a(b.a.p0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (aVar != null) {
                try {
                    jSONObject.put("containerId", aVar.getContainerId());
                } catch (JSONException e2) {
                    if (!f4525a) {
                        e2.printStackTrace();
                    } else {
                        throw new RuntimeException(e2);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b2 = b(g.M().L());
            d.h("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + b.a.p0.a.p0.h.c.a.r(b2));
            jSONObject.put("sdkExtension", b2);
            jSONObject.put("gameSdkExtension", b(b.a.p0.a.c1.b.i().t()));
            jSONObject.put("isDebugSdk", f4525a);
            String string = h.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && b.a.p0.a.u1.a.a.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i2 = b.a.p0.a.c1.a.n().i();
            if (!TextUtils.isEmpty(i2)) {
                jSONObject.put("hostName", i2);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = b.a.p0.a.m2.c.a.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", b.a.p0.a.r0.a.USER_DATA_PATH);
            jSONObject.put("preloadId", g.M().R());
            jSONObject.put("isBaiduSeries", f.f7771d.h());
            jSONObject.put("ttsExtractJSUrl", n.b().a());
            jSONObject.put("coreJSPath", g.M().T());
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
