package com.baidu.swan.menu;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes14.dex */
public class c {
    public static ObjectAnimator b(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", 0.0f);
        ofFloat.setDuration(d(baseMenuView));
        ofFloat.setInterpolator(new e(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    public static ObjectAnimator a(View view, BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(d(baseMenuView));
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator aY(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator c(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", baseMenuView.getHeight());
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new e(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    private static long d(BaseMenuView baseMenuView) {
        return baseMenuView.aBU() ? 240L : 200L;
    }
}
