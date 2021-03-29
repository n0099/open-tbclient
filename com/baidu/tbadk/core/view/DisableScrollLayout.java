package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13358e;

    /* renamed from: f  reason: collision with root package name */
    public double f13359f;

    /* renamed from: g  reason: collision with root package name */
    public double f13360g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13361h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f13359f = 0.0d;
        this.f13360g = 0.0d;
        this.f13361h = true;
    }

    public void a(boolean z) {
        this.f13361h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13359f = motionEvent.getX();
            this.f13360g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f13358e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f13359f) <= Math.abs(y - this.f13360g)) {
                if (y <= this.f13360g || this.f13361h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i) {
        this.f13358e = i;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13359f = 0.0d;
        this.f13360g = 0.0d;
        this.f13361h = true;
    }
}
