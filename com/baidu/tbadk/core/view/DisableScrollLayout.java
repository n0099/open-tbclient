package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12295e;

    /* renamed from: f  reason: collision with root package name */
    public double f12296f;

    /* renamed from: g  reason: collision with root package name */
    public double f12297g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12298h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f12296f = 0.0d;
        this.f12297g = 0.0d;
        this.f12298h = true;
    }

    public void a(boolean z) {
        this.f12298h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12296f = motionEvent.getX();
            this.f12297g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f12295e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f12296f) <= Math.abs(y - this.f12297g)) {
                if (y <= this.f12297g || this.f12298h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i2) {
        this.f12295e = i2;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12296f = 0.0d;
        this.f12297g = 0.0d;
        this.f12298h = true;
    }
}
