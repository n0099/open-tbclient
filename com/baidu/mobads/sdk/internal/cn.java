package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cn {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cn a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833694788, "Lcom/baidu/mobads/sdk/internal/cn;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833694788, "Lcom/baidu/mobads/sdk/internal/cn;");
        }
    }

    public cn() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static cn a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (cn.class) {
                    if (a == null) {
                        a = new cn();
                    }
                }
            }
            return a;
        }
        return (cn) invokeV.objValue;
    }

    private NetworkCapabilities c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                    return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (NetworkCapabilities) invokeL.objValue;
    }

    public NetworkInfo b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public Boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                boolean z = false;
                if (bj.a(context).a() < 29) {
                    NetworkInfo b = b(context);
                    if (b != null && b.isConnected() && b.getType() == 1) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
                NetworkCapabilities c = c(context);
                if (c != null && c.hasCapability(12) && c.hasCapability(16) && c.hasTransport(1)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
        return (Boolean) invokeL.objValue;
    }
}
