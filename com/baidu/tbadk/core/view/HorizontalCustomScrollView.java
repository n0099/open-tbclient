package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes3.dex */
public class HorizontalCustomScrollView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public a f13369e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, int i2);
    }

    public HorizontalCustomScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a aVar = this.f13369e;
        if (aVar != null) {
            aVar.a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setOnSizeChangeListener(a aVar) {
        this.f13369e = aVar;
    }

    public HorizontalCustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalCustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
