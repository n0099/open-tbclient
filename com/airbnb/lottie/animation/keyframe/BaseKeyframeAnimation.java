package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float cachedEndProgress;
    @Nullable
    public A cachedGetValue;
    public float cachedStartDelayProgress;
    public boolean isDiscrete;
    public final KeyframesWrapper<K> keyframesWrapper;
    public final List<AnimationListener> listeners;
    public float progress;
    @Nullable
    public LottieValueCallback<A> valueCallback;

    /* renamed from: com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* loaded from: classes.dex */
    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EmptyKeyframeWrapper() {
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

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new IllegalStateException("not implemented");
            }
            return (Keyframe) invokeV.objValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                throw new IllegalStateException("not implemented");
            }
            return invokeF.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                return false;
            }
            return invokeF.booleanValue;
        }

        public /* synthetic */ EmptyKeyframeWrapper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getEndProgress();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f2);

        boolean isEmpty();

        boolean isValueChanged(float f2);
    }

    /* loaded from: classes.dex */
    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Keyframe<T> cachedCurrentKeyframe;
        public float cachedInterpolatedProgress;
        @NonNull
        public Keyframe<T> currentKeyframe;
        public final List<? extends Keyframe<T>> keyframes;

        public KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cachedCurrentKeyframe = null;
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframes = list;
            this.currentKeyframe = findKeyframe(0.0f);
        }

        private Keyframe<T> findKeyframe(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(65537, this, f2)) == null) {
                List<? extends Keyframe<T>> list = this.keyframes;
                Keyframe<T> keyframe = list.get(list.size() - 1);
                if (f2 >= keyframe.getStartProgress()) {
                    return keyframe;
                }
                for (int size = this.keyframes.size() - 2; size >= 1; size--) {
                    Keyframe<T> keyframe2 = this.keyframes.get(size);
                    if (this.currentKeyframe != keyframe2 && keyframe2.containsProgress(f2)) {
                        return keyframe2;
                    }
                }
                return this.keyframes.get(0);
            }
            return (Keyframe) invokeF.objValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public Keyframe<T> getCurrentKeyframe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.currentKeyframe : (Keyframe) invokeV.objValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<? extends Keyframe<T>> list = this.keyframes;
                return list.get(list.size() - 1).getEndProgress();
            }
            return invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.keyframes.get(0).getStartProgress() : invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                if (this.cachedCurrentKeyframe == this.currentKeyframe && this.cachedInterpolatedProgress == f2) {
                    return true;
                }
                this.cachedCurrentKeyframe = this.currentKeyframe;
                this.cachedInterpolatedProgress = f2;
                return false;
            }
            return invokeF.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                if (this.currentKeyframe.containsProgress(f2)) {
                    return !this.currentKeyframe.isStatic();
                }
                this.currentKeyframe = findKeyframe(f2);
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float cachedInterpolatedProgress;
        @NonNull
        public final Keyframe<T> keyframe;

        public SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframe = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.keyframe : (Keyframe) invokeV.objValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.keyframe.getEndProgress() : invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.keyframe.getStartProgress() : invokeV.floatValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                if (this.cachedInterpolatedProgress == f2) {
                    return true;
                }
                this.cachedInterpolatedProgress = f2;
                return false;
            }
            return invokeF.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) ? !this.keyframe.isStatic() : invokeF.booleanValue;
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listeners = new ArrayList(1);
        this.isDiscrete = false;
        this.progress = 0.0f;
        this.cachedGetValue = null;
        this.cachedStartDelayProgress = -1.0f;
        this.cachedEndProgress = -1.0f;
        this.keyframesWrapper = wrap(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float getStartDelayProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.cachedStartDelayProgress == -1.0f) {
                this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
            }
            return this.cachedStartDelayProgress;
        }
        return invokeV.floatValue;
    }

    public static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list.isEmpty()) {
                return new EmptyKeyframeWrapper(null);
            }
            if (list.size() == 1) {
                return new SingleKeyframeWrapper(list);
            }
            return new KeyframesWrapperImpl(list);
        }
        return (KeyframesWrapper) invokeL.objValue;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationListener) == null) {
            this.listeners.add(animationListener);
        }
    }

    public Keyframe<K> getCurrentKeyframe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
            Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
            L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
            return currentKeyframe;
        }
        return (Keyframe) invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getEndProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.cachedEndProgress == -1.0f) {
                this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
            }
            return this.cachedEndProgress;
        }
        return invokeV.floatValue;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Keyframe<K> currentKeyframe = getCurrentKeyframe();
            if (currentKeyframe.isStatic()) {
                return 0.0f;
            }
            return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
        }
        return invokeV.floatValue;
    }

    public float getLinearCurrentKeyframeProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.isDiscrete) {
                return 0.0f;
            }
            Keyframe<K> currentKeyframe = getCurrentKeyframe();
            if (currentKeyframe.isStatic()) {
                return 0.0f;
            }
            return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
        }
        return invokeV.floatValue;
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.progress : invokeV.floatValue;
    }

    public A getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float interpolatedCurrentKeyframeProgress = getInterpolatedCurrentKeyframeProgress();
            if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(interpolatedCurrentKeyframeProgress)) {
                return this.cachedGetValue;
            }
            A value = getValue(getCurrentKeyframe(), interpolatedCurrentKeyframeProgress);
            this.cachedGetValue = value;
            return value;
        }
        return (A) invokeV.objValue;
    }

    public abstract A getValue(Keyframe<K> keyframe, float f2);

    public void notifyListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onValueChanged();
            }
        }
    }

    public void setIsDiscrete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.isDiscrete = true;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048586, this, f2) == null) || this.keyframesWrapper.isEmpty()) {
            return;
        }
        if (f2 < getStartDelayProgress()) {
            f2 = getStartDelayProgress();
        } else if (f2 > getEndProgress()) {
            f2 = getEndProgress();
        }
        if (f2 == this.progress) {
            return;
        }
        this.progress = f2;
        if (this.keyframesWrapper.isValueChanged(f2)) {
            notifyListeners();
        }
    }

    public void setValueCallback(@Nullable LottieValueCallback<A> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lottieValueCallback) == null) {
            LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
            if (lottieValueCallback2 != null) {
                lottieValueCallback2.setAnimation(null);
            }
            this.valueCallback = lottieValueCallback;
            if (lottieValueCallback != null) {
                lottieValueCallback.setAnimation(this);
            }
        }
    }
}
