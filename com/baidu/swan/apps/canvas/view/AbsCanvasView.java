package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {
    private boolean aGO;
    private boolean aGP;
    private boolean aGQ;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGO = false;
        this.aGP = false;
        this.aGQ = false;
    }

    public boolean Db() {
        return this.aGO;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.aGO = z;
    }

    public void setGesture(boolean z) {
        this.aGP = z;
    }

    public void setHide(boolean z) {
        this.aGQ = z;
    }
}
