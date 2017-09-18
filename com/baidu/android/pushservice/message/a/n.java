package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
        return new com.baidu.android.pushservice.j.e(this.a, intent).b();
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        String str;
        int i;
        String str2;
        int i2;
        com.baidu.android.pushservice.message.g gVar;
        String e = kVar.e();
        String h = kVar.h();
        byte[] j = kVar.j();
        String f = kVar.f();
        com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
        String str3 = new String(bArr);
        com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "ultronMsg: " + str3);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt = jSONObject.optInt("version_require", -1);
            int optInt2 = jSONObject.optInt("command_type");
            String optString = jSONObject.optString("command_body");
            com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "ultronMsg, vr: " + optInt + " ct: " + optInt2 + " b: " + optString);
            if (TextUtils.isEmpty(e) || e.equals("0")) {
                str = null;
                i = 0;
            } else {
                if (TextUtils.isEmpty(f) || !p.c(this.a, f)) {
                    f = null;
                } else {
                    com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "Ultron Message has PackageName = " + f);
                }
                com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(e);
                if (d == null || d.c() == null) {
                    if (optInt2 == 1) {
                        i = 7;
                        str = f;
                    }
                    i = 0;
                    str = f;
                } else if (p.c(this.a, d.c())) {
                    if (TextUtils.isEmpty(f)) {
                        f = d.c();
                        com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "Ultron Message PackageName is from  PushClient");
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
                    String c = a.c();
                    com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "Ultron Message PackageName is from  PushClient  needBaiduAPP");
                    i2 = i;
                    str2 = c;
                }
            } else {
                int i3 = i;
                str2 = str;
                i2 = i3;
            }
            if (i2 == 0) {
                com.baidu.android.pushservice.g.a.c("UltronMessageHandler", "ultronMsg, handleMsg: " + str2);
                gVar = a(str2, 0L, h, j, optString);
            } else {
                gVar = gVar2;
            }
            gVar.a(i2);
            return gVar;
        } catch (JSONException e2) {
            gVar2.a(2);
            return gVar2;
        }
    }
}
