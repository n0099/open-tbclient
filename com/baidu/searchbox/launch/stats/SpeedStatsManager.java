package com.baidu.searchbox.launch.stats;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SpeedStatsManager extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STAGE_ACTIVITY = 3;
    public static final int STAGE_APP_CREATE = 2;
    public static final int STAGE_ATTACH_WINDOW = 4;
    public static final int STAGE_BEFORE_APP_CREATE = 1;
    public static final int STAGE_END = -1;
    public static final int STAGE_FIRST_FRAME = 5;
    public static SpeedStatsManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ActivitySpeedStats mActivityCreateSpeedStats;
    public AdSpeedStats mAdSpeedStats;
    public AppBeforeCreateSpeedStats mAppBeforeCreateSpeedStats;
    public AppCreateSpeedStats mAppCreateSpeedStats;
    public long mAppCreateStartTimeStamp;
    public long mAppOnCreateDuration;
    public AsyncTaskSpeedStats mAsyncTaskSpeedStats;
    public AttachWindowSpeedStats mAttachWindowSpeedStats;
    public long mCodeStartTime;
    public FirstFrameSpeedStats mFirstFrameSpeedStats;
    public boolean mIsInStatsPeriod;
    public boolean mIsMainProcess;
    public long mMainPageEndTimeStamp;
    public int mStageStatus;
    public ZygoteSpeedStats mZygoteSpeedStats;

    public SpeedStatsManager() {
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
        this.mStageStatus = 1;
        this.mAppCreateStartTimeStamp = -1L;
        this.mMainPageEndTimeStamp = -1L;
        this.mCodeStartTime = -1L;
        this.mAppOnCreateDuration = -1L;
        this.mAppBeforeCreateSpeedStats = new AppBeforeCreateSpeedStats();
        this.mAppCreateSpeedStats = new AppCreateSpeedStats();
        this.mAsyncTaskSpeedStats = new AsyncTaskSpeedStats();
        this.mFirstFrameSpeedStats = new FirstFrameSpeedStats();
        this.mAttachWindowSpeedStats = new AttachWindowSpeedStats();
        this.mActivityCreateSpeedStats = new ActivitySpeedStats();
        this.mAdSpeedStats = new AdSpeedStats();
        this.mZygoteSpeedStats = new ZygoteSpeedStats();
        this.mIsMainProcess = false;
        this.mIsInStatsPeriod = false;
    }

    public static SpeedStatsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                mInstance = new SpeedStatsManager();
            }
            return mInstance;
        }
        return (SpeedStatsManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) && this.mIsMainProcess) {
            int i2 = this.mStageStatus;
            if (i2 == 1) {
                this.mAppBeforeCreateSpeedStats.addStatsMap(str, map);
            } else if (i2 == 2) {
                this.mAppCreateSpeedStats.addStatsMap(str, map);
            } else if (i2 == 3) {
                this.mActivityCreateSpeedStats.addStatsMap(str, map);
            } else if (i2 == 4) {
                this.mAttachWindowSpeedStats.addStatsMap(str, map);
            } else if (i2 != 5) {
            } else {
                this.mFirstFrameSpeedStats.addStatsMap(str, map);
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            addStatsTimeStamp(i2, System.currentTimeMillis());
        }
    }

    public long getActivityStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityCreateSpeedStats.getStatsStartTimeStamp() : invokeV.longValue;
    }

    public long getAdShowDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAdSpeedStats.getAdShowDuration() : invokeV.longValue;
    }

    public long getAppCreateEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAppCreateSpeedStats.getStatsEndTimeStamp() : invokeV.longValue;
    }

    public long getAppLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCodeStartTime : invokeV.longValue;
    }

    public long getAppLaunchEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMainPageEndTimeStamp : invokeV.longValue;
    }

    public long getAppLaunchStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAppCreateStartTimeStamp : invokeV.longValue;
    }

    public long getAppOnCreateDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAppOnCreateDuration : invokeV.longValue;
    }

    public long getAppUserPerceptionLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mZygoteSpeedStats.getAppUserPerceptionLaunchDuration() : invokeV.longValue;
    }

    public AttachWindowSpeedStats getAttachWindowSpeedStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mAttachWindowSpeedStats : (AttachWindowSpeedStats) invokeV.objValue;
    }

    public int getDrawCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mFirstFrameSpeedStats.getDrawCount() : invokeV.intValue;
    }

    public long getDurationWithoutAD(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? this.mAdSpeedStats.getDurationWithoutAD(j, j2) : invokeCommon.longValue;
    }

    public long getMainActivityCreateStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mActivityCreateSpeedStats.getMainActivityCreateStartTimeStamp() : invokeV.longValue;
    }

    public long getMainTabActivityEndDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mActivityCreateSpeedStats.getMainActivityOnResumeEndTimeStamp() : invokeV.longValue;
    }

    public long getProcessLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mZygoteSpeedStats.getProcessLaunchDuration() : invokeV.longValue;
    }

    public int getStageStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mStageStatus : invokeV.intValue;
    }

    public boolean getStatsFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mIsInStatsPeriod : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) ? this.mZygoteSpeedStats.packData(jSONObject) && this.mAdSpeedStats.packData(jSONObject) && this.mAppBeforeCreateSpeedStats.packData(jSONObject) && this.mAppCreateSpeedStats.packData(jSONObject) && this.mActivityCreateSpeedStats.packData(jSONObject) && this.mAttachWindowSpeedStats.packData(jSONObject) && this.mFirstFrameSpeedStats.packData(jSONObject) && this.mAsyncTaskSpeedStats.packData(jSONObject) : invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.reset();
            this.mIsInStatsPeriod = false;
            this.mAppBeforeCreateSpeedStats.reset();
            this.mAppCreateSpeedStats.reset();
            this.mActivityCreateSpeedStats.reset();
            this.mAttachWindowSpeedStats.reset();
            this.mFirstFrameSpeedStats.reset();
            this.mAsyncTaskSpeedStats.reset();
            this.mZygoteSpeedStats.reset();
            this.mAsyncTaskSpeedStats.reset();
        }
    }

    public void setMainProcessFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mIsMainProcess = z;
        }
    }

    public void setStageStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mStageStatus = i2;
        }
    }

    public void setStatsFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mIsInStatsPeriod = z;
        }
    }

    public void setTaskRunTime(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048600, this, str, j) == null) && this.mIsMainProcess) {
            if (SpeedStatsMainTable.MAIN_THREAD_TASK_LIST.contains(str)) {
                this.mAppCreateSpeedStats.addStatsDuration(str, j);
            } else {
                this.mAsyncTaskSpeedStats.addStatsDuration(str, j);
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) && this.mIsMainProcess) {
            if (i2 == 1000) {
                this.mAppCreateStartTimeStamp = j;
                setStageStatus(1);
                LaunchStatsUtils.setAppCreateTime(this.mAppCreateStartTimeStamp);
                this.mZygoteSpeedStats.addStatsTimeStamp(1000);
            } else if (i2 == 2000) {
                setStageStatus(2);
                this.mAppOnCreateDuration = j - this.mAppCreateStartTimeStamp;
                this.mAppBeforeCreateSpeedStats.addStatsTimeStamp(2000);
                this.mZygoteSpeedStats.addStatsTimeStamp(2000);
            } else if (i2 == 3000) {
                setStageStatus(3);
            } else if (i2 == 4000) {
                setStageStatus(4);
            } else if (i2 == 5000) {
                setStageStatus(5);
            } else if (i2 == 7000) {
                this.mMainPageEndTimeStamp = j;
                this.mCodeStartTime = j - this.mAppCreateStartTimeStamp;
                this.mZygoteSpeedStats.addStatsTimeStamp(7000);
                setStageStatus(-1);
            }
            int i3 = this.mStageStatus;
            if (i3 == 1) {
                this.mAppBeforeCreateSpeedStats.addStatsTimeStamp(i2, j);
            } else if (i3 == 2) {
                this.mAppCreateSpeedStats.addStatsTimeStamp(i2, j);
            } else if (i3 == 3) {
                if (i2 < 3000) {
                    this.mAppCreateSpeedStats.addStatsTimeStamp(i2, j);
                }
                this.mActivityCreateSpeedStats.addStatsTimeStamp(i2, j);
                this.mAdSpeedStats.addStatsTimeStamp(i2, j);
            } else if (i3 != 4) {
                if (i3 == 5 && this.mIsInStatsPeriod) {
                    this.mFirstFrameSpeedStats.addStatsTimeStamp(i2, j);
                    this.mAdSpeedStats.addStatsTimeStamp(i2, j);
                }
            } else if (this.mIsInStatsPeriod) {
                this.mAttachWindowSpeedStats.addStatsTimeStamp(i2, j);
                this.mAdSpeedStats.addStatsTimeStamp(i2, j);
            }
        }
    }
}
