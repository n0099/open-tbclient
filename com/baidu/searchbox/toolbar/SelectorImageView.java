package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.searchbox.ui.BdBaseImageView;
/* loaded from: classes4.dex */
public class SelectorImageView extends BdBaseImageView {
    public static final int DISABLED_ALPHA = 255;
    public static final int NORMAL_ALPHA = 255;
    public static final int PRESSED_ALPHA = 76;

    public SelectorImageView(Context context) {
        super(context);
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
                setImageAlpha(76);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @Deprecated
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setImageAlpha(255);
        } else {
            setImageAlpha(255);
        }
    }

    public SelectorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
