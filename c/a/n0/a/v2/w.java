package c.a.n0.a.v2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9165a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225023554, "Lc/a/n0/a/v2/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225023554, "Lc/a/n0/a/v2/w;");
                return;
            }
        }
        f9165a = c.a.n0.a.k.f6803a;
    }

    public static <T> T a(JSONObject jSONObject, String str, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, str, cls)) == null) {
            if (jSONObject == null) {
                return null;
            }
            T t = (T) jSONObject.opt(str);
            if (cls.isInstance(t)) {
                if (f9165a) {
                    String obj = t.toString();
                    if (((t instanceof JSONObject) || (t instanceof JSONArray)) && obj.length() > 30) {
                        obj = obj.substring(0, 30) + "...";
                    }
                    if (f9165a) {
                        String str2 = "json: " + str + "=" + obj;
                    }
                }
                return t;
            }
            if (f9165a) {
                if (t == null) {
                    String str3 = "Json has no value by name: '" + str + "'!";
                } else {
                    String str4 = "Value of '" + str + "' is not a instance of '" + cls.getSimpleName() + "'!";
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static float b(JSONObject jSONObject, String str, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jSONObject, str, Float.valueOf(f2)})) == null) ? jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2) : invokeCommon.floatValue;
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) ? (JSONArray) a(jSONObject, str, JSONArray.class) : (JSONArray) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                boolean z = f9165a;
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONArray e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONArray();
            }
            try {
                return new JSONArray(str);
            } catch (JSONException unused) {
                boolean z = f9165a;
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject f(JSONObject jSONObject, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str, obj)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(str, obj);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
