package androidx.collection;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Landroidx/collection/ArraySet;", "arraySetOf", "()Landroidx/collection/ArraySet;", "", SavedStateHandle.VALUES, "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "collection-ktx"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ArraySetKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T> ArraySet<T> arraySetOf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new ArraySet<>() : (ArraySet) invokeV.objValue;
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tArr)) == null) {
            ArraySet<T> arraySet = new ArraySet<>(tArr.length);
            for (T t : tArr) {
                arraySet.add(t);
            }
            return arraySet;
        }
        return (ArraySet) invokeL.objValue;
    }
}
