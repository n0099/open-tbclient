package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class SelectorTextView extends TextView {
    public static final float NORMAL_ALPHA = 1.0f;
    public static final float PRESSED_ALPHA = 0.4f;
    public static final float PRESSED_ALPHA_PHOTO = 0.5f;
    public boolean isPhoto;
    public float pressedAlpha;

    public SelectorTextView(Context context) {
        super(context);
        this.isPhoto = false;
        this.pressedAlpha = 0.4f;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
            } else if (this.isPhoto) {
                setAlpha(0.5f);
            } else {
                setAlpha(this.pressedAlpha);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMode(boolean z) {
        this.isPhoto = z;
    }

    public void setPressedAlpha(float f) {
        this.pressedAlpha = f;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPhoto = false;
        this.pressedAlpha = 0.4f;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPhoto = false;
        this.pressedAlpha = 0.4f;
    }
}
