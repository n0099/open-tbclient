package com.baidu.android.pushservice.p;

import android.content.Context;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    public boolean f;

    public d(i iVar, Context context) {
        super(iVar, context);
        this.f = false;
    }

    @Override // com.baidu.android.pushservice.p.a
    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("response_params");
            String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            if (optJSONObject != null) {
                String optString2 = optJSONObject.optString("channel_id");
                String optString3 = optJSONObject.optString("new_channel_id");
                String optString4 = optJSONObject.optString(com.baidu.android.pushservice.g.f() ? "rsa_channel_token" : "channel_token");
                String optString5 = optJSONObject.optString("user_id");
                String optString6 = optJSONObject.optString("appid");
                this.d.e = optString5;
                this.d.d = optString6;
                com.baidu.android.pushservice.j.a(this.c).a(optString2, optString4, optString3, optJSONObject.optString("new_channel_token"));
                com.baidu.android.pushservice.a0.i.a(this.c, optString6, optString2, optString3, optString, optString5, System.currentTimeMillis(), this.d.b, this.d.f);
            }
        } catch (Exception unused) {
        }
        if (!com.baidu.android.pushservice.l.d.r(this.c) || com.baidu.android.pushservice.l.d.q(this.c)) {
            com.baidu.android.pushservice.k.e eVar = new com.baidu.android.pushservice.k.e();
            eVar.b(this.d.c);
            eVar.a(this.d.d);
            i iVar = this.d;
            eVar.d = iVar.e;
            eVar.a(iVar.g);
            eVar.a(com.baidu.android.pushservice.a.a());
            com.baidu.android.pushservice.k.b.a(this.c).b("r_v2", com.baidu.android.pushservice.k.b.a(this.c).a(eVar, this.f));
            return str;
        }
        return str;
    }
}
