package com.baidu.swan.menu;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator a(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getBgView(), "translationY", 0.0f);
        ofFloat.setDuration(e(baseMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static ObjectAnimator b(@Nullable MainMenuView mainMenuView) {
        if (mainMenuView == null || mainMenuView.getCoverView() == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(mainMenuView.getCoverView(), "translationY", 0.0f);
        ofFloat.setDuration(e(mainMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator b(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "translationY", 0.0f);
        ofFloat.setDuration(e(baseMenuView)).setStartDelay(30L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator c(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "alpha", 1.0f);
        ofFloat.setDuration(e(baseMenuView)).setStartDelay(80L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator a(View view, BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(e(baseMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator aB(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator d(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", baseMenuView.getHeight());
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    private static long e(BaseMenuView baseMenuView) {
        return baseMenuView.VD() ? 240L : 200L;
    }
}
