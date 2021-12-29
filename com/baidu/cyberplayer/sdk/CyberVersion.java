package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public class CyberVersion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CyberVersion() {
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

    public static String getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String coreVersionInternal = getCoreVersionInternal();
            if (CyberCfgManager.getInstance().a("enable_version_for_short", true)) {
                try {
                    return coreVersionInternal.substring(0, coreVersionInternal.lastIndexOf("."));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return coreVersionInternal;
                }
            }
            return coreVersionInternal;
        }
        return (String) invokeV.objValue;
    }

    public static String getCoreVersionInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a = d.a();
            return TextUtils.isEmpty(a) ? "0.0.0.0" : a;
        }
        return (String) invokeV.objValue;
    }

    public static String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? CyberCfgManager.getInstance().a("enable_version_for_short", true) ? "7.32.9" : SDKVersion.VERSION : (String) invokeV.objValue;
    }

    public static String getSDKVersionInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SDKVersion.VERSION : (String) invokeV.objValue;
    }
}
