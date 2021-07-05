package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
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
/* loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    public final Paint paint;
    public final Path path;
    public final List<PathContent> paths;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, baseLayer, shapeFill};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.path = new Path();
        this.paint = new LPaint(1);
        this.paths = new ArrayList();
        this.layer = baseLayer;
        this.name = shapeFill.getName();
        this.hidden = shapeFill.isHidden();
        this.lottieDrawable = lottieDrawable;
        if (shapeFill.getColor() != null && shapeFill.getOpacity() != null) {
            this.path.setFillType(shapeFill.getFillType());
            BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeFill.getColor().createAnimation();
            this.colorAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.colorAnimation);
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = shapeFill.getOpacity().createAnimation();
            this.opacityAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(this.opacityAnimation);
            return;
        }
        this.colorAnimation = null;
        this.opacityAnimation = null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            if (t == LottieProperty.COLOR) {
                this.colorAnimation.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.OPACITY) {
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
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || this.hidden) {
            return;
        }
        L.beginSection("FillContent#draw");
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i2 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.path.reset();
        for (int i3 = 0; i3 < this.paths.size(); i3++) {
            this.path.addPath(this.paths.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        L.endSection("FillContent#draw");
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
