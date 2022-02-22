package c.a.j0.b.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String b2 = b();
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(b2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    long optLong = jSONArray2.optLong(i2);
                    if (c.a.d0.h0.e.b(optLong, currentTimeMillis)) {
                        jSONArray.put(optLong);
                    }
                }
                g(jSONArray.toString());
                return jSONArray.length();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @NonNull
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getString("today_cpc_show_list", "") : (String) invokeV.objValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.d0.y.e.a().b("splash_sp_name").getLong("last_show_time", 0L) : invokeV.longValue;
    }

    public static JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String string = c.a.d0.y.e.a().b("splash_sp_name").getString("today_show_list", "");
            JSONArray jSONArray = new JSONArray();
            if (TextUtils.isEmpty(string)) {
                return jSONArray;
            }
            try {
                JSONArray jSONArray2 = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                    try {
                        if (c.a.d0.h0.e.b(Long.valueOf(optJSONObject.optString("t").split("_")[0]).longValue() * 1000, System.currentTimeMillis())) {
                            jSONArray.put(optJSONObject);
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            c.a.d0.y.e.a().b("splash_sp_name").j("today_show_list", jSONArray.toString(), false);
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void e(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").h("last_show_time", System.currentTimeMillis() / 1000);
            h(gVar);
        }
    }

    public static void f() {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            String b2 = b();
            try {
                if (TextUtils.isEmpty(b2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(b2);
                }
                jSONArray.put(System.currentTimeMillis());
                g(jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void g(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            c.a.d0.y.e.a().b("splash_sp_name").j("today_cpc_show_list", str, false);
        }
    }

    public static void h(g gVar) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.f()) {
            f();
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String string = c.a.d0.y.e.a().b("splash_sp_name").getString("today_show_list", "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(string);
            }
            boolean z = true;
            if (jSONArray.length() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (TextUtils.equals(optJSONObject.optString("k"), gVar.f4292c)) {
                        optJSONObject.put("t", TextUtils.concat(valueOf, "_", optJSONObject.optString("t")).toString());
                        jSONArray.put(i2, optJSONObject);
                        z = false;
                        break;
                    }
                    i2++;
                }
            }
            if (z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", gVar.f4292c);
                jSONObject.put("t", valueOf);
                jSONArray.put(jSONObject);
            }
            c.a.d0.y.e.a().b("splash_sp_name").j("today_show_list", jSONArray.toString(), false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
