package com.baidu.idl.util;

import android.os.Looper;
/* loaded from: classes4.dex */
public class UIThread {
    public static boolean isUITread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
