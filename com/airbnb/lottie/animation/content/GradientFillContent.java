package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHE_STEPS_MS = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF boundsRect;
    public final int cacheSteps;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    @Nullable
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LongSparseArray<LinearGradient> linearGradientCache;
    public final LottieDrawable lottieDrawable;
    @NonNull
    public final String name;
    public final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    public final Paint paint;
    public final Path path;
    public final List<PathContent> paths;
    public final LongSparseArray<RadialGradient> radialGradientCache;
    public final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    public final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, baseLayer, gradientFill};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.linearGradientCache = new LongSparseArray<>();
        this.radialGradientCache = new LongSparseArray<>();
        this.path = new Path();
        this.paint = new LPaint(1);
        this.boundsRect = new RectF();
        this.paths = new ArrayList();
        this.layer = baseLayer;
        this.name = gradientFill.getName();
        this.hidden = gradientFill.isHidden();
        this.lottieDrawable = lottieDrawable;
        this.type = gradientFill.getGradientType();
        this.path.setFillType(gradientFill.getFillType());
        this.cacheSteps = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientFill.getGradientColor().createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = gradientFill.getOpacity().createAnimation();
        this.opacityAnimation = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.opacityAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientFill.getStartPoint().createAnimation();
        this.startPointAnimation = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(this.startPointAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = gradientFill.getEndPoint().createAnimation();
        this.endPointAnimation = createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    private int[] applyDynamicColorsIfNeeded(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation != null) {
                Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
                int i2 = 0;
                if (iArr.length == numArr.length) {
                    while (i2 < iArr.length) {
                        iArr[i2] = numArr[i2].intValue();
                        i2++;
                    }
                } else {
                    iArr = new int[numArr.length];
                    while (i2 < numArr.length) {
                        iArr[i2] = numArr[i2].intValue();
                        i2++;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private int getGradientHash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int round = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
            int round2 = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
            int round3 = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
            int i2 = round != 0 ? 527 * round : 17;
            if (round2 != 0) {
                i2 = i2 * 31 * round2;
            }
            return round3 != 0 ? i2 * 31 * round3 : i2;
        }
        return invokeV.intValue;
    }

    private LinearGradient getLinearGradient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            long gradientHash = getGradientHash();
            LinearGradient linearGradient = this.linearGradientCache.get(gradientHash);
            if (linearGradient != null) {
                return linearGradient;
            }
            PointF value = this.startPointAnimation.getValue();
            PointF value2 = this.endPointAnimation.getValue();
            GradientColor value3 = this.colorAnimation.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, applyDynamicColorsIfNeeded(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
            this.linearGradientCache.put(gradientHash, linearGradient2);
            return linearGradient2;
        }
        return (LinearGradient) invokeV.objValue;
    }

    private RadialGradient getRadialGradient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            long gradientHash = getGradientHash();
            RadialGradient radialGradient = this.radialGradientCache.get(gradientHash);
            if (radialGradient != null) {
                return radialGradient;
            }
            PointF value = this.startPointAnimation.getValue();
            PointF value2 = this.endPointAnimation.getValue();
            GradientColor value3 = this.colorAnimation.getValue();
            int[] applyDynamicColorsIfNeeded = applyDynamicColorsIfNeeded(value3.getColors());
            float[] positions = value3.getPositions();
            float f2 = value.x;
            float f3 = value.y;
            float hypot = (float) Math.hypot(value2.x - f2, value2.y - f3);
            RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot <= 0.0f ? 0.001f : hypot, applyDynamicColorsIfNeeded, positions, Shader.TileMode.CLAMP);
            this.radialGradientCache.put(gradientHash, radialGradient2);
            return radialGradient2;
        }
        return (RadialGradient) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            if (t == LottieProperty.OPACITY) {
                this.opacityAnimation.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.COLOR_FILTER) {
                BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
                if (baseKeyframeAnimation != null) {
                    this.layer.removeAnimation(baseKeyframeAnimation);
                }
                if (lottieValueCallback == null) {
                    this.colorFilterAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.colorFilterAnimation = valueCallbackKeyframeAnimation;
                valueCallbackKeyframeAnimation.addUpdateListener(this);
                this.layer.addAnimation(this.colorFilterAnimation);
            } else if (t == LottieProperty.GRADIENT_COLOR) {
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.colorCallbackAnimation;
                if (valueCallbackKeyframeAnimation2 != null) {
                    this.layer.removeAnimation(valueCallbackKeyframeAnimation2);
                }
                if (lottieValueCallback == null) {
                    this.colorCallbackAnimation = null;
                    return;
                }
                this.linearGradientCache.clear();
                this.radialGradientCache.clear();
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.colorCallbackAnimation = valueCallbackKeyframeAnimation3;
                valueCallbackKeyframeAnimation3.addUpdateListener(this);
                this.layer.addAnimation(this.colorCallbackAnimation);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Shader radialGradient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || this.hidden) {
            return;
        }
        L.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i3 = 0; i3 < this.paths.size(); i3++) {
            this.path.addPath(this.paths.get(i3).getPath(), matrix);
        }
        this.path.computeBounds(this.boundsRect, false);
        if (this.type == GradientType.LINEAR) {
            radialGradient = getLinearGradient();
        } else {
            radialGradient = getRadialGradient();
        }
        radialGradient.setLocalMatrix(matrix);
        this.paint.setShader(radialGradient);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i2 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        L.endSection("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix, z) == null) {
            this.path.reset();
            for (int i2 = 0; i2 < this.paths.size(); i2++) {
                this.path.addPath(this.paths.get(i2).getPath(), matrix);
            }
            this.path.computeBounds(rectF, false);
            rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, keyPath, i2, list, keyPath2) == null) {
            MiscUtils.resolveKeyPath(keyPath, i2, list, keyPath2, this);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                Content content = list2.get(i2);
                if (content instanceof PathContent) {
                    this.paths.add((PathContent) content);
                }
            }
        }
    }
}
