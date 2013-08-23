package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f803a = new e();
    private boolean b = false;

    private e() {
    }

    public static e a() {
        return f803a;
    }

    public void a(Context context) {
        com.baidu.mobstat.a.b.a("stat", "openExceptonAnalysis");
        if (this.b) {
            return;
        }
        this.b = true;
        a.a().a(context);
    }

    public void b(Context context) {
        if (context == null) {
            com.baidu.mobstat.a.b.a("stat", "exceptonAnalysis, context=null");
            return;
        }
        JSONArray b = a.a().b(context);
        if (b == null) {
            com.baidu.mobstat.a.b.a("stat", "no exception str");
            return;
        }
        com.baidu.mobstat.a.b.a("stat", "move exception cache to stat cache");
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= b.length()) {
                    return;
                }
                JSONObject jSONObject = (JSONObject) b.get(i2);
                b.a().a(jSONObject.getLong("t"), jSONObject.getString("c"));
                b.a().b(context);
                i = i2 + 1;
            } catch (Exception e) {
                com.baidu.mobstat.a.b.a("stat", e);
                return;
            }
        }
    }
}
