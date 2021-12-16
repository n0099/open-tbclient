package c.b.b.n.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e(i iVar, float[] fArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, fArr, sArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float[] fArr2 = new float[fArr.length];
        float f2 = iVar.f27947b;
        float f3 = iVar.f27948c;
        float f4 = iVar.f27949d - f2;
        float f5 = iVar.f27950e - f3;
        int i4 = iVar.f27951f;
        int i5 = iVar.f27952g;
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6 += 2) {
            fArr2[i6] = ((fArr[i6] / i4) * f4) + f2;
            int i7 = i6 + 1;
            fArr2[i7] = ((1.0f - (fArr[i7] / i5)) * f5) + f3;
        }
    }
}
