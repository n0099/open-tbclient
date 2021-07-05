package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes.dex */
public class TransformKeyframeAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    @Nullable
    public BaseKeyframeAnimation<?, Float> endOpacity;
    public final Matrix matrix;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatableTransform};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.matrix = new Matrix();
        this.anchorPoint = animatableTransform.getAnchorPoint() == null ? null : animatableTransform.getAnchorPoint().createAnimation();
        this.position = animatableTransform.getPosition() == null ? null : animatableTransform.getPosition().createAnimation();
        this.scale = animatableTransform.getScale() == null ? null : animatableTransform.getScale().createAnimation();
        this.rotation = animatableTransform.getRotation() == null ? null : animatableTransform.getRotation().createAnimation();
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.getSkew() == null ? null : (FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
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
        this.skewAngle = animatableTransform.getSkewAngle() == null ? null : (FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                this.skewValues[i2] = 0.0f;
            }
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseLayer) == null) {
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
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animationListener) == null) {
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
    }

    public <T> boolean applyValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        InterceptResult invokeLL;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, lottieValueCallback)) == null) {
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
            } else if (t != LottieProperty.TRANSFORM_SKEW_ANGLE || (floatKeyframeAnimation = this.skewAngle) == null) {
                return false;
            } else {
                if (floatKeyframeAnimation == null) {
                    this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.skewAngle.setValueCallback(lottieValueCallback);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.endOpacity : (BaseKeyframeAnimation) invokeV.objValue;
    }

    public Matrix getMatrix() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                float cos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((-floatKeyframeAnimation.getFloatValue()) + 90.0f));
                FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
                float sin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-floatKeyframeAnimation2.getFloatValue()) + 90.0f));
                clearSkewValues();
                float[] fArr = this.skewValues;
                fArr[0] = cos;
                fArr[1] = sin;
                float f2 = -sin;
                fArr[3] = f2;
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
                fArr3[1] = f2;
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
        return (Matrix) invokeV.objValue;
    }

    public Matrix getMatrixForRepeater(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
            PointF value = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.getValue();
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.scale;
            ScaleXY value2 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.getValue();
            this.matrix.reset();
            if (value != null) {
                this.matrix.preTranslate(value.x * f2, value.y * f2);
            }
            if (value2 != null) {
                double d2 = f2;
                this.matrix.preScale((float) Math.pow(value2.getScaleX(), d2), (float) Math.pow(value2.getScaleY(), d2));
            }
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.rotation;
            if (baseKeyframeAnimation3 != null) {
                float floatValue = baseKeyframeAnimation3.getValue().floatValue();
                BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
                PointF value3 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.getValue() : null;
                this.matrix.preRotate(floatValue * f2, value3 == null ? 0.0f : value3.x, value3 != null ? value3.y : 0.0f);
            }
            return this.matrix;
        }
        return (Matrix) invokeF.objValue;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.opacity : (BaseKeyframeAnimation) invokeV.objValue;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.startOpacity : (BaseKeyframeAnimation) invokeV.objValue;
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setProgress(f2);
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.setProgress(f2);
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
            if (baseKeyframeAnimation3 != null) {
                baseKeyframeAnimation3.setProgress(f2);
            }
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            if (baseKeyframeAnimation4 != null) {
                baseKeyframeAnimation4.setProgress(f2);
            }
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
            if (baseKeyframeAnimation5 != null) {
                baseKeyframeAnimation5.setProgress(f2);
            }
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
            if (baseKeyframeAnimation6 != null) {
                baseKeyframeAnimation6.setProgress(f2);
            }
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
            if (baseKeyframeAnimation7 != null) {
                baseKeyframeAnimation7.setProgress(f2);
            }
            FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
            if (floatKeyframeAnimation != null) {
                floatKeyframeAnimation.setProgress(f2);
            }
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
            if (floatKeyframeAnimation2 != null) {
                floatKeyframeAnimation2.setProgress(f2);
            }
        }
    }
}
