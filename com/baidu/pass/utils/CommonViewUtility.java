package com.baidu.pass.utils;

import android.view.View;
/* loaded from: classes2.dex */
public class CommonViewUtility implements com.baidu.pass.a {
    public static void setViewClickAlpha(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new a(f2));
    }
}
