package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes20.dex */
public final class y {
    private static String a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return a;
    }
}
