package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import d.b.h0.h.a.j.d;
/* loaded from: classes3.dex */
public class FlipperFrameLayout extends FrameLayout implements d.b {

    /* renamed from: e  reason: collision with root package name */
    public float f12624e;

    /* renamed from: f  reason: collision with root package name */
    public d f12625f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12626g;

    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // d.b.h0.h.a.j.d.b
    public void a(boolean z) {
        this.f12626g = true;
    }

    @Override // d.b.h0.h.a.j.d.b
    public void b(boolean z) {
        this.f12626g = false;
    }

    public final boolean c() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        if (childAt instanceof ScrollingView) {
            return !childAt.canScrollVertically(-1);
        }
        return true;
    }

    public final boolean d(float f2) {
        return Math.abs(f2) >= ((float) ViewConfiguration.getTouchSlop());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f12626g && this.f12625f != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY() - this.f12624e;
                        boolean z = rawY <= 0.0f;
                        if (z && !this.f12625f.d() && d(rawY)) {
                            this.f12625f.e(true);
                            return true;
                        } else if (!z && c() && this.f12625f.d() && d(rawY)) {
                            this.f12625f.e(false);
                            return true;
                        }
                    }
                }
                this.f12624e = motionEvent.getRawY();
            } else {
                this.f12624e = motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f12624e = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setViewFlipper(d dVar) {
        this.f12625f = dVar;
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
