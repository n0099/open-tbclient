package b.h.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public final class z0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <E> ArrayDeque<E> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new ArrayDeque<>() : (ArrayDeque) invokeV.objValue;
    }

    public static <E> LinkedBlockingQueue<E> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new LinkedBlockingQueue<>() : (LinkedBlockingQueue) invokeV.objValue;
    }
}
