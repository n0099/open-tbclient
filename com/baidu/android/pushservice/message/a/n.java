package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends c {
    public n(Context context) {
        super(context);
    }

    private com.baidu.android.pushservice.message.g a(String str, long j, String str2, byte[] bArr, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
        intent.putExtra("message_id", str2);
        intent.putExtra("baidu_message_body", str3);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.setFlags(32);
        intent.setPackage(str);
        intent.setClassName(str, "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_DELIVER");
        intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.SOURCE_PACKAGE", this.a.getPackageName());
        return new com.baidu.android.pushservice.j.d(this.a, intent).b();
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        String str;
        int i;
        String str2;
        int i2;
        String e = kVar.e();
        String h = kVar.h();
        byte[] j = kVar.j();
        String f = kVar.f();
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            int optInt = jSONObject.optInt("version_require", -1);
            int optInt2 = jSONObject.optInt("command_type");
            String optString = jSONObject.optString("command_body");
            if (TextUtils.isEmpty(e) || e.equals("0")) {
                str = null;
                i = 0;
            } else {
                if (TextUtils.isEmpty(f) || !com.baidu.android.pushservice.j.m.c(this.a, f)) {
                    f = null;
                }
                com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(e);
                if (d == null || d.c() == null) {
                    if (optInt2 == 1) {
                        i = 7;
                        str = f;
                    }
                    i = 0;
                    str = f;
                } else if (com.baidu.android.pushservice.j.m.c(this.a, d.c())) {
                    if (TextUtils.isEmpty(f)) {
                        f = d.c();
                    }
                    if (optInt2 == 1 && d.d() < optInt) {
                        i = 6;
                        str = f;
                    }
                    i = 0;
                    str = f;
                } else {
                    if (optInt2 == 1) {
                        i = 8;
                        str = f;
                    }
                    i = 0;
                    str = f;
                }
            }
            if (str == null && i == 0) {
                com.baidu.android.pushservice.b.f a = com.baidu.android.pushservice.b.b.a(this.a).a(optInt, optInt2 == 2);
                if (a == null) {
                    str2 = str;
                    i2 = 6;
                } else {
                    i2 = i;
                    str2 = a.c();
                }
            } else {
                int i3 = i;
                str2 = str;
                i2 = i3;
            }
            com.baidu.android.pushservice.message.g a2 = i2 == 0 ? a(str2, 0L, h, j, optString) : gVar;
            a2.a(i2);
            return a2;
        } catch (JSONException e2) {
            gVar.a(2);
            return gVar;
        }
    }
}
