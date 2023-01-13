package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.hh;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BdLogSetting implements hh {
    public static /* synthetic */ Interceptable $ic;
    public static BdLogSetting mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(333174477, "Lcom/baidu/tbadk/core/util/BdLogSetting;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(333174477, "Lcom/baidu/tbadk/core/util/BdLogSetting;");
        }
    }

    public BdLogSetting() {
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

    public static synchronized BdLogSetting getInstance() {
        InterceptResult invokeV;
        BdLogSetting bdLogSetting;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (BdLogSetting.class) {
                if (mInstance == null) {
                    mInstance = new BdLogSetting();
                }
                bdLogSetting = mInstance;
            }
            return bdLogSetting;
        }
        return (BdLogSetting) invokeV.objValue;
    }

    public long getDebugUploadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkSettings.getInst().loadLong("log_stat_debug_time", 0L);
        }
        return invokeV.longValue;
    }

    public long getErrorUploadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkSettings.getInst().loadLong("log_stat_error_time", 0L);
        }
        return invokeV.longValue;
    }

    public long getPerformanceUploadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbadkSettings.getInst().loadLong("log_stat_perfor_time", 0L);
        }
        return invokeV.longValue;
    }

    public long getStatUploadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return TbadkSettings.getInst().loadLong("log_stat_upload_time ", 0L);
        }
        return invokeV.longValue;
    }

    public String getSwitchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return TbadkSettings.getInst().loadString("log_stat_switch_data", null);
        }
        return (String) invokeV.objValue;
    }

    private String generateKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            return "new_log_upload_time_" + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hh
    public long getLogUploadTime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return TbadkSettings.getInst().loadLong(generateKey(str), 0L);
        }
        return invokeL.longValue;
    }

    public void setDebugUploadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            TbadkSettings.getInst().saveLong("log_stat_debug_time", j);
        }
    }

    public void setErrorUploadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            TbadkSettings.getInst().saveLong("log_stat_error_time", j);
        }
    }

    public void setPerformanceUploadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            TbadkSettings.getInst().saveLong("log_stat_perfor_time", j);
        }
    }

    public void setStatUploadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            TbadkSettings.getInst().saveLong("log_stat_upload_time ", j);
        }
    }

    public void setSwitchData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            TbadkSettings.getInst().saveString("log_stat_switch_data", str);
        }
    }

    @Override // com.baidu.tieba.hh
    public void setLogUploadTime(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j) == null) {
            TbadkSettings.getInst().saveLong(generateKey(str), j);
        }
    }
}
