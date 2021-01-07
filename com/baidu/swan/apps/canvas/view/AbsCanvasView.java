package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes9.dex */
public abstract class AbsCanvasView extends View {
    private boolean cNb;
    private boolean cNc;
    private boolean cNd;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNb = false;
        this.cNc = false;
        this.cNd = false;
    }

    public boolean aoq() {
        return this.cNb;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.cNb = z;
    }

    public void setGesture(boolean z) {
        this.cNc = z;
    }

    public void setHide(boolean z) {
        this.cNd = z;
    }
}
