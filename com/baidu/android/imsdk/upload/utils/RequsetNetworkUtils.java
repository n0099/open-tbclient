package com.baidu.android.imsdk.upload.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RequsetNetworkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequsetNetworkUtils";
    public static ConnectivityManager mConnManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(10568114, "Lcom/baidu/android/imsdk/upload/utils/RequsetNetworkUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(10568114, "Lcom/baidu/android/imsdk/upload/utils/RequsetNetworkUtils;");
        }
    }

    public RequsetNetworkUtils() {
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

    public static ConnectivityManager getConnectivityManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return mConnManager;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && mConnManager == null) {
                mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            return mConnManager;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            NetworkInfo networkInfo = null;
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.d("RequsetNetworkUtils", "context is null !!!");
                }
                ConnectivityManager connectivityManager = getConnectivityManager(applicationContext);
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                    if (networkInfo == null) {
                        Log.e("RequsetNetworkUtils", "networkInfo is null !!!");
                    }
                } else {
                    Log.e("RequsetNetworkUtils", "connManager is null !!!");
                }
            } catch (Exception e) {
                Log.e("RequsetNetworkUtils", "exp: " + e.getMessage());
            }
            return networkInfo;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean isConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null) {
                return netWorkInfo.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
