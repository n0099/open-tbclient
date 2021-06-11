package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12265e;

    /* renamed from: f  reason: collision with root package name */
    public double f12266f;

    /* renamed from: g  reason: collision with root package name */
    public double f12267g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12268h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f12266f = 0.0d;
        this.f12267g = 0.0d;
        this.f12268h = true;
    }

    public void a(boolean z) {
        this.f12268h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12266f = motionEvent.getX();
            this.f12267g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f12265e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f12266f) <= Math.abs(y - this.f12267g)) {
                if (y <= this.f12267g || this.f12268h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i2) {
        this.f12265e = i2;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12266f = 0.0d;
        this.f12267g = 0.0d;
        this.f12268h = true;
    }
}
