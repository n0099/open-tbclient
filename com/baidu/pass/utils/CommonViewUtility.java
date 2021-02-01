package com.baidu.pass.utils;

import android.view.View;
/* loaded from: classes5.dex */
public class CommonViewUtility implements com.baidu.pass.a {
    public static void setViewClickAlpha(View view, float f) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new a(f));
    }
}
