package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class LandingPageSpeedStats extends AbstractSpeedStats {
    public static final String DATABACK_2_DRAW = "databack2draw";
    public static final String MIDDLE_2_LANDING_GAP = "middle2LandingGap";
    public static final String ONCREATE = "create";
    public static final String ONCREATE_2_RESUME = "create2resume";
    public static final String RESUME_2_DATABACK = "resume2databack";
    public long mMiddleCreateEndTimestamp = -1;
    public long mCreateStartTimestamp = -1;
    public long mCreateEndTimestamp = -1;
    public long mResumeStartTimestamp = -1;
    public long mDataBackTimestamp = -1;
    public long mDispatchDrawTimestamp = -1;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        this.mCreateStartTimestamp = -1L;
        this.mCreateEndTimestamp = -1L;
        this.mResumeStartTimestamp = -1L;
        this.mDataBackTimestamp = -1L;
        this.mDispatchDrawTimestamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        super.addStatsTimeStamp(i, j);
        switch (i) {
            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5201 */:
                this.mMiddleCreateEndTimestamp = j;
                return;
            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5202 */:
                this.mCreateStartTimestamp = j;
                return;
            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                this.mCreateEndTimestamp = j;
                return;
            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                this.mResumeStartTimestamp = j;
                return;
            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                this.mDataBackTimestamp = j;
                return;
            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY /* 5206 */:
                this.mDispatchDrawTimestamp = j;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        super.packData(jSONObject);
        if (jSONObject == null) {
            return true;
        }
        long j = this.mDispatchDrawTimestamp;
        long j2 = this.mCreateStartTimestamp;
        long j3 = j - j2;
        long j4 = j2 - this.mMiddleCreateEndTimestamp;
        long j5 = this.mCreateEndTimestamp;
        long j6 = j5 - j2;
        long j7 = this.mResumeStartTimestamp;
        long j8 = j7 - j5;
        long j9 = this.mDataBackTimestamp;
        long j10 = j9 - j7;
        long j11 = j - j9;
        if (j3 > 0 && j3 <= 60000 && j4 <= 60000 && j6 >= 0 && j6 <= 60000 && j8 >= 0 && j8 <= 60000 && j10 <= 60000 && j11 >= 0 && j11 <= 60000) {
            HashMap hashMap = new HashMap();
            hashMap.put(MIDDLE_2_LANDING_GAP, String.valueOf(j4));
            hashMap.put("create", String.valueOf(j6));
            hashMap.put(ONCREATE_2_RESUME, String.valueOf(j8));
            hashMap.put(RESUME_2_DATABACK, String.valueOf(j10));
            hashMap.put(DATABACK_2_DRAW, String.valueOf(j11));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.PUSH_SCHEME_LANDING_PAGE, jsonData);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }
}
