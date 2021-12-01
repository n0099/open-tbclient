package c.i.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes7.dex */
public final class g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sortedSet)) == null) {
            Comparator<? super E> comparator = sortedSet.comparator();
            return comparator == null ? Ordering.natural() : comparator;
        }
        return (Comparator) invokeL.objValue;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        InterceptResult invokeLL;
        Comparator comparator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, comparator, iterable)) == null) {
            c.i.d.a.n.p(comparator);
            c.i.d.a.n.p(iterable);
            if (iterable instanceof SortedSet) {
                comparator2 = a((SortedSet) iterable);
            } else if (!(iterable instanceof f1)) {
                return false;
            } else {
                comparator2 = ((f1) iterable).comparator();
            }
            return comparator.equals(comparator2);
        }
        return invokeLL.booleanValue;
    }
}
