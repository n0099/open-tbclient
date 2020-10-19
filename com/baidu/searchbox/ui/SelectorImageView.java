package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class SelectorImageView extends BdBaseImageView {
    private static final int DISABLED_ALPHA = 255;
    private static int NORMAL_ALPHA = 255;
    private static final int PRESSED_ALPHA = 76;

    public SelectorImageView(Context context) {
        super(context);
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
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        Log.d("ACTION_DOWN", "ACTION_DOWN");
                        if (view instanceof ImageView) {
                            ((ImageView) view).setImageAlpha(76);
                            return false;
                        }
                        return false;
                    case 1:
                    case 3:
                        Log.d("ACTION_UP", "ACTION_UP");
                        if (view instanceof ImageView) {
                            ((ImageView) view).setImageAlpha(255);
                            return false;
                        }
                        return false;
                    case 2:
                    default:
                        return false;
                }
            }
        };
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

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                    setImageAlpha(76);
                    break;
                case 1:
                case 3:
                    Log.d("ACTION_UP", "ACTION_UP");
                    setImageAlpha(NORMAL_ALPHA);
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
