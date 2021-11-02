package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5564a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581798, "Lb/a/p0/a/h0/m/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581798, "Lb/a/p0/a/h0/m/h;");
                return;
            }
        }
        f5564a = b.a.p0.a.k.f6397a;
    }

    public static void a(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, message) == null) || message == null) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("eventType");
            HashMap hashMap = new HashMap();
            hashMap.put("eventType", string);
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(string, "checkForUpdate")) {
                try {
                    jSONObject.put("hasUpdate", bundle.getBoolean("hasUpdate"));
                } catch (JSONException e2) {
                    if (f5564a) {
                        e2.printStackTrace();
                    }
                }
            }
            hashMap.put("data", jSONObject.toString());
            b.a.p0.a.o0.d.b bVar = new b.a.p0.a.o0.d.b("updateStatusChange", hashMap);
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity != null && activity.getFrameType() == 1) {
                b.a.p0.a.c1.b.i().w(string, bundle.getBoolean("hasUpdate"));
            } else {
                b.a.p0.a.g1.f.T().u(bVar);
            }
        }
    }

    public static void b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, str, z) == null) {
            b.a.p0.a.e0.d.h("SwanAppPkgUpdateManager", "send checkForUpdate msg, hasUpdate=" + z);
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasUpdate", z);
            d("checkForUpdate", str, bundle);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            b.a.p0.a.e0.d.h("SwanAppPkgUpdateManager", "send update failed msg");
            d("updateFailed", str, null);
        }
    }

    public static void d(String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bundle) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("eventType", str);
                b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
                b.a.p0.a.v1.c.c cVar = new b.a.p0.a.v1.c.c(107, bundle);
                cVar.c(str2);
                e2.h(cVar);
                return;
            }
            b.a.p0.a.e0.d.h("SwanAppPkgUpdateManager", "appId is empty or eventType is empty");
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            boolean z = f5564a;
            d("updateReady", str, null);
        }
    }

    public static void f(String str, String str2, boolean z) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, z) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -1330233754) {
                if (str.equals("updateFailed")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != -1317168438) {
                if (hashCode == -585906598 && str.equals("updateReady")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("checkForUpdate")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                e(str2);
            } else if (c2 == 1) {
                c(str2);
            } else if (c2 != 2) {
            } else {
                b(str2, z);
            }
        }
    }
}
