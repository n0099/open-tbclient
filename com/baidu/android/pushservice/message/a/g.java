package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.p;
/* loaded from: classes2.dex */
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
        String str2 = null;
        if (TextUtils.isEmpty(f) || !p.c(this.a, f)) {
            if (a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                str2 = a.a.c();
            } else if (a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                str2 = a.b.c();
            }
            com.baidu.android.pushservice.g.a.c("OldPrivateMessageHandler", "OldPrivateMessage PackageName is from  PushClient");
        } else {
            com.baidu.android.pushservice.g.a.c("OldPrivateMessageHandler", "OldPrivateMessage has PackageName = " + f);
            str2 = f;
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = p.a(this.a, h, bArr, j, str2);
                try {
                    this.a.getPackageManager().getPackageInfo(str2, 128);
                    Intent intent = new Intent();
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                        intent.putExtra("bd.message.rate.MH", true);
                    }
                    intent.putExtra("app_id", e);
                    intent.putExtra("msg_id", h);
                    intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", h);
                    intent.putExtra("baidu_message_type", i2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", a2);
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                    }
                    i = p.a(this.a, intent, PushConstants.ACTION_MESSAGE, str2);
                    String str3 = ">>> Deliver message to client: " + a.a.c() + " result: " + i;
                    com.baidu.android.pushservice.g.a.c("OldPrivateMessageHandler", str3);
                    p.b(str3, this.a);
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    String str4 = ">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.";
                    f.a(this.a, e);
                    com.baidu.android.pushservice.g.a.b("OldPrivateMessageHandler", str4);
                    p.b(str4, this.a);
                    i = 7;
                    break;
                }
            case SDK_CLIENT:
                try {
                    byte[] a3 = p.a(this.a, h, bArr, j, str2);
                    this.a.getPackageManager().getPackageInfo(str2, 128);
                    com.baidu.android.pushservice.g.a.c("OldPrivateMessageHandler", "receive sdk message " + str + " pkgName = " + str2);
                    Intent intent2 = new Intent();
                    intent2.setPackage(str2);
                    intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                    intent2.putExtra("message_string", str);
                    intent2.putExtra("baidu_message_type", i2);
                    intent2.putExtra("baidu_message_body", bArr);
                    intent2.putExtra("baidu_message_secur_info", a3);
                    intent2.putExtra("message_id", h);
                    p.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", str2);
                    i = 0;
                    break;
                } catch (PackageManager.NameNotFoundException e3) {
                    com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                    i = 8;
                    break;
                }
            default:
                com.baidu.android.pushservice.g.a.b("OldPrivateMessageHandler", "NOT delivere message to app: client not found appid " + e);
                if (Build.VERSION.SDK_INT < 24) {
                    f.a(this.a, e);
                }
                com.baidu.android.pushservice.g.a.c("OldPrivateMessageHandler", "msgbody " + str);
                p.b(">>> Don't found app  in OldPrivateMessage " + str, this.a);
                i = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
