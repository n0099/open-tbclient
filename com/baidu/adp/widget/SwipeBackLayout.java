package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SwipeBackLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public static final int MARGIN_THRESHOLD = 24;
    public static final int MIN_DISTANCE_FOR_MOVE = 24;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NORMAL = 0;
    public static final int SKIN_TYPE_THEME = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAutoDisable;
    public boolean isAutoEnable;
    public boolean isNeedInit;
    public boolean isTransparent;
    public int mActivePointerId;
    public Activity mActivity;
    public int mAlphaBgColor;
    public Rect mColorRect;
    public View mContentView;
    public int mCurMotionX;
    public float mDownX;
    public int mFlingDistance;
    public boolean mIsFinish;
    public boolean mIsScrolling;
    public boolean mIsSilding;
    public boolean mIsSupportNight;
    public boolean mIsSwipeBackEnabled;
    public boolean mIsTouchModeMargin;
    public float mLastMotionX;
    public float mLastMotionY;
    public int mMarginThreshold;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mMoveDistance;
    public b mOnSlidingStateChangeListener;
    public ViewGroup mRealContentView;
    public Scroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public int mViewWidth;
    public float mXVelocity;

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes.dex */
    public interface c {
        void K0();

        void m0();
    }

    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float a;

        public a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f2 = f * this.a;
                if (f2 > 0.9d) {
                    return 1.0f;
                }
                return f2;
            }
            return invokeF.floatValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.isAutoEnable = false;
        this.isTransparent = false;
        this.isAutoDisable = false;
        this.isNeedInit = false;
        this.mIsSupportNight = true;
        init(context);
    }

    private void customDispatchDraw(Canvas canvas) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) && (view2 = this.mContentView) != null) {
            int i = this.mCurMotionX;
            int bottom = view2.getBottom();
            Rect rect = this.mColorRect;
            rect.top = 0;
            rect.bottom = bottom;
            rect.left = 0;
            rect.right = i;
            canvas.clipRect(rect);
            int i2 = this.mViewWidth;
            if (i2 != 0) {
                this.mAlphaBgColor = 100 - ((int) (((-this.mCurMotionX) / i2) * 120.0f));
            }
            if (this.mAlphaBgColor > 100) {
                this.mAlphaBgColor = 100;
            }
            if (this.mIsFinish) {
                this.mAlphaBgColor = 0;
            }
            if (this.mAlphaBgColor < 0) {
                this.mAlphaBgColor = 0;
            }
            if (this.isTransparent) {
                canvas.drawARGB(0, 0, 0, 0);
            } else {
                canvas.drawARGB(this.mAlphaBgColor, 0, 0, 0);
            }
        }
    }

    private void determineDrag(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, motionEvent) == null) {
            int i = this.mActivePointerId;
            int pointerIndex = getPointerIndex(motionEvent, i);
            if (isInvalidEvent(motionEvent, pointerIndex, i)) {
                return;
            }
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.mMoveDistance && abs > abs2) {
                this.mIsSilding = true;
                b bVar = this.mOnSlidingStateChangeListener;
                if (bVar != null) {
                    bVar.b();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
            this.mScroller = new Scroller(context, new a(1.5f));
            this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
            this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
            this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
            this.mMoveDistance = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
            this.mFlingDistance = ii.l(context) / 4;
        }
    }

    public void attachToActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            try {
                this.mActivity = activity;
                Window window = activity.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(0));
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                this.mRealContentView = viewGroup2;
                viewGroup.removeView(viewGroup2);
                this.mRealContentView.setClickable(true);
                addView(this.mRealContentView);
                this.mContentView = (View) this.mRealContentView.getParent();
                viewGroup.addView(this);
            } catch (Exception e) {
                this.mIsSwipeBackEnabled = false;
                BdLog.e(e);
            }
        }
    }

    public void forceChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (this.isTransparent) {
                this.mRealContentView.setBackgroundResource(R.color.transparent);
            } else if (this.mIsSupportNight) {
                if (i == 1) {
                    this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060994);
                } else if (i == 4) {
                    this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060993);
                } else {
                    this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060995);
                }
            } else {
                this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060995);
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || !this.mIsSwipeBackEnabled) {
            return;
        }
        if (this.isTransparent) {
            this.mRealContentView.setBackgroundResource(R.color.transparent);
        } else if (this.mIsSupportNight) {
            if (i == 1) {
                this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060994);
            } else if (i == 4) {
                this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060993);
            } else {
                this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060995);
            }
        } else {
            this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060995);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.isAutoEnable = false;
        this.isTransparent = false;
        this.isAutoDisable = false;
        this.isNeedInit = false;
        this.mIsSupportNight = true;
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.isAutoEnable = false;
        this.isTransparent = false;
        this.isAutoDisable = false;
        this.isNeedInit = false;
        this.mIsSupportNight = true;
        init(context);
    }

    private void completeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mIsScrolling) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.mContentView.scrollTo(currX, currY);
                }
            }
            this.mIsScrolling = false;
        }
    }

    private void endDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mIsSilding = false;
            this.mActivePointerId = -1;
            releaseVelocityTracker();
        }
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void scrollOrigin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mIsScrolling = true;
            this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
            postInvalidate();
        }
    }

    private void scrollRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mIsScrolling = true;
            this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
            postInvalidate();
        }
    }

    public void disableSwipeJustOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.isAutoEnable = true;
            this.mIsSwipeBackEnabled = false;
        }
    }

    public boolean isIsSupportNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mIsSupportNight;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIsSwipeBackEnabled;
        }
        return invokeV.booleanValue;
    }

    public void setBgTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.isTransparent = true;
            ViewGroup viewGroup = this.mRealContentView;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.color.transparent);
            }
        }
    }

    private int getDiffX(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, motionEvent)) == null) {
            int i = this.mActivePointerId;
            int pointerIndex = getPointerIndex(motionEvent, i);
            if (isInvalidEvent(motionEvent, pointerIndex, i)) {
                return 0;
            }
            return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
        }
        return invokeL.intValue;
    }

    private boolean processAutoEnableSwipe(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                if (this.isAutoEnable) {
                    this.isAutoEnable = false;
                    this.mIsSwipeBackEnabled = true;
                    return true;
                } else if (this.isAutoDisable) {
                    this.isAutoDisable = false;
                    this.mIsSwipeBackEnabled = false;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void scrollOrigin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i) == null) {
            this.mIsScrolling = true;
            this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0, i);
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            try {
                super.dispatchDraw(canvas);
                customDispatchDraw(canvas);
            } catch (Exception e) {
                DefaultLog.getInstance().c("SwipeBackLayout crash", e.getMessage());
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    return;
                }
                throw e;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            processAutoEnableSwipe(motionEvent);
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (!z) {
                if (this.isTransparent) {
                    this.mRealContentView.setBackgroundResource(R.color.transparent);
                } else {
                    this.mRealContentView.setBackgroundResource(R.color.obfuscated_res_0x7f060995);
                }
            }
            this.mIsSupportNight = z;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.mOnSlidingStateChangeListener = bVar;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsSwipeBackEnabled = z;
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, motionEvent, i)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
            if (findPointerIndex == -1) {
                this.mActivePointerId = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, this, motionEvent, i, i2)) == null) {
            if (motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount()) {
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.mContentView.scrollTo(currX, currY);
                }
                invalidate();
            }
            if (this.mScroller.isFinished() && this.mIsFinish) {
                this.mActivity.finish();
                this.mActivity.overridePendingTransition(0, 0);
            }
            if (this.mScroller.isFinished()) {
                completeScroll();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (!this.mIsSwipeBackEnabled) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (!this.mIsFinish && !this.mIsScrolling) {
                int action = motionEvent.getAction() & 255;
                if (action != 3 && action != 1) {
                    if (action != 0) {
                        if (action == 2) {
                            determineDrag(motionEvent);
                        }
                    } else {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        this.mActivePointerId = pointerId;
                        if (!isInvalidEvent(motionEvent, actionIndex, pointerId)) {
                            this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                            this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                            this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                        }
                    }
                    return this.mIsSilding;
                }
                endDrag();
                return super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            try {
                super.onLayout(z, i, i2, i3, i4);
            } catch (Throwable unused) {
            }
            if (z) {
                this.mViewWidth = getWidth();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (!this.mIsFinish && !this.mIsScrolling) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    float f = 0.0f;
                    if (action != 1) {
                        if (action != 2) {
                            if (action == 3) {
                                endDrag();
                                scrollOrigin(10);
                                this.mIsFinish = false;
                                b bVar = this.mOnSlidingStateChangeListener;
                                if (bVar != null) {
                                    bVar.a(false);
                                }
                            }
                        } else {
                            if (this.isNeedInit) {
                                completeScroll();
                                int actionIndex = motionEvent.getActionIndex();
                                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                                this.mLastMotionX = (motionEvent.getX(actionIndex) - 1.0f) - this.mMoveDistance;
                                this.mLastMotionY = motionEvent.getY(actionIndex);
                                this.mDownX = motionEvent.getX(actionIndex);
                                this.mIsSilding = false;
                                this.isNeedInit = false;
                            }
                            if (!this.mIsSilding) {
                                determineDrag(motionEvent);
                            }
                            if (this.mIsSilding) {
                                int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                                if (!isInvalidEvent(motionEvent, pointerIndex, this.mActivePointerId)) {
                                    float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                                    float f2 = this.mLastMotionX - x;
                                    this.mLastMotionX = x;
                                    float scrollX = getScrollX() + f2;
                                    float f3 = -this.mViewWidth;
                                    if (scrollX < f3) {
                                        f = f3;
                                    } else if (scrollX <= 0.0f) {
                                        f = scrollX;
                                    }
                                    int i = (int) f;
                                    this.mLastMotionX += f - i;
                                    this.mCurMotionX = i;
                                    this.mContentView.scrollTo(i, getScrollY());
                                }
                            }
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        this.mXVelocity = velocityTracker.getXVelocity();
                        int diffX = getDiffX(motionEvent);
                        endDrag();
                        if (Math.abs(this.mXVelocity) > this.mMinimumVelocity && diffX > this.mFlingDistance) {
                            if (this.mXVelocity > 0.0f) {
                                this.mIsFinish = true;
                                scrollRight();
                            } else {
                                scrollOrigin();
                                this.mIsFinish = false;
                            }
                            b bVar2 = this.mOnSlidingStateChangeListener;
                            if (bVar2 != null) {
                                bVar2.a(this.mIsFinish);
                            }
                            return true;
                        }
                        if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                            this.mIsFinish = true;
                            scrollRight();
                        } else {
                            scrollOrigin();
                            this.mIsFinish = false;
                        }
                        b bVar3 = this.mOnSlidingStateChangeListener;
                        if (bVar3 != null) {
                            bVar3.a(this.mIsFinish);
                        }
                    }
                } else {
                    completeScroll();
                    int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                    this.mLastMotionX = motionEvent.getX();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex2);
                }
                return super.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void swipeBackControl(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d)}) == null) {
            if (d == 1.0d) {
                if (!this.mIsSwipeBackEnabled) {
                    this.isAutoDisable = true;
                }
                this.isNeedInit = true;
                this.mIsSwipeBackEnabled = true;
                this.mIsSilding = true;
            } else if (d == 2.0d) {
                this.mIsFinish = true;
                scrollRight();
            }
        }
    }
}
