package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;
/* loaded from: classes.dex */
public class TransformKeyframeAnimation {
    @NonNull
    public BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    @Nullable
    public BaseKeyframeAnimation<?, Float> endOpacity;
    public final Matrix matrix = new Matrix();
    @NonNull
    public BaseKeyframeAnimation<Integer, Integer> opacity;
    @NonNull
    public BaseKeyframeAnimation<?, PointF> position;
    @NonNull
    public BaseKeyframeAnimation<Float, Float> rotation;
    @NonNull
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    @Nullable
    public FloatKeyframeAnimation skew;
    @Nullable
    public FloatKeyframeAnimation skewAngle;
    public final Matrix skewMatrix1;
    public final Matrix skewMatrix2;
    public final Matrix skewMatrix3;
    public final float[] skewValues;
    @Nullable
    public BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (animatableTransform.getAnchorPoint() == null) {
            createAnimation = null;
        } else {
            createAnimation = animatableTransform.getAnchorPoint().createAnimation();
        }
        this.anchorPoint = createAnimation;
        if (animatableTransform.getPosition() == null) {
            createAnimation2 = null;
        } else {
            createAnimation2 = animatableTransform.getPosition().createAnimation();
        }
        this.position = createAnimation2;
        if (animatableTransform.getScale() == null) {
            createAnimation3 = null;
        } else {
            createAnimation3 = animatableTransform.getScale().createAnimation();
        }
        this.scale = createAnimation3;
        if (animatableTransform.getRotation() == null) {
            createAnimation4 = null;
        } else {
            createAnimation4 = animatableTransform.getRotation().createAnimation();
        }
        this.rotation = createAnimation4;
        if (animatableTransform.getSkew() == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
        }
        this.skew = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        if (animatableTransform.getSkewAngle() == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
        }
        this.skewAngle = floatKeyframeAnimation2;
        if (animatableTransform.getOpacity() != null) {
            this.opacity = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.startOpacity = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    private void clearSkewValues() {
        for (int i = 0; i < 9; i++) {
            this.skewValues[i] = 0.0f;
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.skew);
        baseLayer.addAnimation(this.skewAngle);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public void setProgress(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f);
        }
    }

    public <T> boolean applyValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.anchorPoint;
            if (baseKeyframeAnimation3 == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
            if (baseKeyframeAnimation4 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_SCALE) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.scale;
            if (baseKeyframeAnimation5 == null) {
                this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_ROTATION) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.rotation;
            if (baseKeyframeAnimation6 == null) {
                this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_OPACITY) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
            if (baseKeyframeAnimation7 == null) {
                this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.startOpacity) != null) {
            if (baseKeyframeAnimation2 == null) {
                this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_END_OPACITY && (baseKeyframeAnimation = this.endOpacity) != null) {
            if (baseKeyframeAnimation == null) {
                this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_SKEW && (floatKeyframeAnimation2 = this.skew) != null) {
            if (floatKeyframeAnimation2 == null) {
                this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.skew.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_SKEW_ANGLE && (floatKeyframeAnimation = this.skewAngle) != null) {
            if (floatKeyframeAnimation == null) {
                this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.skewAngle.setValueCallback(lottieValueCallback);
            return true;
        } else {
            return false;
        }
    }

    public Matrix getMatrix() {
        float cos;
        float sin;
        float floatValue;
        this.matrix.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        if (baseKeyframeAnimation != null) {
            PointF value = baseKeyframeAnimation.getValue();
            if (value.x != 0.0f || value.y != 0.0f) {
                this.matrix.preTranslate(value.x, value.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.rotation;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                floatValue = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (floatValue != 0.0f) {
                this.matrix.preRotate(floatValue);
            }
        }
        if (this.skew != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.skewAngle;
            if (floatKeyframeAnimation == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-floatKeyframeAnimation.getFloatValue()) + 90.0f));
            }
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
            if (floatKeyframeAnimation2 == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-floatKeyframeAnimation2.getFloatValue()) + 90.0f));
            }
            clearSkewValues();
            float[] fArr = this.skewValues;
            fArr[0] = cos;
            fArr[1] = sin;
            float f = -sin;
            fArr[3] = f;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.skewMatrix1.setValues(fArr);
            clearSkewValues();
            float[] fArr2 = this.skewValues;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.skew.getFloatValue()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.skewMatrix2.setValues(fArr2);
            clearSkewValues();
            float[] fArr3 = this.skewValues;
            fArr3[0] = cos;
            fArr3[1] = f;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.skewMatrix3.setValues(fArr3);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.scale;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY value2 = baseKeyframeAnimation3.getValue();
            if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
                this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            PointF value3 = baseKeyframeAnimation4.getValue();
            if (value3.x != 0.0f || value3.y != 0.0f) {
                this.matrix.preTranslate(-value3.x, -value3.y);
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f) {
        PointF value;
        ScaleXY value2;
        float f2;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        PointF pointF = null;
        if (baseKeyframeAnimation == null) {
            value = null;
        } else {
            value = baseKeyframeAnimation.getValue();
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.scale;
        if (baseKeyframeAnimation2 == null) {
            value2 = null;
        } else {
            value2 = baseKeyframeAnimation2.getValue();
        }
        this.matrix.reset();
        if (value != null) {
            this.matrix.preTranslate(value.x * f, value.y * f);
        }
        if (value2 != null) {
            double d = f;
            this.matrix.preScale((float) Math.pow(value2.getScaleX(), d), (float) Math.pow(value2.getScaleY(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.rotation;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.getValue();
            }
            Matrix matrix = this.matrix;
            float f3 = floatValue * f;
            float f4 = 0.0f;
            if (pointF == null) {
                f2 = 0.0f;
            } else {
                f2 = pointF.x;
            }
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f2, f4);
        }
        return this.matrix;
    }
}
