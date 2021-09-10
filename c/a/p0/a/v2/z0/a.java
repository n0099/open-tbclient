package c.a.p0.a.v2.z0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    @SafeVarargs
    public static <E> HashSet<E> a(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eArr)) == null) {
            if (eArr != null && eArr.length > 0) {
                HashSet<E> hashSet = new HashSet<>(eArr.length);
                Collections.addAll(hashSet, eArr);
                return hashSet;
            }
            return new HashSet<>();
        }
        return (HashSet) invokeL.objValue;
    }
}
