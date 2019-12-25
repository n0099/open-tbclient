package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.baidu.swan.games.utils.so.SoUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", Build.VERSION.SDK_INT);
            jSONObject.put("sv", Build.VERSION.RELEASE);
            jSONObject.put(Config.CUID_SEC, bw.a(2, context));
            jSONObject.put("w", bw.c(context));
            jSONObject.put("h", bw.d(context));
            jSONObject.put("ly", ab.c);
            jSONObject.put("pv", SoUtils.SO_EVENT_ID_DEFAULT);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put(Config.PACKAGE_NAME, bw.h(2, context));
                jSONObject.put(Config.APP_VERSION_CODE, packageInfo.versionCode);
                jSONObject.put("n", packageInfo.versionName);
            } catch (Exception e) {
                bb.c().a(e);
            }
            jSONObject.put(Config.DEVICE_MAC_ID, bw.b(2, context));
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, bw.f(2, context));
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
        } catch (JSONException e2) {
            bb.c().b(e2);
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
            JSONObject jSONObject3 = (jSONArray == null || jSONArray.length() <= 0) ? null : (JSONObject) jSONArray.get(0);
            jSONObject2 = jSONObject3 != null ? jSONObject3.getJSONObject(Config.HEADER_PART) : null;
        } catch (Exception e) {
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    public static void b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception e) {
        }
    }

    public static void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put("send_index", jSONObject2.getLong("send_index") + 1);
        } catch (Exception e) {
        }
    }
}
