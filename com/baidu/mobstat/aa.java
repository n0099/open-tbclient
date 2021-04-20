package com.baidu.mobstat;

import android.os.Build;
/* loaded from: classes2.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8446a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f8447b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f8448c;

    static {
        f8447b = Build.VERSION.SDK_INT < 9 ? "http://datax.baidu.com/xs.gif" : "https://datax.baidu.com/xs.gif";
        f8448c = Build.VERSION.SDK_INT < 9 ? "http://dxp.baidu.com/upgrade" : "https://dxp.baidu.com/upgrade";
    }
}
