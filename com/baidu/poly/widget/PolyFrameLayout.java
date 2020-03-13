package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class PolyFrameLayout extends FrameLayout {
    private boolean aSm;

    public PolyFrameLayout(Context context) {
        this(context, null);
    }

    public void a(boolean z) {
        this.aSm = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aSm) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSm = false;
    }
}
