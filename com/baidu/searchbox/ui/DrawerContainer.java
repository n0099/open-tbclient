package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DrawerContainer extends FrameLayout implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DRAW_BACK_DURATION = 800;
    public static final int DRAW_BACK_MIN_DURATION = 500;
    public static final float NANOTIME_DIV = 1.0E9f;
    public static final float SMOOTHING_CONSTANT;
    public static final float SMOOTHING_SPEED = 0.75f;
    public static final int TOUCH_STATE_DELEGATE_SCROLLING = 3;
    public static final int TOUCH_STATE_FLING = 2;
    public static final int TOUCH_STATE_REST = 0;
    public static final int TOUCH_STATE_SCROLLING = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollingChildHelper mChildHelper;
    public float mDeltaDumpY;
    public Drawer mDrawer;
    public DrawerListener mDrawerListener;
    public HeaderStartSpringBackListener mHeaderStartSpringBackListener;
    public float mLastMotionY;
    public NestedScrollingParentHelper mParentHelper;
    public boolean mRefreshBingo;
    public Scroller mScroller;
    public int mSecondSpringBackGap;
    public int mSecondSpringBackTop;
    public float mSmoothingTime;
    public int mTopDrawerLength;
    public int mTouchSlop;
    public int mTouchState;
    public float mTouchY;

    /* loaded from: classes7.dex */
    public interface DrawerListener {
        void onDrawed(int i2);

        void onFlingFinish();

        void onSpringBack(int i2, int i3);
    }

    /* loaded from: classes7.dex */
    public interface HeaderStartSpringBackListener {
        void startSpringBack(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-221129556, "Lcom/baidu/searchbox/ui/DrawerContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-221129556, "Lcom/baidu/searchbox/ui/DrawerContainer;");
                return;
            }
        }
        SMOOTHING_CONSTANT = (float) (0.016d / Math.log(0.75d));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.mScroller = new Scroller(getContext());
            this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.mParentHelper = new NestedScrollingParentHelper(this);
            this.mChildHelper = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        }
    }

    private void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            int scrollY = this.mTopDrawerLength - getScrollY();
            int i2 = (int) ((scrollY * 800) / this.mTopDrawerLength);
            if (i2 < 0) {
                i2 = -i2;
            }
            int i3 = i2 < 500 ? 500 : i2;
            if (scrollY != 0) {
                this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i3);
                this.mTouchState = 2;
            } else {
                this.mTouchState = 0;
            }
            HeaderStartSpringBackListener headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
            if (headerStartSpringBackListener != null) {
                headerStartSpringBackListener.startSpringBack(scrollY);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mScroller.computeScrollOffset()) {
                scrollTo(0, this.mScroller.getCurrY());
                postInvalidate();
                return;
            }
            int i2 = this.mTouchState;
            if (i2 != 1 && i2 != 3) {
                this.mTouchState = 0;
                DrawerListener drawerListener = this.mDrawerListener;
                if (drawerListener != null) {
                    drawerListener.onFlingFinish();
                    return;
                }
                return;
            }
            float nanoTime = ((float) System.nanoTime()) / 1.0E9f;
            float scrollY = this.mTouchY - getScrollY();
            scrollTo(getScrollX(), getScrollY() + ((int) (((float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT)) * scrollY)));
            this.mSmoothingTime = nanoTime;
            if (scrollY > 1.0f || scrollY < -1.0f) {
                postInvalidate();
            }
        }
    }

    public float dampDelta(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? f2 : invokeF.floatValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.mChildHelper.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.mChildHelper.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.mChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    public void drawBy(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            float dampDelta = dampDelta(f2);
            this.mDeltaDumpY = dampDelta;
            if (dampDelta < 0.0f) {
                float f3 = this.mTouchY;
                if (f3 > 0.0f) {
                    this.mTouchY = f3 + Math.max(-f3, dampDelta);
                    this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                    invalidate();
                }
            } else if (dampDelta > 0.0f) {
                float f4 = this.mTouchY;
                float f5 = this.mTopDrawerLength - f4;
                if (f5 > 0.0f) {
                    this.mTouchY = f4 + Math.min(f5, dampDelta);
                    this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                    invalidate();
                }
            }
        }
    }

    public int drawByImmediate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
            float dampDelta = dampDelta(f2);
            this.mDeltaDumpY = dampDelta;
            if (dampDelta < 0.0f) {
                float f3 = this.mTouchY;
                if (f3 > 0.0f) {
                    this.mTouchY = f3 + Math.max(-f3, dampDelta);
                    this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                    return scrollDrawer();
                }
                return 0;
            } else if (dampDelta > 0.0f) {
                float f4 = this.mTouchY;
                float f5 = this.mTopDrawerLength - f4;
                if (f5 > 0.0f) {
                    this.mTouchY = f4 + Math.min(f5, dampDelta);
                    this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                    return scrollDrawer();
                }
                return 0;
            } else {
                return 0;
            }
        }
        return invokeF.intValue;
    }

    public float getCurrentDampY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDeltaDumpY : invokeV.floatValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mParentHelper.getNestedScrollAxes() : invokeV.intValue;
    }

    public int getSecondSpringBackGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSecondSpringBackGap : invokeV.intValue;
    }

    public int getTopDrawerLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mTopDrawerLength : invokeV.intValue;
    }

    public int getTouchSlop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mTouchSlop : invokeV.intValue;
    }

    public int getTouchState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mTouchState : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        int i4;
        HeaderStartSpringBackListener headerStartSpringBackListener;
        DrawerListener drawerListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, motionEvent) == null) || this.mDrawer == null) {
            return;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f2 = this.mLastMotionY;
                    this.mRefreshBingo = false;
                    float y = motionEvent.getY();
                    this.mLastMotionY = y;
                    float f3 = y - f2;
                    if (getScrollY() < this.mTopDrawerLength || (f3 > 0.0f && this.mDrawer.isTop())) {
                        drawBy(-f3);
                        this.mTouchState = 1;
                        return;
                    }
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            int scrollY = this.mTopDrawerLength - getScrollY();
            if (action != 3) {
                int i5 = this.mSecondSpringBackGap;
                if (i5 == Integer.MAX_VALUE) {
                    this.mRefreshBingo = true;
                } else if (scrollY > i5) {
                    this.mRefreshBingo = true;
                    i2 = scrollY - this.mSecondSpringBackTop;
                    i3 = (int) ((i2 * 800) / this.mTopDrawerLength);
                    if (i3 < 0) {
                        i3 = -i3;
                    }
                    i4 = i3;
                    if (this.mRefreshBingo && (drawerListener = this.mDrawerListener) != null) {
                        drawerListener.onSpringBack(i2, i4);
                    }
                    if (i2 == 0) {
                        this.mScroller.startScroll(0, getScrollY(), 0, i2, i4);
                        this.mTouchState = 2;
                    } else {
                        this.mTouchState = 0;
                    }
                    headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
                    if (headerStartSpringBackListener != null) {
                        headerStartSpringBackListener.startSpringBack(scrollY);
                    }
                    invalidate();
                    return;
                }
            }
            i2 = scrollY;
            i3 = (int) ((i2 * 800) / this.mTopDrawerLength);
            if (i3 < 0) {
            }
            i4 = i3;
            if (this.mRefreshBingo) {
                drawerListener.onSpringBack(i2, i4);
            }
            if (i2 == 0) {
            }
            headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
            if (headerStartSpringBackListener != null) {
            }
            invalidate();
            return;
        }
        this.mTouchState = !this.mScroller.isFinished();
        this.mTouchY = getScrollY();
        this.mRefreshBingo = false;
        this.mLastMotionY = motionEvent.getY();
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.abortAnimation();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mChildHelper.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public void invokeScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mChildHelper.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isRefreshBingo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRefreshBingo : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (dispatchNestedPreFling(0.0f, f3)) {
                return false;
            }
            dispatchNestedFling(0.0f, f3, z);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.mTouchState != 0 : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) || i3 == 0) {
            return;
        }
        if (getScrollY() < this.mTopDrawerLength || (i3 < 0 && !ViewCompat.canScrollVertically(view, -1))) {
            int abs = Math.abs(i3) < 3 ? i3 / Math.abs(i3) : i3 / 3;
            int drawByImmediate = drawByImmediate(abs);
            if (Math.abs(abs) != 1) {
                abs = drawByImmediate;
            }
            iArr[1] = abs;
            this.mTouchState = 3;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(0, i3, 0, i5, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, view, view2, i2) == null) {
            this.mParentHelper.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(2);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            DrawerListener drawerListener = this.mDrawerListener;
            if (drawerListener == null || i3 >= (i6 = this.mTopDrawerLength) || this.mTouchState != 1) {
                return;
            }
            drawerListener.onDrawed(i6 - i3);
        }
    }

    public void onScrollViewScrolled(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048604, this, view, view2, i2)) == null) {
            this.mTouchY = getScrollY();
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                if (Math.abs(getScrollY() - this.mTopDrawerLength) < this.mTouchSlop) {
                    scrollTo(0, this.mTopDrawerLength);
                }
            }
            return isNestedScrollingEnabled() && (i2 & 2) != 0;
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            stopNestedScroll();
            onRelease();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public int scrollDrawer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            float nanoTime = ((float) System.nanoTime()) / 1.0E9f;
            int scrollY = (int) ((this.mTouchY - getScrollY()) * ((float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT)));
            scrollTo(getScrollX(), getScrollY() + scrollY);
            this.mSmoothingTime = nanoTime;
            return scrollY;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            super.scrollTo(i2, i3);
        }
    }

    public void setDrawer(Drawer drawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, drawer) == null) {
            this.mDrawer = drawer;
        }
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, drawerListener) == null) {
            this.mDrawerListener = drawerListener;
        }
    }

    public void setHeaderStartSpringBackListener(HeaderStartSpringBackListener headerStartSpringBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, headerStartSpringBackListener) == null) {
            this.mHeaderStartSpringBackListener = headerStartSpringBackListener;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mChildHelper.setNestedScrollingEnabled(z);
        }
    }

    public void setSecondSpringBackBound(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048613, this, i2, i3) == null) || i2 > i3) {
            return;
        }
        this.mSecondSpringBackTop = i2;
        this.mSecondSpringBackGap = i3;
    }

    public boolean setTopDrawerLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            if (i2 != this.mTopDrawerLength) {
                this.mTopDrawerLength = i2;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public int smoothScrollTo(int i2, boolean z) {
        InterceptResult invokeCommon;
        DrawerListener drawerListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int scrollY = i2 - getScrollY();
            this.mRefreshBingo = z;
            if (scrollY != 0) {
                int i3 = (int) ((scrollY * 800) / this.mTopDrawerLength);
                if (i3 < 0) {
                    i3 = -i3;
                }
                if (this.mRefreshBingo && (drawerListener = this.mDrawerListener) != null) {
                    drawerListener.onSpringBack(scrollY, i3);
                }
                this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i3);
                this.mTouchState = 2;
                invalidate();
                return i3;
            } else if (this.mScroller.isFinished()) {
                return 0;
            } else {
                this.mScroller.forceFinished(true);
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? this.mChildHelper.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.mChildHelper.stopNestedScroll();
        }
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerContainer(Context context, AttributeSet attributeSet) {
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
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerContainer(Context context, AttributeSet attributeSet, int i2) {
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
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }
}
