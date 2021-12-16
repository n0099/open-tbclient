package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    public final KeyframesWrapper<K> keyframesWrapper;
    @Nullable
    public LottieValueCallback<A> valueCallback;
    public final List<AnimationListener> listeners = new ArrayList(1);
    public boolean isDiscrete = false;
    public float progress = 0.0f;
    @Nullable
    public A cachedGetValue = null;
    public float cachedStartDelayProgress = -1.0f;
    public float cachedEndProgress = -1.0f;

    /* loaded from: classes9.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* loaded from: classes9.dex */
    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public EmptyKeyframeWrapper() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            return false;
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        public Keyframe<T> cachedCurrentKeyframe = null;
        public float cachedInterpolatedProgress = -1.0f;
        @NonNull
        public Keyframe<T> currentKeyframe = findKeyframe(0.0f);
        public final List<? extends Keyframe<T>> keyframes;

        public KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
        }

        private Keyframe<T> findKeyframe(float f2) {
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

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            List<? extends Keyframe<T>> list = this.keyframes;
            return list.get(list.size() - 1).getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframes.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            if (this.cachedCurrentKeyframe == this.currentKeyframe && this.cachedInterpolatedProgress == f2) {
                return true;
            }
            this.cachedCurrentKeyframe = this.currentKeyframe;
            this.cachedInterpolatedProgress = f2;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            if (this.currentKeyframe.containsProgress(f2)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f2);
            return true;
        }
    }

    /* loaded from: classes9.dex */
    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public float cachedInterpolatedProgress = -1.0f;
        @NonNull
        public final Keyframe<T> keyframe;

        public SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f2) {
            if (this.cachedInterpolatedProgress == f2) {
                return true;
            }
            this.cachedInterpolatedProgress = f2;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f2) {
            return !this.keyframe.isStatic();
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.keyframesWrapper = wrap(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    public static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        if (list.size() == 1) {
            return new SingleKeyframeWrapper(list);
        }
        return new KeyframesWrapperImpl(list);
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public Keyframe<K> getCurrentKeyframe() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    public float getProgress() {
        return this.progress;
    }

    public A getValue() {
        float interpolatedCurrentKeyframeProgress = getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(interpolatedCurrentKeyframeProgress)) {
            return this.cachedGetValue;
        }
        A value = getValue(getCurrentKeyframe(), interpolatedCurrentKeyframeProgress);
        this.cachedGetValue = value;
        return value;
    }

    public abstract A getValue(Keyframe<K> keyframe, float f2);

    public void notifyListeners() {
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            this.listeners.get(i2).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.keyframesWrapper.isEmpty()) {
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
