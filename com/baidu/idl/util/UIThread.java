package com.baidu.idl.util;

import android.os.Looper;
/* loaded from: classes8.dex */
public class UIThread {
    public static boolean isUITread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
