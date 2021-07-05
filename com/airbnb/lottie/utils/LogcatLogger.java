package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class LogcatLogger implements LottieLogger {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> loggedMessages;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1905769684, "Lcom/airbnb/lottie/utils/LogcatLogger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1905769684, "Lcom/airbnb/lottie/utils/LogcatLogger;");
                return;
            }
        }
        loggedMessages = new HashSet();
    }

    public LogcatLogger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            debug(str, null);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th) == null) && L.DBG) {
            Log.d(L.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            warning(str, null);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) && L.DBG) {
            Log.d(L.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, th) == null) || loggedMessages.contains(str)) {
            return;
        }
        Log.w(L.TAG, str, th);
        loggedMessages.add(str);
    }
}
