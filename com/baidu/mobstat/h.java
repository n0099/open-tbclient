package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
                String c = bu.a().c();
                if (TextUtils.isEmpty(c)) {
                    c = bw.a(2, context);
                }
                jSONObject.put(Config.CUID_SEC, c);
                jSONObject.put(Config.DEVICE_WIDTH, bw.c(context));
                jSONObject.put("h", bw.d(context));
                jSONObject.put("ly", z.c);
                jSONObject.put("pv", "35");
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    jSONObject.put("pn", bw.n(2, context));
                    jSONObject.put("a", packageInfo.versionCode);
                    jSONObject.put("n", packageInfo.versionName);
                } catch (Exception e) {
                    ba.c().a(e);
                }
                jSONObject.put(Config.DEVICE_MAC_ID, bw.h(2, context));
                jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, bw.l(2, context));
                jSONObject.put("m", android.os.Build.MODEL);
                jSONObject.put(Config.DEVICE_NAME, bw.a(context, 2));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
                jSONObject2.put("send_index", 0);
                String b = bw.b();
                if (b == null) {
                    b = "";
                }
                jSONObject2.put(Config.ROM, b);
                jSONObject.put(Config.TRACE_PART, jSONObject2);
                jSONObject.put("im", bw.w(context));
                jSONObject.put(Config.OAID, bw.b(2, context));
                jSONObject.put(Config.OUT_OAID, bw.c(2, context));
                jSONObject.put("from", "0");
                jSONObject.put(Config.GAID, bw.e(2, context));
                jSONObject.put("iid", bw.d(2, context));
                jSONObject.put(Config.CUID3, bw.f(2, context));
                jSONObject.put(Config.SSAID, bw.g(2, context));
            } catch (JSONException e2) {
                ba.c().b(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject2 = (JSONObject) jSONArray.get(0);
                } else {
                    jSONObject2 = null;
                }
                if (jSONObject2 == null) {
                    return null;
                }
                return jSONObject2.getJSONObject(Config.HEADER_PART);
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
                jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
            } catch (Exception unused) {
            }
        }
    }

    public static void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
                jSONObject2.put("send_index", jSONObject2.getLong("send_index") + 1);
            } catch (Exception unused) {
            }
        }
    }
}
