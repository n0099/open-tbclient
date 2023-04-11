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
import com.baidu.tieba.id4;
/* loaded from: classes3.dex */
public class FlipperFrameLayout extends FrameLayout implements id4.b {
    public float a;
    public id4 b;
    public boolean c;

    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.id4.b
    public void a(boolean z) {
        this.c = false;
    }

    @Override // com.baidu.tieba.id4.b
    public void b(boolean z) {
        this.c = true;
    }

    public final boolean d(float f) {
        if (Math.abs(f) >= ViewConfiguration.getTouchSlop()) {
            return true;
        }
        return false;
    }

    public void setViewFlipper(id4 id4Var) {
        this.b = id4Var;
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final boolean c() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        if (!(childAt instanceof ScrollingView)) {
            return true;
        }
        return !childAt.canScrollVertically(-1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.c && this.b != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY() - this.a;
                        if (rawY <= 0.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && !this.b.d() && d(rawY)) {
                            this.b.e(true);
                            return true;
                        } else if (!z && c() && this.b.d() && d(rawY)) {
                            this.b.e(false);
                            return true;
                        }
                    }
                }
                this.a = motionEvent.getRawY();
            } else {
                this.a = motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.a = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }
}
