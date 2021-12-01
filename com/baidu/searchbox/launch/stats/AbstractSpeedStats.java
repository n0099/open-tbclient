package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static String TAG = "AbstractSpeedStats";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-195508433, "Lcom/baidu/searchbox/launch/stats/AbstractSpeedStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-195508433, "Lcom/baidu/searchbox/launch/stats/AbstractSpeedStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public AbstractSpeedStats() {
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

    public void addStatsDuration(String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) && DEBUG) {
            String str2 = "addStatsDuration key: " + str + " duration " + j2;
        }
    }

    public void addStatsMap(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) && DEBUG) {
            String str2 = "addStatsTimeStamp key: " + str + " map " + map.toString();
        }
    }

    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && DEBUG) {
            String str = "addStatsTimeStamp key: " + i2;
        }
    }

    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            if (DEBUG) {
                String str = "addStatsTimeStamp json " + jSONObject.toString();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && DEBUG) {
            String str = "addStatsTimeStamp key: " + i2 + " timeStamp " + j2;
        }
    }
}
