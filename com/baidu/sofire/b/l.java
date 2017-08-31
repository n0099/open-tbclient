package com.baidu.sofire.b;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class l {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            d.a(e);
            return null;
        }
    }
}
