package com.baidu.sofire.core;

import android.content.Context;
/* loaded from: classes2.dex */
public final class i {
    public static void a(Context context) {
        try {
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            c a3 = c.a(context);
            for (ApkInfo apkInfo : a2.a()) {
                if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                    a3.a(apkInfo.packageName);
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }
}
