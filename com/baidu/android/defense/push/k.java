package com.baidu.android.defense.push;

import android.content.Context;
import com.baidu.android.a.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends i {
    private boolean a;
    private boolean e;

    public k(String str, Context context) {
        super(str, context);
        this.a = true;
        this.e = true;
        a();
    }

    protected void a() {
        if (this.b != null) {
            try {
                JSONArray jSONArray = this.b.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.c = false;
                } else {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    this.a = jSONObject.getBoolean("tjenable");
                    this.e = jSONObject.getBoolean("localserverenable");
                }
            } catch (Exception e) {
                this.c = false;
            }
        }
    }

    @Override // com.baidu.android.defense.push.i
    public boolean b() {
        if (this.c) {
            o.a(this.d).a("tjenable", String.valueOf(this.a));
            o.a(this.d).a("localserverenable", String.valueOf(this.e));
            com.baidu.android.a.j.k();
            return true;
        }
        return false;
    }
}
