package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes11.dex */
public abstract class AbsCanvasView extends View {
    private boolean bhx;
    private boolean bhy;
    private boolean mInterceptTouchEvent;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterceptTouchEvent = false;
        this.bhx = false;
        this.bhy = false;
    }

    public boolean Kw() {
        return this.mInterceptTouchEvent;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.mInterceptTouchEvent = z;
    }

    public void setGesture(boolean z) {
        this.bhx = z;
    }

    public void setHide(boolean z) {
        this.bhy = z;
    }
}
