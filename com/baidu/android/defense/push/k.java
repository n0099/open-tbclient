package com.baidu.android.defense.push;

import android.content.Context;
import com.baidu.android.systemmonitor.a.a.n;
import com.baidu.android.systemmonitor.a.a.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f247a;
    private boolean e;

    public k(String str, Context context) {
        super(str, context);
        this.f247a = true;
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
                    this.f247a = jSONObject.getBoolean("tjenable");
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
            n.a(this.d).a("tjenable", String.valueOf(this.f247a));
            n.a(this.d).a("localserverenable", String.valueOf(this.e));
            o.f();
            return true;
        }
        return false;
    }
}
