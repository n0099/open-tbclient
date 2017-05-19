package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class m extends c {
    private static final String b = m.class.getSimpleName();

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        int i2;
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        PublicMsg a = j.a(this.a, str2, str, bArr2);
        if (a == null || TextUtils.isEmpty(a.mUrl)) {
            com.baidu.android.pushservice.e.a.c(b, ">>> Don't Show rich media Notification! url is null");
            u.b(">>> Don't Show rich media Notification! url is null", this.a);
            i2 = 2;
        } else {
            if (TextUtils.isEmpty(str3) || !u.c(this.a, str3)) {
                com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(str);
                if (d == null || d.c() == null) {
                    com.baidu.android.pushservice.e.a.c(b, ">>> RichMediaMessage client Not found");
                    gVar.a(7);
                    return gVar;
                }
                a.mPkgName = d.c();
                com.baidu.android.pushservice.e.a.c(b, "RichMedia Message PackageName is from  PushClient");
            } else {
                a.mPkgName = str3;
                com.baidu.android.pushservice.e.a.c(b, "RichMedia Message has PackageName = " + a.mPkgName);
            }
            byte[] a2 = u.a(this.a, str2, bArr2, bArr, a.mPkgName);
            try {
                this.a.getPackageManager().getPackageInfo(a.mPkgName, 128);
                f.a(this.a, str, a, str2, i, a2, bArr2);
                i2 = 1;
                com.baidu.android.pushservice.e.a.c(b, ">>> Show rich media Notification!");
                u.b(">>> Show rich media Notification!", this.a);
            } catch (PackageManager.NameNotFoundException e) {
                i2 = 8;
                String str4 = ">>> NOT deliver to app: " + a.mPkgName + ", package has been uninstalled.";
                f.a(this.a, str);
                com.baidu.android.pushservice.e.a.b(b, str4);
                u.b(str4, this.a);
            }
        }
        gVar.a(i2);
        return gVar;
    }
}
