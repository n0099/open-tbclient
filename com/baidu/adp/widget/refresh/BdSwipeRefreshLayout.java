package com.baidu.adp.widget.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* loaded from: classes.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] N = {16842766};
    public int A;
    public float B;
    public int C;
    public int D;
    public Animation E;
    public Animation F;
    public boolean G;
    public int H;
    public boolean I;
    public j J;
    public Animation.AnimationListener K;
    public final Animation L;
    public final Animation M;

    /* renamed from: e  reason: collision with root package name */
    public int f2470e;

    /* renamed from: f  reason: collision with root package name */
    public View f2471f;

    /* renamed from: g  reason: collision with root package name */
    public k f2472g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2473h;

    /* renamed from: i  reason: collision with root package name */
    public int f2474i;
    public float j;
    public float k;
    public final NestedScrollingParentHelper l;
    public final NestedScrollingChildHelper m;
    public final int[] n;
    public final int[] o;
    public boolean p;
    public int q;
    public float r;
    public float s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public final DecelerateInterpolator x;
    public i y;
    public int z;

    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = BdSwipeRefreshLayout.this;
            if (bdSwipeRefreshLayout.f2473h) {
                bdSwipeRefreshLayout.w();
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = BdSwipeRefreshLayout.this;
                bdSwipeRefreshLayout2.q = bdSwipeRefreshLayout2.y.getView().getTop();
                return;
            }
            bdSwipeRefreshLayout.y();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BdSwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = BdSwipeRefreshLayout.this;
            if (!bdSwipeRefreshLayout.v) {
                bdSwipeRefreshLayout.C(null);
            }
            BdSwipeRefreshLayout.this.m();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class d extends Animation {
        public d() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            BdSwipeRefreshLayout bdSwipeRefreshLayout = BdSwipeRefreshLayout.this;
            if (!bdSwipeRefreshLayout.I) {
                i2 = bdSwipeRefreshLayout.D - Math.abs(bdSwipeRefreshLayout.C);
            } else {
                i2 = bdSwipeRefreshLayout.D;
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout2 = BdSwipeRefreshLayout.this;
            int i3 = bdSwipeRefreshLayout2.A;
            BdSwipeRefreshLayout.this.A((i3 + ((int) ((i2 - i3) * f2))) - bdSwipeRefreshLayout2.y.getView().getTop(), false, "AnimateToCorrectPosition");
        }
    }

    /* loaded from: classes.dex */
    public class e extends Animation {
        public e() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BdSwipeRefreshLayout.this.t(f2);
        }
    }

    /* loaded from: classes.dex */
    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = BdSwipeRefreshLayout.this;
            float f3 = bdSwipeRefreshLayout.B;
            bdSwipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            BdSwipeRefreshLayout.this.t(f2);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = BdSwipeRefreshLayout.this;
            bdSwipeRefreshLayout.h(bdSwipeRefreshLayout.q, bdSwipeRefreshLayout.K);
        }
    }

    /* loaded from: classes.dex */
    public class h implements i {

        /* renamed from: e  reason: collision with root package name */
        public BdCircleImageView f2482e;

        /* renamed from: f  reason: collision with root package name */
        public d.a.c.j.k.a f2483f;

        /* renamed from: g  reason: collision with root package name */
        public Animation f2484g;

        /* renamed from: h  reason: collision with root package name */
        public Animation f2485h;

        /* loaded from: classes.dex */
        public class a extends Animation {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f2487e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f2488f;

            public a(int i2, int i3) {
                this.f2487e = i2;
                this.f2488f = i3;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                d.a.c.j.k.a aVar = h.this.f2483f;
                int i2 = this.f2487e;
                aVar.setAlpha((int) (i2 + ((this.f2488f - i2) * f2)));
            }
        }

        public h(Context context) {
            this.f2482e = new BdCircleImageView(BdSwipeRefreshLayout.this.getContext(), SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            d.a.c.j.k.a aVar = new d.a.c.j.k.a(context, this.f2482e);
            this.f2483f = aVar;
            aVar.e(SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            this.f2482e.setImageDrawable(this.f2483f);
            this.f2482e.setVisibility(8);
        }

        public void a(@ColorInt int i2) {
            this.f2482e.setBackgroundColor(i2);
            this.f2483f.e(i2);
        }

        public void b(@ColorInt int... iArr) {
            this.f2483f.f(iArr);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void c() {
            this.f2483f.setAlpha(76);
            this.f2483f.l(true);
            if (this.f2483f.getAlpha() <= 76 || BdSwipeRefreshLayout.this.q(this.f2484g)) {
                return;
            }
            o();
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void d() {
            if (this.f2483f.getAlpha() >= 255 || BdSwipeRefreshLayout.this.q(this.f2485h)) {
                return;
            }
            n();
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void e(float f2, float f3) {
            this.f2483f.j(0.0f, Math.min(0.8f, f2 * 0.8f));
            this.f2483f.d(Math.min(1.0f, f2));
            this.f2483f.g((((f2 * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public long getCompleteAnimTime() {
            return 0L;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public View getView() {
            return this.f2482e;
        }

        public void i(int i2) {
            this.f2482e.setImageDrawable(null);
            this.f2483f.n(i2);
            this.f2482e.setImageDrawable(this.f2483f);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void k() {
        }

        @SuppressLint({"NewApi"})
        public final Animation l(int i2, int i3) {
            if (BdSwipeRefreshLayout.this.p()) {
                return null;
            }
            a aVar = new a(i2, i3);
            aVar.setDuration(300L);
            this.f2482e.setAnimationListener(null);
            this.f2482e.clearAnimation();
            this.f2482e.startAnimation(aVar);
            return aVar;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void m() {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f2483f.setAlpha(255);
            }
            this.f2483f.d(0.0f);
            this.f2483f.setAlpha(255);
            this.f2483f.start();
        }

        @SuppressLint({"NewApi"})
        public final void n() {
            this.f2485h = l(this.f2483f.getAlpha(), 255);
        }

        @SuppressLint({"NewApi"})
        public final void o() {
            this.f2484g = l(this.f2483f.getAlpha(), 76);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onFinish() {
            this.f2483f.j(0.0f, 0.0f);
            this.f2483f.stop();
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void c();

        void d();

        void e(float f2, float f3);

        long getCompleteAnimTime();

        View getView();

        void k();

        void m();

        void onFinish();
    }

    /* loaded from: classes.dex */
    public interface j {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, @Nullable View view);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onRefresh();
    }

    public BdSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i2) {
        i iVar = this.y;
        if (iVar == null || iVar.getView() == null || this.y.getView().getBackground() == null) {
            return;
        }
        this.y.getView().getBackground().setAlpha(i2);
    }

    public void A(int i2, boolean z, String str) {
        this.y.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.y.getView(), i2);
        View view = this.f2471f;
        if (view != null) {
            ViewCompat.offsetTopAndBottom(view, i2);
        }
        this.q = this.y.getView().getTop();
        if (!z || Build.VERSION.SDK_INT >= 11) {
            return;
        }
        invalidate();
    }

    @SuppressLint({"NewApi"})
    public final void B(float f2, String str) {
        float f3 = this.s;
        int i2 = this.f2474i;
        if (f2 - f3 <= i2 || this.t) {
            return;
        }
        this.r = f3 + i2;
        this.t = true;
    }

    public void C(Animation.AnimationListener animationListener) {
        b bVar = new b();
        this.E = bVar;
        bVar.setDuration(150L);
        this.E.setAnimationListener(animationListener);
        this.y.getView().clearAnimation();
        this.y.getView().startAnimation(this.E);
    }

    @SuppressLint({"NewApi"})
    public final void D(int i2, Animation.AnimationListener animationListener) {
        this.A = i2;
        this.B = ViewCompat.getScaleX(this.y.getView());
        f fVar = new f();
        this.F = fVar;
        fVar.setDuration(150L);
        if (animationListener != null) {
            this.F.setAnimationListener(animationListener);
        }
        this.y.getView().clearAnimation();
        this.y.getView().startAnimation(this.F);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.m.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.m.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.m.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.m.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g(int i2, Animation.AnimationListener animationListener) {
        this.A = i2;
        this.L.reset();
        this.L.setDuration(200L);
        this.L.setInterpolator(this.x);
        if (animationListener != null) {
            this.L.setAnimationListener(animationListener);
        }
        if (this.y.getView().getVisibility() != 0) {
            this.y.getView().setVisibility(0);
        }
        this.y.getView().clearAnimation();
        this.y.getView().startAnimation(this.L);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.z;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.l.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.H;
    }

    public int getProgressViewEndOffset() {
        return this.D;
    }

    public int getProgressViewStartOffset() {
        return this.C;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        if (this.v) {
            D(i2, animationListener);
            return;
        }
        this.A = i2;
        this.M.reset();
        this.M.setDuration(200L);
        this.M.setInterpolator(this.x);
        if (animationListener != null) {
            this.M.setAnimationListener(animationListener);
        }
        this.y.getView().clearAnimation();
        this.y.getView().startAnimation(this.M);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.m.hasNestedScrollingParent();
    }

    public boolean i() {
        j jVar = this.J;
        if (jVar != null) {
            return jVar.a(this, this.f2471f);
        }
        if (Build.VERSION.SDK_INT < 14) {
            View view = this.f2471f;
            if (!(view instanceof AbsListView)) {
                return ViewCompat.canScrollVertically(view, -1) || this.f2471f.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return ViewCompat.canScrollVertically(this.f2471f, -1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.m.isNestedScrollingEnabled();
    }

    public final void j() {
        this.f2470e = 3;
        this.y.k();
        postDelayed(new g(), this.y.getCompleteAnimTime());
    }

    public final void k() {
        h hVar = new h(getContext());
        this.y = hVar;
        addView(hVar.getView());
    }

    public final void l() {
        if (this.f2471f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.y.getView())) {
                    this.f2471f = childAt;
                    return;
                }
            }
        }
    }

    public final void m() {
        this.f2470e = 4;
        this.y.getView().clearAnimation();
        this.y.onFinish();
    }

    public final void n(float f2, String str) {
        if (f2 > this.j) {
            z(true, true);
            return;
        }
        this.f2473h = false;
        h(this.q, this.v ? null : new c());
    }

    public void o() {
        l();
        this.f2473h = false;
        t(1.0f);
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        l();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.w && actionMasked == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || i() || this.p) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.u;
                    if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    B(motionEvent.getY(findPointerIndex), "onInterceptTouchEvent");
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        u(motionEvent);
                    }
                }
            }
            this.t = false;
            this.u = -1;
        } else {
            int pointerId = motionEvent.getPointerId(0);
            this.u = pointerId;
            this.t = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.s = motionEvent.getY(findPointerIndex2);
        }
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2471f == null) {
            l();
        }
        View view = this.f2471f;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + this.q) - this.C;
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.y.getView().getMeasuredWidth();
        int measuredHeight2 = this.y.getView().getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.q;
        this.y.getView().layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2471f == null) {
            l();
        }
        View view = this.f2471f;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.y.getView().measure(View.MeasureSpec.makeMeasureSpec(this.H, 1073741824), View.MeasureSpec.makeMeasureSpec(this.H, 1073741824));
        this.z = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.y.getView()) {
                this.z = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int i2;
        int i3 = this.f2470e;
        if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.q) > this.C) {
            h(i2, null);
        }
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int i2 = this.f2470e;
        if (i2 == 3 || i2 == 2 || this.y.getView() == null || this.y.getView().getBottom() <= 0) {
            return dispatchNestedPreFling(f2, f3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.k;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.k = 0.0f;
                } else {
                    this.k = f2 - f3;
                    iArr[1] = i3;
                }
                s(this.k, "onNestedPreScroll-2");
            }
        }
        if (this.I && i3 > 0 && this.k == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.y.getView().setVisibility(8);
        }
        int[] iArr2 = this.n;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
        int i4 = i3 - iArr[1];
        if ((r() || this.f2470e == 3) && Math.abs(i4) > 0) {
            if ((i4 <= 0 || this.q <= this.C) && (i4 >= 0 || this.q >= this.C + this.D || i())) {
                return;
            }
            s(Math.max(Math.min(this.D, (this.q - this.C) - i4), 0.0f), "onNestedPreScroll-1");
            iArr[1] = iArr[1] + i4;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.o);
        int i6 = i5 + this.o[1];
        if (i6 >= 0 || i() || this.f2473h) {
            return;
        }
        float abs = this.k + Math.abs(i6);
        this.k = abs;
        s(abs, "onNestedScroll");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.l.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.k = 0.0f;
        this.p = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.w || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.l.onStopNestedScroll(view);
        this.p = false;
        float f2 = this.k;
        if (f2 > 0.0f) {
            n(f2, "onStopNestedScroll");
            this.k = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.w && actionMasked == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || i() || this.f2473h || this.p) {
            return false;
        }
        if (actionMasked == 0) {
            this.u = motionEvent.getPointerId(0);
            this.t = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.u);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.t) {
                this.t = false;
                n((motionEvent.getY(findPointerIndex) - this.r) * 0.5f, "onTouchEvent(ACTION_UP)");
            }
            this.u = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.u);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            B(y, "onTouchEvent");
            if (this.t) {
                float f2 = (y - this.r) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                s(f2, "onTouchEvent(ACTION_MOVE)");
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex < 0) {
                    return false;
                }
                this.u = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                u(motionEvent);
            }
        }
        return true;
    }

    public final boolean p() {
        return Build.VERSION.SDK_INT < 11;
    }

    public final boolean q(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public boolean r() {
        return this.f2473h;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2471f instanceof AbsListView)) {
            View view = this.f2471f;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void s(float f2, String str) {
        int i2;
        float min = Math.min(1.0f, Math.abs(f2 / this.j));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.j;
        float f3 = this.I ? this.D - this.C : this.D;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.C + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.y.getView().getVisibility() != 0) {
            this.y.getView().setVisibility(0);
        }
        if (!this.v) {
            ViewCompat.setScaleX(this.y.getView(), 1.0f);
            ViewCompat.setScaleY(this.y.getView(), 1.0f);
        }
        if (this.v) {
            setAnimationProgress(Math.min(1.0f, f2 / this.j));
        }
        if (!this.f2473h && (i2 = this.f2470e) != 3) {
            int i4 = this.C;
            int i5 = this.q;
            if (i4 >= i5 || i5 >= i4 + this.D) {
                if (this.q >= this.C + this.D && this.f2470e != 1) {
                    x();
                }
            } else if (i2 != 0) {
                v();
            }
            this.y.e(max, pow);
        }
        A(i3 - this.q, true, "moveSpinner");
    }

    public void setAnimationProgress(float f2) {
        if (p()) {
            setColorViewAlpha((int) (f2 * 255.0f));
            return;
        }
        ViewCompat.setScaleX(this.y.getView(), f2);
        ViewCompat.setScaleY(this.y.getView(), f2);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        l();
        i iVar = this.y;
        if (iVar instanceof h) {
            ((h) iVar).b(iArr);
        }
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = getContext().getResources().getColor(iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.j = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        y();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.m.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(@Nullable j jVar) {
        this.J = jVar;
    }

    public void setOnRefreshListener(k kVar) {
        this.f2472g = kVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        i iVar = this.y;
        if (iVar instanceof h) {
            ((h) iVar).a(i2);
        }
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(getContext().getResources().getColor(i2));
    }

    public void setProgressView(i iVar) {
        i iVar2;
        if (iVar == null || iVar.getView() == null || iVar == (iVar2 = this.y) || this.f2470e != 4) {
            return;
        }
        removeView(iVar2.getView());
        this.y = iVar;
        iVar.getView().setVisibility(8);
        addView(this.y.getView(), 0);
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        this.D = i2;
        this.v = z;
        this.y.getView().invalidate();
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        this.v = z;
        this.C = i2;
        this.D = i3;
        this.I = true;
        y();
        this.f2473h = false;
    }

    public void setRefreshing(boolean z) {
        if (z && this.f2473h != z) {
            z(z, false);
        } else {
            z(z, false);
        }
    }

    public void setSize(int i2) {
        if ((i2 == 0 || i2 == 1) && (this.y instanceof h)) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.H = (int) (displayMetrics.density * 56.0f);
            } else {
                this.H = (int) (displayMetrics.density * 61.0f);
            }
            ((h) this.y).i(i2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.m.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.m.stopNestedScroll();
    }

    public void t(float f2) {
        int i2 = this.A;
        A((i2 + ((int) ((this.C - i2) * f2))) - this.y.getView().getTop(), false, "moveToStart");
    }

    public final void u(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.u) {
            this.u = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public final void v() {
        this.f2470e = 0;
        this.y.c();
    }

    public final void w() {
        k kVar;
        this.f2470e = 2;
        this.y.m();
        if (!this.G || (kVar = this.f2472g) == null) {
            return;
        }
        kVar.onRefresh();
    }

    public final void x() {
        this.f2470e = 1;
        this.y.d();
    }

    public void y() {
        m();
        this.y.getView().setVisibility(8);
        setColorViewAlpha(255);
        if (this.v) {
            setAnimationProgress(0.0f);
        } else {
            A(this.C - this.q, true, "reset");
        }
        this.q = this.y.getView().getTop();
    }

    public final void z(boolean z, boolean z2) {
        if (this.f2473h != z) {
            this.G = z2;
            l();
            this.f2473h = z;
            if (z) {
                g(this.q, this.K);
            } else {
                j();
            }
        }
    }

    public BdSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2470e = 4;
        this.f2473h = false;
        this.j = -1.0f;
        this.n = new int[2];
        this.o = new int[2];
        this.u = -1;
        this.z = -1;
        this.K = new a();
        this.L = new d();
        this.M = new e();
        this.f2474i = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.H = displayMetrics.widthPixels;
        k();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int i2 = (int) (displayMetrics.density * 86.0f);
        this.D = i2;
        this.j = i2;
        this.l = new NestedScrollingParentHelper(this);
        this.m = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.H;
        this.q = i3;
        this.C = i3;
        t(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
