package com.baidu.sofire.core;

import android.content.Context;
/* loaded from: classes2.dex */
public final class j {
    public static void a(Context context) {
        try {
            com.baidu.sofire.c.a a = com.baidu.sofire.c.a.a(context);
            d a2 = d.a(context);
            com.baidu.sofire.b.a();
            for (ApkInfo apkInfo : a.a()) {
                if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                    a2.a(apkInfo.packageName);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
    }
}
