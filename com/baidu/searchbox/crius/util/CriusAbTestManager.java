package com.baidu.searchbox.crius.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusAbTestManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRIUS_LAYOUT_FLATTEN_SWITCH = "crius_layout_enhance_switch";
    public static final String PREFERENCE_VISITED_KEY = "is_visited_key";
    public static final String TAG = "CriusAbTestManager";
    public static boolean sCriusLayoutFlattenSwitch;
    public static boolean sHasGetCriusLayoutFlattenSwitch;
    public static boolean sIsVisited;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1977648195, "Lcom/baidu/searchbox/crius/util/CriusAbTestManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1977648195, "Lcom/baidu/searchbox/crius/util/CriusAbTestManager;");
                return;
            }
        }
        sIsVisited = PreferenceUtil.getBoolean(PREFERENCE_VISITED_KEY, false);
    }

    public CriusAbTestManager() {
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

    public static boolean isHitLayoutFlattenTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!sHasGetCriusLayoutFlattenSwitch) {
                sCriusLayoutFlattenSwitch = AbTestManager.getInstance().getSwitch(CRIUS_LAYOUT_FLATTEN_SWITCH, false);
                sHasGetCriusLayoutFlattenSwitch = true;
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "isHitLayoutFlattenTest: " + sCriusLayoutFlattenSwitch);
            }
            return sCriusLayoutFlattenSwitch;
        }
        return invokeV.booleanValue;
    }

    public static boolean isVisited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sIsVisited : invokeV.booleanValue;
    }

    public static void updateVisitedState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            PreferenceUtil.putBoolean(PREFERENCE_VISITED_KEY, z);
        }
    }
}
