package com.baidu.android.pushservice.d;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends c {
    protected boolean d;

    public d(i iVar, Context context) {
        super(iVar, context);
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("response_params");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(SharedPrefConfig.CHANNEL_ID);
                String optString2 = optJSONObject.optString("new_channel_id");
                String optString3 = com.baidu.android.pushservice.h.f() ? optJSONObject.optString("rsa_channel_token") : optJSONObject.optString("channel_token");
                this.b.f = optJSONObject.optString("user_id");
                this.b.e = optJSONObject.optString("appid");
                com.baidu.android.pushservice.j.a(this.f1055a).a(optString, optString3, optString2, optJSONObject.optString("new_channel_token"));
            }
        } catch (Exception e) {
            new b.c(this.f1055a).a(Log.getStackTraceString(e)).a();
        }
        if (!com.baidu.android.pushservice.b.d.q(this.f1055a) || com.baidu.android.pushservice.b.d.c(this.f1055a)) {
            com.baidu.android.pushservice.a.e eVar = new com.baidu.android.pushservice.a.e();
            eVar.b(this.b.d);
            eVar.a(this.b.e);
            eVar.d = this.b.f;
            eVar.a(this.b.h);
            eVar.a(com.baidu.android.pushservice.a.a());
            com.baidu.android.pushservice.a.b.a(this.f1055a).a("r_v2", com.baidu.android.pushservice.a.b.a(this.f1055a).a(eVar, this.d));
        }
        return str;
    }
}
