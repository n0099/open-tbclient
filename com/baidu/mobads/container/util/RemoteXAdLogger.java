package com.baidu.mobads.container.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RemoteXAdLogger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int LOG_LEVEL;
    public static final String TAG = "BaiduXAdSDK";
    public static final int UNLOGGABLE = -1;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static volatile RemoteXAdLogger mLogger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(845356548, "Lcom/baidu/mobads/container/util/RemoteXAdLogger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(845356548, "Lcom/baidu/mobads/container/util/RemoteXAdLogger;");
                return;
            }
        }
        LOG_LEVEL = XAdSDKRemoteConfig.DEBUG_MODE ? 2 : 4;
        mLogger = null;
    }

    public RemoteXAdLogger() {
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

    public static RemoteXAdLogger getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mLogger == null) {
                synchronized (RemoteXAdLogger.class) {
                    if (mLogger == null) {
                        mLogger = new RemoteXAdLogger();
                    }
                }
            }
            return mLogger;
        }
        return (RemoteXAdLogger) invokeV.objValue;
    }

    private String join(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(' ');
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            if (isLoggable(3)) {
                return d(join(objArr));
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int e(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr)) == null) {
            if (isLoggable(6)) {
                return e(join(objArr));
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? i(TAG, str) : invokeL.intValue;
    }

    public boolean isLoggable(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) ? i2 >= LOG_LEVEL : invokeLI.booleanValue;
    }

    public int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (isLoggable(5)) {
                try {
                    return Log.w(TAG, str);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (isLoggable(4)) {
                try {
                    return Log.i(str, str2);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public boolean isLoggable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? isLoggable(TAG, i2) : invokeI.booleanValue;
    }

    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? d(TAG, str) : invokeL.intValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (isLoggable(6)) {
                try {
                    return Log.e(TAG, str);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int w(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, objArr)) == null) {
            if (isLoggable(5)) {
                return w(join(objArr));
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (isLoggable(3)) {
                try {
                    return Log.d(str, str2);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int i(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, objArr)) == null) {
            if (isLoggable(4)) {
                return i(join(objArr));
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, th)) == null) ? e("", th) : invokeL.intValue;
    }

    public int w(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, th)) == null) {
            if (isLoggable(5)) {
                try {
                    return Log.w(TAG, str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) ? d("", th) : invokeL.intValue;
    }

    public int e(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, th)) == null) {
            if (isLoggable(6)) {
                try {
                    return Log.e(TAG, str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int i(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, th)) == null) {
            if (isLoggable(4)) {
                try {
                    return Log.i(TAG, str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int d(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th)) == null) {
            if (isLoggable(3)) {
                try {
                    return Log.d(TAG, str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int w(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, th)) == null) ? w("", th) : invokeL.intValue;
    }
}
