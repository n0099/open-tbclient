package c.a.r0.a.z2;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442662936, "Lc/a/r0/a/z2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(442662936, "Lc/a/r0/a/z2/a;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
    }

    public static JSONObject a(String str, String str2, String str3) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", str);
            jSONObject.put("swan", str2);
            jSONObject.put("type", "NA");
            jSONObject.put("error", str3);
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", a(str, str2, str3));
                jSONObject.put(UrlOcrConfig.IdCardKey.OS, "android");
                jSONObject.put("type", CommonTbJsBridge.GET_APIS);
                jSONObject.put("from", "swan");
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(@Nullable String str) {
        String str2;
        SwanCoreVersion e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            try {
                e2 = c.a.r0.a.q2.b.e(0);
            } catch (Exception e3) {
                if (a) {
                    e3.printStackTrace();
                }
            }
            if (e2 != null) {
                str2 = e2.swanCoreVersionName;
                if (str == null) {
                    str = "";
                }
                c.a.r0.a.n2.b.k("1087", b("2", str2, str));
            }
            str2 = "";
            if (str == null) {
            }
            c.a.r0.a.n2.b.k("1087", b("2", str2, str));
        }
    }

    public static void d() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                str = c.a.r0.a.h0.u.g.U().d0().swanCoreVersionName;
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                str = "";
            }
            c.a.r0.a.n2.b.k("1087", b("1", str, ""));
        }
    }
}
