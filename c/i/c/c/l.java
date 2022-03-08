package c.i.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.common.collect.ImmutableList;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes3.dex */
public final class l<E> extends AbstractList<List<E>> implements RandomAccess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final transient ImmutableList<List<E>> f28686e;

    public final int c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            throw null;
        }
        return invokeII.intValue;
    }
}
