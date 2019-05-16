package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean amO;
    private boolean amP;
    private boolean amQ;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amO = false;
        this.amP = false;
        this.amQ = false;
    }

    public boolean xx() {
        return this.amO;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.amO = z;
    }

    public void setGesture(boolean z) {
        this.amP = z;
    }

    public void setHide(boolean z) {
        this.amQ = z;
    }
}
