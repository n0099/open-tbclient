package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class m extends c {
    public m(Context context) {
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
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        PublicMsg a = j.a(this.a, h, e, bArr);
        if (a == null || TextUtils.isEmpty(a.mUrl)) {
            p.b(">>> Don't Show rich media Notification! url is null", this.a);
            i = 2;
        } else {
            if (TextUtils.isEmpty(f) || !p.c(this.a, f)) {
                com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(e);
                if (d == null || d.c() == null) {
                    gVar.a(7);
                    return gVar;
                }
                a.mPkgName = d.c();
            } else {
                a.mPkgName = f;
            }
            byte[] a2 = p.a(this.a, h, bArr, j, a.mPkgName);
            try {
                this.a.getPackageManager().getPackageInfo(a.mPkgName, 128);
                f.a(this.a, e, a, h, i2, a2, bArr);
                i = 1;
                p.b(">>> Show rich media Notification!", this.a);
            } catch (PackageManager.NameNotFoundException e2) {
                i = 8;
                f.a(this.a, e);
                p.b(">>> NOT deliver to app: " + a.mPkgName + ", package has been uninstalled.", this.a);
            }
        }
        gVar.a(i);
        return gVar;
    }
}
