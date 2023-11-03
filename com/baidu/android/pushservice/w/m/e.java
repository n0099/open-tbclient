package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.k.c.values().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.k.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public e(Context context) {
        super(context);
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (Utility.a(context, bArr, str2, bArr2)) {
            PublicMsg a2 = j.a(context, str2, str, bArr2);
            a2.mPkgName = context.getPackageName();
            if (TextUtils.isEmpty(a2.mTitle)) {
                a2.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            }
            return a2;
        }
        return null;
    }

    public static String a(String str, String str2, int i) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put(str2, i);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    @Override // com.baidu.android.pushservice.w.m.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        String a2 = kVar.a();
        String h = kVar.h();
        int q = kVar.q();
        int i = kVar.i();
        byte[] n = kVar.n();
        String j = kVar.j();
        PublicMsg a3 = j.a(this.a, h, a2, bArr);
        int i2 = 1;
        if (a3 == null || TextUtils.isEmpty(a3.mDescription)) {
            i2 = 2;
        } else {
            com.baidu.android.pushservice.k.d a4 = com.baidu.android.pushservice.k.d.a(this.a, a2);
            if (TextUtils.isEmpty(j) || !Utility.m(this.a, j)) {
                if (a4.a() == com.baidu.android.pushservice.k.c.PUSH_CLIENT) {
                    j = a4.b.b();
                }
                Utility.b(this.a, a3);
                if (a.a[a4.a().ordinal()] == 1) {
                    i2 = 7;
                } else {
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a3.mPkgName, 128);
                        if (TextUtils.isEmpty(a3.mTitle)) {
                            a3.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        f.a(this.a, a3, h, a2, q, n, bArr, i, kVar);
                        String str = h + " is showing Notification!";
                    } catch (PackageManager.NameNotFoundException unused) {
                        i2 = 8;
                    }
                }
            }
            a3.mPkgName = j;
            Utility.b(this.a, a3);
            if (a.a[a4.a().ordinal()] == 1) {
            }
        }
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        gVar.a(i2);
        return gVar;
    }
}
