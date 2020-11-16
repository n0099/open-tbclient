package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class PolyFrameLayout extends FrameLayout {
    private boolean ccc;

    public PolyFrameLayout(Context context) {
        this(context, null);
    }

    public void a(boolean z) {
        this.ccc = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ccc) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccc = false;
    }
}
