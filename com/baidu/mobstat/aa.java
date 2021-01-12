package com.baidu.mobstat;

import android.os.Build;
/* loaded from: classes14.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3637a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3638b;
    public static final String c;

    static {
        f3638b = Build.VERSION.SDK_INT < 9 ? "http://datax.baidu.com/xs.gif" : "https://datax.baidu.com/xs.gif";
        c = Build.VERSION.SDK_INT < 9 ? "http://dxp.baidu.com/upgrade" : "https://dxp.baidu.com/upgrade";
    }
}
