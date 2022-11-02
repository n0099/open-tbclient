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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SmartLaunchStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
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
    public static boolean hasTriedToFindFirstAvailableTime;
    public static boolean isFirstAvailableTimeNormal;
    public static long sAfterLaunchAvailableTime;
    public static long sAppStartEndTimeStamp;
    public static long sAppStartTimeStamp;
    public static long sFirstAvailableTime;
    public static long sFirstTouchTime;
    public static long sIdleTaskEndTimeStamp;
    public static long sIdleTaskStartTimeStamp;
    public static boolean sPrivacyDialogIdle;
    public static long sProcessAvailableTime;
    public static long sUserPerceptionAppStartTime;
    public transient /* synthetic */ FieldHolder $fh;
    public UBCManager mUbcManager;

    public static boolean isTimeAvailable(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65553, null, j)) == null) ? j >= 100 && j < 30000 : invokeJ.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1074603274, "Lcom/baidu/searchbox/launch/SmartLaunchStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1074603274, "Lcom/baidu/searchbox/launch/SmartLaunchStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sIdleTaskStartTimeStamp = -1L;
        sIdleTaskEndTimeStamp = -1L;
        sAppStartTimeStamp = -1L;
        sAppStartEndTimeStamp = -1L;
        sUserPerceptionAppStartTime = -1L;
        sFirstAvailableTime = -1L;
        sProcessAvailableTime = -1L;
        sAfterLaunchAvailableTime = -1L;
        sFirstTouchTime = -1L;
        isFirstAvailableTimeNormal = true;
        hasTriedToFindFirstAvailableTime = false;
        sPrivacyDialogIdle = false;
    }

    public static void onPrivacyDialogShow() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65555, null) != null) || Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "onPrivacyDialogShow begin.");
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchStats.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return invokeV.booleanValue;
                }
                boolean unused = SmartLaunchStats.sPrivacyDialogIdle = true;
                if (SmartLaunchStats.DEBUG) {
                    Log.d(SmartLaunchStats.TAG, "show privacy dialog idle begin.");
                }
                SmartLaunchStats.processPrivacyDialogIdle();
                return false;
            }
        });
    }

    public SmartLaunchStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static long getFirstAvailableTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return sFirstAvailableTime;
        }
        return invokeV.longValue;
    }

    public static long getFirstTouchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return sFirstTouchTime;
        }
        return invokeV.longValue;
    }

    public static long getIdleTaskEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return sIdleTaskEndTimeStamp;
        }
        return invokeV.longValue;
    }

    public static long getIdleTaskStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return sIdleTaskStartTimeStamp;
        }
        return invokeV.longValue;
    }

    public static long getProcessAvailableTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return sProcessAvailableTime;
        }
        return invokeV.longValue;
    }

    public static boolean hasTriedToFindFirstAvailableTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return hasTriedToFindFirstAvailableTime;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFirstAvailableTimeNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return isFirstAvailableTimeNormal;
        }
        return invokeV.booleanValue;
    }

    public static void tryToFindFirstIdleTimeStamp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            hasTriedToFindFirstAvailableTime = true;
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchStats.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
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
                    return invokeV.booleanValue;
                }
            });
        }
    }

    public static void setAppStartEndTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65557, null, j) == null) {
            sAppStartEndTimeStamp = j;
        }
    }

    public static void setAppStartTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65558, null, j) == null) {
            sAppStartTimeStamp = j;
        }
    }

    public static void setAppUserPerceptionStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65559, null, j) == null) {
            sUserPerceptionAppStartTime = j;
        }
    }

    public static void setFirstAvailableTimeFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            isFirstAvailableTimeNormal = z;
            if (DEBUG) {
                Log.d(TAG, "sFirstAvailableTime is not normal, throw it away");
            }
        }
    }

    public static void setFirstTouchTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65561, null, j) == null) {
            long j2 = sAppStartTimeStamp;
            if (j2 == -1) {
                return;
            }
            sFirstTouchTime = j - j2;
        }
    }

    public static void setIdleTaskEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65562, null, j) == null) {
            sIdleTaskEndTimeStamp = j;
        }
    }

    public static void onConfirmPrivacy() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65554, null) != null) || Looper.myLooper() != Looper.getMainLooper()) {
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
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(System.currentTimeMillis()) { // from class: com.baidu.searchbox.launch.SmartLaunchStats.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long val$confirmPrivacyTime;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(r6)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$confirmPrivacyTime = r6;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (SmartLaunchStats.DEBUG) {
                        Log.d(SmartLaunchStats.TAG, "confirm privacy dialog idle begin.");
                    }
                    long currentTimeMillis = System.currentTimeMillis() - this.val$confirmPrivacyTime;
                    if (SmartLaunchStats.isTimeAvailable(currentTimeMillis)) {
                        long unused = SmartLaunchStats.sAfterLaunchAvailableTime = currentTimeMillis;
                    }
                    if (SmartLaunchStats.DEBUG) {
                        Log.d(SmartLaunchStats.TAG, "onConfirmPrivacy sAfterLaunchAvailableTime:" + SmartLaunchStats.sAfterLaunchAvailableTime);
                        return false;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        });
    }

    public static void processPrivacyDialogIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
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
    }

    public static void setIdleTaskStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65563, null, j) == null) {
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
    }

    public void stats() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mUbcManager != null) {
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
