package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.launch.LaunchStatsUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpeedStatsManager extends AbstractSpeedStats {
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
    public int mStageStatus = 1;
    public long mAppCreateStartTimeStamp = -1;
    public long mMainPageEndTimeStamp = -1;
    public long mCodeStartTime = -1;
    public long mAppOnCreateDuration = -1;
    public AppBeforeCreateSpeedStats mAppBeforeCreateSpeedStats = new AppBeforeCreateSpeedStats();
    public AppCreateSpeedStats mAppCreateSpeedStats = new AppCreateSpeedStats();
    public AsyncTaskSpeedStats mAsyncTaskSpeedStats = new AsyncTaskSpeedStats();
    public FirstFrameSpeedStats mFirstFrameSpeedStats = new FirstFrameSpeedStats();
    public AttachWindowSpeedStats mAttachWindowSpeedStats = new AttachWindowSpeedStats();
    public ActivitySpeedStats mActivityCreateSpeedStats = new ActivitySpeedStats();
    public AdSpeedStats mAdSpeedStats = new AdSpeedStats();
    public ZygoteSpeedStats mZygoteSpeedStats = new ZygoteSpeedStats();
    public MiddlePageSpeedStats middlePageSpeedStats = new MiddlePageSpeedStats();
    public LandingPageSpeedStats landingPageSpeedStats = new LandingPageSpeedStats();
    public boolean mIsMainProcess = false;
    public int mIsInStatsPeriod = -1;

    public static SpeedStatsManager getInstance() {
        if (mInstance == null) {
            mInstance = new SpeedStatsManager();
        }
        return mInstance;
    }

    public long getActivityStartTime() {
        return this.mActivityCreateSpeedStats.getStatsStartTimeStamp();
    }

    public long getAdShowDuration() {
        return this.mAdSpeedStats.getAdShowDuration();
    }

    public long getAdTotalDuration() {
        return this.mAdSpeedStats.getAdTotalDuration();
    }

    public long getAdViewEndTimeStamp() {
        return this.mAdSpeedStats.getAdViewEndTimeStamp();
    }

    public long getAppCreateEndTimeStamp() {
        return this.mAppCreateSpeedStats.getStatsEndTimeStamp();
    }

    public long getAppLaunchDuration() {
        return this.mCodeStartTime;
    }

    public long getAppLaunchEndTimeStamp() {
        return this.mMainPageEndTimeStamp;
    }

    public long getAppLaunchStartTimeStamp() {
        return this.mAppCreateStartTimeStamp;
    }

    public long getAppOnCreateDuration() {
        return this.mAppOnCreateDuration;
    }

    public long getAppUserPerceptionLaunchDuration() {
        return this.mZygoteSpeedStats.getAppUserPerceptionLaunchDuration();
    }

    public long getAttachWindowEndTime() {
        return this.mAttachWindowSpeedStats.getStatsEndTimeStamp();
    }

    public AttachWindowSpeedStats getAttachWindowSpeedStats() {
        return this.mAttachWindowSpeedStats;
    }

    public int getDrawCount() {
        return this.mFirstFrameSpeedStats.getDrawCount();
    }

    public long getExtraSecondCreateDuration() {
        return this.mActivityCreateSpeedStats.getExtraSecondCreateDuration();
    }

    public long getMainActivityCreateStartTimeStamp() {
        return this.mActivityCreateSpeedStats.getMainActivityCreateStartTimeStamp();
    }

    public long getMainTabActivityEndDuration() {
        return this.mActivityCreateSpeedStats.getMainActivityOnResumeEndTimeStamp();
    }

    public long getProcessLaunchDuration() {
        return this.mZygoteSpeedStats.getProcessLaunchDuration();
    }

    public int getStageStatus() {
        return this.mStageStatus;
    }

    public int getStatsFlag() {
        return this.mIsInStatsPeriod;
    }

    public boolean isAdLoadEnd() {
        return this.mAdSpeedStats.isLoadEnd();
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        if (!this.mIsMainProcess) {
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
        if (this.mIsMainProcess) {
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
        addStatsTimeStamp(i, System.currentTimeMillis());
    }

    public void setAdFailCount(int i) {
        this.mAdSpeedStats.setAdFailCount(i);
    }

    public void setAdLoadResult(int i) {
        this.mAdSpeedStats.setAdLoadResult(i);
    }

    public void setAdSource(String str) {
        this.mAdSpeedStats.setAdSource(str);
    }

    public void setBearLoadResult(boolean z) {
        this.mAdSpeedStats.setBearLoadResult(z);
    }

    public void setIsNeedBear(boolean z) {
        this.mAdSpeedStats.setIsNeedBear(z);
    }

    public void setIsNeedPlg(boolean z) {
        this.mAdSpeedStats.setIsNeedPlg(z);
    }

    public void setIsSwitchOn(boolean z) {
        this.mZygoteSpeedStats.setIsSwitchOn(z);
    }

    public void setIsTimeout(boolean z) {
        this.mAdSpeedStats.setIsTimeout(z);
    }

    public void setMainProcessFlag(boolean z) {
        this.mIsMainProcess = z;
    }

    public void setPlgAdType(String str) {
        this.mAdSpeedStats.setPlgAdType(str);
    }

    public void setPlgLoadResult(boolean z) {
        this.mAdSpeedStats.setPlgLoadResult(z);
    }

    public void setStageStatus(int i) {
        this.mStageStatus = i;
    }

    public void setStatsFlag(int i) {
        this.mIsInStatsPeriod = i;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
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

    public long getDurationWithoutAD(long j, long j2) {
        return this.mAdSpeedStats.getDurationWithoutAD(j, j2);
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
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
