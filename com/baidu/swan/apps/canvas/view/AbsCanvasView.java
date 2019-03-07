package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean amw;
    private boolean amx;
    private boolean amy;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amw = false;
        this.amx = false;
        this.amy = false;
    }

    public boolean wG() {
        return this.amw;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.amw = z;
    }

    public void setGesture(boolean z) {
        this.amx = z;
    }

    public void setHide(boolean z) {
        this.amy = z;
    }
}
