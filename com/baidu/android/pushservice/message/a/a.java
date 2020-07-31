package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.CrossPushMessage;
import com.baidu.android.pushservice.message.k;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT <= 26 && (m.j() || m.k());
    }

    private static boolean a(Context context, String str) {
        List<ResolveInfo> list;
        Intent parseUri;
        PackageManager packageManager;
        try {
            parseUri = Intent.parseUri("baidupush://bdpush/cross", 0);
            parseUri.setPackage(str);
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            list = null;
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentActivities(parseUri, 0);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i = 1;
        if (a()) {
            String b = kVar.b();
            String e = kVar.e();
            byte[] g = kVar.g();
            CrossPushMessage b2 = h.b(this.a, e, b, bArr);
            if (this.a.getPackageName().equals(b2.mPkgName) && !TextUtils.isEmpty(b2.a)) {
                if (!m.b(this.a, b2.a)) {
                    i = 8;
                } else if (a(this.a, b2.a)) {
                    com.baidu.android.pushservice.a.d.a(this.a, b);
                    switch (r1.a()) {
                        case PUSH_CLIENT:
                            d.a(this.a, b2, b, g, bArr);
                            break;
                        default:
                            i = 7;
                            break;
                    }
                } else {
                    i = 20;
                }
            } else {
                i = 2;
            }
        } else {
            i = 20;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
