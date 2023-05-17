package com.baidu.pass.utils;

import android.view.View;
/* loaded from: classes3.dex */
public class CommonViewUtility implements com.baidu.pass.a {
    public static void setViewClickAlpha(View view2, float f) {
        if (view2 == null) {
            return;
        }
        view2.setOnTouchListener(new a(f));
    }
}
