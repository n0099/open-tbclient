package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AsyncTaskSpeedStats extends AbstractSpeedStats {
    public HashMap<String, Long> mLaunchTaskDuration = new HashMap<>();

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        super.addStatsDuration(str, j);
        synchronized (this.mLaunchTaskDuration) {
            this.mLaunchTaskDuration.put(str, Long.valueOf(j));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
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
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
