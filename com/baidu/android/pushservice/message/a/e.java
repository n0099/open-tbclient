package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: com.baidu.android.pushservice.message.a.e$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3504a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.a.c.values().length];
            f3504a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public e(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (m.a(context, bArr, str2, bArr2)) {
            PublicMsg a2 = j.a(context, str2, str, bArr2);
            a2.mPkgName = context.getPackageName();
            if (TextUtils.isEmpty(a2.mTitle)) {
                a2.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            }
            return a2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    @Override // com.baidu.android.pushservice.message.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i2;
        String c2 = kVar.c();
        String f2 = kVar.f();
        int g2 = kVar.g();
        int a2 = kVar.a();
        byte[] i3 = kVar.i();
        String d2 = kVar.d();
        PublicMsg a3 = j.a(this.f3503a, f2, c2, bArr);
        if (a3 == null || TextUtils.isEmpty(a3.mDescription)) {
            m.a("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.f3503a);
            i2 = 2;
        } else {
            com.baidu.android.pushservice.a.d a4 = com.baidu.android.pushservice.a.d.a(this.f3503a, c2);
            if (TextUtils.isEmpty(d2) || !m.b(this.f3503a, d2)) {
                if (a4.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT) {
                    d2 = a4.f2722a.b();
                }
                m.a(this.f3503a, a3);
                i2 = 1;
                if (AnonymousClass1.f3504a[a4.a().ordinal()] == 1) {
                    m.a("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.f3503a);
                    i2 = 7;
                } else {
                    PackageManager packageManager = this.f3503a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a3.mPkgName, 128);
                        if (TextUtils.isEmpty(a3.mTitle)) {
                            a3.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        f.a(this.f3503a, a3, f2, c2, g2, i3, bArr, a2);
                        m.a(f2 + " is showing Notification!", this.f3503a);
                    } catch (PackageManager.NameNotFoundException e2) {
                        new b.c(this.f3503a).a(Log.getStackTraceString(e2)).a();
                        i2 = 8;
                    }
                }
            }
            a3.mPkgName = d2;
            m.a(this.f3503a, a3);
            i2 = 1;
            if (AnonymousClass1.f3504a[a4.a().ordinal()] == 1) {
            }
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
