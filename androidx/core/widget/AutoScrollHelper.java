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

        public ClampedScroller() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        private float getValueAt(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j2)) == null) {
                if (j2 < this.mStartTime) {
                    return 0.0f;
                }
                long j3 = this.mStopTime;
                if (j3 >= 0 && j2 >= j3) {
                    long j4 = j2 - j3;
                    float f2 = this.mStopValue;
                    return (1.0f - f2) + (f2 * AutoScrollHelper.constrain(((float) j4) / this.mEffectiveRampDown, 0.0f, 1.0f));
                }
                return AutoScrollHelper.constrain(((float) (j2 - this.mStartTime)) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
            }
            return invokeJ.floatValue;
        }

        private float interpolateValue(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f2)) == null) ? ((-4.0f) * f2 * f2) + (f2 * 4.0f) : invokeF.floatValue;
        }

        public void computeScrollDelta() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mDeltaTime != 0) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                    this.mDeltaTime = currentAnimationTimeMillis;
                    float f2 = ((float) (currentAnimationTimeMillis - this.mDeltaTime)) * interpolateValue;
                    this.mDeltaX = (int) (this.mTargetVelocityX * f2);
                    this.mDeltaY = (int) (f2 * this.mTargetVelocityY);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }

        public int getDeltaX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDeltaX : invokeV.intValue;
        }

        public int getDeltaY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDeltaY : invokeV.intValue;
        }

        public int getHorizontalDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                float f2 = this.mTargetVelocityX;
                return (int) (f2 / Math.abs(f2));
            }
            return invokeV.intValue;
        }

        public int getVerticalDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                float f2 = this.mTargetVelocityY;
                return (int) (f2 / Math.abs(f2));
            }
            return invokeV.intValue;
        }

        public boolean isFinished() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown) : invokeV.booleanValue;
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

        public void setRampDownDuration(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.mRampDownDuration = i2;
            }
        }

        public void setRampUpDuration(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.mRampUpDuration = i2;
            }
        }

        public void setTargetVelocity(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.mTargetVelocityX = f2;
                this.mTargetVelocityY = f3;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (autoScrollHelper.mAnimating) {
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

    public AutoScrollHelper(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.mTarget = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        setMaximumVelocity(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        setMinimumVelocity(f4, f4);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i2, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float edgeValue = getEdgeValue(this.mRelativeEdges[i2], f3, this.mMaximumEdges[i2], f2);
            int i3 = (edgeValue > 0.0f ? 1 : (edgeValue == 0.0f ? 0 : -1));
            if (i3 == 0) {
                return 0.0f;
            }
            float f5 = this.mRelativeVelocity[i2];
            float f6 = this.mMinimumVelocity[i2];
            float f7 = this.mMaximumVelocity[i2];
            float f8 = f5 * f4;
            if (i3 > 0) {
                return constrain(edgeValue * f8, f6, f7);
            }
            return -constrain((-edgeValue) * f8, f6, f7);
        }
        return invokeCommon.floatValue;
    }

    public static float constrain(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 > f4 ? f4 : f2 < f3 ? f3 : f2 : invokeCommon.floatValue;
    }

    public static int constrain(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    private float constrainEdgeValue(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            int i2 = this.mEdgeType;
            if (i2 == 0 || i2 == 1) {
                if (f2 < f3) {
                    if (f2 >= 0.0f) {
                        return 1.0f - (f2 / f3);
                    }
                    if (this.mAnimating && this.mEdgeType == 1) {
                        return 1.0f;
                    }
                }
            } else if (i2 == 2 && f2 < 0.0f) {
                return f2 / (-f3);
            }
            return 0.0f;
        }
        return invokeCommon.floatValue;
    }

    private float getEdgeValue(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        float interpolation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float constrain = constrain(f2 * f3, 0.0f, f4);
            float constrainEdgeValue = constrainEdgeValue(f3 - f5, constrain) - constrainEdgeValue(f5, constrain);
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

    private void startAnimating() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.mRunnable == null) {
                this.mRunnable = new ScrollAnimationRunnable(this);
            }
            this.mAnimating = true;
            this.mNeedsReset = true;
            if (!this.mAlreadyDelayed && (i2 = this.mActivationDelay) > 0) {
                ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i2);
            } else {
                this.mRunnable.run();
            }
            this.mAlreadyDelayed = true;
        }
    }

    public abstract boolean canTargetScrollHorizontally(int i2);

    public abstract boolean canTargetScrollVertically(int i2);

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEnabled : invokeV.booleanValue;
    }

    public boolean isExclusive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mExclusive : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r0 != 3) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, view, motionEvent)) != null) {
            return invokeLL.booleanValue;
        }
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
            return this.mExclusive && this.mAnimating;
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight()));
        if (!this.mAnimating && shouldAnimate()) {
            startAnimating();
        }
        if (this.mExclusive) {
            return false;
        }
    }

    public abstract void scrollTargetBy(int i2, int i3);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mActivationDelay = i2;
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mEdgeType = i2;
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
    public AutoScrollHelper setMaximumEdges(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.mMaximumEdges;
            fArr[0] = f2;
            fArr[1] = f3;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.mMaximumVelocity;
            fArr[0] = f2 / 1000.0f;
            fArr[1] = f3 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.mMinimumVelocity;
            fArr[0] = f2 / 1000.0f;
            fArr[1] = f3 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.mScroller.setRampDownDuration(i2);
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.mScroller.setRampUpDuration(i2);
            return this;
        }
        return (AutoScrollHelper) invokeI.objValue;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.mRelativeEdges;
            fArr[0] = f2;
            fArr[1] = f3;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.mRelativeVelocity;
            fArr[0] = f2 / 1000.0f;
            fArr[1] = f3 / 1000.0f;
            return this;
        }
        return (AutoScrollHelper) invokeCommon.objValue;
    }

    public boolean shouldAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ClampedScroller clampedScroller = this.mScroller;
            int verticalDirection = clampedScroller.getVerticalDirection();
            int horizontalDirection = clampedScroller.getHorizontalDirection();
            return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
        }
        return invokeV.booleanValue;
    }
}
