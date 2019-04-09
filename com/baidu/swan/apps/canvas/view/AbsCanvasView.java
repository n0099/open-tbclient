package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean amC;
    private boolean amD;
    private boolean amE;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amC = false;
        this.amD = false;
        this.amE = false;
    }

    public boolean wF() {
        return this.amC;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.amC = z;
    }

    public void setGesture(boolean z) {
        this.amD = z;
    }

    public void setHide(boolean z) {
        this.amE = z;
    }
}
