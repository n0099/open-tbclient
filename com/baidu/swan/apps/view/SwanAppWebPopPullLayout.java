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
import com.baidu.tieba.ms1;
/* loaded from: classes4.dex */
public class SwanAppWebPopPullLayout extends FrameLayout {
    public static final boolean f = ms1.a;
    public final ViewDragHelper a;
    public final int b;
    @Nullable
    public c c;
    public b d;
    public View e;

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();

        void c();

        void onPull(float f);
    }

    /* loaded from: classes4.dex */
    public class d extends ViewDragHelper.Callback {
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            return true;
        }

        public d() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view2) {
            return SwanAppWebPopPullLayout.this.getHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view2, int i) {
            if (SwanAppWebPopPullLayout.this.c != null) {
                SwanAppWebPopPullLayout.this.c.c();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view2, int i, int i2) {
            return Math.max(0, i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            if (SwanAppWebPopPullLayout.this.c != null) {
                SwanAppWebPopPullLayout.this.c.onPull(i2 / SwanAppWebPopPullLayout.this.getHeight());
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            int height;
            boolean z;
            if (SwanAppWebPopPullLayout.this.c == null) {
                return;
            }
            if (f2 > SwanAppWebPopPullLayout.this.b) {
                height = SwanAppWebPopPullLayout.this.getHeight() / 6;
            } else {
                height = SwanAppWebPopPullLayout.this.getHeight() / 3;
            }
            if (view2.getTop() > height) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                SwanAppWebPopPullLayout.this.c.b();
                return;
            }
            SwanAppWebPopPullLayout.this.c.a();
            SwanAppWebPopPullLayout.this.a.settleCapturedViewAt(0, 0);
            SwanAppWebPopPullLayout.this.invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.a.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean d() {
        if (this.e.getTop() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.e = getChildAt(0);
    }

    public SwanAppWebPopPullLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        try {
            this.a.processTouchEvent(motionEvent);
            return true;
        } catch (Exception e) {
            if (f) {
                e.printStackTrace();
                return true;
            }
            return true;
        }
    }

    public void setCallback(@Nullable c cVar) {
        this.c = cVar;
    }

    public void setInterceptCallback(b bVar) {
        this.d = bVar;
    }

    public SwanAppWebPopPullLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppWebPopPullLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = ViewDragHelper.create(this, 1.0f, new d());
        this.b = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (f) {
            Log.d("SwanAppWebPopPullLayout", "onInterceptTouchEvent");
        }
        boolean shouldInterceptTouchEvent = this.a.shouldInterceptTouchEvent(motionEvent);
        b bVar = this.d;
        if (bVar != null) {
            shouldInterceptTouchEvent = bVar.a(motionEvent);
        }
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 5) {
            try {
                this.a.processTouchEvent(motionEvent);
            } catch (Exception e) {
                if (f) {
                    e.printStackTrace();
                }
            }
        }
        super.onInterceptTouchEvent(motionEvent);
        return shouldInterceptTouchEvent;
    }
}
