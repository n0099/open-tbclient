package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ACTIVATION_DELAY;
    public static final int DEFAULT_EDGE_TYPE = 1;
    public static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    public static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    public static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    public static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    public static final int DEFAULT_RAMP_UP_DURATION = 500;
    public static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    public static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final Interpolator mEdgeInterpolator;
    public int mEdgeType;
    public boolean mEnabled;
    public boolean mExclusive;
    public float[] mMaximumEdges;
    public float[] mMaximumVelocity;
    public float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public float[] mRelativeEdges;
    public float[] mRelativeVelocity;
    public Runnable mRunnable;
    public final ClampedScroller mScroller;
    public final View mTarget;

    public static float constrain(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f > f3 ? f3 : f < f2 ? f2 : f : invokeCommon.floatValue;
    }

    public static int constrain(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, i3)) == null) ? i > i3 ? i3 : i < i2 ? i2 : i : invokeIII.intValue;
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public abstract void scrollTargetBy(int i, int i2);

    /* loaded from: classes.dex */
    public static class ClampedScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mDeltaTime;
        public int mDeltaX;
        public int mDeltaY;
        public int mEffectiveRampDown;
        public int mRampDownDuration;
        public int mRampUpDuration;
        public long mStartTime;
        public long mStopTime;
        public float mStopValue;
        public float mTargetVelocityX;
        public float mTargetVelocityY;

        private float interpolateValue(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f)) == null) ? ((-4.0f) * f * f) + (f * 4.0f) : invokeF.floatValue;
        }

        public ClampedScroller() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStartTime = Long.MIN_VALUE;
            this.mStopTime = -1L;
            this.mDeltaTime = 0L;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }

        public void computeScrollDelta() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mDeltaTime != 0) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                    this.mDeltaTime = currentAnimationTimeMillis;
                    float f = ((float) (currentAnimationTimeMillis - this.mDeltaTime)) * interpolateValue;
                    this.mDeltaX = (int) (this.mTargetVelocityX * f);
                    this.mDeltaY = (int) (f * this.mTargetVelocityY);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }

        private float getValueAt(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
                if (j < this.mStartTime) {
                    return 0.0f;
                }
                long j2 = this.mStopTime;
                if (j2 >= 0 && j >= j2) {
                    long j3 = j - j2;
                    float f = this.mStopValue;
                    return (1.0f - f) + (f * AutoScrollHelper.constrain(((float) j3) / this.mEffectiveRampDown, 0.0f, 1.0f));
                }
                return AutoScrollHelper.constrain(((float) (j - this.mStartTime)) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
            }
            return invokeJ.floatValue;
        }

        public int getDeltaX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDeltaX;
            }
            return invokeV.intValue;
        }

        public int getDeltaY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mDeltaY;
            }
            return invokeV.intValue;
        }

        public int getHorizontalDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                float f = this.mTargetVelocityX;
                return (int) (f / Math.abs(f));
            }
            return invokeV.intValue;
        }

        public int getVerticalDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                float f = this.mTargetVelocityY;
                return (int) (f / Math.abs(f));
            }
            return invokeV.intValue;
        }

        public boolean isFinished() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void requestStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
                this.mStopValue = getValueAt(currentAnimationTimeMillis);
                this.mStopTime = currentAnimationTimeMillis;
            }
        }

        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                this.mStartTime = currentAnimationTimeMillis;
                this.mStopTime = -1L;
                this.mDeltaTime = currentAnimationTimeMillis;
                this.mStopValue = 0.5f;
                this.mDeltaX = 0;
                this.mDeltaY = 0;
            }
        }

        public void setRampDownDuration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.mRampDownDuration = i;
            }
        }

        public void setRampUpDuration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.mRampUpDuration = i;
            }
        }

        public void setTargetVelocity(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.mTargetVelocityX = f;
                this.mTargetVelocityY = f2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoScrollHelper this$0;

        public ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoScrollHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = autoScrollHelper;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AutoScrollHelper autoScrollHelper = this.this$0;
                if (!autoScrollHelper.mAnimating) {
                    return;
                }
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.start();
                }
                ClampedScroller clampedScroller = this.this$0.mScroller;
                if (!clampedScroller.isFinished() && this.this$0.shouldAnimate()) {
                    AutoScrollHelper autoScrollHelper2 = this.this$0;
                    if (autoScrollHelper2.mNeedsCancel) {
                        autoScrollHelper2.mNeedsCancel = false;
                        autoScrollHelper2.cancelTargetTouch();
                    }
                    clampedScroller.computeScrollDelta();
                    this.this$0.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                    ViewCompat.postOnAnimation(this.this$0.mTarget, this);
                    return;
                }
                this.this$0.mAnimating = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333309380, "Landroidx/core/widget/AutoScrollHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-333309380, "Landroidx/core/widget/AutoScrollHelper;");
                return;
            }
        }
        DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    private void requestStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.mNeedsReset) {
                this.mAnimating = false;
            } else {
                this.mScroller.requestStop();
            }
        }
    }

    public void cancelTargetTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            this.mTarget.onTouchEvent(obtain);
            obtain.recycle();
        }
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isExclusive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExclusive;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ClampedScroller clampedScroller = this.mScroller;
            int verticalDirection = clampedScroller.getVerticalDirection();
            int horizontalDirection = clampedScroller.getHorizontalDirection();
            if ((verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AutoScrollHelper(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mScroller = new ClampedScroller();
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0.0f, 0.0f};
        this.mMaximumEdges = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mRelativeVelocity = new float[]{0.0f, 0.0f};
        this.mMinimumVelocity = new float[]{0.0f, 0.0f};
        this.mMaximumVelocity = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mTarget = view2;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        setMaximumVelocity(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        setMinimumVelocity(f3, f3);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i, float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float edgeValue = getEdgeValue(this.mRelativeEdges[i], f2, this.mMaximumEdges[i], f);
            int i2 = (edgeValue > 0.0f ? 1 : (edgeValue == 0.0f ? 0 : -1));
            if (i2 == 0) {
                return 0.0f;
            }
            float f4 = this.mRelativeVelocity[i];
            float f5 = this.mMinimumVelocity[i];
            float f6 = this.mMaximumVelocity[i];
            float f7 = f4 * f3;
            if (i2 > 0) {
                return constrain(edgeValue * f7, f5, f6);
            }
            return -constrain((-edgeValue) * f7, f5, f6);
        }
        return invokeCommon.floatValue;
    }

    private float getEdgeValue(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        float interpolation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float constrain = constrain(f * f2, 0.0f, f3);
            float constrainEdgeValue = constrainEdgeValue(f2 - f4, constrain) - constrainEdgeValue(f4, constrain);
            if (constrainEdgeValue < 0.0f) {
                interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
            } else if (constrainEdgeValue <= 0.0f) {
                return 0.0f;
            } else {
                interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
            }
            return constrain(interpolation, -1.0f, 1.0f);
        }
        return invokeCommon.floatValue;
    }

    private float constrainEdgeValue(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            int i = this.mEdgeType;
            if (i != 0 && i != 1) {
                if (i == 2 && f < 0.0f) {
                    return f / (-f2);
                }
            } else if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.mAnimating && this.mEdgeType == 1) {
                    return 1.0f;
                }
            }
            return 0.0f;
        }
        return invokeCommon.floatValue;
    }

    private void startAnimating() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.mRunnable == null) {
                this.mRunnable = new ScrollAnimationRunnable(this);
            }
            this.mAnimating = true;
            this.mNeedsReset = true;
            if (!this.mAlreadyDelayed && (i = this.mActivationDelay) > 0) {
                ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i);
            } else {
                this.mRunnable.run();
            }
            this.mAlreadyDelayed = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r0 != 3) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, motionEvent)) == null) {
            if (!this.mEnabled) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                    }
                }
                requestStop();
                if (!this.mExclusive && this.mAnimating) {
                    return true;
                }
            }
            this.mNeedsCancel = true;
            this.mAlreadyDelayed = false;
            this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent.getX(), view2.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent.getY(), view2.getHeight(), this.mTarget.getHeight()));
            if (!this.mAnimating && shouldAnimate()) {
                startAnimating();
            }
            return !this.mExclusive ? false : false;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public AutoScrollHelper setActivationDelay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.mActivationDelay = i;
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.mEdgeType = i;
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (this.mEnabled && !z) {
                requestStop();
            }
            this.mEnabled = z;
            return this;
        }
        return (AutoScrollHelper) invokeZ.objValue;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.mExclusive = z;
            return this;
        }
        return (AutoScrollHelper) invokeZ.objValue;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.mScroller.setRampDownDuration(i);
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.mScroller.setRampUpDuration(i);
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = this.mMaximumEdges;
            fArr[0] = f;
            fArr[1] = f2;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = this.mRelativeEdges;
            fArr[0] = f;
            fArr[1] = f2;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = this.mMaximumVelocity;
            fArr[0] = f / 1000.0f;
            fArr[1] = f2 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = this.mMinimumVelocity;
            fArr[0] = f / 1000.0f;
            fArr[1] = f2 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = this.mRelativeVelocity;
            fArr[0] = f / 1000.0f;
            fArr[1] = f2 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }
}
