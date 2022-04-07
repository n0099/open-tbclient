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
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AppCreateSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INIT_IDLE_TASK = "initIdleTask";
    public static final String INIT_LAUNCH_TASK = "initLaunchTask";
    public static final String INIT_SPEED_STATUS = "initSpeedStatus";
    public static final String SUPER_ON_CREATE = "superOnCreate";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppCreateEndTimestamp;
    public long mCreateStartTimestamp;
    public long mInitIdleTaskEndTimeStamp;
    public long mInitLaunchTaskEndTimestamp;
    public Hashtable<String, Long> mLaunchTaskDuration;
    public long mSuperEndTimeStamp;

    public AppCreateSpeedStats() {
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
        this.mSuperEndTimeStamp = -1L;
        this.mInitIdleTaskEndTimeStamp = -1L;
        this.mInitLaunchTaskEndTimestamp = -1L;
        this.mAppCreateEndTimestamp = -1L;
        this.mLaunchTaskDuration = new Hashtable<>();
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            super.addStatsDuration(str, j);
            this.mLaunchTaskDuration.put(str, Long.valueOf(j));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            addStatsTimeStamp(i, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppCreateEndTimestamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCreateStartTimestamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return true;
            }
            long j = this.mAppCreateEndTimestamp;
            long j2 = this.mCreateStartTimestamp;
            long j3 = j - j2;
            long j4 = this.mSuperEndTimeStamp;
            long j5 = j4 - j2;
            long j6 = this.mInitIdleTaskEndTimeStamp;
            long j7 = j6 - j4;
            long j8 = this.mInitLaunchTaskEndTimestamp;
            long j9 = j8 - j6;
            long j10 = j - j8;
            long activityStartTime = SpeedStatsManager.getInstance().getActivityStartTime() - this.mAppCreateEndTimestamp;
            if (j3 < 0 || j3 > 60000 || j5 < 0 || j5 > 60000 || j7 < 0 || j7 > 60000 || j9 < 0 || j9 > 60000 || j10 < 0 || j10 > 60000 || activityStartTime < 0 || activityStartTime > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("superOnCreate", String.valueOf(j5));
            hashMap.put(INIT_IDLE_TASK, String.valueOf(j7));
            hashMap.put(INIT_LAUNCH_TASK, String.valueOf(j9));
            hashMap.put(INIT_SPEED_STATUS, String.valueOf(j10));
            for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_CREATE_STAGE, jsonData);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jsonData2 = SpeedStatsUtils.getJsonData(activityStartTime, null);
            if (jsonData2 != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_END_2_ACTIVITY_GAP, jsonData2);
                    return true;
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mCreateStartTimestamp = -1L;
            this.mSuperEndTimeStamp = -1L;
            this.mInitIdleTaskEndTimeStamp = -1L;
            this.mInitLaunchTaskEndTimestamp = -1L;
            this.mAppCreateEndTimestamp = -1L;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            switch (i) {
                case 2000:
                    this.mCreateStartTimestamp = j;
                    return;
                case 2001:
                    this.mSuperEndTimeStamp = j;
                    return;
                case 2002:
                    this.mInitIdleTaskEndTimeStamp = j;
                    return;
                case 2003:
                    this.mInitLaunchTaskEndTimestamp = j;
                    return;
                case 2004:
                    this.mAppCreateEndTimestamp = j;
                    return;
                default:
                    return;
            }
        }
    }
}
