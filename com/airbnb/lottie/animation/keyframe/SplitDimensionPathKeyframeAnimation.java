package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PointF point;
    public final BaseKeyframeAnimation<Float, Float> xAnimation;
    public final BaseKeyframeAnimation<Float, Float> yAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseKeyframeAnimation, baseKeyframeAnimation2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.point = new PointF();
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.xAnimation.setProgress(f2);
            this.yAnimation.setProgress(f2);
            this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onValueChanged();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getValue((Keyframe<PointF>) null, 0.0f) : (PointF) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyframe, f2)) == null) ? this.point : (PointF) invokeLF.objValue;
    }
}
