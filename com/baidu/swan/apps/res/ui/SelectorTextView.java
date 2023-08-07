package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.tieba.ir1;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class SelectorTextView extends TextView {
    public static final boolean b = ir1.a;
    public boolean a;

    public SelectorTextView(Context context) {
        super(context);
        this.a = false;
    }

    public void setMode(boolean z) {
        this.a = z;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (b) {
                        Log.d("ACTION_UP", "ACTION_UP");
                    }
                    setAlpha(1.0f);
                }
            } else {
                if (b) {
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                }
                if (this.a) {
                    setAlpha(0.5f);
                } else {
                    setAlpha(0.4f);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
