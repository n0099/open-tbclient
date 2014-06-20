package com.baidu.android.nebula.c;

import android.content.Context;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements r {
    private Context a;
    private long b = -1;

    public d(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String a = com.baidu.android.nebula.a.b.a(this.a);
        this.b = System.currentTimeMillis();
        p a2 = a.a(this.a).a();
        try {
            jSONObject.put("req", l.CHECK_APPSYNC.ordinal());
            jSONObject.put("deviceid", a);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a2.g());
            jSONObject.put("channelid", a2.h());
            jSONObject.put("ccode", j.a(a, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = i.a(this.a).b(a2.f()).b().iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("package", uVar.b());
                jSONObject2.put("signmd5", uVar.a(this.a));
                jSONObject2.put("version", uVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("checklist", jSONArray);
            a.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.c.r
    public void a(p pVar) {
        if (pVar.i() != 200) {
            i.a(this.a).b();
            i.a(this.a).d();
            new g(this.a).a();
        }
    }
}
