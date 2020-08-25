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
/* loaded from: classes5.dex */
public class c extends b {
    public c(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (m.a(context, bArr, str2, bArr2)) {
            PublicMsg a = h.a(context, str2, str, bArr2);
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
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] h = kVar.h();
        String c = kVar.c();
        PublicMsg a = h.a(this.a, e, b, bArr);
        if (a != null && !TextUtils.isEmpty(a.mDescription)) {
            com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.a, b);
            if (!TextUtils.isEmpty(c) && m.b(this.a, c)) {
                a.mPkgName = c;
            } else if (a2.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT) {
                a.mPkgName = a2.a.b();
            }
            m.a(this.a, a);
            switch (a2.a()) {
                case PUSH_CLIENT:
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                        if (TextUtils.isEmpty(a.mTitle)) {
                            a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        d.a(this.a, a, e, b, f, h, bArr);
                        i = 1;
                        m.a(e + " is showing Notification!", this.a);
                        break;
                    } catch (PackageManager.NameNotFoundException e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                        i = 8;
                        break;
                    }
                default:
                    m.a("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
                    i = 7;
                    break;
            }
        } else {
            m.a("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.a);
            i = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
