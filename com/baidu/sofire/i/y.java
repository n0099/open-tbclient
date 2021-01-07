package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes15.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static String f5570a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f5570a)) {
            return f5570a;
        }
        try {
            f5570a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return f5570a;
    }
}
