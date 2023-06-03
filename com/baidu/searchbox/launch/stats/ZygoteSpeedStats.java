package com.baidu.searchbox.launch.stats;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.performance.speed.SpeedStats;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ZygoteSpeedStats extends AbstractSpeedStats {
    public static final String AD_CLOSE_TO_MAIN_FINISH = "adCloseToMainFinish";
    public static final String AFTER_MAINTAB_CREATE_COST_NO_AD = "afterMainTabCreateCostNoAd";
    public static final int APPLICATION_LAUNCH_THRESHOLD = 1000;
    public static final String APP_CREATE_TO_MAIN_CREATE = "appCreateToMainCreate";
    public static final String APP_HAS_BACKGROUND = "hasBackground";
    public static final String APP_STARTED_COST = "appStartedCost";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_TICKS = 100;
    public static final String DRAW_TO_END_COST = "draw2End";
    public static final String ELAPSED_CPU_COST = "elapsedCpuCost";
    public static final String ELAPSED_NO_BACKGROUND_COST = "elapsedNoBackgroundCost";
    public static final String ELAPSED_NO_SPLASH_COST = "elapsedNoSplashCost";
    public static final String ELAPSED_NO_TOTAL_SPLASH_COST = "elapsedNoTotalSplashCost";
    public static final String ELAPSED_REALTIME_COST = "elapsedRealtimeCost";
    public static final String FIX_USER_PERCEPTION_COST = "fixUserPerceptionCost";
    public static final String IS_SWITCH_ON = "isSwitchOn";
    public static final String LAUNCH_2_APP_ON_START = "launch2AppOnStart";
    public static final String LAUNCH_TO_DEAW_COST = "launch2draw";
    public static final String MAIN_CREATE_TO_AD_CLOSE = "mainCreateToAdClose";
    public static final int STAT_PROCESS_START_TIME_INDEX = 21;
    public static final String TAG = "ZygoteSpeedStats";
    public static final String UNFIX_USER_PERCEPTION_COST = "unfixUserPerceptionCost";
    public static final int USER_PERCEPTION_THRESHOLD = 10000;
    public long mElapsedCpuTimeStart = -1;
    public long mElapsedCpuTimeEnd = -1;
    public long mElapsedRealtimeEnd = -1;
    public long appOnCreateRealTime = -1;
    public long mStartTimeFromStats = -1;
    public long mUnFixUserPerceptionCost = -1;
    public long mFixUserPerceptionCost = -1;
    public long mElapsedRealtimeCost = -1;
    public long mSecondDrawDispatchedTimeStamp = -1;
    public long mElapsedSecondDrawTimeStamp = -1;
    public long mLaunchStartStamp = -1;
    public boolean isSwitchOn = false;

    public long getAppUserPerceptionLaunchDuration() {
        if (this.mFixUserPerceptionCost == -1) {
            calculate();
        }
        return this.mFixUserPerceptionCost;
    }

    private void calculate() {
        long appLaunchDuration = SpeedStatsManager.getInstance().getAppLaunchDuration();
        long startTimeFromStats = getStartTimeFromStats();
        if (startTimeFromStats > 0) {
            long j = this.mElapsedRealtimeEnd - startTimeFromStats;
            this.mUnFixUserPerceptionCost = j;
            this.mLaunchStartStamp = startTimeFromStats;
            if (j >= 10000 && Build.VERSION.SDK_INT >= 29) {
                long startElapsedRealtime = Process.getStartElapsedRealtime();
                this.mFixUserPerceptionCost = this.mElapsedRealtimeEnd - startElapsedRealtime;
                this.mLaunchStartStamp = startElapsedRealtime;
            } else {
                this.mFixUserPerceptionCost = this.mUnFixUserPerceptionCost;
            }
            this.mElapsedRealtimeCost = this.mFixUserPerceptionCost - appLaunchDuration;
        }
    }

    public long getProcessLaunchDuration() {
        if (getStartTimeFromStats() <= 0) {
            return 0L;
        }
        long j = this.appOnCreateRealTime - this.mStartTimeFromStats;
        if (j >= 1000 && Build.VERSION.SDK_INT >= 29) {
            return this.appOnCreateRealTime - Process.getStartElapsedRealtime();
        }
        long appOnCreateDuration = j - SpeedStatsManager.getInstance().getAppOnCreateDuration();
        if (appOnCreateDuration < 0) {
            return 0L;
        }
        return appOnCreateDuration;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00c0: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:59:0x00c0 */
    private long getStartTimeFromStats() {
        BufferedReader bufferedReader;
        NumberFormatException e;
        IOException e2;
        FileNotFoundException e3;
        Closeable closeable;
        String readLine;
        long j;
        long j2 = this.mStartTimeFromStats;
        long j3 = -1;
        if (j2 != -1) {
            return j2;
        }
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                try {
                    readLine = bufferedReader.readLine();
                } catch (FileNotFoundException e4) {
                    e3 = e4;
                    if (DEBUG) {
                        Log.e(TAG, "can't read process status file", e3);
                    }
                    Closeables.closeSafely(bufferedReader);
                    this.mStartTimeFromStats = j3;
                    return j3;
                } catch (IOException e5) {
                    e2 = e5;
                    if (DEBUG) {
                        Log.e(TAG, "read process status failed", e2);
                    }
                    Closeables.closeSafely(bufferedReader);
                    this.mStartTimeFromStats = j3;
                    return j3;
                } catch (NumberFormatException e6) {
                    e = e6;
                    if (DEBUG) {
                        Log.e(TAG, "parse status file failed", e);
                    }
                    Closeables.closeSafely(bufferedReader);
                    this.mStartTimeFromStats = j3;
                    return j3;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                Closeables.closeSafely(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e7) {
            bufferedReader = null;
            e3 = e7;
        } catch (IOException e8) {
            bufferedReader = null;
            e2 = e8;
        } catch (NumberFormatException e9) {
            bufferedReader = null;
            e = e9;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(closeable2);
            throw th;
        }
        if (TextUtils.isEmpty(readLine)) {
            Closeables.closeSafely(bufferedReader);
            return -1L;
        }
        String[] split = readLine.split(" ");
        if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
            String str = split[21];
            try {
                j = LaunchNativeUtils.getClkTck();
            } catch (UnsatisfiedLinkError e10) {
                if (DEBUG) {
                    Log.e(TAG, "load so failed, UnsatisfiedLinkError", e10);
                }
                j = 0;
            }
            if (DEBUG) {
                Log.d(TAG, "_SC_CLK_TCK " + j);
            }
            if (j <= 0) {
                j = 100;
            }
            j3 = (Long.parseLong(str) * 1000) / j;
        }
        Closeables.closeSafely(bufferedReader);
        this.mStartTimeFromStats = j3;
        return j3;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        super.addStatsTimeStamp(i, System.currentTimeMillis());
        if (i == 6000) {
            this.mElapsedRealtimeEnd = SystemClock.elapsedRealtime();
            this.mElapsedCpuTimeEnd = Process.getElapsedCpuTime();
        }
        if (i == 2000) {
            this.appOnCreateRealTime = SystemClock.elapsedRealtime();
        }
    }

    public void setIsSwitchOn(boolean z) {
        this.isSwitchOn = z;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        super.addStatsTimeStamp(i, j);
        if (1001 == i) {
            this.mElapsedCpuTimeStart = j;
        }
        if (i == 5054) {
            this.mSecondDrawDispatchedTimeStamp = j;
            this.mElapsedSecondDrawTimeStamp = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        Object obj;
        super.packData(jSONObject);
        long appLaunchDuration = SpeedStatsManager.getInstance().getAppLaunchDuration();
        HashMap hashMap = new HashMap();
        hashMap.put(APP_STARTED_COST, String.valueOf(appLaunchDuration));
        hashMap.put(ELAPSED_CPU_COST, String.valueOf(this.mElapsedCpuTimeEnd - this.mElapsedCpuTimeStart));
        calculate();
        long j = this.mFixUserPerceptionCost - appLaunchDuration;
        if (j > 0 && j < 60000) {
            hashMap.put(LAUNCH_2_APP_ON_START, String.valueOf(j));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j, null);
            if (jsonData != null) {
                try {
                    jSONObject.put(LAUNCH_2_APP_ON_START, jsonData);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        long adShowDuration = this.mFixUserPerceptionCost - SpeedStatsManager.getInstance().getAdShowDuration();
        if (adShowDuration > 50 && adShowDuration < 60000) {
            hashMap.put(ELAPSED_NO_SPLASH_COST, String.valueOf(adShowDuration));
            JSONObject jsonData2 = SpeedStatsUtils.getJsonData(adShowDuration, null);
            if (jsonData2 != null) {
                try {
                    jSONObject.put(ELAPSED_NO_SPLASH_COST, jsonData2);
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        String str = "1";
        if (SpeedStats.getInstance().getAppInBackgroundDuration() > 0) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put(APP_HAS_BACKGROUND, obj);
        long adShowDuration2 = (this.mFixUserPerceptionCost - SpeedStatsManager.getInstance().getAdShowDuration()) - SpeedStats.getInstance().getAppInBackgroundDuration();
        if (adShowDuration2 > 50 && adShowDuration2 < 60000) {
            hashMap.put(ELAPSED_NO_BACKGROUND_COST, String.valueOf(adShowDuration2));
            JSONObject jsonData3 = SpeedStatsUtils.getJsonData(adShowDuration2, null);
            if (jsonData3 != null) {
                try {
                    jSONObject.put(ELAPSED_NO_BACKGROUND_COST, jsonData3);
                } catch (JSONException e3) {
                    if (DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        long adTotalDuration = this.mFixUserPerceptionCost - SpeedStatsManager.getInstance().getAdTotalDuration();
        if (adTotalDuration > 50 && adTotalDuration < 60000) {
            hashMap.put(ELAPSED_NO_TOTAL_SPLASH_COST, String.valueOf(adTotalDuration));
            JSONObject jsonData4 = SpeedStatsUtils.getJsonData(adTotalDuration, null);
            if (jsonData4 != null) {
                try {
                    jSONObject.put(ELAPSED_NO_TOTAL_SPLASH_COST, jsonData4);
                } catch (JSONException e4) {
                    if (DEBUG) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        long durationWithoutAD = SpeedStatsManager.getInstance().getDurationWithoutAD(this.mLaunchStartStamp, this.mElapsedSecondDrawTimeStamp);
        if (durationWithoutAD > 50 && durationWithoutAD < 60000) {
            hashMap.put(LAUNCH_TO_DEAW_COST, String.valueOf(durationWithoutAD));
        }
        long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - this.mSecondDrawDispatchedTimeStamp;
        if (appLaunchEndTimeStamp > 0 && appLaunchEndTimeStamp < 60000) {
            hashMap.put(DRAW_TO_END_COST, String.valueOf(appLaunchEndTimeStamp));
        }
        hashMap.put(ELAPSED_REALTIME_COST, String.valueOf(this.mElapsedRealtimeCost));
        hashMap.put(UNFIX_USER_PERCEPTION_COST, String.valueOf(this.mUnFixUserPerceptionCost));
        long j2 = this.mFixUserPerceptionCost;
        if (j2 > 50 && j2 < 60000) {
            hashMap.put(FIX_USER_PERCEPTION_COST, String.valueOf(j2));
        }
        long durationWithoutAD2 = SpeedStatsManager.getInstance().getDurationWithoutAD(SpeedStatsManager.getInstance().getMainTabActivityEndDuration(), SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp()) - SpeedStatsManager.getInstance().getExtraSecondCreateDuration();
        if (durationWithoutAD2 > 50 && durationWithoutAD2 < 60000) {
            hashMap.put(AFTER_MAINTAB_CREATE_COST_NO_AD, String.valueOf(durationWithoutAD2));
            JSONObject jsonData5 = SpeedStatsUtils.getJsonData(durationWithoutAD2, null);
            if (jsonData5 != null) {
                try {
                    jSONObject.put(AFTER_MAINTAB_CREATE_COST_NO_AD, jsonData5);
                } catch (JSONException e5) {
                    if (DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        long mainActivityCreateStartTimeStamp = SpeedStatsManager.getInstance().getMainActivityCreateStartTimeStamp() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
        if (mainActivityCreateStartTimeStamp > 50 && mainActivityCreateStartTimeStamp < 60000) {
            hashMap.put(APP_CREATE_TO_MAIN_CREATE, String.valueOf(mainActivityCreateStartTimeStamp));
            JSONObject jsonData6 = SpeedStatsUtils.getJsonData(mainActivityCreateStartTimeStamp, null);
            if (jsonData6 != null) {
                try {
                    jSONObject.put(APP_CREATE_TO_MAIN_CREATE, jsonData6);
                } catch (JSONException e6) {
                    if (DEBUG) {
                        e6.printStackTrace();
                    }
                }
            }
        }
        long durationWithoutAD3 = SpeedStatsManager.getInstance().getDurationWithoutAD(SpeedStatsManager.getInstance().getMainActivityCreateStartTimeStamp(), SpeedStatsManager.getInstance().getAdViewEndTimeStamp());
        if (durationWithoutAD3 > 50 && durationWithoutAD3 < 60000) {
            hashMap.put(MAIN_CREATE_TO_AD_CLOSE, String.valueOf(durationWithoutAD3));
            JSONObject jsonData7 = SpeedStatsUtils.getJsonData(durationWithoutAD3, null);
            if (jsonData7 != null) {
                try {
                    jSONObject.put(MAIN_CREATE_TO_AD_CLOSE, jsonData7);
                } catch (JSONException e7) {
                    if (DEBUG) {
                        e7.printStackTrace();
                    }
                }
            }
        }
        long appLaunchEndTimeStamp2 = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - SpeedStatsManager.getInstance().getAdViewEndTimeStamp();
        if (appLaunchEndTimeStamp2 > 50 && appLaunchEndTimeStamp2 < 60000) {
            hashMap.put(AD_CLOSE_TO_MAIN_FINISH, String.valueOf(appLaunchEndTimeStamp2));
            JSONObject jsonData8 = SpeedStatsUtils.getJsonData(appLaunchEndTimeStamp2, null);
            if (jsonData8 != null) {
                try {
                    jSONObject.put(AD_CLOSE_TO_MAIN_FINISH, jsonData8);
                } catch (JSONException e8) {
                    if (DEBUG) {
                        e8.printStackTrace();
                    }
                }
            }
        }
        if (!this.isSwitchOn) {
            str = "0";
        }
        hashMap.put(IS_SWITCH_ON, str);
        JSONObject jsonData9 = SpeedStatsUtils.getJsonData(this.mUnFixUserPerceptionCost, hashMap);
        if (jsonData9 != null) {
            try {
                jSONObject.put(SpeedStatsMainTable.APP_ZYGOTE, jsonData9);
                return true;
            } catch (JSONException e9) {
                if (DEBUG) {
                    e9.printStackTrace();
                    return true;
                }
                return true;
            }
        }
        return true;
    }
}
