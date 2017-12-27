package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.s;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@CoordinatorLayout.DefaultBehavior(Behavior.class)
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout {
    private int kF;
    private int kG;
    private int kH;
    private boolean kI;
    private int kJ;
    private WindowInsetsCompat kK;
    private boolean kL;
    private boolean kM;
    private final int[] kN;
    private List<OnOffsetChangedListener> mListeners;

    /* loaded from: classes2.dex */
    public interface OnOffsetChangedListener {
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kF = -1;
        this.kG = -1;
        this.kH = -1;
        this.kJ = 0;
        this.kN = new int[2];
        setOrientation(1);
        r.R(context);
        if (Build.VERSION.SDK_INT >= 21) {
            aa.F(this);
            aa.a(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false));
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            aa.o(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.AppBarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.a(windowInsetsCompat);
            }
        });
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        if (onOffsetChangedListener != null && !this.mListeners.contains(onOffsetChangedListener)) {
            this.mListeners.add(onOffsetChangedListener);
        }
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners != null && onOffsetChangedListener != null) {
            this.mListeners.remove(onOffsetChangedListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        aT();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        aT();
        this.kI = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).getScrollInterpolator() == null) {
                i5++;
            } else {
                this.kI = true;
                break;
            }
        }
        aS();
    }

    private void aS() {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (!((LayoutParams) getChildAt(i).getLayoutParams()).aY()) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        g(z);
    }

    private void aT() {
        this.kF = -1;
        this.kG = -1;
        this.kH = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        this.kJ = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean aU() {
        return this.kI;
    }

    public final int getTotalScrollRange() {
        int i;
        if (this.kF != -1) {
            return this.kF;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.le;
            if ((i4 & 1) == 0) {
                break;
            }
            i2 += layoutParams.bottomMargin + measuredHeight + layoutParams.topMargin;
            if ((i4 & 2) != 0) {
                i = i2 - ViewCompat.getMinimumHeight(childAt);
                break;
            }
        }
        i = i2;
        int max = Math.max(0, i - getTopInset());
        this.kF = max;
        return max;
    }

    boolean aV() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int i;
        if (this.kG != -1) {
            return this.kG;
        }
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.le;
            if ((i3 & 5) == 5) {
                int i4 = layoutParams.bottomMargin + layoutParams.topMargin + i2;
                if ((i3 & 8) != 0) {
                    i = i4 + ViewCompat.getMinimumHeight(childAt);
                } else if ((i3 & 2) != 0) {
                    i = i4 + (measuredHeight - ViewCompat.getMinimumHeight(childAt));
                } else {
                    i = i4 + measuredHeight;
                }
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        int max = Math.max(0, i2);
        this.kG = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i;
        if (this.kH != -1) {
            return this.kH;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i4 = layoutParams.le;
            if ((i4 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i4 & 2) != 0) {
                i = i2 - (ViewCompat.getMinimumHeight(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        int max = Math.max(0, i);
        this.kH = max;
        return max;
    }

    void l(int i) {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnOffsetChangedListener onOffsetChangedListener = this.mListeners.get(i2);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
        if (minimumHeight2 != 0) {
            return (minimumHeight2 * 2) + topInset;
        }
        return getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArr = this.kN;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.kL ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[1] = (this.kL && this.kM) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean g(boolean z) {
        if (this.kL != z) {
            this.kL = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    boolean h(boolean z) {
        if (this.kM != z) {
            this.kM = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            aa.o(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    int getPendingAction() {
        return this.kJ;
    }

    void aW() {
        this.kJ = 0;
    }

    final int getTopInset() {
        if (this.kK != null) {
            return this.kK.getSystemWindowInsetTop();
        }
        return 0;
    }

    WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!z.d(this.kK, windowInsetsCompat2)) {
            this.kK = windowInsetsCompat2;
            aT();
        }
        return windowInsetsCompat;
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        int le;
        Interpolator lf;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        /* loaded from: classes2.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.le = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.le = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.lf = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.le = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.le = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.le = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.le = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.le = 1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.le = 1;
            this.le = layoutParams.le;
            this.lf = layoutParams.lf;
        }

        public void setScrollFlags(int i) {
            this.le = i;
        }

        public int getScrollFlags() {
            return this.le;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.lf = interpolator;
        }

        public Interpolator getScrollInterpolator() {
            return this.lf;
        }

        boolean aY() {
            return (this.le & 1) == 1 && (this.le & 10) != 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends k<AppBarLayout> {
        private int kP;
        private boolean kQ;
        private boolean kR;
        private s kS;
        private int kT;
        private boolean kU;
        private float kV;
        private WeakReference<View> kW;
        private DragCallback kX;

        /* loaded from: classes2.dex */
        public static abstract class DragCallback {
            public abstract boolean canDrag(AppBarLayout appBarLayout);
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public Behavior() {
            this.kT = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.kT = -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.aV() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.kS != null) {
                this.kS.cancel();
            }
            this.kW = null;
            return z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            int i3;
            int i4;
            if (i2 != 0 && !this.kQ) {
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    i4 = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    i4 = 0;
                }
                iArr[1] = b(coordinatorLayout, appBarLayout, i2, i3, i4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.kQ = true;
                return;
            }
            this.kQ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.kR) {
                a2(coordinatorLayout, appBarLayout);
            }
            this.kQ = false;
            this.kR = false;
            this.kW = new WeakReference<>(view);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = a(coordinatorLayout, (CoordinatorLayout) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                int downNestedPreScrollRange = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (aX() < downNestedPreScrollRange) {
                    a(coordinatorLayout, appBarLayout, downNestedPreScrollRange, f2);
                    z2 = true;
                }
            } else {
                int i = -appBarLayout.getUpNestedPreScrollRange();
                if (aX() > i) {
                    a(coordinatorLayout, appBarLayout, i, f2);
                    z2 = true;
                }
            }
            this.kR = z2;
            return z2;
        }

        public void setDragCallback(DragCallback dragCallback) {
            this.kX = dragCallback;
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int height;
            int abs = Math.abs(aX() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, appBarLayout, i, height);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int aX = aX();
            if (aX == i) {
                if (this.kS != null && this.kS.isRunning()) {
                    this.kS.cancel();
                    return;
                }
                return;
            }
            if (this.kS == null) {
                this.kS = z.cE();
                this.kS.setInterpolator(a.kE);
                this.kS.a(new s.c() { // from class: android.support.design.widget.AppBarLayout.Behavior.1
                    @Override // android.support.design.widget.s.c
                    public void a(s sVar) {
                        Behavior.this.a(coordinatorLayout, appBarLayout, sVar.cA());
                    }
                });
            } else {
                this.kS.cancel();
            }
            this.kS.setDuration(Math.min(i2, 600));
            this.kS.q(aX, i);
            this.kS.start();
        }

        private int a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        private void a2(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            int aX = aX();
            int a = a(appBarLayout, aX);
            if (a >= 0) {
                View childAt = appBarLayout.getChildAt(a);
                int scrollFlags = ((LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a == appBarLayout.getChildCount() - 1) {
                        i3 += appBarLayout.getTopInset();
                    }
                    if (l(scrollFlags, 2)) {
                        i3 += ViewCompat.getMinimumHeight(childAt);
                        i = i2;
                    } else if (l(scrollFlags, 5)) {
                        i = ViewCompat.getMinimumHeight(childAt) + i3;
                        if (aX >= i) {
                            i3 = i;
                            i = i2;
                        }
                    } else {
                        i = i2;
                    }
                    if (aX >= (i3 + i) / 2) {
                        i3 = i;
                    }
                    a(coordinatorLayout, appBarLayout, m.constrain(i3, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private static boolean l(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).height == -2) {
                coordinatorLayout.onMeasureChild(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.x, android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, appBarLayout, i2, 0.0f);
                    } else {
                        a(coordinatorLayout, appBarLayout, i2);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.kT >= 0) {
                View childAt = appBarLayout.getChildAt(this.kT);
                int i3 = -childAt.getBottom();
                if (this.kU) {
                    round = ViewCompat.getMinimumHeight(childAt) + i3;
                } else {
                    round = Math.round(childAt.getHeight() * this.kV) + i3;
                }
                setTopAndBottomOffset(round);
            }
            appBarLayout.aW();
            this.kT = -1;
            setTopAndBottomOffset(m.constrain(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            appBarLayout.l(getTopAndBottomOffset());
            return onLayoutChild;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.k
        /* renamed from: a */
        public boolean q(AppBarLayout appBarLayout) {
            if (this.kX != null) {
                return this.kX.canDrag(appBarLayout);
            }
            if (this.kW != null) {
                View view = this.kW.get();
                return (view == null || !view.isShown() || ViewCompat.canScrollVertically(view, -1)) ? false : true;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.k
        /* renamed from: b */
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            a2(coordinatorLayout, appBarLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.k
        /* renamed from: b */
        public int p(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.k
        /* renamed from: c */
        public int o(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.k
        public int a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int aX = aX();
            if (i2 != 0 && aX >= i2 && aX <= i3) {
                int constrain = m.constrain(i, i2, i3);
                if (aX != constrain) {
                    int b = appBarLayout.aU() ? b(appBarLayout, constrain) : constrain;
                    boolean topAndBottomOffset = setTopAndBottomOffset(b);
                    int i4 = aX - constrain;
                    this.kP = constrain - b;
                    if (!topAndBottomOffset && appBarLayout.aU()) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.l(getTopAndBottomOffset());
                    b(coordinatorLayout, appBarLayout, constrain, constrain < aX ? -1 : 1);
                    return i4;
                }
                return 0;
            }
            this.kP = 0;
            return 0;
        }

        private int b(AppBarLayout appBarLayout, int i) {
            int i2;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (scrollInterpolator != null) {
                        int scrollFlags = layoutParams.getScrollFlags();
                        if ((scrollFlags & 1) != 0) {
                            i2 = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin + 0;
                            if ((scrollFlags & 2) != 0) {
                                i2 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        } else {
                            i2 = 0;
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i2 -= appBarLayout.getTopInset();
                        }
                        if (i2 > 0) {
                            return Integer.signum(i) * (Math.round(scrollInterpolator.getInterpolation((abs - childAt.getTop()) / i2) * i2) + childAt.getTop());
                        }
                        return i;
                    } else {
                        return i;
                    }
                }
            }
            return i;
        }

        private void b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            boolean z = false;
            View c = c(appBarLayout, i);
            if (c != null) {
                int scrollFlags = ((LayoutParams) c.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(c);
                    if (i2 > 0 && (scrollFlags & 12) != 0) {
                        z = (-i) >= (c.getBottom() - minimumHeight) - appBarLayout.getTopInset();
                    } else if ((scrollFlags & 2) != 0) {
                        z = (-i) >= (c.getBottom() - minimumHeight) - appBarLayout.getTopInset();
                    }
                }
                if (appBarLayout.h(z) && Build.VERSION.SDK_INT >= 11 && c(coordinatorLayout, appBarLayout)) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List<View> dependents = coordinatorLayout.getDependents(appBarLayout);
            int size = dependents.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
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

        @Override // android.support.design.widget.k
        int aX() {
            return getTopAndBottomOffset() + this.kP;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.lb = i;
                    savedState.ld = bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                    savedState.lc = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, savedState.getSuperState());
                this.kT = savedState.lb;
                this.kV = savedState.lc;
                this.kU = savedState.ld;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
            this.kT = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.design.widget.AppBarLayout.Behavior.SavedState.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
                /* renamed from: m */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            int lb;
            float lc;
            boolean ld;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.lb = parcel.readInt();
                this.lc = parcel.readFloat();
                this.ld = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.lb);
                parcel.writeFloat(this.lc);
                parcel.writeByte((byte) (this.ld ? 1 : 0));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends l {
        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // android.support.design.widget.x, android.support.design.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        @Override // android.support.design.widget.l, android.support.design.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // android.support.design.widget.x
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(coordinatorLayout, view, view2);
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout f = f(coordinatorLayout.getDependencies(view));
            if (f != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.nF;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    f.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof Behavior) {
                ViewCompat.offsetTopAndBottom(view, ((((Behavior) behavior).kP + (view2.getBottom() - view.getTop())) + cb()) - C(view2));
            }
        }

        @Override // android.support.design.widget.l
        float r(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int d = d(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + d > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return 1.0f + (d / i);
                }
                return 0.0f;
            }
            return 0.0f;
        }

        private static int d(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof Behavior) {
                return ((Behavior) behavior).aX();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        /* renamed from: e */
        public AppBarLayout f(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        public int s(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.s(view);
        }
    }
}
