package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LottieComposition composition;
    public float frame;
    public long lastFrameTimeNs;
    public float maxFrame;
    public float minFrame;
    public int repeatCount;
    @VisibleForTesting
    public boolean running;
    public float speed;
    public boolean speedReversedForRepeatMode;

    public LottieValueAnimator() {
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
        this.speed = 1.0f;
        this.speedReversedForRepeatMode = false;
        this.lastFrameTimeNs = 0L;
        this.frame = 0.0f;
        this.repeatCount = 0;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
        this.running = false;
    }

    private float getFrameDurationNs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return Float.MAX_VALUE;
            }
            return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
        }
        return invokeV.floatValue;
    }

    private boolean isReversed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? getSpeed() < 0.0f : invokeV.booleanValue;
    }

    private void verifyFrame() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.composition == null) {
            return;
        }
        float f2 = this.frame;
        if (f2 < this.minFrame || f2 > this.maxFrame) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            notifyCancel();
            removeFrameCallback();
        }
    }

    public void clearComposition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.composition = null;
            this.minFrame = -2.1474836E9f;
            this.maxFrame = 2.1474836E9f;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            postFrameCallback();
            if (this.composition == null || !isRunning()) {
                return;
            }
            L.beginSection("LottieValueAnimator#doFrame");
            long j2 = this.lastFrameTimeNs;
            float frameDurationNs = ((float) (j2 != 0 ? j - j2 : 0L)) / getFrameDurationNs();
            float f2 = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            float f3 = f2 + frameDurationNs;
            this.frame = f3;
            boolean z = !MiscUtils.contains(f3, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j;
            notifyUpdate();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                } else {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = j;
                }
            }
            verifyFrame();
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            removeFrameCallback();
            notifyEnd(isReversed());
        }
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        InterceptResult invokeV;
        float minFrame;
        float maxFrame;
        float minFrame2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.composition == null) {
                return 0.0f;
            }
            if (isReversed()) {
                minFrame = getMaxFrame() - this.frame;
                maxFrame = getMaxFrame();
                minFrame2 = getMinFrame();
            } else {
                minFrame = this.frame - getMinFrame();
                maxFrame = getMaxFrame();
                minFrame2 = getMinFrame();
            }
            return minFrame / (maxFrame - minFrame2);
        }
        return invokeV.floatValue;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Float.valueOf(getAnimatedValueAbsolute()) : invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return 0.0f;
            }
            return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
        }
        return invokeV.floatValue;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return 0L;
            }
            return lottieComposition.getDuration();
        }
        return invokeV.longValue;
    }

    public float getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.frame : invokeV.floatValue;
    }

    public float getMaxFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return 0.0f;
            }
            float f2 = this.maxFrame;
            return f2 == 2.1474836E9f ? lottieComposition.getEndFrame() : f2;
        }
        return invokeV.floatValue;
    }

    public float getMinFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return 0.0f;
            }
            float f2 = this.minFrame;
            return f2 == -2.1474836E9f ? lottieComposition.getStartFrame() : f2;
        }
        return invokeV.floatValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.speed : invokeV.floatValue;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.running : invokeV.booleanValue;
    }

    @MainThread
    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            removeFrameCallback();
        }
    }

    @MainThread
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.running = true;
            notifyStart(isReversed());
            setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
            this.lastFrameTimeNs = 0L;
            this.repeatCount = 0;
            postFrameCallback();
        }
    }

    public void postFrameCallback() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void removeFrameCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            removeFrameCallback(true);
        }
    }

    @MainThread
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.running = true;
            postFrameCallback();
            this.lastFrameTimeNs = 0L;
            if (isReversed() && getFrame() == getMinFrame()) {
                this.frame = getMaxFrame();
            } else if (isReversed() || getFrame() != getMaxFrame()) {
            } else {
                this.frame = getMinFrame();
            }
        }
    }

    public void reverseAnimationSpeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            setSpeed(-getSpeed());
        }
    }

    public void setComposition(LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, lottieComposition) == null) {
            boolean z = this.composition == null;
            this.composition = lottieComposition;
            if (z) {
                setMinAndMaxFrames((int) Math.max(this.minFrame, lottieComposition.getStartFrame()), (int) Math.min(this.maxFrame, lottieComposition.getEndFrame()));
            } else {
                setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
            }
            float f2 = this.frame;
            this.frame = 0.0f;
            setFrame((int) f2);
            notifyUpdate();
        }
    }

    public void setFrame(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048597, this, f2) == null) || this.frame == f2) {
            return;
        }
        this.frame = MiscUtils.clamp(f2, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public void setMaxFrame(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            setMinAndMaxFrames(this.minFrame, f2);
        }
    }

    public void setMinAndMaxFrames(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 <= f3) {
                LottieComposition lottieComposition = this.composition;
                float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
                LottieComposition lottieComposition2 = this.composition;
                float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
                this.minFrame = MiscUtils.clamp(f2, startFrame, endFrame);
                this.maxFrame = MiscUtils.clamp(f3, startFrame, endFrame);
                setFrame((int) MiscUtils.clamp(this.frame, f2, f3));
                return;
            }
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
        }
    }

    public void setMinFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            setMinAndMaxFrames(i2, (int) this.maxFrame);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            super.setRepeatMode(i2);
            if (i2 == 2 || !this.speedReversedForRepeatMode) {
                return;
            }
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            this.speed = f2;
        }
    }

    @MainThread
    public void removeFrameCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            Choreographer.getInstance().removeFrameCallback(this);
            if (z) {
                this.running = false;
            }
        }
    }
}
