package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes8.dex */
public class f extends b {
    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] g = kVar.g();
        String c = kVar.c();
        String str = new String(bArr);
        com.baidu.android.pushservice.a.d a = com.baidu.android.pushservice.a.d.a(this.a, b);
        if (TextUtils.isEmpty(c) || !l.c(this.a, c)) {
            c = a.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a.a.c() : a.a() == com.baidu.android.pushservice.a.c.SDK_CLIENT ? a.b.c() : null;
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                String a2 = a(c);
                byte[] a3 = l.a(this.a, e, bArr, g, a2);
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
                    intent.putExtra("baidu_message_secur_info", a3);
                    i = l.a(this.a, intent, PushConstants.ACTION_MESSAGE, a2);
                    l.b(">>> Deliver message to client: " + a.a.c() + " result: " + i, this.a);
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    e.a(this.a, b);
                    l.b(">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.", this.a);
                    i = 7;
                    break;
                }
            case SDK_CLIENT:
                try {
                    byte[] a4 = l.a(this.a, e, bArr, g, c);
                    this.a.getPackageManager().getPackageInfo(c, 128);
                    Intent intent2 = new Intent();
                    intent2.setPackage(c);
                    intent2.putExtra("message", bArr);
                    intent2.putExtra("message_string", str);
                    intent2.putExtra("baidu_message_type", f);
                    intent2.putExtra("baidu_message_body", bArr);
                    intent2.putExtra("baidu_message_secur_info", a4);
                    intent2.putExtra("message_id", e);
                    l.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", c);
                    i = 0;
                    break;
                } catch (PackageManager.NameNotFoundException e3) {
                    com.baidu.android.pushservice.a.h.a(this.a).a((com.baidu.android.pushservice.a.a) a.b, false);
                    i = 8;
                    break;
                }
            default:
                if (Build.VERSION.SDK_INT < 24) {
                    e.a(this.a, b);
                }
                l.b(">>> Don't found app  in OldPrivateMessage " + str, this.a);
                i = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
