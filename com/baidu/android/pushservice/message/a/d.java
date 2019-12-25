package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes5.dex */
public class d extends b {
    public d(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (l.a(context, bArr, str, str2, bArr2)) {
            PublicMsg a = i.a(context, str2, str, bArr2);
            a.mPkgName = context.getPackageName();
            if (TextUtils.isEmpty(a.mTitle)) {
                a.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                return a;
            }
            return a;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] g = kVar.g();
        String c = kVar.c();
        PublicMsg a = i.a(this.a, e, b, bArr);
        if (a != null && !TextUtils.isEmpty(a.mDescription)) {
            com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.a, b);
            if (!TextUtils.isEmpty(c) && l.c(this.a, c)) {
                a.mPkgName = c;
            } else if (a2.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT) {
                a.mPkgName = a2.a.c();
            } else if (a2.a() == com.baidu.android.pushservice.a.c.SDK_CLIENT) {
                a.mPkgName = a2.b.c();
            }
            l.a(this.a, a);
            switch (a2.a()) {
                case PUSH_CLIENT:
                case SDK_CLIENT:
                    byte[] a3 = l.a(this.a, e, bArr, g, a.mPkgName);
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                        if (TextUtils.isEmpty(a.mTitle)) {
                            a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        e.a(this.a, a, e, b, f, a3, bArr);
                        i = 1;
                        l.b(">>> Show pMsg private Notification!", this.a);
                        break;
                    } catch (PackageManager.NameNotFoundException e2) {
                        if (a2.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT) {
                            e.a(this.a, b);
                        } else if (a2.a() == com.baidu.android.pushservice.a.c.SDK_CLIENT) {
                            com.baidu.android.pushservice.a.h.a(this.a).a((com.baidu.android.pushservice.a.a) a2.b, false);
                        }
                        i = 8;
                        break;
                    }
                default:
                    if (Build.VERSION.SDK_INT < 24) {
                        e.a(this.a, b);
                    }
                    l.b("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
                    i = 7;
                    break;
            }
        } else {
            l.b("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.a);
            i = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
