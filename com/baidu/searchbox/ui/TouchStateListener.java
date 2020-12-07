package com.baidu.searchbox.ui;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes20.dex */
public class TouchStateListener implements View.OnTouchListener {
    public static final float PRESSED_ALPHA_IN_DAY_MODE = 0.2f;
    public static final float PRESSED_ALPHA_IN_NIGHT_MODE = 0.5f;
    private View mTargetView;

    public TouchStateListener() {
    }

    public TouchStateListener(View view) {
        this.mTargetView = view;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mTargetView == null) {
                    view.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                    return false;
                }
                this.mTargetView.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                return false;
            case 1:
            default:
                if (this.mTargetView == null) {
                    view.setAlpha(1.0f);
                    return false;
                }
                this.mTargetView.setAlpha(1.0f);
                return false;
            case 2:
                return false;
        }
    }
}
