package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13019e;

    /* renamed from: f  reason: collision with root package name */
    public double f13020f;

    /* renamed from: g  reason: collision with root package name */
    public double f13021g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13022h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f13020f = 0.0d;
        this.f13021g = 0.0d;
        this.f13022h = true;
    }

    public void a(boolean z) {
        this.f13022h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13020f = motionEvent.getX();
            this.f13021g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f13019e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f13020f) <= Math.abs(y - this.f13021g)) {
                if (y <= this.f13021g || this.f13022h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i) {
        this.f13019e = i;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13020f = 0.0d;
        this.f13021g = 0.0d;
        this.f13022h = true;
    }
}
