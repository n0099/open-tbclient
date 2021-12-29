package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", Build.VERSION.SDK_INT);
                jSONObject.put("sv", Build.VERSION.RELEASE);
                jSONObject.put("ii", bw.a(2, context));
                jSONObject.put("w", bw.c(context));
                jSONObject.put("h", bw.d(context));
                jSONObject.put("ly", ab.f37599c);
                jSONObject.put("pv", "24");
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    jSONObject.put("pn", bw.h(2, context));
                    jSONObject.put("a", packageInfo.versionCode);
                    jSONObject.put("n", packageInfo.versionName);
                } catch (Exception e2) {
                    bb.c().a(e2);
                }
                jSONObject.put("mc", bw.b(2, context));
                jSONObject.put("bm", bw.f(2, context));
                jSONObject.put("m", android.os.Build.MODEL);
                jSONObject.put("dn", bw.a(context, 2));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("failed_cnt", 0);
                jSONObject2.put("send_index", 0);
                String b2 = bw.b();
                if (b2 == null) {
                    b2 = "";
                }
                jSONObject2.put("rom", b2);
                jSONObject.put("trace", jSONObject2);
            } catch (JSONException e3) {
                bb.c().b(e3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("trace");
                jSONObject2.put("failed_cnt", jSONObject2.getLong("failed_cnt") + 1);
            } catch (Exception unused) {
            }
        }
    }

    public static void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("trace");
                jSONObject2.put("send_index", jSONObject2.getLong("send_index") + 1);
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
                JSONObject jSONObject2 = (jSONArray == null || jSONArray.length() <= 0) ? null : (JSONObject) jSONArray.get(0);
                if (jSONObject2 != null) {
                    return jSONObject2.getJSONObject("he");
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
