package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String b = e.class.getSimpleName();

    public e(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (u.a(context, bArr, str, str2, bArr2)) {
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
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        int i2;
        PublicMsg a = j.a(this.a, str2, str, bArr2);
        if (a != null && !TextUtils.isEmpty(a.mDescription)) {
            com.baidu.android.pushservice.b.d a2 = com.baidu.android.pushservice.b.d.a(this.a, str);
            if (TextUtils.isEmpty(str3) || !u.c(this.a, str3)) {
                if (a2.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                    a.mPkgName = a2.a.c();
                } else if (a2.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                    a.mPkgName = a2.b.c();
                }
                com.baidu.android.pushservice.e.a.c(b, "Notification Message PackageName is from  PushClient");
            } else {
                a.mPkgName = str3;
                com.baidu.android.pushservice.e.a.c(b, "Notification Message has PackageName = " + str3);
            }
            u.a(this.a, a);
            switch (a2.a()) {
                case PUSH_CLIENT:
                case SDK_CLIENT:
                    byte[] a3 = u.a(this.a, str2, bArr2, bArr, a.mPkgName);
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                        if (TextUtils.isEmpty(a.mTitle)) {
                            a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        if (!str.equals("8965186")) {
                            f.a(this.a, a, str2, str, i, a3, bArr2);
                        }
                        com.baidu.android.pushservice.e.a.c(b, ">>> Show pMsg private Notification!");
                        u.b(">>> Show pMsg private Notification!", this.a);
                        i2 = 1;
                        break;
                    } catch (PackageManager.NameNotFoundException e) {
                        com.baidu.android.pushservice.e.a.a(b, e);
                        if (a2.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                            f.a(this.a, str);
                        } else if (a2.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                            com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a2.b, false);
                        }
                        i2 = 8;
                        break;
                    }
                case WEBAPP_CLIENT:
                    if (TextUtils.isEmpty(a.mTitle)) {
                        a.mTitle = str;
                    }
                    f.a(this.a, a, str2, str);
                    com.baidu.android.pushservice.e.a.c(b, ">>> Show pMsg private web Notification!");
                    u.b(">>> Show pMsg private Notification!", this.a);
                    i2 = 1;
                    break;
                default:
                    com.baidu.android.pushservice.e.a.c(b, ">>> Don't Show pMsg private Notification! package name is null");
                    f.a(this.a, str);
                    u.b(b + "*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
                    i2 = 7;
                    break;
            }
        } else {
            com.baidu.android.pushservice.e.a.e(b, ">>> pMsg JSON parsing error!");
            u.b(b + "*BBind*>>> pMsg JSON parsing error!", this.a);
            i2 = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
