package com.baidu.searchbox.http.response;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.SocketTimeoutException;
/* loaded from: classes11.dex */
public class ResponseException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANCELED = "Canceled";
    public static final String NO_NETWORK = " no network connected";
    public static final String ONLY_WIFI_EXECUTE = " only allow wifi connected";
    public transient /* synthetic */ FieldHolder $fh;

    public ResponseException() {
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

    public static boolean isCancel(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, exc)) == null) ? (exc == null || TextUtils.isEmpty(exc.getMessage()) || !exc.getMessage().contains(CANCELED)) ? false : true : invokeL.booleanValue;
    }

    public static boolean isNoNetwork(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) ? (exc == null || TextUtils.isEmpty(exc.getMessage()) || !exc.getMessage().startsWith(NO_NETWORK)) ? false : true : invokeL.booleanValue;
    }

    public static boolean isOnlyWifiException(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) ? exc != null && ONLY_WIFI_EXECUTE.equals(exc.getMessage()) : invokeL.booleanValue;
    }

    public static boolean isTimeoutException(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, exc)) == null) ? exc != null && (exc instanceof SocketTimeoutException) : invokeL.booleanValue;
    }

    public static IOException wrapNoNetworkExceptionWithDetail(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, exc)) == null) {
            return new IOException(" no network connected\n" + exc.toString(), exc);
        }
        return (IOException) invokeL.objValue;
    }
}
