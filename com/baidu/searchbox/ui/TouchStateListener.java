package com.baidu.searchbox.ui;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes4.dex */
public class TouchStateListener implements View.OnTouchListener {
    public static final float PRESSED_ALPHA_IN_DAY_MODE = 0.2f;
    public static final float PRESSED_ALPHA_IN_NIGHT_MODE = 0.5f;
    public View mTargetView;

    public TouchStateListener() {
    }

    public TouchStateListener(View view2) {
        this.mTargetView = view2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                View view3 = this.mTargetView;
                if (view3 == null) {
                    view2.setAlpha(1.0f);
                    return false;
                }
                view3.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        View view4 = this.mTargetView;
        float f = 0.5f;
        if (view4 == null) {
            if (!NightModeHelper.getNightModeSwitcherState()) {
                f = 0.2f;
            }
            view2.setAlpha(f);
            return false;
        }
        if (!NightModeHelper.getNightModeSwitcherState()) {
            f = 0.2f;
        }
        view4.setAlpha(f);
        return false;
    }
}
