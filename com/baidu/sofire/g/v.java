package com.baidu.sofire.g;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static String f11804a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f11804a)) {
            return f11804a;
        }
        try {
            f11804a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            d.a();
        }
        return f11804a;
    }
}
