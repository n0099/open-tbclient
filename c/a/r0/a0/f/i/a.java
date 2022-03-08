package c.a.r0.a0.f.i;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int[] iArr = {R.color.common_color_10313, R.color.common_color_10314, R.color.common_color_10315, R.color.common_color_10316, R.color.common_color_10317};
            int i2 = a % 5;
            int i3 = iArr[i2];
            a = i2 + 1;
            return i3;
        }
        return invokeV.intValue;
    }
}
