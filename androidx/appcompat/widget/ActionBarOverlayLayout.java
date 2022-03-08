package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_BAR_ANIMATE_DELAY = 600;
    public static final int[] ATTRS;
    public static final String TAG = "ActionBarOverlayLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public int mActionBarHeight;
    public ActionBarContainer mActionBarTop;
    public ActionBarVisibilityCallback mActionBarVisibilityCallback;
    public final Runnable mAddActionBarHideOffset;
    public boolean mAnimatingForFling;
    public final Rect mBaseContentInsets;
    @NonNull
    public WindowInsetsCompat mBaseInnerInsets;
    public final Rect mBaseInnerInsetsRect;
    public ContentFrameLayout mContent;
    public final Rect mContentInsets;
    public ViewPropertyAnimator mCurrentActionBarTopAnimator;
    public DecorToolbar mDecorToolbar;
    public OverScroller mFlingEstimator;
    public boolean mHasNonEmbeddedTabs;
    public boolean mHideOnContentScroll;
    public int mHideOnContentScrollReference;
    public boolean mIgnoreWindowContentOverlay;
    @NonNull
    public WindowInsetsCompat mInnerInsets;
    public final Rect mInnerInsetsRect;
    public final Rect mLastBaseContentInsets;
    @NonNull
    public WindowInsetsCompat mLastBaseInnerInsets;
    public final Rect mLastBaseInnerInsetsRect;
    @NonNull
    public WindowInsetsCompat mLastInnerInsets;
    public final Rect mLastInnerInsetsRect;
    public int mLastSystemUiVisibility;
    public boolean mOverlayMode;
    public final NestedScrollingParentHelper mParentHelper;
    public final Runnable mRemoveActionBarHideOffset;
    public final AnimatorListenerAdapter mTopAnimatorListener;
    public Drawable mWindowContentOverlay;
    public int mWindowVisibility;

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i2);

        void showForSystem();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2059334553, "Landroidx/appcompat/widget/ActionBarOverlayLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2059334553, "Landroidx/appcompat/widget/ActionBarOverlayLayout;");
                return;
            }
        }
        ATTRS = new int[]{R$attr.actionBarSize, 16842841};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addActionBarHideOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            haltActionBarHideOffsetAnimations();
            this.mAddActionBarHideOffset.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean applyInsets(@NonNull View view, @NonNull Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{view, rect, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (z) {
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int i3 = rect.left;
                if (i2 != i3) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
                    z5 = true;
                    if (z2) {
                        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        int i5 = rect.top;
                        if (i4 != i5) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i5;
                            z5 = true;
                        }
                    }
                    if (z4) {
                        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        int i7 = rect.right;
                        if (i6 != i7) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i7;
                            z5 = true;
                        }
                    }
                    if (z3) {
                        int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        int i9 = rect.bottom;
                        if (i8 != i9) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i9;
                            return true;
                        }
                    }
                    return z5;
                }
            }
            z5 = false;
            if (z2) {
            }
            if (z4) {
            }
            if (z3) {
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    private DecorToolbar getDecorToolbar(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, view)) == null) {
            if (view instanceof DecorToolbar) {
                return (DecorToolbar) view;
            }
            if (view instanceof Toolbar) {
                return ((Toolbar) view).getWrapper();
            }
            throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
        }
        return (DecorToolbar) invokeL.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
            this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            this.mWindowContentOverlay = drawable;
            setWillNotDraw(drawable == null);
            obtainStyledAttributes.recycle();
            this.mIgnoreWindowContentOverlay = context.getApplicationInfo().targetSdkVersion < 19;
            this.mFlingEstimator = new OverScroller(context);
        }
    }

    private void postAddActionBarHideOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mAddActionBarHideOffset, 600L);
        }
    }

    private void postRemoveActionBarHideOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mRemoveActionBarHideOffset, 600L);
        }
    }

    private void removeActionBarHideOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            haltActionBarHideOffsetAnimations();
            this.mRemoveActionBarHideOffset.run();
        }
    }

    private boolean shouldHideActionBarOnFling(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65546, this, f2)) == null) {
            this.mFlingEstimator.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight();
        }
        return invokeF.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.canShowOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pullChildren();
            this.mDecorToolbar.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (this.mWindowContentOverlay == null || this.mIgnoreWindowContentOverlay) {
                return;
            }
            int bottom = this.mActionBarTop.getVisibility() == 0 ? (int) (this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5f) : 0;
            this.mWindowContentOverlay.setBounds(0, bottom, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + bottom);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rect)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return super.fitSystemWindows(rect);
            }
            pullChildren();
            boolean applyInsets = applyInsets(this.mActionBarTop, rect, true, true, false, true);
            this.mBaseInnerInsetsRect.set(rect);
            ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsetsRect, this.mBaseContentInsets);
            if (!this.mLastBaseInnerInsetsRect.equals(this.mBaseInnerInsetsRect)) {
                this.mLastBaseInnerInsetsRect.set(this.mBaseInnerInsetsRect);
                applyInsets = true;
            }
            if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
                this.mLastBaseContentInsets.set(this.mBaseContentInsets);
                applyInsets = true;
            }
            if (applyInsets) {
                requestLayout();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int getActionBarHideOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ActionBarContainer actionBarContainer = this.mActionBarTop;
            if (actionBarContainer != null) {
                return -((int) actionBarContainer.getTranslationY());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mParentHelper.getNestedScrollAxes() : invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.getTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    public void haltActionBarHideOffsetAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            removeCallbacks(this.mRemoveActionBarHideOffset);
            removeCallbacks(this.mAddActionBarHideOffset);
            ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.hasIcon();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.hasLogo();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.hideOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            pullChildren();
            if (i2 == 2) {
                this.mDecorToolbar.initProgress();
            } else if (i2 == 5) {
                this.mDecorToolbar.initIndeterminateProgress();
            } else if (i2 != 109) {
            } else {
                setOverlayMode(true);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mHideOnContentScroll : invokeV.booleanValue;
    }

    public boolean isInOverlayMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mOverlayMode : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.isOverflowMenuShowPending();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.isOverflowMenuShowing();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, windowInsets)) == null) {
            pullChildren();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
            boolean applyInsets = applyInsets(this.mActionBarTop, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
            ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.mBaseContentInsets);
            Rect rect = this.mBaseContentInsets;
            WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
            this.mBaseInnerInsets = inset;
            boolean z = true;
            if (!this.mLastBaseInnerInsets.equals(inset)) {
                this.mLastBaseInnerInsets = this.mBaseInnerInsets;
                applyInsets = true;
            }
            if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
                z = applyInsets;
            } else {
                this.mLastBaseContentInsets.set(this.mBaseContentInsets);
            }
            if (z) {
                requestLayout();
            }
            return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            init(getContext());
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetachedFromWindow();
            haltActionBarHideOffsetAnimations();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                    childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            pullChildren();
            measureChildWithMargins(this.mActionBarTop, i2, 0, i3, 0);
            LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
            int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
            int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            int combineMeasuredStates = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
            boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
            if (z) {
                measuredHeight = this.mActionBarHeight;
                if (this.mHasNonEmbeddedTabs && this.mActionBarTop.getTabContainer() != null) {
                    measuredHeight += this.mActionBarHeight;
                }
            } else {
                measuredHeight = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
            }
            this.mContentInsets.set(this.mBaseContentInsets);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mInnerInsets = this.mBaseInnerInsets;
            } else {
                this.mInnerInsetsRect.set(this.mBaseInnerInsetsRect);
            }
            if (!this.mOverlayMode && !z) {
                Rect rect = this.mContentInsets;
                rect.top += measuredHeight;
                rect.bottom += 0;
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mInnerInsets = this.mInnerInsets.inset(0, measuredHeight, 0, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(this.mInnerInsets.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + measuredHeight, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0)).build();
            } else {
                Rect rect2 = this.mInnerInsetsRect;
                rect2.top += measuredHeight;
                rect2.bottom += 0;
            }
            applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
            if (Build.VERSION.SDK_INT >= 21 && !this.mLastInnerInsets.equals(this.mInnerInsets)) {
                WindowInsetsCompat windowInsetsCompat = this.mInnerInsets;
                this.mLastInnerInsets = windowInsetsCompat;
                ViewCompat.dispatchApplyWindowInsets(this.mContent, windowInsetsCompat);
            } else if (Build.VERSION.SDK_INT < 21 && !this.mLastInnerInsetsRect.equals(this.mInnerInsetsRect)) {
                this.mLastInnerInsetsRect.set(this.mInnerInsetsRect);
                this.mContent.dispatchFitSystemWindows(this.mInnerInsetsRect);
            }
            measureChildWithMargins(this.mContent, i2, 0, i3, 0);
            LayoutParams layoutParams2 = (LayoutParams) this.mContent.getLayoutParams();
            int max3 = Math.max(max, this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
            int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
            int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.mContent.getMeasuredState());
            setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (this.mHideOnContentScroll && z) {
                if (shouldHideActionBarOnFling(f3)) {
                    addActionBarHideOffset();
                } else {
                    removeActionBarHideOffset();
                }
                this.mAnimatingForFling = true;
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) && i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
            onNestedScroll(view, i2, i3, i4, i5, i6);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(1048611, this, view, view2, i2, i3) == null) && i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, view, view2, i2, i3)) == null) ? i3 == 0 && onStartNestedScroll(view, view2, i2) : invokeLLII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048615, this, view, i2) == null) && i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                super.onWindowSystemUiVisibilityChanged(i2);
            }
            pullChildren();
            int i3 = this.mLastSystemUiVisibility ^ i2;
            this.mLastSystemUiVisibility = i2;
            boolean z = (i2 & 4) == 0;
            boolean z2 = (i2 & 256) != 0;
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            if (actionBarVisibilityCallback != null) {
                actionBarVisibilityCallback.enableContentAnimations(!z2);
                if (!z && z2) {
                    this.mActionBarVisibilityCallback.hideForSystem();
                } else {
                    this.mActionBarVisibilityCallback.showForSystem();
                }
            }
            if ((i3 & 256) == 0 || this.mActionBarVisibilityCallback == null) {
                return;
            }
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            this.mWindowVisibility = i2;
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            if (actionBarVisibilityCallback != null) {
                actionBarVisibilityCallback.onWindowVisibilityChanged(i2);
            }
        }
    }

    public void pullChildren() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.mDecorToolbar = getDecorToolbar(findViewById(R$id.action_bar));
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, sparseArray) == null) {
            pullChildren();
            this.mDecorToolbar.restoreHierarchyState(sparseArray);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, sparseArray) == null) {
            pullChildren();
            this.mDecorToolbar.saveHierarchyState(sparseArray);
        }
    }

    public void setActionBarHideOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            haltActionBarHideOffsetAnimations();
            this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(i2, this.mActionBarTop.getHeight())));
        }
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, actionBarVisibilityCallback) == null) {
            this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
            if (getWindowToken() != null) {
                this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
                int i2 = this.mLastSystemUiVisibility;
                if (i2 != 0) {
                    onWindowSystemUiVisibilityChanged(i2);
                    ViewCompat.requestApplyInsets(this);
                }
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mHasNonEmbeddedTabs = z;
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || z == this.mHideOnContentScroll) {
            return;
        }
        this.mHideOnContentScroll = z;
        if (z) {
            return;
        }
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            pullChildren();
            this.mDecorToolbar.setIcon(i2);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            pullChildren();
            this.mDecorToolbar.setLogo(i2);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, menu, callback) == null) {
            pullChildren();
            this.mDecorToolbar.setMenu(menu, callback);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            pullChildren();
            this.mDecorToolbar.setMenuPrepared();
        }
    }

    public void setOverlayMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.mOverlayMode = z;
            this.mIgnoreWindowContentOverlay = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        }
    }

    public void setShowingForActionMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, callback) == null) {
            pullChildren();
            this.mDecorToolbar.setWindowCallback(callback);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, charSequence) == null) {
            pullChildren();
            this.mDecorToolbar.setWindowTitle(charSequence);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            pullChildren();
            return this.mDecorToolbar.showOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = windowInsetsCompat;
        this.mLastBaseInnerInsets = windowInsetsCompat;
        this.mInnerInsets = windowInsetsCompat;
        this.mLastInnerInsets = windowInsetsCompat;
        this.mTopAnimatorListener = new AnimatorListenerAdapter(this) { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActionBarOverlayLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                }
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable(this) { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActionBarOverlayLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.haltActionBarHideOffsetAnimations();
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(0.0f).setListener(this.this$0.mTopAnimatorListener);
                }
            }
        };
        this.mAddActionBarHideOffset = new Runnable(this) { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActionBarOverlayLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.haltActionBarHideOffsetAnimations();
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-this.this$0.mActionBarTop.getHeight()).setListener(this.this$0.mTopAnimatorListener);
                }
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new LayoutParams(-1, -1) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) && i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, view, view2, i2) == null) {
            this.mParentHelper.onNestedScrollAccepted(view, view2, i2);
            this.mHideOnContentScrollReference = getActionBarHideOffset();
            haltActionBarHideOffsetAnimations();
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            if (actionBarVisibilityCallback != null) {
                actionBarVisibilityCallback.onContentScrollStarted();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048612, this, view, view2, i2)) == null) {
            if ((i2 & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
                return false;
            }
            return this.mHideOnContentScroll;
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
                if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                    postRemoveActionBarHideOffset();
                } else {
                    postAddActionBarHideOffset();
                }
            }
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            if (actionBarVisibilityCallback != null) {
                actionBarVisibilityCallback.onContentScrollStopped();
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = this.mHideOnContentScrollReference + i3;
            this.mHideOnContentScrollReference = i6;
            setActionBarHideOffset(i6);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, drawable) == null) {
            pullChildren();
            this.mDecorToolbar.setIcon(drawable);
        }
    }
}
