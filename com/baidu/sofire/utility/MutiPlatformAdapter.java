package com.baidu.sofire.utility;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.facesrc.FaceLivenessProcessManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MutiPlatformAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MutiPlatformAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean geKeepDexOptSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void platformPrivateConfig(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) || context == null) {
            return;
        }
        FaceLivenessProcessManager.getInstance(context).setSdkFaceConfig(jSONObject);
    }

    public static void setTechainResouse(ForHostApp forHostApp, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, forHostApp, i) == null) {
        }
    }
}
