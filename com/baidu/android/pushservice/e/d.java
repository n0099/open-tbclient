package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
        com.baidu.android.pushservice.b.g gVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
            String string = jSONObject2.getString("user_id");
            String string2 = jSONObject2.getString("appid");
            jSONObject2.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
            this.b.g = string;
            this.b.f = string2;
            String jSONObject3 = jSONObject.toString();
            try {
                if (this.b.a.equals("method_deal_webapp_bind_intent") && !TextUtils.isEmpty(this.b.i)) {
                    com.baidu.android.pushservice.b.i iVar = (com.baidu.android.pushservice.b.i) com.baidu.android.pushservice.b.j.a(this.a).c(this.b.i);
                    if (iVar != null) {
                        iVar.a(string2);
                        String a = com.baidu.android.pushservice.b.j.a(this.a).a(iVar, this.d);
                        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
                        intent.putExtra("r_sync_rdata_v2", a);
                        intent.putExtra("r_sync_type", 1);
                        intent.putExtra("r_sync_from", this.a.getPackageName());
                        intent.setFlags(32);
                        this.a.sendBroadcast(intent);
                        return jSONObject3;
                    }
                } else if (this.b.a.equals("method_sdk_bind") && (gVar = (com.baidu.android.pushservice.b.g) com.baidu.android.pushservice.b.h.a(this.a).c(this.b.i)) != null) {
                    gVar.a(string2);
                    gVar.b(this.b.e);
                    String a2 = com.baidu.android.pushservice.b.h.a(this.a).a(gVar);
                    Intent intent2 = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
                    intent2.putExtra("r_sync_rdata_v2", a2);
                    intent2.putExtra("r_sync_type", 3);
                    intent2.putExtra("r_sync_sdk_from", this.a.getPackageName());
                    intent2.setFlags(32);
                    this.a.sendBroadcast(intent2);
                    return jSONObject3;
                }
                com.baidu.android.pushservice.g.a.b("BaseRegisterProcessor", "RegisterThread userId :  " + string);
                com.baidu.android.pushservice.g.a.b("BaseRegisterProcessor", "RegisterThread appId :  " + string2);
                com.baidu.android.pushservice.g.a.b("BaseRegisterProcessor", "RegisterThread content :  " + str);
                str2 = jSONObject3;
            } catch (JSONException e) {
                str2 = jSONObject3;
                com.baidu.android.pushservice.g.a.c("BaseRegisterProcessor", "Appid or user_id not found @: \r\n" + str);
                if (TextUtils.isEmpty(this.b.b)) {
                }
                if (TextUtils.isEmpty(this.b.l)) {
                }
                com.baidu.android.pushservice.b.f fVar = new com.baidu.android.pushservice.b.f();
                fVar.b(this.b.e);
                fVar.a(this.b.f);
                fVar.f = this.b.g;
                fVar.a(this.b.k);
                fVar.b(com.baidu.android.pushservice.a.a());
                String a3 = com.baidu.android.pushservice.b.b.a(this.a).a(fVar, this.d);
                com.baidu.android.pushservice.b.b.a(this.a).a("r_v2", a3);
                com.baidu.android.pushservice.j.q.x(this.a, a3);
                return str2;
            }
        } catch (JSONException e2) {
            str2 = str;
        }
        if (TextUtils.isEmpty(this.b.b) && this.b.b.equals("internal")) {
            return str2;
        }
        if (TextUtils.isEmpty(this.b.l) && com.baidu.android.pushservice.c.d.d(this.a)) {
            return str2;
        }
        com.baidu.android.pushservice.b.f fVar2 = new com.baidu.android.pushservice.b.f();
        fVar2.b(this.b.e);
        fVar2.a(this.b.f);
        fVar2.f = this.b.g;
        fVar2.a(this.b.k);
        fVar2.b(com.baidu.android.pushservice.a.a());
        String a32 = com.baidu.android.pushservice.b.b.a(this.a).a(fVar2, this.d);
        com.baidu.android.pushservice.b.b.a(this.a).a("r_v2", a32);
        com.baidu.android.pushservice.j.q.x(this.a, a32);
        return str2;
    }
}
