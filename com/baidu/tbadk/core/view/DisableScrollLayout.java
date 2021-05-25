package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12203e;

    /* renamed from: f  reason: collision with root package name */
    public double f12204f;

    /* renamed from: g  reason: collision with root package name */
    public double f12205g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12206h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f12204f = 0.0d;
        this.f12205g = 0.0d;
        this.f12206h = true;
    }

    public void a(boolean z) {
        this.f12206h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12204f = motionEvent.getX();
            this.f12205g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f12203e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f12204f) <= Math.abs(y - this.f12205g)) {
                if (y <= this.f12205g || this.f12206h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i2) {
        this.f12203e = i2;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12204f = 0.0d;
        this.f12205g = 0.0d;
        this.f12206h = true;
    }
}
