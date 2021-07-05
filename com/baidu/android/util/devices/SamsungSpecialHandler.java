package com.baidu.android.util.devices;

import android.app.Activity;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public final class SamsungSpecialHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SamsungSpecialHandler";
    public transient /* synthetic */ FieldHolder $fh;

    public SamsungSpecialHandler() {
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

    public static boolean beforeCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? DeviceUtil.OSInfo.hasLollipop() : invokeV.booleanValue;
    }

    public static void removeSumsungRList(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, activity) == null) && beforeCheck()) {
            try {
                System.currentTimeMillis();
                activity.deleteFile("rList-" + activity.getClass().getName());
            } catch (Exception unused) {
            }
        }
    }
}
