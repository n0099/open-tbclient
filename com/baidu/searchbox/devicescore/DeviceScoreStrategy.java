package com.baidu.searchbox.devicescore;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
/* loaded from: classes3.dex */
public class DeviceScoreStrategy {
    public static final float DEFAULT_LOW_THRESHOLD = 0.37f;
    public static final float DEFAULT_MID_THRESHOLD = 0.6f;
    public static final String SP_KEY_LOW_THRESHOLD = "device_score_float_low_threshold";
    public static final String SP_KEY_MID_THRESHOLD = "device_score_float_mid_threshold";
    public static final String TAG = "DeviceScoreStrategy";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static float sLowThreshold = -1.0f;
    public static float sMidThreshold = -1.0f;

    public static float getLowThreshold() {
        if (sLowThreshold == -1.0f) {
            sLowThreshold = QuickPersistConfig.getInstance().getFloat(SP_KEY_LOW_THRESHOLD, 0.37f);
        }
        return sLowThreshold;
    }

    public static float getMidThreshold() {
        if (sMidThreshold == -1.0f) {
            sMidThreshold = QuickPersistConfig.getInstance().getFloat(SP_KEY_MID_THRESHOLD, 0.6f);
        }
        return sMidThreshold;
    }

    public static void updateStrategy(DeviceScoreConfig deviceScoreConfig) {
        if (deviceScoreConfig != null && validThreshold(deviceScoreConfig.lowThreshold) && validThreshold(deviceScoreConfig.midThreshold) && Float.compare(deviceScoreConfig.midThreshold, deviceScoreConfig.lowThreshold) > 0) {
            QuickPersistConfig.getInstance().putFloat(SP_KEY_LOW_THRESHOLD, deviceScoreConfig.lowThreshold);
            QuickPersistConfig.getInstance().putFloat(SP_KEY_MID_THRESHOLD, deviceScoreConfig.midThreshold);
            if (DEBUG) {
                Log.d(TAG, "updateStrategy success. low threshold:" + deviceScoreConfig.lowThreshold + " mid threshold:" + deviceScoreConfig.midThreshold);
            }
        } else if (DEBUG && deviceScoreConfig != null) {
            Log.d(TAG, "updateStrategy exception. low threshold:" + deviceScoreConfig.lowThreshold + " mid threshold:" + deviceScoreConfig.midThreshold);
        }
    }

    public static boolean validThreshold(float f) {
        if (Float.compare(f, -1.0f) > 0 && Float.compare(f, 1.0f) <= 0) {
            return true;
        }
        return false;
    }
}
