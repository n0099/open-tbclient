package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i {
    private static i a = new i();
    private boolean b = false;

    private i() {
    }

    public static i a() {
        return a;
    }

    public void a(Context context) {
        com.baidu.mobstat.a.e.a("statsdk", "openExceptonAnalysis");
        if (this.b) {
            return;
        }
        this.b = true;
        a.a().a(context);
    }

    public void b(Context context) {
        if (context == null) {
            com.baidu.mobstat.a.e.a("statsdk", "exceptonAnalysis, context=null");
            return;
        }
        JSONArray b = a.a().b(context);
        if (b == null) {
            com.baidu.mobstat.a.e.a("statsdk", "no exception str");
            return;
        }
        com.baidu.mobstat.a.e.a("statsdk", "move exception cache to stat cache");
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= b.length()) {
                    return;
                }
                JSONObject jSONObject = (JSONObject) b.get(i2);
                DataCore.getInstance().putException(jSONObject.getLong("t"), jSONObject.getString("c"), jSONObject.getString("y"));
                DataCore.getInstance().flush(context);
                i = i2 + 1;
            } catch (Exception e) {
                com.baidu.mobstat.a.e.a("statsdk", e);
                return;
            }
        }
    }
}
