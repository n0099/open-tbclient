package com.baidu.android.pushservice.d;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: d  reason: collision with root package name */
    public boolean f2948d;

    public d(i iVar, Context context) {
        super(iVar, context);
        this.f2948d = false;
    }

    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("response_params");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("channel_id");
                String optString2 = optJSONObject.optString("new_channel_id");
                String optString3 = optJSONObject.optString(com.baidu.android.pushservice.h.f() ? "rsa_channel_token" : "channel_token");
                ((a) this).f2944b.f2964f = optJSONObject.optString("user_id");
                ((a) this).f2944b.f2963e = optJSONObject.optString("appid");
                com.baidu.android.pushservice.k.a(((a) this).f2943a).a(optString, optString3, optString2, optJSONObject.optString("new_channel_token"));
            }
        } catch (Exception e2) {
            new b.c(((a) this).f2943a).a(Log.getStackTraceString(e2)).a();
        }
        if (!com.baidu.android.pushservice.b.d.q(((a) this).f2943a) || com.baidu.android.pushservice.b.d.c(((a) this).f2943a)) {
            com.baidu.android.pushservice.a.e eVar = new com.baidu.android.pushservice.a.e();
            eVar.b(((a) this).f2944b.f2962d);
            eVar.a(((a) this).f2944b.f2963e);
            i iVar = ((a) this).f2944b;
            eVar.f2690d = iVar.f2964f;
            eVar.a(iVar.f2966h);
            eVar.a(com.baidu.android.pushservice.a.a());
            com.baidu.android.pushservice.a.b.a(((a) this).f2943a).a("r_v2", com.baidu.android.pushservice.a.b.a(((a) this).f2943a).a(eVar, this.f2948d));
            return str;
        }
        return str;
    }
}
