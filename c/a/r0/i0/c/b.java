package c.a.r0.i0.c;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a a(BaseFragment baseFragment, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i2)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i2 == 1) {
                return new e(baseFragment, i2);
            }
            if (i2 == 3) {
                return new c(baseFragment, i2);
            }
            return null;
        }
        return (a) invokeLI.objValue;
    }
}
