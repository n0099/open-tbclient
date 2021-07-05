package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScaleXY scaleXY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
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
        this.scaleXY = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<ScaleXY>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f2) {
        InterceptResult invokeLF;
        ScaleXY scaleXY;
        ScaleXY scaleXY2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, keyframe, f2)) == null) {
            ScaleXY scaleXY3 = keyframe.startValue;
            if (scaleXY3 != null && (scaleXY = keyframe.endValue) != null) {
                ScaleXY scaleXY4 = scaleXY3;
                ScaleXY scaleXY5 = scaleXY;
                LottieValueCallback<A> lottieValueCallback = this.valueCallback;
                if (lottieValueCallback == 0 || (scaleXY2 = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY4, scaleXY5, f2, getLinearCurrentKeyframeProgress(), getProgress())) == null) {
                    this.scaleXY.set(MiscUtils.lerp(scaleXY4.getScaleX(), scaleXY5.getScaleX(), f2), MiscUtils.lerp(scaleXY4.getScaleY(), scaleXY5.getScaleY(), f2));
                    return this.scaleXY;
                }
                return scaleXY2;
            }
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (ScaleXY) invokeLF.objValue;
    }
}
