package com.baidu.android.imsdk.internal;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class IMSettings {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEBUG_MODE = 1;
    public static final int INVALIDE_MODE = -1;
    public static final int UNDEBUG_MODE = 0;
    public static int mDebugMode = -1;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-778443159, "Lcom/baidu/android/imsdk/internal/IMSettings;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-778443159, "Lcom/baidu/android/imsdk/internal/IMSettings;");
        }
    }

    public IMSettings() {
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

    public static boolean enableDebugMode(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            if (z) {
                mDebugMode = 1;
            } else {
                mDebugMode = 0;
            }
            sContext = context;
            Utility.writeIntData(context, Constants.SETTING_DEBUG_MODE, mDebugMode);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static Context getsContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sContext : (Context) invokeV.objValue;
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int i2 = mDebugMode;
            if (i2 != -1) {
                return i2 == 1;
            }
            Context context = sContext;
            if (context == null) {
                return false;
            }
            int readIntData = Utility.readIntData(context, Constants.SETTING_DEBUG_MODE, 0);
            mDebugMode = readIntData;
            return readIntData == 1;
        }
        return invokeV.booleanValue;
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            sContext = context;
        }
    }
}
