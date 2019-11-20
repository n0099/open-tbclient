package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class SelectorTextView extends TextView {
    private boolean bdh;

    public SelectorTextView(Context context) {
        super(context);
        this.bdh = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdh = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdh = false;
    }

    public void setMode(boolean z) {
        this.bdh = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                    if (this.bdh) {
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
