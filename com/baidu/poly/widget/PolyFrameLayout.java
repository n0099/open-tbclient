package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class PolyFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f9356e;

    public PolyFrameLayout(Context context) {
        this(context, null);
    }

    public void a(boolean z) {
        this.f9356e = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f9356e) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9356e = false;
    }
}
