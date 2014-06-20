package com.baidu.android.nebula.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements r {
    private Context a;
    private long b = -1;

    public g(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String a = com.baidu.android.nebula.a.b.a(this.a);
        this.b = System.currentTimeMillis();
        p a2 = a.a(this.a).a();
        try {
            ArrayList b = i.a(this.a).a(a2.j()).b();
            if (b == null || b.size() <= 0) {
                return;
            }
            jSONObject.put("req", l.UPDATE_APPSSTATE.ordinal());
            jSONObject.put("deviceid", a);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a2.g());
            jSONObject.put("channelid", a2.h());
            jSONObject.put("ccode", j.a(a, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("op", uVar.a().ordinal());
                jSONObject2.put("package", uVar.b());
                jSONObject2.put("signmd5", uVar.a(this.a));
                jSONObject2.put("version", uVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("applist", jSONArray);
            a.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.c.r
    public void a(p pVar) {
        if (pVar.c()) {
            pVar.d();
        } else if (pVar.i() == 200) {
            if (pVar.e().size() > 0) {
                i.a(this.a).a(pVar.e());
            }
            if (i.a(this.a).c()) {
                new g(this.a).a();
            }
        } else if (pVar.i() == 58217) {
            if (pVar.a().size() > 0) {
                i.a(this.a).b(pVar.a());
            } else if (pVar.e().size() > 0) {
                i.a(this.a).a(pVar.e());
            }
            if (i.a(this.a).c()) {
                new g(this.a).a();
            }
        }
    }
}
