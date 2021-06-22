package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {

    /* renamed from: e  reason: collision with root package name */
    public boolean f10808e;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f10808e;
    }

    public void setGesture(boolean z) {
    }

    public void setHide(boolean z) {
    }

    public void setInterceptTouchEvent(boolean z) {
        this.f10808e = z;
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10808e = false;
    }
}
