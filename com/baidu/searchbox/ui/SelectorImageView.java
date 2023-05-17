package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class SelectorImageView extends BdBaseImageView {
    public static final int DISABLED_ALPHA = 255;
    public static int NORMAL_ALPHA = 255;
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
                    setImageAlpha(NORMAL_ALPHA);
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
            setImageAlpha(NORMAL_ALPHA);
        }
    }

    public SelectorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static View.OnTouchListener getStaticOnTouchListener() {
        return new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.SelectorImageView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if ((action == 1 || action == 3) && (view2 instanceof ImageView)) {
                        ((ImageView) view2).setImageAlpha(255);
                        return false;
                    }
                    return false;
                } else if (view2 instanceof ImageView) {
                    ((ImageView) view2).setImageAlpha(76);
                    return false;
                } else {
                    return false;
                }
            }
        };
    }
}
