package com.baidu.live.utils;

import android.os.Build;
import android.view.View;
/* loaded from: classes2.dex */
public class h {
    public static void S(View view) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            view.setSystemUiVisibility(4);
        } else {
            view.setSystemUiVisibility(4100);
        }
    }

    public static void T(View view) {
        view.setSystemUiVisibility(0);
    }
}
