package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean anr;
    private boolean ans;
    private boolean ant;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anr = false;
        this.ans = false;
        this.ant = false;
    }

    public boolean yb() {
        return this.anr;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.anr = z;
    }

    public void setGesture(boolean z) {
        this.ans = z;
    }

    public void setHide(boolean z) {
        this.ant = z;
    }
}
