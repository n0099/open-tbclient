package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12959e;

    /* renamed from: f  reason: collision with root package name */
    public double f12960f;

    /* renamed from: g  reason: collision with root package name */
    public double f12961g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12962h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f12960f = 0.0d;
        this.f12961g = 0.0d;
        this.f12962h = true;
    }

    public void a(boolean z) {
        this.f12962h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12960f = motionEvent.getX();
            this.f12961g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f12959e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f12960f) <= Math.abs(y - this.f12961g)) {
                if (y <= this.f12961g || this.f12962h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i2) {
        this.f12959e = i2;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12960f = 0.0d;
        this.f12961g = 0.0d;
        this.f12962h = true;
    }
}
