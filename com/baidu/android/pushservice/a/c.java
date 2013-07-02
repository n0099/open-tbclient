package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b {
    protected boolean e;

    public c(h hVar, Context context) {
        super(hVar, context);
        this.e = false;
    }

    @Override // com.baidu.android.pushservice.a.b
    protected String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
            String string = jSONObject2.getString(PushConstants.EXTRA_USER_ID);
            String string2 = jSONObject2.getString("appid");
            jSONObject2.put("channel_id", y.a().b());
            this.b.e = string;
            this.b.d = string2;
            str = jSONObject.toString();
        } catch (JSONException e) {
        }
        com.baidu.android.pushservice.c cVar = new com.baidu.android.pushservice.c();
        cVar.a = this.b.c;
        cVar.b = this.b.d;
        cVar.c = this.b.e;
        String a = com.baidu.android.pushservice.a.a(this.a).a(cVar, this.e);
        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
        intent.putExtra("r_sync_rdata", a);
        intent.putExtra("r_sync_from", this.a.getPackageName());
        intent.setFlags(32);
        this.a.sendBroadcast(intent);
        return str;
    }
}
