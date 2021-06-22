package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12347e;

    /* renamed from: f  reason: collision with root package name */
    public double f12348f;

    /* renamed from: g  reason: collision with root package name */
    public double f12349g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12350h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f12348f = 0.0d;
        this.f12349g = 0.0d;
        this.f12350h = true;
    }

    public void a(boolean z) {
        this.f12350h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12348f = motionEvent.getX();
            this.f12349g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f12347e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f12348f) <= Math.abs(y - this.f12349g)) {
                if (y <= this.f12349g || this.f12350h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i2) {
        this.f12347e = i2;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12348f = 0.0d;
        this.f12349g = 0.0d;
        this.f12350h = true;
    }
}
