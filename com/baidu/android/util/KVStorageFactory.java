package com.baidu.android.util;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class KVStorageFactory {
    public static /* synthetic */ Interceptable $ic = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? getSharedPreferences(str, 0) : (SharedPreferences) invokeL.objValue;
    }

    public static boolean isKVStorageInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? sIsKVInitSuccessfully : invokeV.booleanValue;
    }

    public static SharedPreferences getSharedPreferences(String str, int i2) {
        SharedPreferences proxy;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            try {
                if (KVStorageRuntime.getKVStorageControl().getKVStorageType() != 0 && (proxy = KVStorageRuntime.getKVStorageProxy().getProxy(str)) != null) {
                    String str2 = "use SwanKV " + str;
                    return proxy;
                }
            } catch (UnsatisfiedLinkError unused) {
                sIsKVInitSuccessfully = false;
            }
            String str3 = "use default SharedPreferences " + str;
            return AppRuntime.getAppContext().getSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }
}
