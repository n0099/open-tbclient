package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static String f5287a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f5287a)) {
            return f5287a;
        }
        try {
            f5287a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return f5287a;
    }
}
