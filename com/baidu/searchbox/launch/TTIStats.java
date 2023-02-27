package com.baidu.searchbox.launch;

import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.ubc.UBCManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TTIStats {
    public static final String TAG = "TTIStats";
    public static final String UBC_DEVICE_SCORE_KEY = "device_score";
    public static final String UBC_FIRST_AVAILABLE_TIME = "first_available_time";
    public static final String UBC_FIRST_AVAILABLE_TIME_NO_AD = "first_available_time_no_ad";
    public static final String UBC_LAUNCH_TYPE_KEY = "launch_type";
    public static final String UBC_PROCESS_AVAILABLE_TIME_KEY = "process_available_time";
    public static final String UBC_PROCESS_AVAILABLE_TIME_KEY_NO_AD = "process_available_time_no_ad";
    public static final String UBC_STAGE_KEY = "stage";
    public static final String UBC_STARTTS_KEY = "startts";
    public static final String UBC_START_LAUNCH_ID = "3112";
    public UBCManager mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final boolean DEBUG = AppConfig.isDebug();
    public static long sAppCreateTimeStamp = -1;
    public static Map<String, TTIData> mRecordMap = new HashMap();

    /* loaded from: classes2.dex */
    public static class TTIData {
        public long duration;
        public long startTs;

        public TTIData(long j, long j2) {
            this.duration = j;
            this.startTs = j2;
        }
    }

    private void asyncWriteTtiInfoToSdcard(final JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0 && SpeedStatsUtils.hasPermission(AppRuntime.getAppContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (DEBUG) {
                Log.d(TAG, "have sdcard permission! delay task execute.");
            }
            ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.launch.TTIStats.1
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009c -> B:37:0x009f). Please submit an issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    BufferedWriter bufferedWriter;
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            try {
                                File file = new File(Environment.getExternalStorageDirectory(), "cold_start_tti.txt");
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                            } catch (IOException e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedWriter.write("starttime：" + System.currentTimeMillis() + "\n");
                        StringBuilder sb = new StringBuilder();
                        sb.append(jSONObject.toString());
                        sb.append("\n");
                        bufferedWriter.write(sb.toString());
                        if (TTIStats.DEBUG) {
                            Log.d(TTIStats.TAG, "write info to cold_start_tti.txt: " + jSONObject.toString());
                        }
                        bufferedWriter.close();
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter2 = bufferedWriter;
                        e.printStackTrace();
                        Log.e(TTIStats.TAG, e.toString());
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }, "asyncWriteTtiInfoToSdcard", 3, 10000L);
        } else if (DEBUG) {
            Log.d(TAG, "do not have sdcard permission!");
        }
    }

    public static void record(String str, long j) {
        if (SmartLaunchStats.getIdleTaskStartTime() > 0) {
            return;
        }
        if (sAppCreateTimeStamp < 0) {
            sAppCreateTimeStamp = LaunchStatsUtils.getAppCreateTime();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            str = str + "_async";
        }
        TTIData tTIData = mRecordMap.get(str);
        if (tTIData != null) {
            tTIData.duration += j;
        } else {
            tTIData = new TTIData(j, (System.currentTimeMillis() - j) - sAppCreateTimeStamp);
            mRecordMap.put(str, tTIData);
        }
        if (DEBUG) {
            Log.d(TAG, "name:" + str + " time:" + j + " startTs:" + tTIData.startTs);
        }
    }

    public void stats() {
        if (SpeedStatsManager.getInstance().getStatsFlag() == 0 && this.mUbcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score", ScheduleStrategy.getDeviceScore());
                jSONObject.put("launch_type", LaunchStatsUtils.getLaunchTypeDetail());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                for (String str : mRecordMap.keySet()) {
                    TTIData tTIData = mRecordMap.get(str);
                    if (tTIData != null) {
                        jSONObject2.put(str, tTIData.duration);
                        jSONObject3.put(str, tTIData.startTs);
                    }
                }
                jSONObject.put("stage", jSONObject2);
                jSONObject.put(UBC_STARTTS_KEY, jSONObject3);
                jSONObject.put("first_available_time", SmartLaunchStats.getFirstAvailableTime());
                jSONObject.put(UBC_FIRST_AVAILABLE_TIME_NO_AD, SmartLaunchStats.getFirstAvailableTime() - SpeedStatsManager.getInstance().getAdShowDuration());
                jSONObject.put("process_available_time", SmartLaunchStats.getProcessAvailableTime());
                jSONObject.put(UBC_PROCESS_AVAILABLE_TIME_KEY_NO_AD, SmartLaunchStats.getProcessAvailableTime() - SpeedStatsManager.getInstance().getAdShowDuration());
                this.mUbcManager.onEvent(UBC_START_LAUNCH_ID, jSONObject);
                if (DEBUG) {
                    asyncWriteTtiInfoToSdcard(jSONObject);
                    Log.d(TAG, jSONObject.toString());
                }
                mRecordMap.clear();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
