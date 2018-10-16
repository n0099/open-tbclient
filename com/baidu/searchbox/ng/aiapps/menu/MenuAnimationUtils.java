package com.baidu.searchbox.ng.aiapps.menu;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
/* loaded from: classes2.dex */
class MenuAnimationUtils {
    static final long HIDE_DURATION = 200;
    static final long LONG_SHOW_DURATION = 240;
    static final long MAIN_MENU_ALPHA_DELAY = 80;
    static final long MAIN_MENU_SHOW_DELAY = 30;
    static final long SHORT_SHOW_DURATION = 200;
    static final long SUB_MENU_ALPHA_DELAY = 140;
    static final long SUB_MENU_BG_SHOW_DELAY = 60;
    static final long SUB_MENU_CONTENT_SHOW_DELAY = 90;

    MenuAnimationUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMainMenuBGShowAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getBgView(), "translationY", 0.0f);
        ofFloat.setDuration(getDuration(baseMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static ObjectAnimator getMainMenuCoverViewShowAnimator(@Nullable MainMenuView mainMenuView) {
        if (mainMenuView == null || mainMenuView.getCoverView() == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(mainMenuView.getCoverView(), "translationY", 0.0f);
        ofFloat.setDuration(getDuration(mainMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMainMenuShowAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "translationY", 0.0f);
        ofFloat.setDuration(getDuration(baseMenuView)).setStartDelay(MAIN_MENU_SHOW_DELAY);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMainMenuAlphaAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "alpha", 1.0f);
        ofFloat.setDuration(getDuration(baseMenuView)).setStartDelay(MAIN_MENU_ALPHA_DELAY);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getSubMenuAlphaAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "alpha", 1.0f);
        ofFloat.setDuration(getDuration(baseMenuView)).setStartDelay(SUB_MENU_ALPHA_DELAY);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getSubMenuBGShowAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getBgView(), "translationY", 0.0f);
        ofFloat.setDuration(getDuration(baseMenuView)).setStartDelay(SUB_MENU_BG_SHOW_DELAY);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getSubMenuShowAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView.getContentView(), "translationY", 0.0f);
        ofFloat.setDuration(getDuration(baseMenuView)).setStartDelay(SUB_MENU_CONTENT_SHOW_DELAY);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMaskShowAnimator(View view, BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(getDuration(baseMenuView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMaskHideAnimator(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectAnimator getMenuHideAnimator(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", baseMenuView.getHeight());
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    private static long getDuration(BaseMenuView baseMenuView) {
        if (baseMenuView.isHighMenu()) {
            return LONG_SHOW_DURATION;
        }
        return 200L;
    }
}
