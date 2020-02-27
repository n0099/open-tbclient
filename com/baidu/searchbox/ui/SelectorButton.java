package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
/* loaded from: classes13.dex */
public class SelectorButton extends Button {
    private static final float DISABLED_ALPHA_SCALE_DEFAULT = 0.4f;
    private static final int NORMAL_ALPHA = 1;
    private static final float PRESSED_ALPHA_SCALE_DEFAULT = 0.6f;
    private float disabledAlpha;
    private float pressedAlpha;

    public SelectorButton(Context context) {
        super(context);
        init(context, null);
    }

    public SelectorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SelectorButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.SelectorImageButton);
            if (obtainStyledAttributes != null) {
                float f = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.SelectorImageButton_disabledAlphaScale, 0.4f);
                float f2 = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.SelectorImageButton_pressedAlphaScale, PRESSED_ALPHA_SCALE_DEFAULT);
                this.disabledAlpha = verify(f);
                this.pressedAlpha = verify(f2);
                obtainStyledAttributes.recycle();
                return;
            }
            return;
        }
        this.disabledAlpha = 1.0f;
        this.pressedAlpha = 1.0f;
    }

    public void setDisabledAlphaScale(float f) {
        this.disabledAlpha = verify(f);
    }

    public void setPressedAlphaScale(float f) {
        this.pressedAlpha = verify(f);
    }

    private float verify(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setAlpha(this.disabledAlpha);
        } else {
            setAlpha(1.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    setAlpha(this.pressedAlpha);
                    break;
                case 1:
                    setAlpha(1.0f);
                    break;
                case 3:
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
