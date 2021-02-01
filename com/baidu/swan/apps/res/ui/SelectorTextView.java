package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class SelectorTextView extends TextView {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dww;

    public SelectorTextView(Context context) {
        super(context);
        this.dww = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dww = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dww = false;
    }

    public void setMode(boolean z) {
        this.dww = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (DEBUG) {
                        Log.d("ACTION_DOWN", "ACTION_DOWN");
                    }
                    if (this.dww) {
                        setAlpha(0.5f);
                        break;
                    } else {
                        setAlpha(0.4f);
                        break;
                    }
                case 1:
                case 3:
                    if (DEBUG) {
                        Log.d("ACTION_UP", "ACTION_UP");
                    }
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
