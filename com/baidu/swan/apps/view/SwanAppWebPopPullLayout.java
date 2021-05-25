package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class SwanAppWebPopPullLayout extends FrameLayout {
    public static final boolean j = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public final ViewDragHelper f11360e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11361f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public c f11362g;

    /* renamed from: h  reason: collision with root package name */
    public b f11363h;

    /* renamed from: i  reason: collision with root package name */
    public View f11364i;

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b();

        void c();

        void d(float f2);
    }

    /* loaded from: classes3.dex */
    public class d extends ViewDragHelper.Callback {
        public d() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return Math.max(0, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SwanAppWebPopPullLayout.this.getHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            if (SwanAppWebPopPullLayout.this.f11362g != null) {
                SwanAppWebPopPullLayout.this.f11362g.c();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            if (SwanAppWebPopPullLayout.this.f11362g != null) {
                SwanAppWebPopPullLayout.this.f11362g.d(i3 / SwanAppWebPopPullLayout.this.getHeight());
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            if (SwanAppWebPopPullLayout.this.f11362g == null) {
                return;
            }
            if (view.getTop() > ((f3 > ((float) SwanAppWebPopPullLayout.this.f11361f) ? 1 : (f3 == ((float) SwanAppWebPopPullLayout.this.f11361f) ? 0 : -1)) > 0 ? SwanAppWebPopPullLayout.this.getHeight() / 6 : SwanAppWebPopPullLayout.this.getHeight() / 3)) {
                SwanAppWebPopPullLayout.this.f11362g.b();
                return;
            }
            SwanAppWebPopPullLayout.this.f11362g.a();
            SwanAppWebPopPullLayout.this.f11360e.settleCapturedViewAt(0, 0);
            SwanAppWebPopPullLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            return true;
        }
    }

    public SwanAppWebPopPullLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f11360e.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean d() {
        return this.f11364i.getTop() > 0;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f11364i = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (j) {
            Log.d("SwanAppWebPopPullLayout", "onInterceptTouchEvent");
        }
        boolean shouldInterceptTouchEvent = this.f11360e.shouldInterceptTouchEvent(motionEvent);
        b bVar = this.f11363h;
        if (bVar != null) {
            shouldInterceptTouchEvent = bVar.a(motionEvent);
        }
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 5) {
            try {
                this.f11360e.processTouchEvent(motionEvent);
            } catch (Exception e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        super.onInterceptTouchEvent(motionEvent);
        return shouldInterceptTouchEvent;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        try {
            this.f11360e.processTouchEvent(motionEvent);
            return true;
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
                return true;
            }
            return true;
        }
    }

    public void setCallback(@Nullable c cVar) {
        this.f11362g = cVar;
    }

    public void setInterceptCallback(b bVar) {
        this.f11363h = bVar;
    }

    public SwanAppWebPopPullLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppWebPopPullLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11360e = ViewDragHelper.create(this, 1.0f, new d());
        this.f11361f = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }
}
