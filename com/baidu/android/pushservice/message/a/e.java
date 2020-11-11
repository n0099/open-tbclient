package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.k;
/* loaded from: classes10.dex */
public class e extends b {
    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] h = kVar.h();
        String c = kVar.c();
        String str = new String(bArr);
        com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.f1168a, b);
        if (TextUtils.isEmpty(c) || !m.b(this.f1168a, c)) {
            c = a2.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a2.f1012a.b() : null;
        }
        switch (a2.a()) {
            case PUSH_CLIENT:
                String a3 = a(c);
                try {
                    this.f1168a.getPackageManager().getPackageInfo(a3, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", b);
                    intent.putExtra("msg_id", e);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", e);
                    intent.putExtra("baidu_message_type", f);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", h);
                    i = m.a(this.f1168a, intent, "com.baidu.android.pushservice.action.MESSAGE", a3);
                    m.a(">>> Deliver message to client: " + a2.f1012a.b() + " result: " + i, this.f1168a);
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    m.a(">>> NOT deliver to app: " + a2.f1012a.b() + ", package has been uninstalled.", this.f1168a);
                    new b.c(this.f1168a).a(Log.getStackTraceString(e2)).a();
                    i = 7;
                    break;
                }
            default:
                m.a(">>> Don't found app  in OldPrivateMessage " + str, this.f1168a);
                i = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
