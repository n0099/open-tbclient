package com.baidu.sofire.utility;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static String f10466a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f10466a)) {
            return f10466a;
        }
        try {
            f10466a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            c.a();
        }
        return f10466a;
    }
}
