package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean anP;
    private boolean anQ;
    private boolean anR;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anP = false;
        this.anQ = false;
        this.anR = false;
    }

    public boolean yf() {
        return this.anP;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.anP = z;
    }

    public void setGesture(boolean z) {
        this.anQ = z;
    }

    public void setHide(boolean z) {
        this.anR = z;
    }
}
