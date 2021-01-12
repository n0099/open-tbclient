package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes8.dex */
public abstract class AbsCanvasView extends View {
    private boolean cIp;
    private boolean cIq;
    private boolean cIr;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cIp = false;
        this.cIq = false;
        this.cIr = false;
    }

    public boolean akw() {
        return this.cIp;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.cIp = z;
    }

    public void setGesture(boolean z) {
        this.cIq = z;
    }

    public void setHide(boolean z) {
        this.cIr = z;
    }
}
