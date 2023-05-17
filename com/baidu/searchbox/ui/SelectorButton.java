package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
/* loaded from: classes4.dex */
public class SelectorButton extends Button {
    public static final float DISABLED_ALPHA_SCALE_DEFAULT = 0.4f;
    public static final int NORMAL_ALPHA = 1;
    public static final float PRESSED_ALPHA_SCALE_DEFAULT = 0.6f;
    public float disabledAlpha;
    public float pressedAlpha;

    private float verify(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    public SelectorButton(Context context) {
        super(context);
        init(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        setAlpha(1.0f);
                    }
                } else {
                    setAlpha(1.0f);
                }
            } else {
                setAlpha(this.pressedAlpha);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDisabledAlphaScale(float f) {
        this.disabledAlpha = verify(f);
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

    public void setPressedAlphaScale(float f) {
        this.pressedAlpha = verify(f);
    }

    public SelectorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.SelectorImageButton);
            if (obtainStyledAttributes != null) {
                float f = obtainStyledAttributes.getFloat(0, 0.4f);
                float f2 = obtainStyledAttributes.getFloat(1, 0.6f);
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

    public SelectorButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
