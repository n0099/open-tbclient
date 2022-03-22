package c.a.n0.a.p2;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-850757405, "Lc/a/n0/a/p2/p0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-850757405, "Lc/a/n0/a/p2/p0;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.n0.a.t1.e.L() != null ? c.a.n0.a.t1.e.L().f6344b : "" : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? k.b(k.a(), "yyyy-MM-dd") : (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JSONObject d2 = d(a());
            if (d2 != null) {
                return d2.optInt("launch_count", 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String string = c.a.n0.a.e2.g.h.a().getString("dailyInfo", "");
            if (a) {
                Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
            }
            JSONObject jSONObject = null;
            try {
                JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
                if (f(jSONObject2)) {
                    jSONObject2.put("date", b());
                }
                jSONObject = jSONObject2.optJSONObject(str);
                if (jSONObject == null) {
                    jSONObject2.put(str, new JSONObject());
                    c.a.n0.a.e2.g.h.a().putString("dailyInfo", jSONObject2.toString());
                    return jSONObject;
                }
            } catch (JSONException e2) {
                if (a) {
                    Log.e("SwanAppUserVisitInfoUtils", e2.getMessage());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject d2 = d(a());
            long optLong = d2 != null ? d2.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
            if (d2 != null) {
                return d2.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            String b2 = b();
            String optString = jSONObject.optString("date", "");
            return TextUtils.isEmpty(optString) || !optString.equals(b2);
        }
        return invokeL.booleanValue;
    }

    public static void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            i(a(), "foreground_aiapp_last_time_local", Long.valueOf(j));
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            i(a(), "visit_duration", Long.valueOf(e()));
        }
    }

    public static void i(String str, String str2, Object obj) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, obj) == null) {
            String string = c.a.n0.a.e2.g.h.a().getString("dailyInfo", "");
            if (a) {
                Log.i("SwanAppUserVisitInfoUtils", TextUtils.isEmpty(string) ? "dailyinfo is null" : string);
            }
            try {
                if (TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(string);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null) {
                    optJSONObject.put(str2, obj);
                } else {
                    jSONObject.put(str, new JSONObject());
                }
                c.a.n0.a.e2.g.h.a().putString("dailyInfo", jSONObject.toString());
            } catch (JSONException e2) {
                if (a) {
                    Log.e("SwanAppUserVisitInfoUtils", e2.getMessage());
                }
            }
        }
    }
}
