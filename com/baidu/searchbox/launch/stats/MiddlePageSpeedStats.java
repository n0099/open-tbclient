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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MiddlePageSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_2_MIDDLE_GAP = "app2middle";
    public static final String ONCREATE = "create";
    public transient /* synthetic */ FieldHolder $fh;
    public long mCreateEndTimestamp;
    public long mCreateStartTimestamp;

    public MiddlePageSpeedStats() {
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
        this.mCreateStartTimestamp = -1L;
        this.mCreateEndTimestamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            if (i == 5200) {
                this.mCreateStartTimestamp = j;
            } else if (i != 5201) {
            } else {
                this.mCreateEndTimestamp = j;
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return true;
            }
            long j = this.mCreateEndTimestamp;
            long j2 = this.mCreateStartTimestamp;
            long j3 = j - j2;
            long appCreateEndTimeStamp = j2 - SpeedStatsManager.getInstance().getAppCreateEndTimeStamp();
            long j4 = this.mCreateEndTimestamp - this.mCreateStartTimestamp;
            if (j3 <= 0 || j3 > 60000 || appCreateEndTimeStamp < 0 || appCreateEndTimeStamp > 60000 || j4 < 0 || j4 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(APP_2_MIDDLE_GAP, String.valueOf(appCreateEndTimeStamp));
            hashMap.put("create", String.valueOf(j4));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.PUSH_SCHEME_MIDDLE_PAGE, jsonData);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
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
            this.mCreateEndTimestamp = -1L;
            this.mCreateStartTimestamp = -1L;
        }
    }
}
