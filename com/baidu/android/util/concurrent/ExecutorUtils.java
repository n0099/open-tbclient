package com.baidu.android.util.concurrent;

import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes8.dex */
public class ExecutorUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ExecutorUtils() {
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

    @Deprecated
    public static String getStandardThreadName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                str = null;
            } else if (!str.startsWith("RxDeprecate_")) {
                str = "RxDeprecate_" + str;
            }
            if (str == null) {
                str = "RxDeprecate";
            }
            return str.length() > 256 ? str.substring(0, 255) : str;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, runnable, str) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, 2);
        }
    }

    @Deprecated
    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, runnable, str) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, 2);
        }
    }
}
