package com.baidu.swan.menu;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator a(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", 0.0f);
        ofFloat.setDuration(c(baseMenuView));
        ofFloat.setInterpolator(new e(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator a(View view, BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(c(baseMenuView));
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator aJ(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator b(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", baseMenuView.getHeight());
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new e(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    private static long c(BaseMenuView baseMenuView) {
        return baseMenuView.aEQ() ? 240L : 200L;
    }
}
