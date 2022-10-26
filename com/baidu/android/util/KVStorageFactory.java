package com.baidu.android.util;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class KVStorageFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String PREFERENCE_SUFFIX = "preferences";
    public static final String TAG = "KVStorageFactory";
    public static boolean sIsKVInitSuccessfully = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(915096706, "Lcom/baidu/android/util/KVStorageFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(915096706, "Lcom/baidu/android/util/KVStorageFactory;");
        }
    }

    public KVStorageFactory() {
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

    public static boolean isKVStorageInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return sIsKVInitSuccessfully;
        }
        return invokeV.booleanValue;
    }

    public static SharedPreferences getDefaultSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return getSharedPreferences(AppRuntime.getAppContext().getPackageName() + "_" + PREFERENCE_SUFFIX, 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return getSharedPreferences(str, 0);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static SharedPreferences getSharedPreferences(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            try {
                if (KVStorageRuntime.getKVStorageControl().getKVStorageType() != 0) {
                    SharedPreferences proxy = KVStorageRuntime.getKVStorageProxy().getProxy(str);
                    if (proxy != null) {
                        return proxy;
                    }
                }
            } catch (UnsatisfiedLinkError unused) {
                sIsKVInitSuccessfully = false;
            }
            return AppRuntime.getAppContext().getSharedPreferences(str, i);
        }
        return (SharedPreferences) invokeLI.objValue;
    }
}
