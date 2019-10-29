package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean aHg;
    private boolean aHh;
    private boolean aHi;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHg = false;
        this.aHh = false;
        this.aHi = false;
    }

    public boolean Da() {
        return this.aHg;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.aHg = z;
    }

    public void setGesture(boolean z) {
        this.aHh = z;
    }

    public void setHide(boolean z) {
        this.aHi = z;
    }
}
