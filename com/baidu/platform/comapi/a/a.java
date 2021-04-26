package com.baidu.platform.comapi.a;

import android.content.Context;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f9733a = 621133959;

    public static boolean a(Context context) {
        return c(context);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures[0].hashCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c(Context context) {
        return b(context) == f9733a;
    }
}
