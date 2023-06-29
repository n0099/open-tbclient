package com.baidu.live.framework.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.bc0;
import com.baidu.tieba.zc0;
import java.lang.ref.WeakReference;
import java.util.List;
@CoordinatorLayout.c(Behavior.class)
/* loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public WindowInsetsCompat f;
    public List<b> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int[] l;

    /* loaded from: classes3.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t, int i);
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n;
        public boolean o;
        public float p;
        public WeakReference<View> q;
        public b r;

        /* loaded from: classes3.dex */
        public static abstract class b<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t);
        }

        public static boolean W(int i, int i2) {
            return (i & i2) == i2;
        }

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public BaseBehavior() {
            this.n = -1;
        }

        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        public int M() {
            return E() + this.k;
        }

        /* loaded from: classes3.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            /* loaded from: classes3.dex */
            public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                boolean z;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                if (parcel.readByte() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.firstVisibleChildAtMinimumHeight = z;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        public static View Y(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: d0 */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            p0(coordinatorLayout, t);
        }

        public final boolean o0(CoordinatorLayout coordinatorLayout, T t) {
            List<View> m = coordinatorLayout.m(t);
            int size = m.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) m.get(i).getLayoutParams()).e();
                if (e instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) e).K() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: U */
        public boolean H(T t) {
            b bVar = this.r;
            if (bVar != null) {
                return bVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view2 = weakReference.get();
            if (view2 != null && view2.isShown() && !view2.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final View X(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof NestedScrollingChild) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: a0 */
        public int K(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: b0 */
        public int L(T t) {
            return t.getTotalScrollRange();
        }

        public void m0(@Nullable b bVar) {
            this.r = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: f0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) t.getLayoutParams())).height == -2) {
                coordinatorLayout.D(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.m(coordinatorLayout, t, i, i2, i3, i4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: k0 */
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view2, View view3, int i, int i2) {
            boolean z;
            ValueAnimator valueAnimator;
            if ((i & 2) != 0 && (t.i() || V(coordinatorLayout, t, view2))) {
                z = true;
            } else {
                z = false;
            }
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i2;
            return z;
        }

        public final void S(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int abs = Math.abs(M() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            T(coordinatorLayout, t, i, height);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: l0 */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view2, int i) {
            if (this.l == 0 || i == 1) {
                p0(coordinatorLayout, t);
            }
            this.q = new WeakReference<>(view2);
        }

        public final void q0(int i, T t, View view2, int i2) {
            if (i2 == 1) {
                int M = M();
                if ((i < 0 && M == 0) || (i > 0 && M == (-t.getDownNestedScrollRange()))) {
                    ViewCompat.stopNestedScroll(view2, 1);
                }
            }
        }

        public final void T(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int M = M();
            if (M == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(new DecelerateInterpolator());
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, 600));
            this.m.setIntValues(M, i);
            this.m.start();
        }

        public final boolean V(CoordinatorLayout coordinatorLayout, T t, View view2) {
            if (t.g() && coordinatorLayout.getHeight() - view2.getHeight() <= t.getHeight()) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: i0 */
        public void x(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.x(coordinatorLayout, t, savedState.getSuperState());
                this.n = savedState.firstVisibleChildIndex;
                this.p = savedState.firstVisibleChildPercentageShown;
                this.o = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.x(coordinatorLayout, t, parcelable);
            this.n = -1;
        }

        public final int Z(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (W(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: j0 */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable y = super.y(coordinatorLayout, t);
            int E = E();
            int childCount = t.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(y);
                    savedState.firstVisibleChildIndex = i;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z;
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return y;
        }

        public final int c0(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (b2 != null) {
                        int a2 = layoutParams.a();
                        if ((a2 & 1) != 0) {
                            i2 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((a2 & 2) != 0) {
                                i2 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i2 -= t.getTopInset();
                        }
                        if (i2 > 0) {
                            float f = i2;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(f * b2.getInterpolation((abs - childAt.getTop()) / f)));
                        }
                    }
                } else {
                    i3++;
                }
            }
            return i;
        }

        public final void p0(CoordinatorLayout coordinatorLayout, T t) {
            int M = M();
            int Z = Z(t, M);
            if (Z >= 0) {
                View childAt = t.getChildAt(Z);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (Z == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (W(a2, 2)) {
                        i2 += ViewCompat.getMinimumHeight(childAt);
                    } else if (W(a2, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i2;
                        if (M < minimumHeight) {
                            i = minimumHeight;
                        } else {
                            i2 = minimumHeight;
                        }
                    }
                    if (W(a2, 32)) {
                        i += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i2 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (M < (i2 + i) / 2) {
                        i = i2;
                    }
                    S(coordinatorLayout, t, MathUtils.clamp(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior, com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: e0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i) {
            boolean z;
            int round;
            boolean l = super.l(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.o) {
                    round = ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                P(coordinatorLayout, t, i3 + round);
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        S(coordinatorLayout, t, i4, 0.0f);
                    } else {
                        P(coordinatorLayout, t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        S(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        P(coordinatorLayout, t, 0);
                    }
                }
            }
            t.k();
            this.n = -1;
            G(MathUtils.clamp(E(), -t.getTotalScrollRange(), 0));
            r0(coordinatorLayout, t, E(), 0, true);
            t.a(E());
            return l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: g0 */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view2, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i4 = i6;
                    i5 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = O(coordinatorLayout, t, i2, i4, i5);
                    q0(i2, t, view2, i3);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: h0 */
        public void s(CoordinatorLayout coordinatorLayout, T t, View view2, int i, int i2, int i3, int i4, int i5) {
            boolean z;
            if (i4 < 0) {
                O(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
                q0(i4, t, view2, i5);
            }
            if (t.i()) {
                if (view2.getScrollY() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                t.n(z);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: n0 */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int i4;
            int i5;
            int M = M();
            int i6 = 0;
            if (i2 != 0 && M >= i2 && M <= i3) {
                int clamp = MathUtils.clamp(i, i2, i3);
                if (M != clamp) {
                    if (t.e()) {
                        i4 = c0(t, clamp);
                    } else {
                        i4 = clamp;
                    }
                    boolean G = G(i4);
                    i6 = M - clamp;
                    this.k = clamp - i4;
                    if (!G && t.e()) {
                        coordinatorLayout.f(t);
                    }
                    t.a(E());
                    if (clamp < M) {
                        i5 = -1;
                    } else {
                        i5 = 1;
                    }
                    r0(coordinatorLayout, t, clamp, i5, false);
                }
            } else {
                this.k = 0;
            }
            return i6;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void r0(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            boolean z2;
            View X;
            View Y = Y(t, i);
            if (Y != null) {
                int a2 = ((LayoutParams) Y.getLayoutParams()).a();
                boolean z3 = true;
                if ((a2 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(Y);
                    if (i2 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i) < (Y.getBottom() - minimumHeight) - t.getTopInset()) : (-i) >= (Y.getBottom() - minimumHeight) - t.getTopInset()) {
                        z2 = true;
                        if (t.i() && (X = X(coordinatorLayout)) != null) {
                            if (X.getScrollY() <= 0) {
                                z3 = false;
                            }
                            z2 = z3;
                        }
                        boolean n = t.n(z2);
                        if (!z || (n && o0(coordinatorLayout, t))) {
                            t.jumpDrawablesToCurrentState();
                        }
                        return;
                    }
                }
                z2 = false;
                if (t.i()) {
                    if (X.getScrollY() <= 0) {
                    }
                    z2 = z3;
                }
                boolean n2 = t.n(z2);
                if (!z) {
                }
                t.jumpDrawablesToCurrentState();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* loaded from: classes3.dex */
        public static abstract class a extends BaseBehavior.b<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int a;
        public Interpolator b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bc0.LiveAppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        public boolean c() {
            int i = this.a;
            if ((i & 1) == 1 && (i & 10) != 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bc0.LiveScrollingViewBehavior_Layout);
            if (obtainStyledAttributes.hasValue(0)) {
                O(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public final void R(View view2, View view3) {
            CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) view3.getLayoutParams()).e();
            if (e instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view2, (((view3.getBottom() - view2.getTop()) + ((BaseBehavior) e).k) + M()) - I(view3));
            }
        }

        public final void S(View view2, View view3) {
            boolean z;
            if (view3 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view3;
                if (appBarLayout.i()) {
                    if (view2.getScrollY() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    appBarLayout.n(z);
                }
            }
        }

        public static int Q(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).e();
            if (e instanceof BaseBehavior) {
                return ((BaseBehavior) e).M();
            }
            return 0;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public float J(View view2) {
            int i;
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int Q = Q(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + Q > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (Q / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public int L(View view2) {
            if (view2 instanceof AppBarLayout) {
                return ((AppBarLayout) view2).getTotalScrollRange();
            }
            return super.L(view2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        /* renamed from: P */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view2 = list.get(i);
                if (view2 instanceof AppBarLayout) {
                    return (AppBarLayout) view2;
                }
            }
            return null;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean e(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            return view3 instanceof AppBarLayout;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean h(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            R(view2, view3);
            S(view2, view3);
            return false;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean w(CoordinatorLayout coordinatorLayout, View view2, Rect rect, boolean z) {
            AppBarLayout H = H(coordinatorLayout.l(view2));
            if (H != null) {
                rect.offset(view2.getLeft(), view2.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    H.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout.this.j(windowInsetsCompat);
            return windowInsetsCompat;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public void a(int i) {
        List<b> list = this.g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.g.get(i2);
                if (bVar != null) {
                    bVar.a(this, i);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public WindowInsetsCompat j(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.f, windowInsetsCompat2)) {
            this.f = windowInsetsCompat2;
            h();
        }
        return windowInsetsCompat;
    }

    public final boolean m(boolean z) {
        if (this.i != z) {
            this.i = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public boolean n(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            return;
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            zc0.b(this, f);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            zc0.a(this);
            zc0.c(this, attributeSet, 0, R.style.obfuscated_res_0x7f10012c);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bc0.LiveAppBarLayout, 0, R.style.obfuscated_res_0x7f10012c);
        if (obtainStyledAttributes.hasValue(2)) {
            l(obtainStyledAttributes.getBoolean(2, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(1)) {
            zc0.b(this, obtainStyledAttributes.getDimensionPixelSize(1, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(3)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(3, false));
            }
            if (obtainStyledAttributes.hasValue(7)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(7, false));
            }
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.k = obtainStyledAttributes.getBoolean(4, false);
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public boolean e() {
        return this.d;
    }

    public final boolean f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    public int getPendingAction() {
        return this.e;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    public boolean i() {
        return this.k;
    }

    public void k() {
        this.e = 0;
    }

    public int getDownNestedPreScrollRange() {
        int topInset;
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.a;
            if ((i3 & 5) == 5) {
                int i4 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i3 & 8) != 0) {
                    i2 = i4 + ViewCompat.getMinimumHeight(childAt);
                } else {
                    if ((i3 & 2) != 0) {
                        topInset = ViewCompat.getMinimumHeight(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i2 = i4 + (measuredHeight - topInset);
                }
            } else if (i2 > 0) {
                break;
            }
        }
        int max = Math.max(0, i2);
        this.b = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.c = max;
        return max;
    }

    public final int getTotalScrollRange() {
        int i = this.a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.a = max;
        return max;
    }

    public final void l(boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        int i3 = 0;
        if (z2) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        int i4 = i | i2;
        if (z3) {
            i3 = 8;
        }
        this.e = i4 | i3;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        if (this.i) {
            i2 = R.attr.obfuscated_res_0x7f0404bc;
        } else {
            i2 = -2130969788;
        }
        iArr[0] = i2;
        if (this.i && this.j) {
            i3 = R.attr.obfuscated_res_0x7f0404bd;
        } else {
            i3 = -2130969789;
        }
        iArr[1] = i3;
        if (this.i) {
            i4 = R.attr.obfuscated_res_0x7f0404bb;
        } else {
            i4 = -2130969787;
        }
        iArr[2] = i4;
        if (this.i && this.j) {
            i5 = R.attr.obfuscated_res_0x7f0404ba;
        } else {
            i5 = -2130969786;
        }
        iArr[3] = i5;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        h();
        boolean z2 = false;
        this.d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            } else {
                i5++;
            }
        }
        if (!this.h) {
            m((this.k || f()) ? true : true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        h();
    }

    public void setExpanded(boolean z, boolean z2) {
        l(z, z2, true);
    }
}
