package com.baidu.sapi2.views.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.tieba.uf1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SwipeBackLayout extends ViewGroup {
    public static final String t = "SwipeBackLayout";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    public int a;
    public final ViewDragHelper b;
    public View c;
    public View d;
    public int e;
    public int f;
    public int g;
    public float h;
    public float i;
    public int j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public int o;
    public float p;
    public int q;
    public d r;
    public d s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface b {
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view2, float f, float f2);

        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view2, float f, float f2) {
            SwipeBackLayout.this.invalidate();
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view2, boolean z) {
            if (z) {
                SwipeBackLayout.this.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view2) {
            return SwipeBackLayout.this.e;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view2) {
            return SwipeBackLayout.this.f;
        }

        public /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i, int i2) {
            super.onEdgeTouched(i, i2);
            SwipeBackLayout.this.q = i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            if (view2 == SwipeBackLayout.this.c) {
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view2, int i, int i2) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.n = swipeBackLayout.getPaddingLeft();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.a == 1 && !com.baidu.sapi2.views.swipeback.a.a.c(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    swipeBackLayout2.n = Math.min(Math.max(i, swipeBackLayout2.getPaddingLeft()), SwipeBackLayout.this.e);
                } else if (SwipeBackLayout.this.a == 2 && !com.baidu.sapi2.views.swipeback.a.a.b(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.n = Math.min(Math.max(i, -swipeBackLayout3.e), SwipeBackLayout.this.getPaddingRight());
                }
            }
            return SwipeBackLayout.this.n;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view2, int i, int i2) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.o = swipeBackLayout.getPaddingTop();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.a == 4 && !com.baidu.sapi2.views.swipeback.a.a.d(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    swipeBackLayout2.o = Math.min(Math.max(i, swipeBackLayout2.getPaddingTop()), SwipeBackLayout.this.f);
                } else if (SwipeBackLayout.this.a == 8 && !com.baidu.sapi2.views.swipeback.a.a.a(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.o = Math.min(Math.max(i, -swipeBackLayout3.f), SwipeBackLayout.this.getPaddingBottom());
                }
            }
            return SwipeBackLayout.this.o;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            if (i == 0 && SwipeBackLayout.this.r != null) {
                if (SwipeBackLayout.this.i == 0.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, false);
                } else if (SwipeBackLayout.this.i == 1.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, true);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view2, i, i2, i3, i4);
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            int i5 = SwipeBackLayout.this.a;
            if (i5 != 1 && i5 != 2) {
                if (i5 == 4 || i5 == 8) {
                    SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                    swipeBackLayout.i = (abs2 * 1.0f) / swipeBackLayout.f;
                }
            } else {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                swipeBackLayout2.i = (abs * 1.0f) / swipeBackLayout2.e;
            }
            if (SwipeBackLayout.this.r != null) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, SwipeBackLayout.this.i, SwipeBackLayout.this.h);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            super.onViewReleased(view2, f, f2);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean z = false;
            swipeBackLayout.n = swipeBackLayout.o = 0;
            if (!SwipeBackLayout.this.c()) {
                SwipeBackLayout.this.q = -1;
                return;
            }
            SwipeBackLayout.this.q = -1;
            if ((SwipeBackLayout.this.a(f, f2) || SwipeBackLayout.this.i >= SwipeBackLayout.this.h) ? true : true) {
                int i = SwipeBackLayout.this.a;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i == 8) {
                                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                                swipeBackLayout2.b(-swipeBackLayout2.f);
                                return;
                            }
                            return;
                        }
                        SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                        swipeBackLayout3.b(swipeBackLayout3.f);
                        return;
                    }
                    SwipeBackLayout swipeBackLayout4 = SwipeBackLayout.this;
                    swipeBackLayout4.a(-swipeBackLayout4.e);
                    return;
                }
                SwipeBackLayout swipeBackLayout5 = SwipeBackLayout.this;
                swipeBackLayout5.a(swipeBackLayout5.e);
                return;
            }
            int i2 = SwipeBackLayout.this.a;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 4 || i2 == 8) {
                    SwipeBackLayout swipeBackLayout6 = SwipeBackLayout.this;
                    swipeBackLayout6.b(swipeBackLayout6.getPaddingTop());
                    return;
                }
                return;
            }
            SwipeBackLayout swipeBackLayout7 = SwipeBackLayout.this;
            swipeBackLayout7.a(swipeBackLayout7.getPaddingLeft());
        }
    }

    public SwipeBackLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.processTouchEvent(motionEvent);
        return true;
    }

    public void setAutoFinishedVelocityLimit(float f) {
        this.p = f;
    }

    public void setDirectionMode(int i) {
        this.a = i;
        this.b.setEdgeTrackingEnabled(i);
    }

    public void setMaskAlpha(@IntRange(from = 0, to = 255) int i) {
        if (i > 255) {
            i = 255;
        } else if (i < 0) {
            i = 0;
        }
        this.j = i;
    }

    public void setSwipeBackFactor(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.h = f;
    }

    public void setSwipeBackListener(d dVar) {
        this.r = dVar;
    }

    public void setSwipeFromEdge(boolean z) {
        this.k = z;
    }

    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        this.h = 0.5f;
        this.j = 125;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 2000.0f;
        this.q = -1;
        this.s = new a();
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new c(this, null));
        this.b = create;
        create.setEdgeTrackingEnabled(this.a);
        this.g = this.b.getTouchSlop();
        setSwipeBackListener(this.s);
        a(context, attributeSet);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, uf1.sapi_sdk_SwipeBackLayout);
        setDirectionMode(obtainStyledAttributes.getInt(0, this.a));
        setSwipeBackFactor(obtainStyledAttributes.getFloat(3, this.h));
        setMaskAlpha(obtainStyledAttributes.getInteger(2, this.j));
        this.k = obtainStyledAttributes.getBoolean(1, this.k);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2) {
        int i = this.a;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8 || f2 >= (-this.p)) {
                        return false;
                    }
                    return true;
                } else if (f2 <= this.p) {
                    return false;
                } else {
                    return true;
                }
            } else if (f >= (-this.p)) {
                return false;
            } else {
                return true;
            }
        } else if (f <= this.p) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (!this.k) {
            return true;
        }
        int i = this.a;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8 || this.q == 8) {
                        return true;
                    }
                    return false;
                } else if (this.q == 4) {
                    return true;
                } else {
                    return false;
                }
            } else if (this.q == 2) {
                return true;
            } else {
                return false;
            }
        } else if (this.q == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void a() {
        ((Activity) getContext()).finish();
    }

    public boolean b() {
        return this.k;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public float getAutoFinishedVelocityLimit() {
        return this.p;
    }

    public int getDirectionMode() {
        return this.a;
    }

    public int getMaskAlpha() {
        return this.j;
    }

    public float getSwipeBackFactor() {
        return this.h;
    }

    public void a(int i) {
        if (this.b.settleCapturedViewAt(i, getPaddingTop())) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void b(int i) {
        if (this.b.settleCapturedViewAt(getPaddingLeft(), i)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundColor(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        viewGroup.addView(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 2 && (view2 = this.d) != null && com.baidu.sapi2.views.swipeback.a.a.a(view2, this.l, this.m)) {
                float abs = Math.abs(motionEvent.getRawX() - this.l);
                float abs2 = Math.abs(motionEvent.getRawY() - this.m);
                int i = this.a;
                if (i != 1 && i != 2) {
                    if ((i == 4 || i == 8) && abs > this.g && abs > abs2) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else if (abs2 > this.g && abs2 > abs) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            }
        } else {
            this.l = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
        }
        boolean shouldInterceptTouchEvent = this.b.shouldInterceptTouchEvent(motionEvent);
        if (!shouldInterceptTouchEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return shouldInterceptTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft() + this.n;
        int paddingTop = getPaddingTop() + this.o;
        this.c.layout(paddingLeft, paddingTop, this.c.getMeasuredWidth() + paddingLeft, this.c.getMeasuredHeight() + paddingTop);
        if (z) {
            this.e = getWidth();
            this.f = getHeight();
        }
        this.d = com.baidu.sapi2.views.swipeback.a.a.a((ViewGroup) this);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount <= 1) {
            int i4 = 0;
            if (childCount > 0) {
                measureChildren(i, i2);
                View childAt = getChildAt(0);
                this.c = childAt;
                i4 = childAt.getMeasuredWidth();
                i3 = this.c.getMeasuredHeight();
            } else {
                i3 = 0;
            }
            setMeasuredDimension(View.resolveSize(i4, i) + getPaddingLeft() + getPaddingRight(), View.resolveSize(i3, i2) + getPaddingTop() + getPaddingBottom());
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must contains only one direct child.");
    }
}
