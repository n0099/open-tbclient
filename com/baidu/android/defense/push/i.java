package com.baidu.android.defense.push;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends a {
    private boolean d;
    private boolean e;

    public i(String str, Context context) {
        super(str, context);
        this.d = true;
        this.e = true;
        b();
    }

    @Override // com.baidu.android.defense.push.a
    public boolean a() {
        if (this.b) {
            com.baidu.android.systemmonitor.d.a.i.a(this.c).a("tjenable", String.valueOf(this.d));
            com.baidu.android.systemmonitor.d.a.i.a(this.c).a("localserverenable", String.valueOf(this.e));
            com.baidu.android.systemmonitor.d.a.k.f();
            return true;
        }
        return false;
    }

    protected void b() {
        if (this.f505a != null) {
            try {
                JSONArray jSONArray = this.f505a.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.b = false;
                } else {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    this.d = jSONObject.getBoolean("tjenable");
                    this.e = jSONObject.getBoolean("localserverenable");
                }
            } catch (Exception e) {
                this.b = false;
            }
        }
    }
}
