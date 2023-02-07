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
/* loaded from: classes2.dex */
public class SpeedStatsManager extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STAGE_ACTIVITY = 3;
    public static final int STAGE_APP_CREATE = 2;
    public static final int STAGE_ATTACH_WINDOW = 4;
    public static final int STAGE_BEFORE_APP_CREATE = 1;
    public static final int STAGE_END = -1;
    public static final int STAGE_FIRST_FRAME = 5;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_NOT_STAT = -1;
    public static final int TYPE_PUSH = 1;
    public static final int TYPE_SCHEME = 2;
    public static SpeedStatsManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public LandingPageSpeedStats landingPageSpeedStats;
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
    public int mIsInStatsPeriod;
    public boolean mIsMainProcess;
    public long mMainPageEndTimeStamp;
    public int mStageStatus;
    public ZygoteSpeedStats mZygoteSpeedStats;
    public MiddlePageSpeedStats middlePageSpeedStats;

    public SpeedStatsManager() {
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
        this.middlePageSpeedStats = new MiddlePageSpeedStats();
        this.landingPageSpeedStats = new LandingPageSpeedStats();
        this.mIsMainProcess = false;
        this.mIsInStatsPeriod = -1;
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

    public long getActivityStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mActivityCreateSpeedStats.getStatsStartTimeStamp();
        }
        return invokeV.longValue;
    }

    public long getAdShowDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAdSpeedStats.getAdShowDuration();
        }
        return invokeV.longValue;
    }

    public long getAdTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAdSpeedStats.getAdTotalDuration();
        }
        return invokeV.longValue;
    }

    public long getAdViewEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mAdSpeedStats.getAdViewEndTimeStamp();
        }
        return invokeV.longValue;
    }

    public long getAppCreateEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAppCreateSpeedStats.getStatsEndTimeStamp();
        }
        return invokeV.longValue;
    }

    public long getAppLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mCodeStartTime;
        }
        return invokeV.longValue;
    }

    public long getAppLaunchEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mMainPageEndTimeStamp;
        }
        return invokeV.longValue;
    }

    public long getAppLaunchStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mAppCreateStartTimeStamp;
        }
        return invokeV.longValue;
    }

    public long getAppOnCreateDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mAppOnCreateDuration;
        }
        return invokeV.longValue;
    }

    public long getAppUserPerceptionLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mZygoteSpeedStats.getAppUserPerceptionLaunchDuration();
        }
        return invokeV.longValue;
    }

    public long getAttachWindowEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mAttachWindowSpeedStats.getStatsEndTimeStamp();
        }
        return invokeV.longValue;
    }

    public AttachWindowSpeedStats getAttachWindowSpeedStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mAttachWindowSpeedStats;
        }
        return (AttachWindowSpeedStats) invokeV.objValue;
    }

    public int getDrawCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mFirstFrameSpeedStats.getDrawCount();
        }
        return invokeV.intValue;
    }

    public long getExtraSecondCreateDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mActivityCreateSpeedStats.getExtraSecondCreateDuration();
        }
        return invokeV.longValue;
    }

    public long getMainActivityCreateStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mActivityCreateSpeedStats.getMainActivityCreateStartTimeStamp();
        }
        return invokeV.longValue;
    }

    public long getMainTabActivityEndDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mActivityCreateSpeedStats.getMainActivityOnResumeEndTimeStamp();
        }
        return invokeV.longValue;
    }

    public long getProcessLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mZygoteSpeedStats.getProcessLaunchDuration();
        }
        return invokeV.longValue;
    }

    public int getStageStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mStageStatus;
        }
        return invokeV.intValue;
    }

    public int getStatsFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mIsInStatsPeriod;
        }
        return invokeV.intValue;
    }

    public boolean isAdLoadEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mAdSpeedStats.isLoadEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, map) != null) || !this.mIsMainProcess) {
            return;
        }
        int i = this.mStageStatus;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            this.mFirstFrameSpeedStats.addStatsMap(str, map);
                            return;
                        }
                        return;
                    }
                    this.mAttachWindowSpeedStats.addStatsMap(str, map);
                    return;
                }
                this.mActivityCreateSpeedStats.addStatsMap(str, map);
                return;
            }
            this.mAppCreateSpeedStats.addStatsMap(str, map);
            return;
        }
        this.mAppBeforeCreateSpeedStats.addStatsMap(str, map);
    }

    public void setTaskRunTime(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048615, this, str, j) == null) && this.mIsMainProcess) {
            if (str != null && str.startsWith(SpeedStatsMainTable.IGNORE_FLAG)) {
                return;
            }
            if (str != null && str.startsWith(SpeedStatsMainTable.APP_CREATE_FLAG)) {
                this.mAppCreateSpeedStats.addStatsDuration(str, j);
            } else if (str != null && str.startsWith(SpeedStatsMainTable.AD_FLAG)) {
                this.mAdSpeedStats.addStatsDuration(str, j);
            } else {
                this.mAsyncTaskSpeedStats.addStatsDuration(str, j);
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            addStatsTimeStamp(i, System.currentTimeMillis());
        }
    }

    public void setAdFailCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mAdSpeedStats.setAdFailCount(i);
        }
    }

    public void setAdLoadResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mAdSpeedStats.setAdLoadResult(i);
        }
    }

    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mAdSpeedStats.setAdSource(str);
        }
    }

    public void setBearLoadResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mAdSpeedStats.setBearLoadResult(z);
        }
    }

    public void setIsNeedBear(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mAdSpeedStats.setIsNeedBear(z);
        }
    }

    public void setIsNeedPlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.mAdSpeedStats.setIsNeedPlg(z);
        }
    }

    public void setIsSwitchOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.mZygoteSpeedStats.setIsSwitchOn(z);
        }
    }

    public void setIsTimeout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.mAdSpeedStats.setIsTimeout(z);
        }
    }

    public void setMainProcessFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mIsMainProcess = z;
        }
    }

    public void setPlgAdType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mAdSpeedStats.setPlgAdType(str);
        }
    }

    public void setPlgLoadResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mAdSpeedStats.setPlgLoadResult(z);
        }
    }

    public void setStageStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.mStageStatus = i;
        }
    }

    public void setStatsFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.mIsInStatsPeriod = i;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i != 1000) {
                if (i != 2000) {
                    if (i != 3000) {
                        if (i != 3012) {
                            if (i != 4000) {
                                if (i != 5000) {
                                    if (i != 5054) {
                                        if (i != 5200) {
                                            if (i == 6000) {
                                                this.mMainPageEndTimeStamp = j;
                                                this.mCodeStartTime = j - this.mAppCreateStartTimeStamp;
                                                this.mZygoteSpeedStats.addStatsTimeStamp(6000);
                                                setStageStatus(-1);
                                            }
                                        } else {
                                            setStageStatus(3);
                                        }
                                    } else {
                                        this.mZygoteSpeedStats.addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY, j);
                                    }
                                } else {
                                    setStageStatus(5);
                                }
                            } else {
                                setStageStatus(4);
                            }
                        } else {
                            setStageStatus(3);
                        }
                    } else {
                        setStageStatus(3);
                    }
                } else {
                    setStageStatus(2);
                    this.mAppOnCreateDuration = j - this.mAppCreateStartTimeStamp;
                    this.mAppBeforeCreateSpeedStats.addStatsTimeStamp(2000);
                    this.mZygoteSpeedStats.addStatsTimeStamp(2000);
                }
            } else {
                this.mAppCreateStartTimeStamp = j;
                setStageStatus(1);
                LaunchStatsUtils.setAppCreateTime(this.mAppCreateStartTimeStamp);
                this.mZygoteSpeedStats.addStatsTimeStamp(1000);
            }
            int i2 = this.mStageStatus;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                this.mFirstFrameSpeedStats.addStatsTimeStamp(i, j);
                                this.mAdSpeedStats.addStatsTimeStamp(i, j);
                                this.middlePageSpeedStats.addStatsTimeStamp(i, j);
                                this.landingPageSpeedStats.addStatsTimeStamp(i, j);
                                return;
                            }
                            return;
                        }
                        this.mAttachWindowSpeedStats.addStatsTimeStamp(i, j);
                        this.mAdSpeedStats.addStatsTimeStamp(i, j);
                        this.middlePageSpeedStats.addStatsTimeStamp(i, j);
                        this.landingPageSpeedStats.addStatsTimeStamp(i, j);
                        return;
                    }
                    if (i < 3000) {
                        this.mAppCreateSpeedStats.addStatsTimeStamp(i, j);
                    }
                    this.mActivityCreateSpeedStats.addStatsTimeStamp(i, j);
                    this.mAdSpeedStats.addStatsTimeStamp(i, j);
                    this.middlePageSpeedStats.addStatsTimeStamp(i, j);
                    this.landingPageSpeedStats.addStatsTimeStamp(i, j);
                    return;
                }
                this.mAppCreateSpeedStats.addStatsTimeStamp(i, j);
                return;
            }
            this.mAppBeforeCreateSpeedStats.addStatsTimeStamp(i, j);
        }
    }

    public long getDurationWithoutAD(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return this.mAdSpeedStats.getDurationWithoutAD(j, j2);
        }
        return invokeCommon.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, jSONObject)) == null) {
            this.mAdSpeedStats.packData(jSONObject);
            this.mZygoteSpeedStats.packData(jSONObject);
            this.mAppBeforeCreateSpeedStats.packData(jSONObject);
            this.mAppCreateSpeedStats.packData(jSONObject);
            this.mActivityCreateSpeedStats.packData(jSONObject);
            this.mAttachWindowSpeedStats.packData(jSONObject);
            this.mFirstFrameSpeedStats.packData(jSONObject);
            this.mAsyncTaskSpeedStats.packData(jSONObject);
            this.middlePageSpeedStats.packData(jSONObject);
            this.landingPageSpeedStats.packData(jSONObject);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.reset();
            this.mAppBeforeCreateSpeedStats.reset();
            this.mAppCreateSpeedStats.reset();
            this.mActivityCreateSpeedStats.reset();
            this.mAttachWindowSpeedStats.reset();
            this.mFirstFrameSpeedStats.reset();
            this.mAsyncTaskSpeedStats.reset();
            this.mZygoteSpeedStats.reset();
            this.mAsyncTaskSpeedStats.reset();
            this.middlePageSpeedStats.reset();
            this.landingPageSpeedStats.reset();
        }
    }
}
