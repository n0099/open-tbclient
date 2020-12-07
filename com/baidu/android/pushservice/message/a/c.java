package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;
/* loaded from: classes7.dex */
public class c extends b {
    public c(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (m.a(context, bArr, str2, bArr2)) {
            PublicMsg a2 = h.a(context, str2, str, bArr2);
            a2.mPkgName = context.getPackageName();
            if (TextUtils.isEmpty(a2.mTitle)) {
                a2.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                return a2;
            }
            return a2;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] h = kVar.h();
        String c = kVar.c();
        PublicMsg a2 = h.a(this.f1169a, e, b, bArr);
        if (a2 != null && !TextUtils.isEmpty(a2.mDescription)) {
            com.baidu.android.pushservice.a.d a3 = com.baidu.android.pushservice.a.d.a(this.f1169a, b);
            if (!TextUtils.isEmpty(c) && m.b(this.f1169a, c)) {
                a2.mPkgName = c;
            } else if (a3.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT) {
                a2.mPkgName = a3.f1013a.b();
            }
            m.a(this.f1169a, a2);
            switch (a3.a()) {
                case PUSH_CLIENT:
                    PackageManager packageManager = this.f1169a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a2.mPkgName, 128);
                        if (TextUtils.isEmpty(a2.mTitle)) {
                            a2.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        d.a(this.f1169a, a2, e, b, f, h, bArr);
                        i = 1;
                        m.a(e + " is showing Notification!", this.f1169a);
                        break;
                    } catch (PackageManager.NameNotFoundException e2) {
                        new b.c(this.f1169a).a(Log.getStackTraceString(e2)).a();
                        i = 8;
                        break;
                    }
                default:
                    m.a("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.f1169a);
                    i = 7;
                    break;
            }
        } else {
            m.a("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.f1169a);
            i = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
