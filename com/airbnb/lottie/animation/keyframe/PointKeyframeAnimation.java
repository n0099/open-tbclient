package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PointF point;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
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
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<PointF>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f2) {
        InterceptResult invokeLF;
        PointF pointF;
        PointF pointF2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, keyframe, f2)) == null) {
            PointF pointF3 = keyframe.startValue;
            if (pointF3 != null && (pointF = keyframe.endValue) != null) {
                PointF pointF4 = pointF3;
                PointF pointF5 = pointF;
                LottieValueCallback<A> lottieValueCallback = this.valueCallback;
                if (lottieValueCallback == 0 || (pointF2 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF4, pointF5, f2, getLinearCurrentKeyframeProgress(), getProgress())) == null) {
                    PointF pointF6 = this.point;
                    float f3 = pointF4.x;
                    float f4 = pointF4.y;
                    pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                    return this.point;
                }
                return pointF2;
            }
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (PointF) invokeLF.objValue;
    }
}
