package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes8.dex */
public abstract class AbsCanvasView extends View {
    private boolean cMd;
    private boolean cMe;
    private boolean cMf;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cMd = false;
        this.cMe = false;
        this.cMf = false;
    }

    public boolean akX() {
        return this.cMd;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.cMd = z;
    }

    public void setGesture(boolean z) {
        this.cMe = z;
    }

    public void setHide(boolean z) {
        this.cMf = z;
    }
}
