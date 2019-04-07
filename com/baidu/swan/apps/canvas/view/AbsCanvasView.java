package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean amB;
    private boolean amC;
    private boolean amD;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amB = false;
        this.amC = false;
        this.amD = false;
    }

    public boolean wF() {
        return this.amB;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.amB = z;
    }

    public void setGesture(boolean z) {
        this.amC = z;
    }

    public void setHide(boolean z) {
        this.amD = z;
    }
}
