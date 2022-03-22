package c.b.b.n.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float[] fArr2 = new float[fArr.length];
        float f2 = iVar.f22542b;
        float f3 = iVar.f22543c;
        float f4 = iVar.f22544d - f2;
        float f5 = iVar.f22545e - f3;
        int i3 = iVar.f22546f;
        int i4 = iVar.f22547g;
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5 += 2) {
            fArr2[i5] = ((fArr[i5] / i3) * f4) + f2;
            int i6 = i5 + 1;
            fArr2[i6] = ((1.0f - (fArr[i6] / i4)) * f5) + f3;
        }
    }
}
