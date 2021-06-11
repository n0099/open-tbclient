package com.baidu.sofire.g;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static String f10328a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f10328a)) {
            return f10328a;
        }
        try {
            f10328a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            d.a();
        }
        return f10328a;
    }
}
