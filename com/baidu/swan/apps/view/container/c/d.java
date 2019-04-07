package com.baidu.swan.apps.view.container.c;

import com.baidu.swan.apps.m.a.f;
import com.baidu.swan.apps.w.e;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        f fVar = new f();
        fVar.mData = c(str, str2, str3, str4, jSONObject);
        e.Ea().a(str, fVar);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        f fVar = new f();
        fVar.mData = c(str, str2, str3, str4, jSONObject);
        e.Ea().a(fVar);
    }

    public static JSONObject c(String str, String str2, String str3, String str4, JSONObject jSONObject) {
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
            jSONObject2.put(UBC.CONTENT_KEY_VALUE, jSONObject4);
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static JSONObject aM(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slaveId", str);
            jSONObject.put("type", str2);
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
