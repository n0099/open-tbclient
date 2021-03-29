package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12118e;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f12118e;
    }

    public void setGesture(boolean z) {
    }

    public void setHide(boolean z) {
    }

    public void setInterceptTouchEvent(boolean z) {
        this.f12118e = z;
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12118e = false;
    }
}
