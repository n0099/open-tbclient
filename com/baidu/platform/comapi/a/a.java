package com.baidu.platform.comapi.a;

import android.content.Context;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f2868a = 621133959;

    public static boolean a(Context context) {
        return c(context);
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures[0].hashCode();
        } catch (Exception e) {
            return 0;
        }
    }

    private static boolean c(Context context) {
        return b(context) == f2868a;
    }
}
