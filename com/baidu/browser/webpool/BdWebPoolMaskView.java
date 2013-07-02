package com.baidu.browser.webpool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public class BdWebPoolMaskView extends FrameLayout {
    public BdWebPoolMaskView(Context context) {
        this(context, null);
        setBackgroundColor(-1);
        setVisibility(8);
    }

    public BdWebPoolMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BdLog.d("Action: " + motionEvent.getAction());
        return true;
    }

    public void onStart() {
        if (getVisibility() != 0) {
            BdLog.d("start to showMaskView.");
            setVisibility(0);
        }
    }

    public void onStop() {
        if (getVisibility() == 0) {
            BdLog.d("start to hideMaskView.");
            setVisibility(8);
        }
    }
}
