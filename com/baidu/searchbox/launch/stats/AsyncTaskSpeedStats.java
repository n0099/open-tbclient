package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class AsyncTaskSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Long> mLaunchTaskDuration;

    public AsyncTaskSpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLaunchTaskDuration = new HashMap<>();
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            super.addStatsDuration(str, j);
            synchronized (this.mLaunchTaskDuration) {
                this.mLaunchTaskDuration.put(str, Long.valueOf(j));
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            super.packData(jSONObject);
            HashMap hashMap = new HashMap();
            synchronized (this.mLaunchTaskDuration) {
                long j = 0;
                for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                    j += entry.getValue().longValue();
                }
                JSONObject jsonData = SpeedStatsUtils.getJsonData(j, hashMap);
                if (jsonData != null) {
                    try {
                        jSONObject.put(SpeedStatsMainTable.ASYNC_TASK, jsonData);
                    } catch (JSONException e2) {
                        if (AppConfig.isDebug()) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
