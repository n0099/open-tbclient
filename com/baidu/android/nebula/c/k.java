package com.baidu.android.nebula.c;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements r {
    private Context a;
    private long b = -1;

    public k(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String a = com.baidu.android.nebula.a.b.a(this.a);
        this.b = System.currentTimeMillis();
        try {
            jSONObject.put("req", l.SEND_USERDATA.ordinal());
            jSONObject.put("deviceid", a);
            jSONObject.put("time", this.b);
            jSONObject.put("ccode", j.a(a, "MhxzKhl", this.b));
            a.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.c.r
    public void a(p pVar) {
        if (pVar.i() == 200) {
            if (i.a(this.a).e()) {
                new g(this.a).a();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - e.a(this.a, currentTimeMillis) > e.a(this.a) * 1000) {
                new d(this.a).a();
                e.b(this.a, currentTimeMillis);
            }
        }
    }
}
