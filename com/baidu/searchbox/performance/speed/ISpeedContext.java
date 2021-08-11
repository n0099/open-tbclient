package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface ISpeedContext {
    public static final ISpeedContext EMPTY = new ISpeedContext() { // from class: com.baidu.searchbox.performance.speed.ISpeedContext.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
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

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void checkSendStatisticData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean getNightModeSwitcherState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public String getVersionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean hasSkin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isMainActivity(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isMainLine() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isPushDispatchActivity(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isSchemeDispatchActivity(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isSplashActivity(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void launchData(HashMap<String, String> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) {
            }
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void launchTime(boolean z, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            }
        }
    };

    void checkSendStatisticData();

    boolean getNightModeSwitcherState();

    String getVersionName();

    boolean hasSkin();

    boolean isMainActivity(Activity activity);

    boolean isMainLine();

    boolean isPushDispatchActivity(Activity activity);

    boolean isSchemeDispatchActivity(Activity activity);

    boolean isSplashActivity(Activity activity);

    void launchData(HashMap<String, String> hashMap);

    void launchTime(boolean z, long j2);
}
