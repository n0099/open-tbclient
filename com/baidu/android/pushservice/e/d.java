package com.baidu.android.pushservice.e;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends c {
    protected boolean d;

    public d(l lVar, Context context) {
        super(lVar, context);
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public String b(String str) {
        String str2;
        String string;
        String jSONObject;
        com.baidu.android.pushservice.b.g gVar;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("response_params");
            String string2 = jSONObject3.getString("user_id");
            string = jSONObject3.getString("appid");
            jSONObject3.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
            if (com.baidu.android.pushservice.c.e.b(this.a)) {
                jSONObject3.put("new_channel_id", com.baidu.android.pushservice.j.a(this.a).c());
            }
            this.b.g = string2;
            this.b.f = string;
            jSONObject = jSONObject2.toString();
            try {
            } catch (JSONException e) {
                str2 = jSONObject;
            }
        } catch (JSONException e2) {
            str2 = str;
        }
        if (this.b.a.equals("method_sdk_bind") && (gVar = (com.baidu.android.pushservice.b.g) com.baidu.android.pushservice.b.h.a(this.a).b(this.b.i)) != null) {
            gVar.a(string);
            gVar.b(this.b.e);
            com.baidu.android.pushservice.j.m.a(this.a, com.baidu.android.pushservice.b.h.a(this.a).a(gVar), 3);
            return jSONObject;
        }
        str2 = jSONObject;
        if (TextUtils.isEmpty(this.b.b) || !this.b.b.equals("internal")) {
            if (TextUtils.isEmpty(this.b.l) || !com.baidu.android.pushservice.c.e.h(this.a)) {
                com.baidu.android.pushservice.b.f fVar = new com.baidu.android.pushservice.b.f();
                fVar.b(this.b.e);
                fVar.a(this.b.f);
                fVar.f = this.b.g;
                fVar.a(this.b.k);
                fVar.b(com.baidu.android.pushservice.a.a());
                String a = com.baidu.android.pushservice.b.b.a(this.a).a(fVar, this.d);
                com.baidu.android.pushservice.b.b.a(this.a).a("r_v2", a);
                com.baidu.android.pushservice.j.m.a(this.a, a, 0);
                return str2;
            }
            return str2;
        }
        return str2;
    }
}
