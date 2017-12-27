package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class e extends c {
    public e(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (p.a(context, bArr, str, str2, bArr2)) {
            PublicMsg a = j.a(context, str2, str, bArr2);
            a.mPkgName = context.getPackageName();
            if (TextUtils.isEmpty(a.mTitle)) {
                a.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                return a;
            }
            return a;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String e = kVar.e();
        String h = kVar.h();
        int i2 = kVar.i();
        byte[] j = kVar.j();
        String f = kVar.f();
        PublicMsg a = j.a(this.a, h, e, bArr);
        if (a != null && !TextUtils.isEmpty(a.mDescription)) {
            com.baidu.android.pushservice.b.d a2 = com.baidu.android.pushservice.b.d.a(this.a, e);
            if (!TextUtils.isEmpty(f) && p.c(this.a, f)) {
                a.mPkgName = f;
            } else if (a2.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                a.mPkgName = a2.a.c();
            } else if (a2.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                a.mPkgName = a2.b.c();
            }
            p.a(this.a, a);
            switch (a2.a()) {
                case PUSH_CLIENT:
                case SDK_CLIENT:
                    byte[] a3 = p.a(this.a, h, bArr, j, a.mPkgName);
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                        if (TextUtils.isEmpty(a.mTitle)) {
                            a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        if (!e.equals("8965186")) {
                            f.a(this.a, a, h, e, i2, a3, bArr);
                        }
                        i = 1;
                        p.b(">>> Show pMsg private Notification!", this.a);
                        break;
                    } catch (PackageManager.NameNotFoundException e2) {
                        if (a2.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                            f.a(this.a, e);
                        } else if (a2.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                            com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a2.b, false);
                        }
                        i = 8;
                        break;
                    }
                default:
                    if (Build.VERSION.SDK_INT < 24) {
                        f.a(this.a, e);
                    }
                    p.b("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
                    i = 7;
                    break;
            }
        } else {
            p.b("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.a);
            i = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
