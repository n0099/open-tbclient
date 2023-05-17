package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public abstract class AbsCanvasView extends View {
    public boolean a;

    public void setGesture(boolean z) {
    }

    public void setHide(boolean z) {
    }

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public void setInterceptTouchEvent(boolean z) {
        this.a = z;
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
    }

    public boolean a() {
        return this.a;
    }
}
