package b.a.r0.w.f.i;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f24959a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int[] iArr = {R.color.common_color_10313, R.color.common_color_10314, R.color.common_color_10315, R.color.common_color_10316, R.color.common_color_10317};
            int i2 = f24959a % 5;
            int i3 = iArr[i2];
            f24959a = i2 + 1;
            return i3;
        }
        return invokeV.intValue;
    }
}
