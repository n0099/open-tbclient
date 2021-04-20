package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.baidu.swan.games.utils.so.SoUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", Build.VERSION.SDK_INT);
            jSONObject.put("sv", Build.VERSION.RELEASE);
            jSONObject.put(Config.CUID_SEC, bw.a(2, context));
            jSONObject.put("w", bw.c(context));
            jSONObject.put("h", bw.d(context));
            jSONObject.put("ly", ab.f8451c);
            jSONObject.put("pv", SoUtils.SO_EVENT_ID_DEFAULT);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put(Config.PACKAGE_NAME, bw.h(2, context));
                jSONObject.put("a", packageInfo.versionCode);
                jSONObject.put("n", packageInfo.versionName);
            } catch (Exception e2) {
                bb.c().a(e2);
            }
            jSONObject.put(Config.DEVICE_MAC_ID, bw.b(2, context));
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, bw.f(2, context));
            jSONObject.put("m", android.os.Build.MODEL);
            jSONObject.put(Config.DEVICE_NAME, bw.a(context, 2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            jSONObject2.put("send_index", 0);
            String b2 = bw.b();
            if (b2 == null) {
                b2 = "";
            }
            jSONObject2.put(Config.ROM, b2);
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (JSONException e3) {
            bb.c().b(e3);
        }
        return jSONObject;
    }

    public static void b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception unused) {
        }
    }

    public static void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put("send_index", jSONObject2.getLong("send_index") + 1);
        } catch (Exception unused) {
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
            JSONObject jSONObject2 = (jSONArray == null || jSONArray.length() <= 0) ? null : (JSONObject) jSONArray.get(0);
            if (jSONObject2 != null) {
                return jSONObject2.getJSONObject(Config.HEADER_PART);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
