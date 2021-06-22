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
import d.a.a0.a.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class SwipeBackLayout extends ViewGroup {
    public static final String t = "SwipeBackLayout";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;

    /* renamed from: a  reason: collision with root package name */
    public int f10005a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewDragHelper f10006b;

    /* renamed from: c  reason: collision with root package name */
    public View f10007c;

    /* renamed from: d  reason: collision with root package name */
    public View f10008d;

    /* renamed from: e  reason: collision with root package name */
    public int f10009e;

    /* renamed from: f  reason: collision with root package name */
    public int f10010f;

    /* renamed from: g  reason: collision with root package name */
    public int f10011g;

    /* renamed from: h  reason: collision with root package name */
    public float f10012h;

    /* renamed from: i  reason: collision with root package name */
    public float f10013i;
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

    /* loaded from: classes2.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view, float f2, float f3) {
            SwipeBackLayout.this.invalidate();
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view, boolean z) {
            if (z) {
                SwipeBackLayout.this.a();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    /* loaded from: classes2.dex */
    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.n = swipeBackLayout.getPaddingLeft();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.f10005a != 1 || com.baidu.sapi2.views.swipeback.a.a.c(SwipeBackLayout.this.f10008d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    if (SwipeBackLayout.this.f10005a == 2 && !com.baidu.sapi2.views.swipeback.a.a.b(SwipeBackLayout.this.f10008d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                        SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                        swipeBackLayout2.n = Math.min(Math.max(i2, -swipeBackLayout2.f10009e), SwipeBackLayout.this.getPaddingRight());
                    }
                } else {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.n = Math.min(Math.max(i2, swipeBackLayout3.getPaddingLeft()), SwipeBackLayout.this.f10009e);
                }
            }
            return SwipeBackLayout.this.n;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.o = swipeBackLayout.getPaddingTop();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.f10005a != 4 || com.baidu.sapi2.views.swipeback.a.a.d(SwipeBackLayout.this.f10008d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    if (SwipeBackLayout.this.f10005a == 8 && !com.baidu.sapi2.views.swipeback.a.a.a(SwipeBackLayout.this.f10008d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                        SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                        swipeBackLayout2.o = Math.min(Math.max(i2, -swipeBackLayout2.f10010f), SwipeBackLayout.this.getPaddingBottom());
                    }
                } else {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.o = Math.min(Math.max(i2, swipeBackLayout3.getPaddingTop()), SwipeBackLayout.this.f10010f);
                }
            }
            return SwipeBackLayout.this.o;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SwipeBackLayout.this.f10009e;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SwipeBackLayout.this.f10010f;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i2, int i3) {
            super.onEdgeTouched(i2, i3);
            SwipeBackLayout.this.q = i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            super.onViewDragStateChanged(i2);
            if (i2 != 0 || SwipeBackLayout.this.r == null) {
                return;
            }
            if (SwipeBackLayout.this.f10013i == 0.0f) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.f10007c, false);
            } else if (SwipeBackLayout.this.f10013i == 1.0f) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.f10007c, true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            int i6 = SwipeBackLayout.this.f10005a;
            if (i6 == 1 || i6 == 2) {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                swipeBackLayout.f10013i = (abs * 1.0f) / swipeBackLayout.f10009e;
            } else if (i6 == 4 || i6 == 8) {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                swipeBackLayout2.f10013i = (abs2 * 1.0f) / swipeBackLayout2.f10010f;
            }
            if (SwipeBackLayout.this.r != null) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.f10007c, SwipeBackLayout.this.f10013i, SwipeBackLayout.this.f10012h);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean z = false;
            swipeBackLayout.n = swipeBackLayout.o = 0;
            if (!SwipeBackLayout.this.c()) {
                SwipeBackLayout.this.q = -1;
                return;
            }
            SwipeBackLayout.this.q = -1;
            if ((SwipeBackLayout.this.a(f2, f3) || SwipeBackLayout.this.f10013i >= SwipeBackLayout.this.f10012h) ? true : true) {
                int i2 = SwipeBackLayout.this.f10005a;
                if (i2 == 1) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    swipeBackLayout2.a(swipeBackLayout2.f10009e);
                    return;
                } else if (i2 == 2) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.a(-swipeBackLayout3.f10009e);
                    return;
                } else if (i2 == 4) {
                    SwipeBackLayout swipeBackLayout4 = SwipeBackLayout.this;
                    swipeBackLayout4.b(swipeBackLayout4.f10010f);
                    return;
                } else if (i2 != 8) {
                    return;
                } else {
                    SwipeBackLayout swipeBackLayout5 = SwipeBackLayout.this;
                    swipeBackLayout5.b(-swipeBackLayout5.f10010f);
                    return;
                }
            }
            int i3 = SwipeBackLayout.this.f10005a;
            if (i3 == 1 || i3 == 2) {
                SwipeBackLayout swipeBackLayout6 = SwipeBackLayout.this;
                swipeBackLayout6.a(swipeBackLayout6.getPaddingLeft());
            } else if (i3 == 4 || i3 == 8) {
                SwipeBackLayout swipeBackLayout7 = SwipeBackLayout.this;
                swipeBackLayout7.b(swipeBackLayout7.getPaddingTop());
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            return view == SwipeBackLayout.this.f10007c;
        }

        public /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, float f2, float f3);

        void a(View view, boolean z);
    }

    public SwipeBackLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f10006b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public float getAutoFinishedVelocityLimit() {
        return this.p;
    }

    public int getDirectionMode() {
        return this.f10005a;
    }

    public int getMaskAlpha() {
        return this.j;
    }

    public float getSwipeBackFactor() {
        return this.f10012h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.l = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
        } else if (actionMasked == 2 && (view = this.f10008d) != null && com.baidu.sapi2.views.swipeback.a.a.a(view, this.l, this.m)) {
            float abs = Math.abs(motionEvent.getRawX() - this.l);
            float abs2 = Math.abs(motionEvent.getRawY() - this.m);
            int i2 = this.f10005a;
            if (i2 != 1 && i2 != 2) {
                if ((i2 == 4 || i2 == 8) && abs > this.f10011g && abs > abs2) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            } else if (abs2 > this.f10011g && abs2 > abs) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        boolean shouldInterceptTouchEvent = this.f10006b.shouldInterceptTouchEvent(motionEvent);
        return shouldInterceptTouchEvent ? shouldInterceptTouchEvent : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft() + this.n;
        int paddingTop = getPaddingTop() + this.o;
        this.f10007c.layout(paddingLeft, paddingTop, this.f10007c.getMeasuredWidth() + paddingLeft, this.f10007c.getMeasuredHeight() + paddingTop);
        if (z) {
            this.f10009e = getWidth();
            this.f10010f = getHeight();
        }
        this.f10008d = com.baidu.sapi2.views.swipeback.a.a.a((ViewGroup) this);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        if (childCount <= 1) {
            int i5 = 0;
            if (childCount > 0) {
                measureChildren(i2, i3);
                View childAt = getChildAt(0);
                this.f10007c = childAt;
                i5 = childAt.getMeasuredWidth();
                i4 = this.f10007c.getMeasuredHeight();
            } else {
                i4 = 0;
            }
            setMeasuredDimension(View.resolveSize(i5, i2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(i4, i3) + getPaddingTop() + getPaddingBottom());
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must contains only one direct child.");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f10006b.processTouchEvent(motionEvent);
        return true;
    }

    public void setAutoFinishedVelocityLimit(float f2) {
        this.p = f2;
    }

    public void setDirectionMode(int i2) {
        this.f10005a = i2;
        this.f10006b.setEdgeTrackingEnabled(i2);
    }

    public void setMaskAlpha(@IntRange(from = 0, to = 255) int i2) {
        if (i2 > 255) {
            i2 = 255;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.j = i2;
    }

    public void setSwipeBackFactor(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f10012h = f2;
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

    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10005a = 1;
        this.f10012h = 0.5f;
        this.j = 125;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 2000.0f;
        this.q = -1;
        this.s = new a();
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new c(this, null));
        this.f10006b = create;
        create.setEdgeTrackingEnabled(this.f10005a);
        this.f10011g = this.f10006b.getTouchSlop();
        setSwipeBackListener(this.s);
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.k) {
            int i2 = this.f10005a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 || this.q == 8 : this.q == 4 : this.q == 2 : this.q == 1;
        }
        return true;
    }

    public void b(int i2) {
        if (this.f10006b.settleCapturedViewAt(getPaddingLeft(), i2)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_SwipeBackLayout);
        setDirectionMode(obtainStyledAttributes.getInt(i.sapi_sdk_SwipeBackLayout_sapi_sdk_directionMode, this.f10005a));
        setSwipeBackFactor(obtainStyledAttributes.getFloat(i.sapi_sdk_SwipeBackLayout_sapi_sdk_swipeBackFactor, this.f10012h));
        setMaskAlpha(obtainStyledAttributes.getInteger(i.sapi_sdk_SwipeBackLayout_sapi_sdk_maskAlpha, this.j));
        this.k = obtainStyledAttributes.getBoolean(i.sapi_sdk_SwipeBackLayout_sapi_sdk_isSwipeFromEdge, this.k);
        obtainStyledAttributes.recycle();
    }

    public boolean b() {
        return this.k;
    }

    public void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundColor(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        viewGroup.addView(this);
    }

    public void a(int i2) {
        if (this.f10006b.settleCapturedViewAt(i2, getPaddingTop())) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        ((Activity) getContext()).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f2, float f3) {
        int i2 = this.f10005a;
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 == 8 && f3 < (-this.p) : f3 > this.p : f2 < (-this.p) : f2 > this.p;
    }
}
