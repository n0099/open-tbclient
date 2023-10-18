package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class AppCreateSpeedStats extends AbstractSpeedStats {
    public static final String INIT_IDLE_TASK = "initIdleTask";
    public static final String INIT_LAUNCH_TASK = "initLaunchTask";
    public static final String INIT_SPEED_STATUS = "initSpeedStatus";
    public static final String SUPER_ON_CREATE = "superOnCreate";
    public long mCreateStartTimestamp = -1;
    public long mSuperEndTimeStamp = -1;
    public long mInitIdleTaskEndTimeStamp = -1;
    public long mInitLaunchTaskEndTimestamp = -1;
    public long mAppCreateEndTimestamp = -1;
    public Hashtable<String, Long> mLaunchTaskDuration = new Hashtable<>();

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        return this.mAppCreateEndTimestamp;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        return this.mCreateStartTimestamp;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        this.mCreateStartTimestamp = -1L;
        this.mSuperEndTimeStamp = -1L;
        this.mInitIdleTaskEndTimeStamp = -1L;
        this.mInitLaunchTaskEndTimestamp = -1L;
        this.mAppCreateEndTimestamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        super.addStatsDuration(str, j);
        synchronized (this.mLaunchTaskDuration) {
            this.mLaunchTaskDuration.put(str, Long.valueOf(j));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        addStatsTimeStamp(i, System.currentTimeMillis());
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
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
        if (j3 >= 0 && j3 <= 60000 && j5 >= 0 && j5 <= 60000 && j7 >= 0 && j7 <= 60000 && j9 >= 0 && j9 <= 60000 && j10 >= 0 && j10 <= 60000 && activityStartTime >= 0 && activityStartTime <= 60000) {
            HashMap hashMap = new HashMap();
            hashMap.put("superOnCreate", String.valueOf(j5));
            hashMap.put(INIT_IDLE_TASK, String.valueOf(j7));
            hashMap.put(INIT_LAUNCH_TASK, String.valueOf(j9));
            hashMap.put(INIT_SPEED_STATUS, String.valueOf(j10));
            synchronized (this.mLaunchTaskDuration) {
                for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
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
        return false;
    }
}
