package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
/* loaded from: classes4.dex */
public class SelectorImageButton extends ImageButton {
    public static final float DISABLED_ALPHA_SCALE_DEFAULT = 0.4f;
    public static final int NORMAL_ALPHA = 255;
    public static final float PRESSED_ALPHA_SCALE_DEFAULT = 0.6f;
    public int disabledAlpha;
    public int pressedAlpha;

    private float verify(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    public SelectorImageButton(Context context) {
        super(context);
        init(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setImageAlpha(255);
                }
            } else {
                setImageAlpha(this.pressedAlpha);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDisabledAlphaScale(float f) {
        this.disabledAlpha = (int) (verify(f) * 255.0f);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setImageAlpha(this.disabledAlpha);
        } else {
            setImageAlpha(255);
        }
    }

    public void setPressedAlphaScale(float f) {
        this.pressedAlpha = (int) (verify(f) * 255.0f);
    }

    public SelectorImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SelectorImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.SelectorImageButton);
            if (obtainStyledAttributes != null) {
                float f = obtainStyledAttributes.getFloat(0, 0.4f);
                float f2 = obtainStyledAttributes.getFloat(1, 0.6f);
                this.disabledAlpha = (int) (verify(f) * 255.0f);
                this.pressedAlpha = (int) (verify(f2) * 255.0f);
                obtainStyledAttributes.recycle();
            }
        } else {
            this.disabledAlpha = 255;
            this.pressedAlpha = 255;
        }
        setBackgroundResource(com.baidu.tieba.R.color.transparent);
    }
}
