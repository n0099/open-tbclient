package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes15.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static String f3647a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f3647a)) {
            return f3647a;
        }
        try {
            f3647a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return f3647a;
    }
}
