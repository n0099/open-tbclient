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
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void addStatsDuration(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            super.addStatsDuration(str, j2);
            this.mLaunchTaskDuration.put(str, Long.valueOf(j2));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            addStatsTimeStamp(i2, System.currentTimeMillis());
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
            long j2 = this.mAppCreateEndTimestamp;
            long j3 = this.mCreateStartTimestamp;
            long j4 = j2 - j3;
            long j5 = this.mSuperEndTimeStamp;
            long j6 = j5 - j3;
            long j7 = this.mInitIdleTaskEndTimeStamp;
            long j8 = j7 - j5;
            long j9 = this.mInitLaunchTaskEndTimestamp;
            long j10 = j9 - j7;
            long j11 = j2 - j9;
            long activityStartTime = SpeedStatsManager.getInstance().getActivityStartTime() - this.mAppCreateEndTimestamp;
            if (j4 < 0 || j4 > 60000 || j6 < 0 || j6 > 60000 || j8 < 0 || j8 > 60000 || j10 < 0 || j10 > 60000 || j11 < 0 || j11 > 60000 || activityStartTime < 0 || activityStartTime > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("superOnCreate", String.valueOf(j6));
            hashMap.put(INIT_IDLE_TASK, String.valueOf(j8));
            hashMap.put(INIT_LAUNCH_TASK, String.valueOf(j10));
            hashMap.put(INIT_SPEED_STATUS, String.valueOf(j11));
            for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j4, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_CREATE_STAGE, jsonData);
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject jsonData2 = SpeedStatsUtils.getJsonData(activityStartTime, null);
            if (jsonData2 != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_END_2_ACTIVITY_GAP, jsonData2);
                    return true;
                } catch (JSONException e3) {
                    if (AppConfig.isDebug()) {
                        e3.printStackTrace();
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
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            switch (i2) {
                case 2000:
                    this.mCreateStartTimestamp = j2;
                    return;
                case 2001:
                    this.mSuperEndTimeStamp = j2;
                    return;
                case 2002:
                    this.mInitIdleTaskEndTimeStamp = j2;
                    return;
                case 2003:
                    this.mInitLaunchTaskEndTimestamp = j2;
                    return;
                case 2004:
                    this.mAppCreateEndTimestamp = j2;
                    return;
                default:
                    return;
            }
        }
    }
}
