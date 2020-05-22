package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes11.dex */
public abstract class AbsCanvasView extends View {
    private boolean bOU;
    private boolean bOV;
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
        this.bOU = false;
        this.bOV = false;
    }

    public boolean UZ() {
        return this.mInterceptTouchEvent;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.mInterceptTouchEvent = z;
    }

    public void setGesture(boolean z) {
        this.bOU = z;
    }

    public void setHide(boolean z) {
        this.bOV = z;
    }
}
