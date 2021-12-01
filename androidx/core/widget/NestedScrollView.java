package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    public static final int ANIMATED_SCROLL_GAP = 250;
    public static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    public static final int INVALID_POINTER = -1;
    public static final float MAX_SCROLL_FACTOR = 0.5f;
    public static final int[] SCROLLVIEW_STYLEABLE;
    public static final String TAG = "NestedScrollView";
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public final NestedScrollingChildHelper mChildHelper;
    public View mChildToScrollTo;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    public boolean mFillViewport;
    public boolean mIsBeingDragged;
    public boolean mIsLaidOut;
    public boolean mIsLayoutDirty;
    public int mLastMotionY;
    public long mLastScroll;
    public int mLastScrollerY;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mNestedYOffset;
    public OnScrollChangeListener mOnScrollChangeListener;
    public final NestedScrollingParentHelper mParentHelper;
    public SavedState mSavedState;
    public final int[] mScrollConsumed;
    public final int[] mScrollOffset;
    public OverScroller mScroller;
    public boolean mSmoothScrollingEnabled;
    public final Rect mTempRect;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public float mVerticalScrollFactor;

    /* loaded from: classes.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AccessibilityDelegate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
                AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                    return;
                }
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, bundle)) == null) {
                if (super.performAccessibilityAction(view, i2, bundle)) {
                    return true;
                }
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                if (nestedScrollView.isEnabled()) {
                    if (i2 != 4096) {
                        if (i2 == 8192 || i2 == 16908344) {
                            int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                            if (max != nestedScrollView.getScrollY()) {
                                nestedScrollView.smoothScrollTo(0, max, true);
                                return true;
                            }
                            return false;
                        } else if (i2 != 16908346) {
                            return false;
                        }
                    }
                    int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (min != nestedScrollView.getScrollY()) {
                        nestedScrollView.smoothScrollTo(0, min, true);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int scrollPosition;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-199075701, "Landroidx/core/widget/NestedScrollView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-199075701, "Landroidx/core/widget/NestedScrollView$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.scrollPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.scrollPosition = parcel.readInt();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2033868509, "Landroidx/core/widget/NestedScrollView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2033868509, "Landroidx/core/widget/NestedScrollView;");
                return;
            }
        }
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{16843130};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollView(@NonNull Context context) {
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

    private void abortAnimatedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mScroller.abortAnimation();
            stopNestedScroll(1);
        }
    }

    private boolean canScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int clamp(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i2, i3, i4)) == null) {
            if (i3 >= i4 || i2 < 0) {
                return 0;
            }
            return i3 + i2 > i4 ? i4 - i3 : i2;
        }
        return invokeIII.intValue;
    }

    private void doScrollY(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || i2 == 0) {
            return;
        }
        if (this.mSmoothScrollingEnabled) {
            smoothScrollBy(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private void endDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mIsBeingDragged = false;
            recycleVelocityTracker();
            stopNestedScroll(0);
            EdgeEffect edgeEffect = this.mEdgeGlowTop;
            if (edgeEffect != null) {
                edgeEffect.onRelease();
                this.mEdgeGlowBottom.onRelease();
            }
        }
    }

    private void ensureGlows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (getOverScrollMode() != 2) {
                if (this.mEdgeGlowTop == null) {
                    Context context = getContext();
                    this.mEdgeGlowTop = new EdgeEffect(context);
                    this.mEdgeGlowBottom = new EdgeEffect(context);
                    return;
                }
                return;
            }
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
    }

    private View findFocusableViewInBounds(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ArrayList focusables = getFocusables(2);
            int size = focusables.size();
            View view = null;
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) focusables.get(i4);
                int top = view2.getTop();
                int bottom = view2.getBottom();
                if (i2 < bottom && top < i3) {
                    boolean z3 = i2 < top && bottom < i3;
                    if (view == null) {
                        view = view2;
                        z2 = z3;
                    } else {
                        boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                        if (z2) {
                            if (z3) {
                                if (!z4) {
                                }
                                view = view2;
                            }
                        } else if (z3) {
                            view = view2;
                            z2 = true;
                        } else {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    }
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    private float getVerticalScrollFactorCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.mVerticalScrollFactor == 0.0f) {
                TypedValue typedValue = new TypedValue();
                Context context = getContext();
                if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                    this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
                } else {
                    throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                }
            }
            return this.mVerticalScrollFactor;
        }
        return invokeV.floatValue;
    }

    private boolean inChild(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i2, i3)) == null) {
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    private void initOrResetVelocityTracker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
        }
    }

    private void initScrollView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mScroller = new OverScroller(getContext());
            setFocusable(true);
            setDescendantFocusability(262144);
            setWillNotDraw(false);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, view)) == null) ? !isWithinDeltaOfScreen(view, 0, getHeight()) : invokeL.booleanValue;
    }

    public static boolean isViewDescendantOf(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, view, view2)) == null) {
            if (view == view2) {
                return true;
            }
            ViewParent parent = view.getParent();
            return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
        }
        return invokeLL.booleanValue;
    }

    private boolean isWithinDeltaOfScreen(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, this, view, i2, i3)) == null) {
            view.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(view, this.mTempRect);
            return this.mTempRect.bottom + i2 >= getScrollY() && this.mTempRect.top - i2 <= getScrollY() + i3;
        }
        return invokeLII.booleanValue;
    }

    private void onNestedScrollInternal(int i2, int i3, @Nullable int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65555, this, i2, i3, iArr) == null) {
            int scrollY = getScrollY();
            scrollBy(0, i2);
            int scrollY2 = getScrollY() - scrollY;
            if (iArr != null) {
                iArr[1] = iArr[1] + scrollY2;
            }
            this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, motionEvent) == null) {
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.mLastMotionY = (int) motionEvent.getY(i2);
                this.mActivePointerId = motionEvent.getPointerId(i2);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (velocityTracker = this.mVelocityTracker) == null) {
            return;
        }
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private void runAnimatedScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, this, z) == null) {
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.mLastScrollerY = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private boolean scrollAndFocus(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65559, this, i2, i3, i4)) == null) {
            int height = getHeight();
            int scrollY = getScrollY();
            int i5 = height + scrollY;
            boolean z = false;
            boolean z2 = i2 == 33;
            View findFocusableViewInBounds = findFocusableViewInBounds(z2, i3, i4);
            if (findFocusableViewInBounds == null) {
                findFocusableViewInBounds = this;
            }
            if (i3 < scrollY || i4 > i5) {
                doScrollY(z2 ? i3 - scrollY : i4 - i5);
                z = true;
            }
            if (findFocusableViewInBounds != findFocus()) {
                findFocusableViewInBounds.requestFocus(i2);
            }
            return z;
        }
        return invokeIII.booleanValue;
    }

    private void scrollToChild(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, view) == null) {
            view.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(view, this.mTempRect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, this, rect, z)) == null) {
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
            if (z2) {
                if (z) {
                    scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                } else {
                    smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (getChildCount() <= 0) {
                super.addView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    public boolean arrowScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            int maxScrollAmount = getMaxScrollAmount();
            if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
                findNextFocus.getDrawingRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
                doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
                findNextFocus.requestFocus(i2);
            } else {
                if (i2 == 33 && getScrollY() < maxScrollAmount) {
                    maxScrollAmount = getScrollY();
                } else if (i2 == 130 && getChildCount() > 0) {
                    View childAt = getChildAt(0);
                    maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
                }
                if (maxScrollAmount == 0) {
                    return false;
                }
                if (i2 != 130) {
                    maxScrollAmount = -maxScrollAmount;
                }
                doScrollY(maxScrollAmount);
            }
            if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
                int descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(131072);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.computeHorizontalScrollExtent() : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.computeHorizontalScrollOffset() : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.computeHorizontalScrollRange() : invokeV.intValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int i2 = currY - this.mLastScrollerY;
        this.mLastScrollerY = currY;
        int[] iArr = this.mScrollConsumed;
        boolean z = false;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i2, iArr, null, 1);
        int i3 = i2 - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (i3 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i4 = i3 - scrollY2;
            int[] iArr2 = this.mScrollConsumed;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i4, this.mScrollOffset, 1, iArr2);
            i3 = i4 - this.mScrollConsumed[1];
        }
        if (i3 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                ensureGlows();
                if (i3 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            stopNestedScroll(1);
        }
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rect)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            int height = getHeight();
            int scrollY = getScrollY();
            int i4 = scrollY + height;
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (rect.top > 0) {
                scrollY += verticalFadingEdgeLength;
            }
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
            if (rect.bottom > i5 && rect.top > scrollY) {
                if (rect.height() > height) {
                    i3 = rect.top - scrollY;
                } else {
                    i3 = rect.bottom - i5;
                }
                return Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
            } else if (rect.top >= scrollY || rect.bottom >= i5) {
                return 0;
            } else {
                if (rect.height() > height) {
                    i2 = 0 - (i5 - rect.bottom);
                } else {
                    i2 = 0 - (scrollY - rect.top);
                }
                return Math.max(i2, -getScrollY());
            }
        }
        return invokeL.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? super.computeVerticalScrollExtent() : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Math.max(0, super.computeVerticalScrollOffset()) : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int childCount = getChildCount();
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            if (childCount == 0) {
                return height;
            }
            View childAt = getChildAt(0);
            int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int scrollY = getScrollY();
            int max = Math.max(0, bottom - height);
            return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.mChildHelper.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.mChildHelper.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) ? this.mChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, @NonNull int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), iArr2}) == null) {
            this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6, iArr2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, canvas) == null) {
            super.draw(canvas);
            if (this.mEdgeGlowTop != null) {
                int scrollY = getScrollY();
                int i2 = 0;
                if (!this.mEdgeGlowTop.isFinished()) {
                    int save = canvas.save();
                    int width = getWidth();
                    int height = getHeight();
                    int min = Math.min(0, scrollY);
                    if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                        width -= getPaddingLeft() + getPaddingRight();
                        paddingLeft = getPaddingLeft() + 0;
                    } else {
                        paddingLeft = 0;
                    }
                    if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                        height -= getPaddingTop() + getPaddingBottom();
                        min += getPaddingTop();
                    }
                    canvas.translate(paddingLeft, min);
                    this.mEdgeGlowTop.setSize(width, height);
                    if (this.mEdgeGlowTop.draw(canvas)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    canvas.restoreToCount(save);
                }
                if (this.mEdgeGlowBottom.isFinished()) {
                    return;
                }
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i2 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate(i2 - width2, max);
                canvas.rotate(180.0f, width2, 0.0f);
                this.mEdgeGlowBottom.setSize(width2, height2);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, keyEvent)) == null) {
            this.mTempRect.setEmpty();
            if (!canScroll()) {
                if (!isFocused() || keyEvent.getKeyCode() == 4) {
                    return false;
                }
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
            } else if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(33);
                    }
                    return fullScroll(33);
                } else if (keyCode == 20) {
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(130);
                    }
                    return fullScroll(130);
                } else if (keyCode != 62) {
                    return false;
                } else {
                    pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void fling(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || getChildCount() <= 0) {
            return;
        }
        this.mScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
    }

    public boolean fullScroll(int i2) {
        InterceptResult invokeI;
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            boolean z = i2 == 130;
            int height = getHeight();
            Rect rect = this.mTempRect;
            rect.top = 0;
            rect.bottom = height;
            if (z && (childCount = getChildCount()) > 0) {
                View childAt = getChildAt(childCount - 1);
                this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect2 = this.mTempRect;
                rect2.top = rect2.bottom - height;
            }
            Rect rect3 = this.mTempRect;
            return scrollAndFocus(i2, rect3.top, rect3.bottom);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (getChildCount() == 0) {
                return 0.0f;
            }
            View childAt = getChildAt(0);
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
            if (bottom < verticalFadingEdgeLength) {
                return bottom / verticalFadingEdgeLength;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public int getMaxScrollAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (int) (getHeight() * 0.5f) : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mParentHelper.getNestedScrollAxes() : invokeV.intValue;
    }

    public int getScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getChildCount() == 0) {
                return 0.0f;
            }
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            int scrollY = getScrollY();
            if (scrollY < verticalFadingEdgeLength) {
                return scrollY / verticalFadingEdgeLength;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) ? this.mChildHelper.hasNestedScrollingParent(i2) : invokeI.booleanValue;
    }

    public boolean isFillViewport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mFillViewport : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mChildHelper.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isSmoothScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mSmoothScrollingEnabled : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048611, this, view, i2, i3) == null) {
            view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onAttachedToWindow();
            this.mIsLaidOut = false;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
                float axisValue = motionEvent.getAxisValue(9);
                if (axisValue != 0.0f) {
                    int scrollRange = getScrollRange();
                    int scrollY = getScrollY();
                    int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                    if (verticalScrollFactorCompat < 0) {
                        scrollRange = 0;
                    } else if (verticalScrollFactorCompat <= scrollRange) {
                        scrollRange = verticalScrollFactorCompat;
                    }
                    if (scrollRange != scrollY) {
                        super.scrollTo(getScrollX(), scrollRange);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 2 && this.mIsBeingDragged) {
                return true;
            }
            int i2 = action & 255;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int i3 = this.mActivePointerId;
                        if (i3 != -1) {
                            int findPointerIndex = motionEvent.findPointerIndex(i3);
                            if (findPointerIndex == -1) {
                                String str = "Invalid pointerId=" + i3 + " in onInterceptTouchEvent";
                            } else {
                                int y = (int) motionEvent.getY(findPointerIndex);
                                if (Math.abs(y - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                    this.mIsBeingDragged = true;
                                    this.mLastMotionY = y;
                                    initVelocityTrackerIfNotExists();
                                    this.mVelocityTracker.addMovement(motionEvent);
                                    this.mNestedYOffset = 0;
                                    ViewParent parent = getParent();
                                    if (parent != null) {
                                        parent.requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                    } else if (i2 != 3) {
                        if (i2 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                stopNestedScroll(0);
            } else {
                int y2 = (int) motionEvent.getY();
                if (!inChild((int) motionEvent.getX(), y2)) {
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                } else {
                    this.mLastMotionY = y2;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.computeScrollOffset();
                    this.mIsBeingDragged = !this.mScroller.isFinished();
                    startNestedScroll(2, 0);
                }
            }
            return this.mIsBeingDragged;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int i6 = 0;
            this.mIsLayoutDirty = false;
            View view = this.mChildToScrollTo;
            if (view != null && isViewDescendantOf(view, this)) {
                scrollToChild(this.mChildToScrollTo);
            }
            this.mChildToScrollTo = null;
            if (!this.mIsLaidOut) {
                if (this.mSavedState != null) {
                    scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                    this.mSavedState = null;
                }
                if (getChildCount() > 0) {
                    View childAt = getChildAt(0);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                }
                int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                int clamp = clamp(scrollY, paddingTop, i6);
                if (clamp != scrollY) {
                    scrollTo(getScrollX(), clamp);
                }
            }
            scrollTo(getScrollX(), getScrollY());
            this.mIsLaidOut = true;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.mFillViewport && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
                if (measuredHeight < measuredHeight2) {
                    childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (z) {
                return false;
            }
            dispatchNestedFling(0.0f, f3, true);
            fling((int) f3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
            dispatchNestedPreScroll(i2, i3, iArr, null, i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
            onNestedScrollInternal(i5, i6, iArr);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048626, this, view, view2, i2, i3) == null) {
            this.mParentHelper.onNestedScrollAccepted(view, view2, i2, i3);
            startNestedScroll(2, i3);
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.scrollTo(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        InterceptResult invokeIL;
        View findNextFocusFromRect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048628, this, i2, rect)) == null) {
            if (i2 == 2) {
                i2 = 130;
            } else if (i2 == 1) {
                i2 = 33;
            }
            if (rect == null) {
                findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i2);
            } else {
                findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
            }
            if (findNextFocusFromRect == null || isOffScreen(findNextFocusFromRect)) {
                return false;
            }
            return findNextFocusFromRect.requestFocus(i2, rect);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.mSavedState = savedState;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.scrollPosition = getScrollY();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048631, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
            if (onScrollChangeListener != null) {
                onScrollChangeListener.onScrollChange(this, i2, i3, i4, i5);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048632, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            View findFocus = findFocus();
            if (findFocus == null || this == findFocus || !isWithinDeltaOfScreen(findFocus, 0, i5)) {
                return;
            }
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048633, this, view, view2, i2)) == null) ? onStartNestedScroll(view, view2, i2, 0) : invokeLLI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048634, this, view, view2, i2, i3)) == null) ? (i2 & 2) != 0 : invokeLLII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048636, this, view, i2) == null) {
            this.mParentHelper.onStopNestedScroll(view, i2);
            stopNestedScroll(i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, motionEvent)) == null) {
            initVelocityTrackerIfNotExists();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mNestedYOffset = 0;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(0.0f, this.mNestedYOffset);
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                    if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                        int i2 = -yVelocity;
                        float f2 = i2;
                        if (!dispatchNestedPreFling(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            fling(i2);
                        }
                    } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        String str = "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent";
                    } else {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int i3 = this.mLastMotionY - y;
                        if (!this.mIsBeingDragged && Math.abs(i3) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i3 = i3 > 0 ? i3 - this.mTouchSlop : i3 + this.mTouchSlop;
                        }
                        int i4 = i3;
                        if (this.mIsBeingDragged) {
                            if (dispatchNestedPreScroll(0, i4, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                i4 -= this.mScrollConsumed[1];
                                this.mNestedYOffset += this.mScrollOffset[1];
                            }
                            int i5 = i4;
                            this.mLastMotionY = y - this.mScrollOffset[1];
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            int overScrollMode = getOverScrollMode();
                            boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                            if (overScrollByCompat(0, i5, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(0)) {
                                this.mVelocityTracker.clear();
                            }
                            int scrollY2 = getScrollY() - scrollY;
                            int[] iArr = this.mScrollConsumed;
                            iArr[1] = 0;
                            dispatchNestedScroll(0, scrollY2, 0, i5 - scrollY2, this.mScrollOffset, 0, iArr);
                            int i6 = this.mLastMotionY;
                            int[] iArr2 = this.mScrollOffset;
                            this.mLastMotionY = i6 - iArr2[1];
                            this.mNestedYOffset += iArr2[1];
                            if (z) {
                                int i7 = i5 - this.mScrollConsumed[1];
                                ensureGlows();
                                int i8 = scrollY + i7;
                                if (i8 < 0) {
                                    EdgeEffectCompat.onPull(this.mEdgeGlowTop, i7 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                } else if (i8 > scrollRange) {
                                    EdgeEffectCompat.onPull(this.mEdgeGlowBottom, i7 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                }
                                EdgeEffect edgeEffect = this.mEdgeGlowTop;
                                if (edgeEffect != null && (!edgeEffect.isFinished() || !this.mEdgeGlowBottom.isFinished())) {
                                    ViewCompat.postInvalidateOnAnimation(this);
                                }
                            }
                        }
                    }
                } else if (actionMasked == 3) {
                    if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                } else if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (getChildCount() == 0) {
                return false;
            } else {
                boolean z2 = !this.mScroller.isFinished();
                this.mIsBeingDragged = z2;
                if (z2 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.mScroller.isFinished()) {
                    abortAnimatedScroll();
                }
                this.mLastMotionY = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                startNestedScroll(2, 0);
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean overScrollByCompat(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i10 = i4 + i2;
        int i11 = !z6 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z7 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i10 = i15;
        } else if (i10 >= i14) {
            z2 = false;
            if (i12 <= i17) {
                i12 = i17;
            } else if (i12 >= i16) {
                z3 = false;
                if (z3 && !hasNestedScrollingParent(1)) {
                    this.mScroller.springBack(i10, i12, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i10, i12, z2, z3);
                return !z2 || z3;
            } else {
                i12 = i16;
            }
            z3 = true;
            if (z3) {
                this.mScroller.springBack(i10, i12, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i10, i12, z2, z3);
            if (z2) {
            }
        } else {
            i10 = i14;
        }
        z2 = true;
        if (i12 <= i17) {
        }
        z3 = true;
        if (z3) {
        }
        onOverScrolled(i10, i12, z2, z3);
        if (z2) {
        }
    }

    public boolean pageScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            boolean z = i2 == 130;
            int height = getHeight();
            if (z) {
                this.mTempRect.top = getScrollY() + height;
                int childCount = getChildCount();
                if (childCount > 0) {
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                    Rect rect = this.mTempRect;
                    if (rect.top + height > bottom) {
                        rect.top = bottom - height;
                    }
                }
            } else {
                this.mTempRect.top = getScrollY() - height;
                Rect rect2 = this.mTempRect;
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
            }
            Rect rect3 = this.mTempRect;
            int i3 = rect3.top;
            int i4 = height + i3;
            rect3.bottom = i4;
            return scrollAndFocus(i2, i3, i4);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, view, view2) == null) {
            if (!this.mIsLayoutDirty) {
                scrollToChild(view2);
            } else {
                this.mChildToScrollTo = view2;
            }
            super.requestChildFocus(view, view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048641, this, view, rect, z)) == null) {
            rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
            return scrollToChildRect(rect, z);
        }
        return invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            if (z) {
                recycleVelocityTracker();
            }
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.mIsLayoutDirty = true;
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048644, this, i2, i3) == null) || getChildCount() <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int clamp = clamp(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int clamp2 = clamp(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        if (clamp == getScrollX() && clamp2 == getScrollY()) {
            return;
        }
        super.scrollTo(clamp, clamp2);
    }

    public void setFillViewport(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || z == this.mFillViewport) {
            return;
        }
        this.mFillViewport = z;
        requestLayout();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.mChildHelper.setNestedScrollingEnabled(z);
        }
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onScrollChangeListener) == null) {
            this.mOnScrollChangeListener = onScrollChangeListener;
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.mSmoothScrollingEnabled = z;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void smoothScrollBy(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i2, i3) == null) {
            smoothScrollBy(i2, i3, 250, false);
        }
    }

    public final void smoothScrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048652, this, i2, i3) == null) {
            smoothScrollTo(i2, i3, 250, false);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048657, this, i2, i3)) == null) ? this.mChildHelper.startNestedScroll(i2, i3) : invokeII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.mChildHelper.stopNestedScroll(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? dispatchNestedPreScroll(i2, i3, iArr, iArr2, 0) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) ? this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? hasNestedScrollingParent(0) : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            onNestedPreScroll(view, i2, i3, iArr, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            onNestedScrollInternal(i5, i6, null);
        }
    }

    public final void smoothScrollBy(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048651, this, i2, i3, i4) == null) {
            smoothScrollBy(i2, i3, i4, false);
        }
    }

    public final void smoothScrollTo(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048653, this, i2, i3, i4) == null) {
            smoothScrollTo(i2, i3, i4, false);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048656, this, i2)) == null) ? startNestedScroll(i2, 0) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            stopNestedScroll(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) || getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
            runAnimatedScroll(z);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(i2, i3);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            onNestedScrollInternal(i5, 0, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048625, this, view, view2, i2) == null) {
            onNestedScrollAccepted(view, view2, i2, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, view) == null) {
            onStopNestedScroll(view, 0);
        }
    }

    public void smoothScrollTo(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            smoothScrollTo(i2, i3, 250, z);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            if (getChildCount() <= 0) {
                super.addView(view, i2);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    public void smoothScrollTo(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            smoothScrollBy(i2 - getScrollX(), i3 - getScrollY(), i4, z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, layoutParams) == null) {
            if (getChildCount() <= 0) {
                super.addView(view, layoutParams);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, layoutParams) == null) {
            if (getChildCount() <= 0) {
                super.addView(view, i2, layoutParams);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }
}
