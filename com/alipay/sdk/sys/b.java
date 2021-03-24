package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f1942a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1943b;

    public static b a() {
        if (f1942a == null) {
            f1942a = new b();
        }
        return f1942a;
    }

    public static boolean d() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public Context b() {
        return this.f1943b;
    }

    public c c() {
        return c.b();
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.f1943b);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1839e, com.alipay.sdk.app.statistic.c.k, th);
            return "";
        }
    }

    public void a(Context context, c cVar) {
        this.f1943b = context.getApplicationContext();
    }
}
