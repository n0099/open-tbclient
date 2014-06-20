package com.baidu.android.defense.push;

import android.content.Context;
import com.baidu.android.a.s;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p extends n {
    private boolean a;
    private boolean e;

    public p(String str, Context context) {
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

    @Override // com.baidu.android.defense.push.n
    public boolean b() {
        if (this.c) {
            com.baidu.android.a.h.a(this.d).a("tjenable", String.valueOf(this.a));
            com.baidu.android.a.h.a(this.d).a("localserverenable", String.valueOf(this.e));
            s.n();
            return true;
        }
        return false;
    }
}
