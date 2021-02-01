package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes9.dex */
public abstract class AbsCanvasView extends View {
    private boolean cKD;
    private boolean cKE;
    private boolean cKF;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKD = false;
        this.cKE = false;
        this.cKF = false;
    }

    public boolean akU() {
        return this.cKD;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.cKD = z;
    }

    public void setGesture(boolean z) {
        this.cKE = z;
    }

    public void setHide(boolean z) {
        this.cKF = z;
    }
}
