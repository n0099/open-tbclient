package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AnimatableTextProperties {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final AnimatableColorValue color;
    @Nullable
    public final AnimatableColorValue stroke;
    @Nullable
    public final AnimatableFloatValue strokeWidth;
    @Nullable
    public final AnimatableFloatValue tracking;

    public AnimatableTextProperties(@Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableColorValue animatableColorValue2, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableFloatValue animatableFloatValue2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
    }
}
