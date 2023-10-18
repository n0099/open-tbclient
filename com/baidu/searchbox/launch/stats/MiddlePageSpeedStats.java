package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class MiddlePageSpeedStats extends AbstractSpeedStats {
    public static final String APP_2_MIDDLE_GAP = "app2middle";
    public static final String ONCREATE = "create";
    public long mCreateStartTimestamp = -1;
    public long mCreateEndTimestamp = -1;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        this.mCreateEndTimestamp = -1L;
        this.mCreateStartTimestamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        super.addStatsTimeStamp(i, j);
        if (i != 5200) {
            if (i == 5201) {
                this.mCreateEndTimestamp = j;
                return;
            }
            return;
        }
        this.mCreateStartTimestamp = j;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        super.packData(jSONObject);
        if (jSONObject == null) {
            return true;
        }
        long j = this.mCreateEndTimestamp;
        long j2 = this.mCreateStartTimestamp;
        long j3 = j - j2;
        long appCreateEndTimeStamp = j2 - SpeedStatsManager.getInstance().getAppCreateEndTimeStamp();
        long j4 = this.mCreateEndTimestamp - this.mCreateStartTimestamp;
        if (j3 > 0 && j3 <= 60000 && appCreateEndTimeStamp >= 0 && appCreateEndTimeStamp <= 60000 && j4 >= 0 && j4 <= 60000) {
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
        return false;
    }
}
