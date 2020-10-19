package com.baidu.swan.apps.menu.fontsize;

import android.util.Log;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public static void bT(String str, String str2) {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "text-size-adjust");
            jSONObject.put("level", str2);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.avu().a(str, gVar);
    }

    public static void e(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level", String.valueOf(num));
        f.avu().b(new com.baidu.swan.apps.event.a.b("text-size-adjust", hashMap));
    }
}
