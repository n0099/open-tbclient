package androidx.transition;

import android.animation.TypeEvaluator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mArray = fArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), fArr, fArr2})) == null) {
            float[] fArr3 = this.mArray;
            if (fArr3 == null) {
                fArr3 = new float[fArr.length];
            }
            for (int i2 = 0; i2 < fArr3.length; i2++) {
                float f3 = fArr[i2];
                fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
            }
            return fArr3;
        }
        return (float[]) invokeCommon.objValue;
    }
}
