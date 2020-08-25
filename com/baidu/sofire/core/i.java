package com.baidu.sofire.core;

import android.content.Context;
/* loaded from: classes20.dex */
public final class i {
    public static void a(Context context) {
        try {
            com.baidu.sofire.c.a a = com.baidu.sofire.c.a.a(context);
            c a2 = c.a(context);
            com.baidu.sofire.b.a();
            for (ApkInfo apkInfo : a.a()) {
                if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                    a2.a(apkInfo.packageName);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }
}
