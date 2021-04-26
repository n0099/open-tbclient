package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11617e;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f11617e;
    }

    public void setGesture(boolean z) {
    }

    public void setHide(boolean z) {
    }

    public void setInterceptTouchEvent(boolean z) {
        this.f11617e = z;
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11617e = false;
    }
}
