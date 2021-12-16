package c.a.h0.b.f;

import android.text.TextUtils;
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

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.h0.a.c.i.d("last_show_time", 0L) : invokeV.longValue;
    }

    public static JSONArray b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String f2 = c.a.h0.a.c.i.f("today_show_list", "");
            JSONArray jSONArray = new JSONArray();
            if (TextUtils.isEmpty(f2)) {
                return jSONArray;
            }
            try {
                JSONArray jSONArray2 = new JSONArray(f2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                    try {
                        if (c.a.h0.a.c.c.a(Long.valueOf(Long.valueOf(optJSONObject.optString("t").split("_")[0]).longValue()), Long.valueOf(System.currentTimeMillis()))) {
                            jSONArray.put(optJSONObject);
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            c.a.h0.a.c.i.j("today_show_list", jSONArray.toString());
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, gVar) == null) {
            c.a.h0.a.c.i.i("last_show_time", System.currentTimeMillis() / 1000);
            d(gVar);
        }
    }

    public static void d(g gVar) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gVar) == null) {
            String f2 = c.a.h0.a.c.i.f("today_show_list", "");
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                if (TextUtils.isEmpty(f2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(f2);
                }
                boolean z = false;
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (TextUtils.equals(optJSONObject.optString("k"), gVar.f3387c)) {
                            optJSONObject.put("t", TextUtils.concat(valueOf, "_", optJSONObject.optString("t")).toString());
                            jSONArray.put(i2, optJSONObject);
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("k", gVar.f3387c);
                    jSONObject.put("t", valueOf);
                    jSONArray.put(jSONObject);
                }
                c.a.h0.a.c.i.j("today_show_list", jSONArray.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
