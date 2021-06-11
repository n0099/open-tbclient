package com.baidu.swan.map.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import d.a.l0.j.o.d;
/* loaded from: classes3.dex */
public class FlipperFrameLayout extends FrameLayout implements d.b {

    /* renamed from: e  reason: collision with root package name */
    public float f11827e;

    /* renamed from: f  reason: collision with root package name */
    public d f11828f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11829g;

    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // d.a.l0.j.o.d.b
    public void a(boolean z) {
        this.f11829g = false;
    }

    @Override // d.a.l0.j.o.d.b
    public void b(boolean z) {
        this.f11829g = true;
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
        if (!this.f11829g && this.f11828f != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY() - this.f11827e;
                        boolean z = rawY <= 0.0f;
                        if (z && !this.f11828f.d() && d(rawY)) {
                            this.f11828f.e(true);
                            return true;
                        } else if (!z && c() && this.f11828f.d() && d(rawY)) {
                            this.f11828f.e(false);
                            return true;
                        }
                    }
                }
                this.f11827e = motionEvent.getRawY();
            } else {
                this.f11827e = motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f11827e = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setViewFlipper(d dVar) {
        this.f11828f = dVar;
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
