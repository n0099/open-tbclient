package com.baidu.fsg.base.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class Assert {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Assert() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void hasLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
        }
    }

    public static void hasLength(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && !StringUtils.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void isTrue(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            isTrue(z, "[Assertion failed] - this expression must be true");
        }
    }

    public static void isTrue(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, str) == null) && !z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, collection) == null) {
            notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
        }
    }

    public static void notEmpty(Collection<?> collection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, collection, str) == null) {
            if (collection == null || collection.size() == 0) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, map) == null) {
            notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
        }
    }

    public static void notEmpty(Map<?, ?> map, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, map, str) == null) && CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, obj) == null) {
            notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
        }
    }

    public static void notNull(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, obj, str) == null) && obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void state(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            state(z, "[Assertion failed] - this state invariant must be true");
        }
    }

    public static void state(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65548, null, z, str) == null) && !z) {
            throw new IllegalStateException(str);
        }
    }
}
