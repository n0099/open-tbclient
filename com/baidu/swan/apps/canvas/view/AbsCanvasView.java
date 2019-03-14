package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean amx;
    private boolean amy;
    private boolean amz;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amx = false;
        this.amy = false;
        this.amz = false;
    }

    public boolean wG() {
        return this.amx;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.amx = z;
    }

    public void setGesture(boolean z) {
        this.amy = z;
    }

    public void setHide(boolean z) {
        this.amz = z;
    }
}
