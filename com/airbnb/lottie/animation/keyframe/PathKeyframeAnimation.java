package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
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
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PathMeasure pathMeasure;
    public PathKeyframe pathMeasureKeyframe;
    public final PointF point;
    public final float[] pos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
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
        this.pos = new float[2];
        this.pathMeasure = new PathMeasure();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<PointF>) keyframe, f2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f2) {
        InterceptResult invokeLF;
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, keyframe, f2)) == null) {
            PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
            Path path = pathKeyframe.getPath();
            if (path == null) {
                return keyframe.startValue;
            }
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback == 0 || (pointF = (PointF) lottieValueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), pathKeyframe.startValue, pathKeyframe.endValue, getLinearCurrentKeyframeProgress(), f2, getProgress())) == null) {
                if (this.pathMeasureKeyframe != pathKeyframe) {
                    this.pathMeasure.setPath(path, false);
                    this.pathMeasureKeyframe = pathKeyframe;
                }
                PathMeasure pathMeasure = this.pathMeasure;
                pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.pos, null);
                PointF pointF2 = this.point;
                float[] fArr = this.pos;
                pointF2.set(fArr[0], fArr[1]);
                return this.point;
            }
            return pointF;
        }
        return (PointF) invokeLF.objValue;
    }
}
