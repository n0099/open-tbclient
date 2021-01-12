package com.baidu.swan.apps.view.b.b;

import com.baidu.swan.apps.b;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void c(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        g gVar = new g();
        gVar.mData = e(str, str2, str3, str4, jSONObject);
        f.azN().a(str, gVar);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void d(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        g gVar = new g();
        gVar.mData = e(str, str2, str3, str4, jSONObject);
        f.azN().b(gVar);
    }

    public static JSONObject e(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str2);
            jSONObject3.put("action", str4);
            jSONObject3.put("e", jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str3);
            jSONObject4.put("params", jSONObject3);
            jSONObject2.put("slaveId", str);
            jSONObject2.put("type", "abilityMessage");
            jSONObject2.put("value", jSONObject4);
        } catch (JSONException e) {
            if (b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static JSONObject cO(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slaveId", str);
            jSONObject.put("type", str2);
        } catch (JSONException e) {
            if (b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
