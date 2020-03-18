package com.baidu.swan.apps.as;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes11.dex */
public class ae implements View.OnTouchListener {
    private View mTargetView;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mTargetView == null) {
                    view.setAlpha(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState() ? 0.5f : 0.2f);
                    return false;
                }
                this.mTargetView.setAlpha(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState() ? 0.5f : 0.2f);
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
