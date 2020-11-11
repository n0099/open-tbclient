package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes10.dex */
public abstract class AbsCanvasView extends View {
    private boolean cCZ;
    private boolean cDa;
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
        this.cCZ = false;
        this.cDa = false;
    }

    public boolean akG() {
        return this.mInterceptTouchEvent;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.mInterceptTouchEvent = z;
    }

    public void setGesture(boolean z) {
        this.cCZ = z;
    }

    public void setHide(boolean z) {
        this.cDa = z;
    }
}
