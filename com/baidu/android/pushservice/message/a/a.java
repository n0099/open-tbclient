package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.CrossPushMessage;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT <= 26 && (l.g() || l.h());
    }

    private static boolean a(Context context, String str) {
        Intent parseUri;
        PackageManager packageManager;
        List<ResolveInfo> list = null;
        try {
            parseUri = Intent.parseUri("baidupush://bdpush/cross", 0);
            parseUri.setPackage(str);
            packageManager = context.getPackageManager();
        } catch (Exception e) {
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentActivities(parseUri, 0);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i = 1;
        if (a()) {
            String b = kVar.b();
            String e = kVar.e();
            kVar.f();
            byte[] g = kVar.g();
            CrossPushMessage a = i.a(e, b, bArr);
            if (this.a.getPackageName().equals(a.mPkgName) && !TextUtils.isEmpty(a.a)) {
                if (!l.c(this.a, a.a)) {
                    i = 8;
                } else if (a(this.a, a.a)) {
                    com.baidu.android.pushservice.a.d.a(this.a, b);
                    switch (r1.a()) {
                        case PUSH_CLIENT:
                            e.a(this.a, a, b, l.a(this.a, e, bArr, g, a.mPkgName), bArr);
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
