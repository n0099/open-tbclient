package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    protected boolean e;

    public d(l lVar, Context context) {
        super(lVar, context);
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011d A[LOOP:0: B:19:0x0117->B:21:0x011d, LOOP_END] */
    @Override // com.baidu.android.pushservice.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        String str2;
        String str3;
        Iterator it;
        String string;
        String string2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
            string = jSONObject2.getString(PushConstants.EXTRA_USER_ID);
            string2 = jSONObject2.getString("appid");
            jSONObject2.put("channel_id", com.baidu.android.pushservice.y.a().c());
            this.b.g = string;
            this.b.f = string2;
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            str2 = str;
        }
        try {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("BaseRegisterProcessor", "RegisterThread userId :  " + string);
                Log.i("BaseRegisterProcessor", "RegisterThread appId :  " + string2);
                Log.i("BaseRegisterProcessor", "RegisterThread content :  " + str);
            }
            str3 = str2;
        } catch (JSONException e2) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("BaseRegisterProcessor", "Appid or user_id not found @: \r\n" + str);
            }
            str3 = str2;
            if (!TextUtils.isEmpty(this.b.b)) {
            }
            com.baidu.android.pushservice.d dVar = new com.baidu.android.pushservice.d();
            dVar.f707a = this.b.e;
            dVar.b = this.b.f;
            dVar.c = this.b.g;
            Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
            intent.putExtra("r_sync_rdata", com.baidu.android.pushservice.a.a(this.f688a).a(dVar, this.e));
            intent.putExtra("r_sync_rdata_v2", com.baidu.android.pushservice.a.a(this.f688a).b(dVar, this.e));
            intent.putExtra("r_sync_from", this.f688a.getPackageName());
            intent.setFlags(32);
            this.f688a.sendBroadcast(intent);
            it = com.baidu.android.pushservice.util.m.q(this.f688a).iterator();
            while (it.hasNext()) {
            }
            return str3;
        }
        if (!TextUtils.isEmpty(this.b.b) || !this.b.b.equals("internal")) {
            com.baidu.android.pushservice.d dVar2 = new com.baidu.android.pushservice.d();
            dVar2.f707a = this.b.e;
            dVar2.b = this.b.f;
            dVar2.c = this.b.g;
            Intent intent2 = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
            intent2.putExtra("r_sync_rdata", com.baidu.android.pushservice.a.a(this.f688a).a(dVar2, this.e));
            intent2.putExtra("r_sync_rdata_v2", com.baidu.android.pushservice.a.a(this.f688a).b(dVar2, this.e));
            intent2.putExtra("r_sync_from", this.f688a.getPackageName());
            intent2.setFlags(32);
            this.f688a.sendBroadcast(intent2);
            it = com.baidu.android.pushservice.util.m.q(this.f688a).iterator();
            while (it.hasNext()) {
                Intent createMethodIntent = PushConstants.createMethodIntent(this.f688a);
                createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
                createMethodIntent.setPackage((String) it.next());
                this.f688a.sendBroadcast(createMethodIntent);
                com.baidu.android.pushservice.b.a(this.f688a, false);
            }
        }
        return str3;
    }
}
