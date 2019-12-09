package com.baidu.sofire.i;

import android.content.Context;
/* loaded from: classes2.dex */
public final class w {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }
}
