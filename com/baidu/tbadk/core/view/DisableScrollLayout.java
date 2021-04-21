package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DisableScrollLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13027e;

    /* renamed from: f  reason: collision with root package name */
    public double f13028f;

    /* renamed from: g  reason: collision with root package name */
    public double f13029g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13030h;

    public DisableScrollLayout(Context context) {
        super(context);
        this.f13028f = 0.0d;
        this.f13029g = 0.0d;
        this.f13030h = true;
    }

    public void a(boolean z) {
        this.f13030h = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13028f = motionEvent.getX();
            this.f13029g = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.f13027e) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.f13028f) <= Math.abs(y - this.f13029g)) {
                if (y <= this.f13029g || this.f13030h) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setHeaderViewHeight(int i) {
        this.f13027e = i;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13028f = 0.0d;
        this.f13029g = 0.0d;
        this.f13030h = true;
    }
}
