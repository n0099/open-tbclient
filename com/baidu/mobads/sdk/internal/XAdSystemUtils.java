package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
/* loaded from: classes7.dex */
public class XAdSystemUtils {
    public static /* synthetic */ Interceptable $ic;
    public static volatile XAdSystemUtils shareInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1634086392, "Lcom/baidu/mobads/sdk/internal/XAdSystemUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1634086392, "Lcom/baidu/mobads/sdk/internal/XAdSystemUtils;");
        }
    }

    public XAdSystemUtils() {
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

    public static XAdSystemUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (shareInstance == null) {
                synchronized (XAdSystemUtils.class) {
                    if (shareInstance == null) {
                        shareInstance = new XAdSystemUtils();
                    }
                }
            }
            return shareInstance;
        }
        return (XAdSystemUtils) invokeV.objValue;
    }

    private Boolean isXTypeConnected(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, context, i2)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                boolean z = true;
                if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) != 0) {
                    XAdLogger.getInstance().e(Utils.TAG, "no permission android.permission.ACCESS_NETWORK_STATE");
                    return Boolean.FALSE;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || activeNetworkInfo.getType() != i2 || !activeNetworkInfo.isConnected()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
        return (Boolean) invokeLI.objValue;
    }

    public Boolean is3GConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? isXTypeConnected(context, 0) : (Boolean) invokeL.objValue;
    }

    public boolean isCurrentNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isAvailable();
                }
                return false;
            } catch (Exception e2) {
                XAdLogger.getInstance().d("isCurrentNetworkAvailable", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public Boolean isWifiConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? isXTypeConnected(context, 1) : (Boolean) invokeL.objValue;
    }
}
