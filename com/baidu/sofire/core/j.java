package com.baidu.sofire.core;

import android.content.Context;
/* loaded from: classes.dex */
public class j {
    public static void a(Context context) {
        try {
            com.baidu.sofire.a.a a = com.baidu.sofire.a.a.a(context);
            d a2 = d.a(context);
            com.baidu.sofire.b.a("handleWork in TimeoutRunner");
            for (ApkInfo apkInfo : a.b()) {
                if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                    a2.b(apkInfo.packageName);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
