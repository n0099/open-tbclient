package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@CoordinatorLayout.DefaultBehavior(Behavior.class)
/* loaded from: classes18.dex */
public class AppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private boolean mCollapsed;
    private boolean mCollapsible;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    private boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private List<OnOffsetChangedListener> mListeners;
    private int mPendingAction;
    private int[] mTmpStatesArray;
    private int mTotalScrollRange;

    /* loaded from: classes18.dex */
    public interface OnOffsetChangedListener {
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
        this.mPendingAction = 0;
        setOrientation(1);
        ThemeUtils.checkAppCompatTheme(context);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.AppBarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
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
        invalidateScrollRanges();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        invalidateScrollRanges();
        this.mHaveChildWithInterpolator = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).getScrollInterpolator() == null) {
                i5++;
            } else {
                this.mHaveChildWithInterpolator = true;
                break;
            }
        }
        updateCollapsible();
    }

    private void updateCollapsible() {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (!((LayoutParams) getChildAt(i).getLayoutParams()).isCollapsible()) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        setCollapsibleState(z);
    }

    private void invalidateScrollRanges() {
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
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
        setExpanded(z, z2, true);
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        this.mPendingAction = (z3 ? 8 : 0) | (z2 ? 4 : 0) | (z ? 1 : 2);
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
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean hasChildWithInterpolator() {
        return this.mHaveChildWithInterpolator;
    }

    public final int getTotalScrollRange() {
        int i;
        if (this.mTotalScrollRange != -1) {
            return this.mTotalScrollRange;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.mScrollFlags;
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
        this.mTotalScrollRange = max;
        return max;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int i;
        if (this.mDownPreScrollRange != -1) {
            return this.mDownPreScrollRange;
        }
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.mScrollFlags;
            if ((i3 & 5) == 5) {
                int i4 = layoutParams.bottomMargin + layoutParams.topMargin + i2;
                if ((i3 & 8) != 0) {
                    i = i4 + ViewCompat.getMinimumHeight(childAt);
                } else if ((i3 & 2) != 0) {
                    i = i4 + (measuredHeight - ViewCompat.getMinimumHeight(childAt));
                } else {
                    i = i4 + (measuredHeight - getTopInset());
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
        this.mDownPreScrollRange = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i;
        if (this.mDownScrollRange != -1) {
            return this.mDownScrollRange;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i4 = layoutParams.mScrollFlags;
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
        this.mDownScrollRange = max;
        return max;
    }

    void dispatchOffsetUpdates(int i) {
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
        if (this.mTmpStatesArray == null) {
            this.mTmpStatesArray = new int[2];
        }
        int[] iArr = this.mTmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.mCollapsible ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[1] = (this.mCollapsible && this.mCollapsed) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean setCollapsibleState(boolean z) {
        if (this.mCollapsible != z) {
            this.mCollapsible = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    boolean setCollapsedState(boolean z) {
        if (this.mCollapsed != z) {
            this.mCollapsed = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    int getPendingAction() {
        return this.mPendingAction;
    }

    void resetPendingAction() {
        this.mPendingAction = 0;
    }

    @VisibleForTesting
    final int getTopInset() {
        if (this.mLastInsets != null) {
            return this.mLastInsets.getSystemWindowInsetTop();
        }
        return 0;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }

    /* loaded from: classes18.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        int mScrollFlags;
        Interpolator mScrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes18.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mScrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.mScrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.mScrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mScrollFlags = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.mScrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mScrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mScrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.mScrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.mScrollFlags = 1;
            this.mScrollFlags = layoutParams.mScrollFlags;
            this.mScrollInterpolator = layoutParams.mScrollInterpolator;
        }

        public void setScrollFlags(int i) {
            this.mScrollFlags = i;
        }

        public int getScrollFlags() {
            return this.mScrollFlags;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.mScrollInterpolator = interpolator;
        }

        public Interpolator getScrollInterpolator() {
            return this.mScrollInterpolator;
        }

        boolean isCollapsible() {
            return (this.mScrollFlags & 1) == 1 && (this.mScrollFlags & 10) != 0;
        }
    }

    /* loaded from: classes18.dex */
    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private DragCallback mOnDragCallback;

        /* loaded from: classes18.dex */
        public static abstract class DragCallback {
            public abstract boolean canDrag(@NonNull AppBarLayout appBarLayout);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public Behavior() {
            this.mOffsetToChildIndexOnLayout = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOffsetToChildIndexOnLayout = -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && appBarLayout.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.mOffsetAnimator != null) {
                this.mOffsetAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    i5 = i4 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = scroll(coordinatorLayout, appBarLayout, i2, i4, i5);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                scroll(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            }
            this.mLastNestedScrollingChildRef = new WeakReference<>(view);
        }

        public void setDragCallback(@Nullable DragCallback dragCallback) {
            this.mOnDragCallback = dragCallback;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int height;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, appBarLayout, i, height);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                if (this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning()) {
                    this.mOffsetAnimator.cancel();
                    return;
                }
                return;
            }
            if (this.mOffsetAnimator == null) {
                this.mOffsetAnimator = new ValueAnimator();
                this.mOffsetAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.AppBarLayout.Behavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Behavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.mOffsetAnimator.cancel();
            }
            this.mOffsetAnimator.setDuration(Math.min(i2, 600));
            this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.mOffsetAnimator.start();
        }

        private int getChildIndexOnOffset(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = appBarLayout.getChildAt(childIndexOnOffset);
                int scrollFlags = ((LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (childIndexOnOffset == appBarLayout.getChildCount() - 1) {
                        i3 += appBarLayout.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i3 += ViewCompat.getMinimumHeight(childAt);
                        i = i2;
                    } else if (checkFlag(scrollFlags, 5)) {
                        i = ViewCompat.getMinimumHeight(childAt) + i3;
                        if (topBottomOffsetForScrollingSibling >= i) {
                            i3 = i;
                            i = i2;
                        }
                    } else {
                        i = i2;
                    }
                    if (topBottomOffsetForScrollingSibling >= (i3 + i) / 2) {
                        i3 = i;
                    }
                    animateOffsetTo(coordinatorLayout, appBarLayout, MathUtils.clamp(i3, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private static boolean checkFlag(int i, int i2) {
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
        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.mOffsetToChildIndexOnLayout >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.mOffsetToChildIndexOnLayout);
                int i2 = -childAt.getBottom();
                if (this.mOffsetToChildIndexOnLayoutIsMinHeight) {
                    round = ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset() + i2;
                } else {
                    round = Math.round(childAt.getHeight() * this.mOffsetToChildIndexOnLayoutPerc) + i2;
                }
                setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, i3, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.resetPendingAction();
            this.mOffsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            return onLayoutChild;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public boolean canDragView(AppBarLayout appBarLayout) {
            if (this.mOnDragCallback != null) {
                return this.mOnDragCallback.canDrag(appBarLayout);
            }
            if (this.mLastNestedScrollingChildRef != null) {
                View view = this.mLastNestedScrollingChildRef.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public void onFlingFinished(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            snapToChildIfNeeded(coordinatorLayout, appBarLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public int getMaxDragOffset(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public int getScrollRangeForDragFling(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (i2 != 0 && topBottomOffsetForScrollingSibling >= i2 && topBottomOffsetForScrollingSibling <= i3) {
                int clamp = MathUtils.clamp(i, i2, i3);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    int interpolateOffset = appBarLayout.hasChildWithInterpolator() ? interpolateOffset(appBarLayout, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i4 = topBottomOffsetForScrollingSibling - clamp;
                    this.mOffsetDelta = clamp - interpolateOffset;
                    if (!topAndBottomOffset && appBarLayout.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    return i4;
                }
                return 0;
            }
            this.mOffsetDelta = 0;
            return 0;
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            return this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning();
        }

        private int interpolateOffset(AppBarLayout appBarLayout, int i) {
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

        private void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            boolean z2 = false;
            View appBarChildOnOffset = getAppBarChildOnOffset(appBarLayout, i);
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i2 > 0 && (scrollFlags & 12) != 0) {
                        z2 = (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - appBarLayout.getTopInset();
                    } else if ((scrollFlags & 2) != 0) {
                        z2 = (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - appBarLayout.getTopInset();
                    }
                }
                boolean collapsedState = appBarLayout.setCollapsedState(z2);
                if (Build.VERSION.SDK_INT >= 11) {
                    if (z || (collapsedState && shouldJumpElevationState(coordinatorLayout, appBarLayout))) {
                        appBarLayout.jumpDrawablesToCurrentState();
                    }
                }
            }
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
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

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i) {
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

        @Override // android.support.design.widget.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.mOffsetDelta;
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
                    savedState.firstVisibleChildIndex = i;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
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
                this.mOffsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.mOffsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.mOffsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
            this.mOffsetToChildIndexOnLayout = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes18.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.AppBarLayout.Behavior.SavedState.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte((byte) (this.firstVisibleChildAtMinimumHeight ? 1 : 0));
            }
        }
    }

    /* loaded from: classes18.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
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
            offsetChildAsNeeded(coordinatorLayout, view, view2);
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.mTempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void offsetChildAsNeeded(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof Behavior) {
                ViewCompat.offsetTopAndBottom(view, ((((Behavior) behavior).mOffsetDelta + (view2.getBottom() - view.getTop())) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return 1.0f + (appBarLayoutOffset / i);
                }
                return 0.0f;
            }
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof Behavior) {
                return ((Behavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        AppBarLayout findFirstDependency(List<View> list) {
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
        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }
    }
}
