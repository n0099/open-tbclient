package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.h.u;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes2.dex */
public class g extends c {
    private static final String b = g.class.getSimpleName();

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        int i2;
        String str4 = new String(bArr2);
        com.baidu.android.pushservice.b.d a = com.baidu.android.pushservice.b.d.a(this.a, str);
        String str5 = null;
        if (TextUtils.isEmpty(str3) || !u.c(this.a, str3)) {
            if (a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                str5 = a.a.c();
            } else if (a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                str5 = a.b.c();
            }
            com.baidu.android.pushservice.e.a.c(b, "OldPrivateMessage PackageName is from  PushClient");
            str3 = str5;
        } else {
            com.baidu.android.pushservice.e.a.c(b, "OldPrivateMessage has PackageName = " + str3);
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = u.a(this.a, str2, bArr2, bArr, str3);
                try {
                    this.a.getPackageManager().getPackageInfo(str3, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", str);
                    intent.putExtra(PbActivityConfig.KEY_MSG_ID, str2);
                    intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr2);
                    intent.putExtra("message_string", str4);
                    intent.putExtra("message_id", str2);
                    intent.putExtra("baidu_message_type", i);
                    intent.putExtra("baidu_message_body", bArr2);
                    intent.putExtra("baidu_message_secur_info", a2);
                    i2 = u.a(this.a, intent, PushConstants.ACTION_MESSAGE, str3);
                    String str6 = ">>> Deliver message to client: " + a.a.c() + " result: " + i2;
                    com.baidu.android.pushservice.e.a.c(b, str6);
                    u.b(str6, this.a);
                    break;
                } catch (PackageManager.NameNotFoundException e) {
                    String str7 = ">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.";
                    f.a(this.a, str);
                    com.baidu.android.pushservice.e.a.b(b, str7);
                    u.b(str7, this.a);
                    i2 = 7;
                    break;
                }
            case SDK_CLIENT:
                try {
                    byte[] a3 = u.a(this.a, str2, bArr2, bArr, str3);
                    this.a.getPackageManager().getPackageInfo(str3, 128);
                    com.baidu.android.pushservice.e.a.c(b, "receive sdk message " + str4 + " pkgName = " + str3);
                    Intent intent2 = new Intent();
                    intent2.setPackage(str3);
                    intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr2);
                    intent2.putExtra("message_string", str4);
                    intent2.putExtra("baidu_message_type", i);
                    intent2.putExtra("baidu_message_body", bArr2);
                    intent2.putExtra("baidu_message_secur_info", a3);
                    intent2.putExtra("message_id", str2);
                    u.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", str3);
                    i2 = 0;
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                    i2 = 8;
                    break;
                }
            default:
                com.baidu.android.pushservice.e.a.b(b, "NOT delivere message to app: client not found appid " + str);
                f.a(this.a, str);
                com.baidu.android.pushservice.e.a.c(b, "msgbody " + str4);
                u.b(">>> Don't found app  in OldPrivateMessage " + str4, this.a);
                i2 = 7;
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
