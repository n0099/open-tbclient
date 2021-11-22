package androidx.collection;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Pair;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"K", "V", "Landroidx/collection/ArrayMap;", "arrayMapOf", "()Landroidx/collection/ArrayMap;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Landroidx/collection/ArrayMap;", "collection-ktx"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ArrayMapKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new ArrayMap<>() : (ArrayMap) invokeV.objValue;
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pairArr)) == null) {
            ArrayMap<K, V> arrayMap = new ArrayMap<>(pairArr.length);
            for (Pair<? extends K, ? extends V> pair : pairArr) {
                arrayMap.put(pair.getFirst(), pair.getSecond());
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }
}
