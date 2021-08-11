package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean hidden;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final Path path;
    public final BaseKeyframeAnimation<?, Path> shapeAnimation;
    public CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, baseLayer, shapePath};
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
        this.name = shapePath.getName();
        this.hidden = shapePath.isHidden();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> createAnimation = shapePath.getShapePath().createAnimation();
        this.shapeAnimation = createAnimation;
        baseLayer.addAnimation(createAnimation);
        this.shapeAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.isPathValid = false;
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.isPathValid) {
                return this.path;
            }
            this.path.reset();
            if (this.hidden) {
                this.isPathValid = true;
                return this.path;
            }
            this.path.set(this.shapeAnimation.getValue());
            this.path.setFillType(Path.FillType.EVEN_ODD);
            this.trimPaths.apply(this.path);
            this.isPathValid = true;
            return this.path;
        }
        return (Path) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            invalidate();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
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
