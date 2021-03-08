package com.baidu.sofire.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static String f3554a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f3554a)) {
            return f3554a;
        }
        try {
            f3554a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            e.a();
        }
        return f3554a;
    }
}
