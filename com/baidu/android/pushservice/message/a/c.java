package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.CrossPushMessage;
import java.util.List;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: com.baidu.android.pushservice.message.a.c$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3503a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.a.c.values().length];
            f3503a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 26 && (m.j() || m.k());
    }

    public static boolean a(Context context, String str) {
        List<ResolveInfo> list;
        Intent parseUri;
        PackageManager packageManager;
        try {
            parseUri = Intent.parseUri("baidupush://bdpush/cross", 0);
            parseUri.setPackage(str);
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            list = null;
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentActivities(parseUri, 0);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i2 = 20;
        if (a()) {
            String c2 = kVar.c();
            String f2 = kVar.f();
            int a2 = kVar.a();
            byte[] h2 = kVar.h();
            CrossPushMessage b2 = j.b(this.f3504a, f2, c2, bArr);
            if (!this.f3504a.getPackageName().equals(b2.mPkgName) || TextUtils.isEmpty(b2.f3492a)) {
                i2 = 2;
            } else if (!m.b(this.f3504a, b2.f3492a)) {
                i2 = 8;
            } else if (a(this.f3504a, b2.f3492a)) {
                if (AnonymousClass1.f3503a[com.baidu.android.pushservice.a.d.a(this.f3504a, c2).a().ordinal()] != 1) {
                    i2 = 7;
                } else {
                    f.a(this.f3504a, b2, c2, h2, bArr, a2);
                    i2 = 1;
                }
            }
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
