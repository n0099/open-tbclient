package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    public transient /* synthetic */ FieldHolder $fh;
    public final CircleShape circleShape;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final Path path;
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    public CompoundTrimPathContent trimPaths;

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, baseLayer, circleShape};
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
        this.trimPaths = new CompoundTrimPathContent();
        this.name = circleShape.getName();
        this.lottieDrawable = lottieDrawable;
        this.sizeAnimation = circleShape.getSize().createAnimation();
        this.positionAnimation = circleShape.getPosition().createAnimation();
        this.circleShape = circleShape;
        baseLayer.addAnimation(this.sizeAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        this.sizeAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.isPathValid = false;
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            if (t == LottieProperty.ELLIPSE_SIZE) {
                this.sizeAnimation.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.POSITION) {
                this.positionAnimation.setValueCallback(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.isPathValid) {
                return this.path;
            }
            this.path.reset();
            if (this.circleShape.isHidden()) {
                this.isPathValid = true;
                return this.path;
            }
            PointF value = this.sizeAnimation.getValue();
            float f2 = value.x / 2.0f;
            float f3 = value.y / 2.0f;
            float f4 = f2 * 0.55228f;
            float f5 = 0.55228f * f3;
            this.path.reset();
            if (this.circleShape.isReversed()) {
                float f6 = -f3;
                this.path.moveTo(0.0f, f6);
                float f7 = 0.0f - f4;
                float f8 = -f2;
                float f9 = 0.0f - f5;
                this.path.cubicTo(f7, f6, f8, f9, f8, 0.0f);
                float f10 = f5 + 0.0f;
                this.path.cubicTo(f8, f10, f7, f3, 0.0f, f3);
                float f11 = f4 + 0.0f;
                this.path.cubicTo(f11, f3, f2, f10, f2, 0.0f);
                this.path.cubicTo(f2, f9, f11, f6, 0.0f, f6);
            } else {
                float f12 = -f3;
                this.path.moveTo(0.0f, f12);
                float f13 = f4 + 0.0f;
                float f14 = 0.0f - f5;
                this.path.cubicTo(f13, f12, f2, f14, f2, 0.0f);
                float f15 = f5 + 0.0f;
                this.path.cubicTo(f2, f15, f13, f3, 0.0f, f3);
                float f16 = 0.0f - f4;
                float f17 = -f2;
                this.path.cubicTo(f16, f3, f17, f15, f17, 0.0f);
                this.path.cubicTo(f17, f14, f16, f12, 0.0f, f12);
            }
            PointF value2 = this.positionAnimation.getValue();
            this.path.offset(value2.x, value2.y);
            this.path.close();
            this.trimPaths.apply(this.path);
            this.isPathValid = true;
            return this.path;
        }
        return (Path) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            invalidate();
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, keyPath, i2, list, keyPath2) == null) {
            MiscUtils.resolveKeyPath(keyPath, i2, list, keyPath2, this);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Content content = list.get(i2);
                if (content instanceof TrimPathContent) {
                    TrimPathContent trimPathContent = (TrimPathContent) content;
                    if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                        this.trimPaths.addTrimPath(trimPathContent);
                        trimPathContent.addListener(this);
                    }
                }
            }
        }
    }
}
