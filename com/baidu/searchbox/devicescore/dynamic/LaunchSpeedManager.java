package com.baidu.searchbox.devicescore.dynamic;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.aideviceperformanceboxproxy.dynamic.LaunchSpeedScoreManagerSingleton;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.devicescore.ParamKeys;
import com.baidu.searchbox.devicescore.ScoreMetaData;
import java.util.Map;
/* loaded from: classes3.dex */
public class LaunchSpeedManager implements IDynamicScoreManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "LaunchSpeedManager";
    public float mScore = -1.0f;

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public float getScore(Context context) {
        float f = this.mScore;
        if (f >= 0.0f) {
            return f;
        }
        float launchSpeedScore = LaunchSpeedScoreManagerSingleton.getInstance().getLaunchSpeedScore();
        this.mScore = launchSpeedScore;
        if (Float.compare(launchSpeedScore, 0.0f) >= 0) {
            if (DEBUG) {
                Log.d(TAG, "getScore: " + this.mScore);
            }
            return this.mScore;
        }
        return -1.0f;
    }

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public void putMetaData(Context context, ScoreMetaData scoreMetaData) {
        if (validMetaData(context, scoreMetaData)) {
            LaunchSpeedScoreManagerSingleton.getInstance().putLaunchSpeedData(context, ((Long) scoreMetaData.params.get(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS)).longValue(), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public boolean validMetaData(Context context, ScoreMetaData scoreMetaData) {
        Map<String, Object> map;
        if (scoreMetaData != null && IDeviceScore.TYPE_LAUNCH_SPEED.equals(scoreMetaData.type) && (map = scoreMetaData.params) != null) {
            return map.keySet().contains(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS);
        }
        return false;
    }
}
