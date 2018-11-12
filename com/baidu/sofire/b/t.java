package com.baidu.sofire.b;

import android.content.Context;
/* loaded from: classes.dex */
public class t {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }
}
