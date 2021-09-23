package c.p.a.e.a.h;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.a.j;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, j.a> f35029a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502078115, "Lc/p/a/e/a/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502078115, "Lc/p/a/e/a/h/b;");
                return;
            }
        }
        f35029a = new HashMap<>();
    }

    public static j.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    j.a g2 = g(str);
                    if (g2 != null) {
                        return g2;
                    }
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (j.a) invokeL.objValue;
    }

    public static boolean b(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) == 0) {
                return true;
            }
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("package_names");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                    String optString2 = optJSONObject.optString("allow_version_range");
                    if (TextUtils.isEmpty(optString)) {
                        return false;
                    }
                    for (String str : optString.split(",")) {
                        if ("market".equals(str)) {
                            str = e.m();
                        }
                        j.a g2 = g(str);
                        if (g2 != null && !(z = d(optJSONArray, optJSONArray2, optString2, g2))) {
                            return false;
                        }
                    }
                    continue;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONArray, str)) == null) {
            if (jSONArray != null && !TextUtils.isEmpty(str)) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && e(optJSONObject)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull j.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, jSONArray2, str, aVar)) == null) {
            String n = aVar.n();
            int m = aVar.m();
            String str2 = m + "_" + n;
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.split("[-,]");
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        int parseInt = Integer.parseInt(split[i2]);
                        int parseInt2 = Integer.parseInt(split[i2 + 1]);
                        if (m >= parseInt && m <= parseInt2) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (jSONArray != null && jSONArray.length() > 0) {
                if (h(jSONArray, str2)) {
                    return true;
                }
            } else if (jSONArray2 != null && jSONArray2.length() > 0 && !h(jSONArray2, str2)) {
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return i(jSONObject) && b(jSONObject.optJSONArray("device_requirements")) && j(jSONObject);
        }
        return invokeL.booleanValue;
    }

    public static boolean f(JSONObject jSONObject, Context context, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
                String optString = jSONObject.optString("s");
                try {
                    String b2 = d.b(jSONObject.optString("az"), optString);
                    String b3 = d.b(jSONObject.optString("ba"), optString);
                    Field declaredField = ContextWrapper.class.getDeclaredField(b2);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(context);
                    Field declaredField2 = obj.getClass().getDeclaredField(b3);
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, str);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static j.a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (f35029a.containsKey(str)) {
                j.a aVar = f35029a.get(str);
                if (aVar != null) {
                    return aVar;
                }
                return null;
            }
            j.a c2 = j.c(str);
            f35029a.put(str, c2);
            if (c2 != null) {
                return c2;
            }
            return null;
        }
        return (j.a) invokeL.objValue;
    }

    public static boolean h(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONArray, str)) == null) {
            if (jSONArray != null && str != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return true;
            }
            int i2 = Build.VERSION.SDK_INT;
            String optString = jSONObject.optString("allow_os_api_range");
            int optInt = jSONObject.optInt("min_os_api", -1);
            if (TextUtils.isEmpty(optString)) {
                return optInt <= 0 || i2 >= optInt;
            }
            try {
                String[] split = optString.split("[-,]");
                for (int i3 = 0; i3 < split.length; i3 += 2) {
                    int parseInt = Integer.parseInt(split[i3]);
                    int parseInt2 = Integer.parseInt(split[i3 + 1]);
                    if (i2 >= parseInt && i2 <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) ? jSONObject == null || f.c() || jSONObject.optInt("scy_mode") != 1 : invokeL.booleanValue;
    }
}
