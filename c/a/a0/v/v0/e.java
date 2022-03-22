package c.a.a0.v.v0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String[] array) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, array)) == null) {
            Intrinsics.checkNotNullParameter(array, "array");
            int length = array.length;
            for (int i = 0; i < length; i++) {
                String str = array[i];
                if (!(str == null || str.length() == 0)) {
                    return str;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
