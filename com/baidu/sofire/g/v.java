package com.baidu.sofire.g;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static String f10266a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f10266a)) {
            return f10266a;
        }
        try {
            f10266a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            d.a();
        }
        return f10266a;
    }
}
