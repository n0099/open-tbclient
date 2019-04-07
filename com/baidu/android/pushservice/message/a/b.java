package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    private Context b;

    public b(Context context) {
        super(context);
        this.b = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    @Override // com.baidu.android.pushservice.message.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        boolean z;
        String str2;
        Intent intent = null;
        String h = kVar.h();
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        try {
            jSONObject = new JSONObject(new String(bArr));
            try {
                str = jSONObject.getString("action");
                z = true;
                jSONObject2 = jSONObject;
            } catch (JSONException e) {
                e = e;
                com.baidu.android.pushservice.g.a.b("BaiduSupperHandler", "Supper message parsing action Fail:\r\n" + e.getMessage(), this.b);
                jSONObject2 = jSONObject;
                str = null;
                z = false;
                if (z) {
                }
                intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
                intent.putExtra("message", bArr);
                com.baidu.android.pushservice.j.m.b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
                if (intent == null) {
                }
                return gVar;
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (z || TextUtils.isEmpty(str)) {
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra("message", bArr);
            com.baidu.android.pushservice.j.m.b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
        } else if (str.equalsIgnoreCase("push.NOTIFICATION")) {
            try {
                f.a(this.a, !jSONObject2.isNull("title") ? jSONObject2.getString("title") : null, jSONObject2.getString("description"), !jSONObject2.isNull("iconUrl") ? jSONObject2.getString("iconUrl") : null, !jSONObject2.isNull("url") ? jSONObject2.getString("url") : null, h);
            } catch (JSONException e3) {
                com.baidu.android.pushservice.g.a.b("BaiduSupperHandler", "Supper message parsing notification action Fail:\r\n" + e3.getMessage(), this.b);
            }
        } else {
            try {
                str2 = jSONObject2.getString("message");
            } catch (JSONException e4) {
                str2 = null;
            }
            intent = new Intent(str);
            intent.putExtra("message", str2);
        }
        if (intent == null) {
            intent.setFlags(32);
            this.a.sendBroadcast(intent);
            gVar.a(0);
        } else {
            gVar.a(2);
        }
        return gVar;
    }
}
