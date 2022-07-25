package com.baidu.cloudsdk.common.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes.dex */
public final class Validator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTAINS_NO_NULLS_FMT = "Container '%s' cannot contain null values";
    public static final String NOT_NULL_FMT = "Argument '%s' cannot be null";
    public static final String NOT_NULL_OR_EMPTY_FMT = "Argument '%s' cannot be null or empty";
    public static final String NOT_ONE_OF_FMT = "Argument '%s' was not one of the allowed values";
    public transient /* synthetic */ FieldHolder $fh;

    public Validator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, collection, str) == null) {
            notNull(collection, str);
            for (T t : collection) {
                if (t == null) {
                    throw new NullPointerException(String.format(CONTAINS_NO_NULLS_FMT, str));
                }
            }
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, collection, str) == null) {
            notNullOrEmpty(collection, str);
            for (T t : collection) {
                if (t == null) {
                    throw new NullPointerException(String.format(CONTAINS_NO_NULLS_FMT, str));
                }
            }
        }
    }

    public static void notNull(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, obj, str) == null) && obj == null) {
            throw new NullPointerException(String.format(NOT_NULL_FMT, str));
        }
    }

    public static void notNullOrEmpty(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, str2));
        }
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, objArr) == null) {
            for (Object obj2 : objArr) {
                if (obj2 != null) {
                    if (obj2.equals(obj)) {
                        return;
                    }
                } else if (obj == null) {
                    return;
                }
            }
            throw new IllegalArgumentException(String.format(NOT_ONE_OF_FMT, str));
        }
    }

    public static <T> void notNullOrEmpty(Collection<T> collection, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, collection, str) == null) && Utils.isEmpty(collection)) {
            throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, str));
        }
    }

    public static <T> void notNullOrEmpty(T[] tArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, tArr, str) == null) {
            notNull(tArr, str);
            if (tArr.length == 0) {
                throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, str));
            }
        }
    }
}
