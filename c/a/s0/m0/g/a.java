package c.a.s0.m0.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    public static final <T, K extends Comparable<? super K>> int a(List<? extends T> list, K key, Function1<? super T, ? extends K> selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i2 = 0;
            while (i2 < size) {
                int i3 = (i2 + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues(selector.invoke((T) list.get(i3)), key);
                if (compareValues < 0) {
                    i2 = i3 + 1;
                } else if (compareValues <= 0) {
                    return i3 - 1;
                } else {
                    size = i3;
                }
            }
            return i2;
        }
        return invokeLLL.intValue;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    public static final <T, K extends Comparable<? super K>> int b(List<? extends T> list, K key, Function1<? super T, ? extends K> selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i2 = 0;
            while (i2 < size) {
                int i3 = (i2 + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues(selector.invoke((T) list.get(i3)), key);
                if (compareValues < 0) {
                    i2 = i3 + 1;
                } else if (compareValues <= 0) {
                    return i3 - 1;
                } else {
                    size = i3;
                }
            }
            return size;
        }
        return invokeLLL.intValue;
    }

    public static final <T extends Comparable<? super T>> c.a.s0.m0.d.a<T> c(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, collection)) == null) {
            Intrinsics.checkNotNullParameter(collection, "<this>");
            return new c.a.s0.m0.d.a<>(collection);
        }
        return (c.a.s0.m0.d.a) invokeL.objValue;
    }
}
