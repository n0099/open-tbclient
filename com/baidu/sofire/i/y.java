package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static String f5289a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f5289a)) {
            return f5289a;
        }
        try {
            f5289a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return f5289a;
    }
}
