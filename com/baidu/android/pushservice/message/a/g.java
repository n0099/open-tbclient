package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes3.dex */
public class g extends c {
    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String e = kVar.e();
        String h = kVar.h();
        int i2 = kVar.i();
        byte[] j = kVar.j();
        String f = kVar.f();
        String str = new String(bArr);
        com.baidu.android.pushservice.b.d a = com.baidu.android.pushservice.b.d.a(this.a, e);
        if (TextUtils.isEmpty(f) || !com.baidu.android.pushservice.j.m.c(this.a, f)) {
            f = a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT ? a.a.c() : a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT ? a.b.c() : null;
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = com.baidu.android.pushservice.j.m.a(this.a, h, bArr, j, f);
                try {
                    this.a.getPackageManager().getPackageInfo(f, 128);
                    Intent intent = new Intent();
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                        intent.putExtra("bd.message.rate.MH", true);
                    }
                    intent.putExtra(HttpConstants.HTTP_APP_ID, e);
                    intent.putExtra("msg_id", h);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", h);
                    intent.putExtra("baidu_message_type", i2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", a2);
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                    }
                    i = com.baidu.android.pushservice.j.m.a(this.a, intent, PushConstants.ACTION_MESSAGE, f);
                    com.baidu.android.pushservice.j.m.b(">>> Deliver message to client: " + a.a.c() + " result: " + i, this.a);
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    f.a(this.a, e);
                    com.baidu.android.pushservice.j.m.b(">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.", this.a);
                    i = 7;
                    break;
                }
            case SDK_CLIENT:
                try {
                    byte[] a3 = com.baidu.android.pushservice.j.m.a(this.a, h, bArr, j, f);
                    this.a.getPackageManager().getPackageInfo(f, 128);
                    Intent intent2 = new Intent();
                    intent2.setPackage(f);
                    intent2.putExtra("message", bArr);
                    intent2.putExtra("message_string", str);
                    intent2.putExtra("baidu_message_type", i2);
                    intent2.putExtra("baidu_message_body", bArr);
                    intent2.putExtra("baidu_message_secur_info", a3);
                    intent2.putExtra("message_id", h);
                    com.baidu.android.pushservice.j.m.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", f);
                    i = 0;
                    break;
                } catch (PackageManager.NameNotFoundException e3) {
                    com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                    i = 8;
                    break;
                }
            default:
                if (Build.VERSION.SDK_INT < 24) {
                    f.a(this.a, e);
                }
                com.baidu.android.pushservice.j.m.b(">>> Don't found app  in OldPrivateMessage " + str, this.a);
                i = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
