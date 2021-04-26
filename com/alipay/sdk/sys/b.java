package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f1921a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1922b;

    public static b a() {
        if (f1921a == null) {
            f1921a = new b();
        }
        return f1921a;
    }

    public static boolean d() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public Context b() {
        return this.f1922b;
    }

    public c c() {
        return c.b();
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.f1922b);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1810e, com.alipay.sdk.app.statistic.c.k, th);
            return "";
        }
    }

    public void a(Context context, c cVar) {
        this.f1922b = context.getApplicationContext();
    }
}
