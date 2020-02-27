package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes13.dex */
public class SelectorTextView extends TextView {
    private static final float NORMAL_ALPHA = 1.0f;
    private static final float PRESSED_ALPHA = 0.4f;
    private static final float PRESSED_ALPHA_PHOTO = 0.5f;
    private boolean isPhoto;

    public SelectorTextView(Context context) {
        super(context);
        this.isPhoto = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPhoto = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPhoto = false;
    }

    public void setMode(boolean z) {
        this.isPhoto = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                    if (this.isPhoto) {
                        setAlpha(0.5f);
                        break;
                    } else {
                        setAlpha(0.4f);
                        break;
                    }
                case 1:
                case 3:
                    Log.d("ACTION_UP", "ACTION_UP");
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
