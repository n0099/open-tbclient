package c.a.v0.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(CharSequence charSequence) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, charSequence)) == null) {
            if (charSequence != null && (length = charSequence.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!Character.isWhitespace(charSequence.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
