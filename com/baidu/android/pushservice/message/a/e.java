package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.k;
/* loaded from: classes7.dex */
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
        com.baidu.android.pushservice.a.d a = com.baidu.android.pushservice.a.d.a(this.a, b);
        if (TextUtils.isEmpty(c) || !m.b(this.a, c)) {
            c = a.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a.a.b() : null;
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                String a2 = a(c);
                try {
                    this.a.getPackageManager().getPackageInfo(a2, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", b);
                    intent.putExtra("msg_id", e);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", e);
                    intent.putExtra("baidu_message_type", f);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", h);
                    i = m.a(this.a, intent, "com.baidu.android.pushservice.action.MESSAGE", a2);
                    m.a(">>> Deliver message to client: " + a.a.b() + " result: " + i, this.a);
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    m.a(">>> NOT deliver to app: " + a.a.b() + ", package has been uninstalled.", this.a);
                    new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    i = 7;
                    break;
                }
            default:
                m.a(">>> Don't found app  in OldPrivateMessage " + str, this.a);
                i = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
