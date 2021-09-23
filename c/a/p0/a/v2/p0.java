package c.a.p0.a.v2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9382a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22082079, "Lc/a/p0/a/v2/p0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(22082079, "Lc/a/p0/a/v2/p0;");
                return;
            }
        }
        f9382a = c.a.p0.a.k.f7085a;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.p0.a.a2.e.i() != null ? c.a.p0.a.a2.e.i().f4566f : "" : (String) invokeV.objValue;
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
            String string = c.a.p0.a.k2.g.h.a().getString("dailyInfo", "");
            if (f9382a) {
                String str2 = "dailyInfo:" + string;
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
                    c.a.p0.a.k2.g.h.a().putString("dailyInfo", jSONObject2.toString());
                    return jSONObject;
                }
            } catch (JSONException e2) {
                if (f9382a) {
                    e2.getMessage();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject)) == null) {
            String b2 = b();
            String optString = jSONObject.optString("date", "");
            return TextUtils.isEmpty(optString) || !optString.equals(b2);
        }
        return invokeL.booleanValue;
    }

    public static void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j2) == null) {
            i(a(), "foreground_aiapp_last_time_local", Long.valueOf(j2));
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
            String string = c.a.p0.a.k2.g.h.a().getString("dailyInfo", "");
            if (f9382a) {
                TextUtils.isEmpty(string);
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
                c.a.p0.a.k2.g.h.a().putString("dailyInfo", jSONObject.toString());
            } catch (JSONException e2) {
                if (f9382a) {
                    e2.getMessage();
                }
            }
        }
    }
}
