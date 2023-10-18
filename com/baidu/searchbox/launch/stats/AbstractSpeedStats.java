package com.baidu.searchbox.launch.stats;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class AbstractSpeedStats {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "AbstractSpeedStats";

    public long getStatsEndTimeStamp() {
        return -1L;
    }

    public long getStatsStartTimeStamp() {
        return -1L;
    }

    public void reset() {
    }

    public void addStatsDuration(String str, long j) {
        if (DEBUG) {
            Log.d(TAG, "addStatsDuration key: " + str + " duration " + j);
        }
    }

    public void addStatsMap(String str, Map<String, String> map) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + str + " map " + map.toString());
        }
    }

    public void addStatsTimeStamp(int i, long j) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + i + " timeStamp " + j);
        }
    }

    public void addStatsTimeStamp(int i) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + i);
        }
    }

    public boolean packData(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp json " + jSONObject.toString());
            return false;
        }
        return false;
    }
}
