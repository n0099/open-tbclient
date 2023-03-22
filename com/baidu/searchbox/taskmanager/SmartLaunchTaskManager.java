package com.baidu.searchbox.taskmanager;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.SmartLaunchController;
/* loaded from: classes2.dex */
public class SmartLaunchTaskManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SmartLaunchManager";

    private void smartLaunchSchedule(Context context) {
        SmartLaunchController.scheduleIdleTask();
        if (DEBUG) {
            Log.d("SmartLaunchManager", "SmartLaunch: schedule idle task");
        }
    }

    public void schedule(Context context) {
        if (SmartLaunchController.isSmartLaunchEnabled()) {
            if (DEBUG) {
                Log.d("SmartLaunchManager", "enable smart launch");
            }
            smartLaunchSchedule(context);
            return;
        }
        if (DEBUG) {
            Log.d("SmartLaunchManager", "disable smart launch");
        }
        SmartLaunchController.scheduleIdleTask();
    }
}
