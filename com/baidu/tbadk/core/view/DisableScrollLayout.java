package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13357e;

    /* renamed from: f  reason: collision with root package name */
    public double f13358f;

    /* renamed from: g  reason: collision with root package name */
    public double f13359g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13360h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f13358f = 0.0d;
        this.f13359g = 0.0d;
        this.f13360h = true;
    }

    public void a(boolean z) {
        this.f13360h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13358f = motionEvent.getX();
            this.f13359g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f13357e) {
            double x = motionEvent.getX();
            double y = motionEvent.getY();
            double d2 = this.f13358f;
            Double.isNaN(x);
            double abs = Math.abs(x - d2);
            double d3 = this.f13359g;
            Double.isNaN(y);
            if (abs <= Math.abs(y - d3)) {
                if (y <= this.f13359g || this.f13360h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i) {
        this.f13357e = i;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13358f = 0.0d;
        this.f13359g = 0.0d;
        this.f13360h = true;
    }
}
