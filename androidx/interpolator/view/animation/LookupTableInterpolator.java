package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class LookupTableInterpolator implements Interpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float mStepSize;
    public final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (f2 >= 1.0f) {
                return 1.0f;
            }
            if (f2 <= 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mValues;
            int min = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
            float f3 = this.mStepSize;
            float f4 = (f2 - (min * f3)) / f3;
            float[] fArr2 = this.mValues;
            return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
        }
        return invokeF.floatValue;
    }
}
