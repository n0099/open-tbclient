package com.baidu.sofire.b;

import android.content.Context;
/* loaded from: classes.dex */
public final class m {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }
}
