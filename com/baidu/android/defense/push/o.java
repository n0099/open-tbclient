package com.baidu.android.defense.push;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class o extends h {
    private ArrayList e;

    public o() {
    }

    public o(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.h
    public void a() {
        if (this.b != null) {
            try {
                JSONArray jSONArray = this.b.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.c = false;
                    return;
                }
                this.e = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.baidu.android.a.f fVar = new com.baidu.android.a.f();
                    fVar.b(jSONArray.getString(i));
                    this.e.add(fVar);
                }
                if (this.e.size() > 0) {
                    com.baidu.android.a.h.a(this.d).a(this.e, 5);
                    com.baidu.android.moplus.util.d.a(this.d).b();
                    com.baidu.android.nebula.d.b.b();
                    Intent c = com.baidu.android.moplus.util.a.c(this.d);
                    c.putExtra("type", "service_sing_restart");
                    c.putExtra("restartflag", true);
                    c.setPackage(com.baidu.android.moplus.util.a.d(this.d));
                    this.d.sendBroadcast(c);
                }
            } catch (JSONException e) {
                this.c = false;
                this.e = null;
            }
        }
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.n
    public boolean b() {
        return (this.e == null || this.e.size() == 0) ? false : true;
    }
}
