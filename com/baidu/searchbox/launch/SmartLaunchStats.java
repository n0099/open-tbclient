package com.baidu.searchbox.launch;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.IDyeConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.searchbox.taskmanager.SmartLaunchTaskManager;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SmartLaunchStats {
    public static final long FIRST_AVAILABLE_TIME_MAX = 30000;
    public static final long FIRST_AVAILABLE_TIME_MIN = 100;
    public static final String TAG = "SmartLaunchStats";
    public static final String UBC_AFTER_LAUNCH_AVAILABLE_TIME_KEY = "after_launch_available_time";
    public static final String UBC_BUSINESS_COUNT_KEY = "count";
    public static final String UBC_BUSINESS_END_TIME_KEY = "end_time";
    public static final String UBC_BUSINESS_FIRST_USE_TIME_KEY = "first_use_time";
    public static final String UBC_BUSINESS_ID_KEY = "business_id";
    public static final String UBC_BUSINESS_KEY = "businesses";
    public static final String UBC_BUSINESS_SCORE = "score";
    public static final String UBC_BUSINESS_START_TIME_KEY = "start_time";
    public static final String UBC_BUSINESS_TYPE_KEY = "type";
    public static final String UBC_DEVICE_SCORE_KEY = "device_score";
    public static final String UBC_DYE_CONFIG_ID = "config_id";
    public static final String UBC_DYNAMIC_SCORE_KEY = "dynamic_score";
    public static final String UBC_FIRST_AVAILABLE_TIME = "first_available_time";
    public static final String UBC_FIRST_TOUCH_TIME = "first_touch_time";
    public static final String UBC_LAUNCH_TIME_STAMP = "launch_timestamp";
    public static final String UBC_LAUNCH_TYPE = "launch_type";
    public static final String UBC_PROCESS_AVAILABLE_TIME_KEY = "process_available_time";
    public static final String UBC_STAGE_KEY = "stage";
    public static final String UBC_START_LAUNCH_ID = "1023";
    public static final String UBC_STATIC_SCORE_KEY = "static_score";
    public UBCManager mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final boolean DEBUG = AppConfig.isDebug();
    public static long sIdleTaskStartTimeStamp = -1;
    public static long sIdleTaskEndTimeStamp = -1;
    public static long sAppStartTimeStamp = -1;
    public static long sAppStartEndTimeStamp = -1;
    public static long sUserPerceptionAppStartTime = -1;
    public static long sFirstAvailableTime = -1;
    public static long sProcessAvailableTime = -1;
    public static long sAfterLaunchAvailableTime = -1;
    public static long sFirstTouchTime = -1;
    public static boolean isFirstAvailableTimeNormal = true;
    public static boolean hasTriedToFindFirstAvailableTime = false;
    public static boolean sPrivacyDialogIdle = false;

    public static boolean isTimeAvailable(long j) {
        return j >= 100 && j < 30000;
    }

    public static long getFirstAvailableTime() {
        return sFirstAvailableTime;
    }

    public static long getFirstTouchTime() {
        return sFirstTouchTime;
    }

    public static long getIdleTaskEndTime() {
        return sIdleTaskEndTimeStamp;
    }

    public static long getIdleTaskStartTime() {
        return sIdleTaskStartTimeStamp;
    }

    public static long getProcessAvailableTime() {
        return sProcessAvailableTime;
    }

    public static boolean hasTriedToFindFirstAvailableTime() {
        return hasTriedToFindFirstAvailableTime;
    }

    public static boolean isFirstAvailableTimeNormal() {
        return isFirstAvailableTimeNormal;
    }

    public static void onPrivacyDialogShow() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "onPrivacyDialogShow begin.");
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchStats.2
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                boolean unused = SmartLaunchStats.sPrivacyDialogIdle = true;
                if (SmartLaunchStats.DEBUG) {
                    Log.d(SmartLaunchStats.TAG, "show privacy dialog idle begin.");
                }
                SmartLaunchStats.processPrivacyDialogIdle();
                return false;
            }
        });
    }

    public static void tryToFindFirstIdleTimeStamp() {
        hasTriedToFindFirstAvailableTime = true;
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchStats.3
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (SpeedStatsManager.getInstance().getAppLaunchDuration() < 0) {
                    if (SmartLaunchStats.DEBUG) {
                        Log.d(SmartLaunchStats.TAG, "launch is not finish ! do not remove idleHandler!");
                    }
                    return true;
                } else if (SpeedRuntime.getSpeedContext().isAdShowing()) {
                    if (SmartLaunchStats.DEBUG) {
                        Log.d(SmartLaunchStats.TAG, "ad is not finish ! do not remove idleHandler!");
                    }
                    return true;
                } else if (SmartLaunchStats.sIdleTaskStartTimeStamp == -1) {
                    SmartLaunchStats.setIdleTaskStartTime(System.currentTimeMillis());
                    LaunchedTaskSpeedStats.getInstance().endStatistics();
                    new SmartLaunchTaskManager().schedule(SpeedRuntime.getAppContext());
                    if (SmartLaunchStats.DEBUG) {
                        Log.d(SmartLaunchStats.TAG, "set idle time! tti:" + SmartLaunchStats.sFirstAvailableTime);
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        });
    }

    public static void setAppStartEndTimeStamp(long j) {
        sAppStartEndTimeStamp = j;
    }

    public static void setAppStartTimeStamp(long j) {
        sAppStartTimeStamp = j;
    }

    public static void setAppUserPerceptionStartTime(long j) {
        sUserPerceptionAppStartTime = j;
    }

    public static void setFirstAvailableTimeFlag(boolean z) {
        isFirstAvailableTimeNormal = z;
        if (DEBUG) {
            Log.d(TAG, "sFirstAvailableTime is not normal, throw it away");
        }
    }

    public static void setFirstTouchTime(long j) {
        long j2 = sAppStartTimeStamp;
        if (j2 == -1) {
            return;
        }
        sFirstTouchTime = j - j2;
    }

    public static void setIdleTaskEndTime(long j) {
        sIdleTaskEndTimeStamp = j;
    }

    public static void onConfirmPrivacy() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "onConfirmPrivacy begin.");
        }
        if (!sPrivacyDialogIdle) {
            if (DEBUG) {
                Log.d(TAG, "onConfirmPrivacy process privacy dialog begin.");
            }
            processPrivacyDialogIdle();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchStats.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (SmartLaunchStats.DEBUG) {
                    Log.d(SmartLaunchStats.TAG, "confirm privacy dialog idle begin.");
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (SmartLaunchStats.isTimeAvailable(currentTimeMillis2)) {
                    long unused = SmartLaunchStats.sAfterLaunchAvailableTime = currentTimeMillis2;
                }
                if (SmartLaunchStats.DEBUG) {
                    Log.d(SmartLaunchStats.TAG, "onConfirmPrivacy sAfterLaunchAvailableTime:" + SmartLaunchStats.sAfterLaunchAvailableTime);
                    return false;
                }
                return false;
            }
        });
    }

    public static void processPrivacyDialogIdle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (sFirstAvailableTime == -1 && sProcessAvailableTime == -1) {
            long j = currentTimeMillis - sAppStartTimeStamp;
            if (isTimeAvailable(j)) {
                sFirstAvailableTime = j;
            }
            long processLaunchDuration = sFirstAvailableTime + SpeedStatsManager.getInstance().getProcessLaunchDuration();
            if (isTimeAvailable(processLaunchDuration)) {
                sProcessAvailableTime = processLaunchDuration;
            }
            if (DEBUG) {
                Log.d(TAG, "onPrivacyDialogShow sFirstAvailableTime:" + sFirstAvailableTime + " sProcessAvailableTime:" + sProcessAvailableTime);
            }
        } else if (DEBUG) {
            Log.d(TAG, "onPrivacyDialogShow process done. do nothing.");
        }
    }

    public static void setIdleTaskStartTime(long j) {
        if (sFirstAvailableTime == -1 && sAfterLaunchAvailableTime == -1 && sProcessAvailableTime == -1) {
            long j2 = j - sAppStartTimeStamp;
            if (isTimeAvailable(j2)) {
                sFirstAvailableTime = j2;
            }
            long j3 = j - sAppStartEndTimeStamp;
            if (isTimeAvailable(j3)) {
                sAfterLaunchAvailableTime = j3;
            }
            long j4 = sUserPerceptionAppStartTime;
            if (j4 > 0) {
                long j5 = j3 + j4;
                if (isTimeAvailable(j5)) {
                    sProcessAvailableTime = j5;
                }
            }
        }
        sIdleTaskStartTimeStamp = j;
        if (DEBUG) {
            Log.d(TAG, "########## TTI end");
        }
    }

    public void stats() {
        if (this.mUbcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "research");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(UBC_DYNAMIC_SCORE_KEY, ScheduleStrategy.getDynamicScore());
                jSONObject2.put(UBC_STATIC_SCORE_KEY, ScheduleStrategy.getStaticScore());
                jSONObject2.put("device_score", ScheduleStrategy.getDeviceScore());
                jSONObject2.put("launch_type", LaunchStatsUtils.getLaunchTypeDetail());
                jSONObject2.put(UBC_LAUNCH_TIME_STAMP, sAppStartTimeStamp);
                jSONObject2.put(UBC_FIRST_TOUCH_TIME, sFirstTouchTime);
                String dyeConfig = IDyeConfig.Impl.get().getDyeConfig();
                if (!TextUtils.isEmpty(dyeConfig)) {
                    jSONObject2.put(UBC_DYE_CONFIG_ID, dyeConfig);
                }
                if (isFirstAvailableTimeNormal) {
                    jSONObject2.put("first_available_time", sFirstAvailableTime);
                    jSONObject2.put(UBC_AFTER_LAUNCH_AVAILABLE_TIME_KEY, sAfterLaunchAvailableTime);
                    jSONObject2.put("process_available_time", sProcessAvailableTime);
                } else {
                    jSONObject2.put("first_available_time", -1L);
                    jSONObject2.put(UBC_AFTER_LAUNCH_AVAILABLE_TIME_KEY, -1L);
                    jSONObject2.put("process_available_time", -1L);
                }
                jSONObject2.put("device_score", ScheduleStrategy.getDeviceScore());
                List<SmartLaunchTask> registeredPersonalLaunchTasks = SmartLaunchScheduler.getInstance().getRegisteredPersonalLaunchTasks();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < registeredPersonalLaunchTasks.size(); i++) {
                    registeredPersonalLaunchTasks.get(i);
                }
                jSONObject2.put("count", 0);
                jSONObject2.put(UBC_BUSINESS_KEY, jSONArray);
                jSONObject.put("ext", jSONObject2);
                this.mUbcManager.onEvent(UBC_START_LAUNCH_ID, jSONObject);
                if (DEBUG) {
                    Log.d(TAG, jSONObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
