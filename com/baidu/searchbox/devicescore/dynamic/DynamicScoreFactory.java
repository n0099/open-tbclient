package com.baidu.searchbox.devicescore.dynamic;

import android.util.Log;
import com.baidu.searchbox.devicescore.IDeviceScore;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class DynamicScoreFactory {
    public static final String TAG = "DynamicScoreFactory";
    public static Map<String, IDynamicScoreManager> sDynamicManagerMap = new HashMap(1);

    public static IDynamicScoreManager getDynamicScoreManager(String str) {
        if (IDeviceScore.TYPE_LAUNCH_SPEED.equals(str)) {
            IDynamicScoreManager iDynamicScoreManager = sDynamicManagerMap.get(IDeviceScore.TYPE_LAUNCH_SPEED);
            if (iDynamicScoreManager == null) {
                LaunchSpeedManager launchSpeedManager = new LaunchSpeedManager();
                sDynamicManagerMap.put(IDeviceScore.TYPE_LAUNCH_SPEED, launchSpeedManager);
                return launchSpeedManager;
            }
            return iDynamicScoreManager;
        }
        Log.e(TAG, "DynamicScoreFactory unKnow dynamic type:" + str);
        return null;
    }
}
