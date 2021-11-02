package com.baidu.searchbox.launch.stats;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ZygoteSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AFTER_MAINTAB_CREATE_COST = "afterMainTabCreateCost";
    public static final int APPLICATION_LAUNCH_THRESHOLD = 1000;
    public static final String APP_STARTED_COST = "appStartedCost";
    public static boolean DEBUG = false;
    public static final int DEFAULT_TICKS = 100;
    public static final String ELAPSED_CPU_COST = "elapsedCpuCost";
    public static final String ELAPSED_NO_SPLASH_COST = "elapsedNoSplashCost";
    public static final String ELAPSED_REALTIME_COST = "elapsedRealtimeCost";
    public static final String FIX_USER_PERCEPTION_COST = "fixUserPerceptionCost";
    public static final String IS_KV_LOAD_SUCCESS = "isLoadKvOptSuccess";
    public static final String KV_INIT_DURATION = "kvInitDuration";
    public static final String KV_OPT_TYPE = "isEnableKvOpt";
    public static final String LAUNCH_2_APP_ON_START = "launch2AppOnStart";
    public static final int STAT_PROCESS_START_TIME_INDEX = 21;
    public static final String TAG = "ZygoteSpeedStats";
    public static final String UNFIX_USER_PERCEPTION_COST = "unfixUserPerceptionCost";
    public static final int USER_PERCEPTION_THRESHOLD = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public long appOnCreateRealTime;
    public long mElapsedCpuTimeEnd;
    public long mElapsedCpuTimeStart;
    public long mElapsedRealtimeCost;
    public long mElapsedRealtimeEnd;
    public long mFixUserPerceptionCost;
    public long mStartTimeFromStats;
    public long mUnFixUserPerceptionCost;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(273544185, "Lcom/baidu/searchbox/launch/stats/ZygoteSpeedStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(273544185, "Lcom/baidu/searchbox/launch/stats/ZygoteSpeedStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ZygoteSpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mElapsedCpuTimeStart = -1L;
        this.mElapsedCpuTimeEnd = -1L;
        this.mElapsedRealtimeEnd = -1L;
        this.appOnCreateRealTime = -1L;
        this.mStartTimeFromStats = -1L;
        this.mUnFixUserPerceptionCost = -1L;
        this.mFixUserPerceptionCost = -1L;
        this.mElapsedRealtimeCost = -1L;
    }

    private void calculate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long appLaunchDuration = SpeedStatsManager.getInstance().getAppLaunchDuration();
            long startTimeFromStats = getStartTimeFromStats();
            if (startTimeFromStats > 0) {
                long j = this.mElapsedRealtimeEnd - startTimeFromStats;
                this.mUnFixUserPerceptionCost = j;
                if (j >= 10000 && Build.VERSION.SDK_INT >= 29) {
                    this.mFixUserPerceptionCost = this.mElapsedRealtimeEnd - Process.getStartElapsedRealtime();
                } else {
                    this.mFixUserPerceptionCost = this.mUnFixUserPerceptionCost;
                }
                this.mElapsedRealtimeCost = this.mFixUserPerceptionCost - appLaunchDuration;
            }
        }
    }

    private long getStartTimeFromStats() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            long j2 = this.mStartTimeFromStats;
            long j3 = -1;
            if (j2 != -1) {
                return j2;
            }
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (NumberFormatException unused3) {
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (FileNotFoundException unused4) {
                bufferedReader2 = bufferedReader;
                boolean z = DEBUG;
                Closeables.closeSafely(bufferedReader2);
                this.mStartTimeFromStats = j3;
                return j3;
            } catch (IOException unused5) {
                bufferedReader2 = bufferedReader;
                boolean z2 = DEBUG;
                Closeables.closeSafely(bufferedReader2);
                this.mStartTimeFromStats = j3;
                return j3;
            } catch (NumberFormatException unused6) {
                bufferedReader2 = bufferedReader;
                boolean z3 = DEBUG;
                Closeables.closeSafely(bufferedReader2);
                this.mStartTimeFromStats = j3;
                return j3;
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(bufferedReader);
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
                } catch (UnsatisfiedLinkError unused7) {
                    boolean z4 = DEBUG;
                    j = 0;
                }
                if (DEBUG) {
                    String str2 = "_SC_CLK_TCK " + j;
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
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i2, j);
            if (1001 == i2) {
                this.mElapsedCpuTimeStart = j;
            }
        }
    }

    public long getAppUserPerceptionLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mFixUserPerceptionCost == -1) {
                calculate();
            }
            return this.mFixUserPerceptionCost;
        }
        return invokeV.longValue;
    }

    public long getProcessLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getStartTimeFromStats() <= 0) {
                return 0L;
            }
            long j = this.appOnCreateRealTime - this.mStartTimeFromStats;
            if (j >= 1000 && Build.VERSION.SDK_INT >= 29) {
                return this.appOnCreateRealTime - Process.getStartElapsedRealtime();
            }
            long appOnCreateDuration = j - SpeedStatsManager.getInstance().getAppOnCreateDuration();
            if (appOnCreateDuration >= 0) {
                return appOnCreateDuration;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            super.packData(jSONObject);
            long appLaunchDuration = SpeedStatsManager.getInstance().getAppLaunchDuration();
            HashMap hashMap = new HashMap();
            hashMap.put(APP_STARTED_COST, String.valueOf(appLaunchDuration));
            hashMap.put(ELAPSED_CPU_COST, String.valueOf(this.mElapsedCpuTimeEnd - this.mElapsedCpuTimeStart));
            calculate();
            long j = this.mFixUserPerceptionCost - appLaunchDuration;
            if (j > 50 && j < 60000) {
                hashMap.put(LAUNCH_2_APP_ON_START, String.valueOf(j));
            }
            long splashActivityDuration = this.mFixUserPerceptionCost - SpeedStatsManager.getInstance().getSplashActivityDuration();
            if (splashActivityDuration > 50 && splashActivityDuration < 60000) {
                hashMap.put(ELAPSED_NO_SPLASH_COST, String.valueOf(splashActivityDuration));
            }
            hashMap.put(ELAPSED_REALTIME_COST, String.valueOf(this.mElapsedRealtimeCost));
            hashMap.put(UNFIX_USER_PERCEPTION_COST, String.valueOf(this.mUnFixUserPerceptionCost));
            long j2 = this.mFixUserPerceptionCost;
            if (j2 > 50 && j2 < 60000) {
                hashMap.put(FIX_USER_PERCEPTION_COST, String.valueOf(j2));
            }
            long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - SpeedStatsManager.getInstance().getMainTabActivityEndDuration();
            if (appLaunchEndTimeStamp > 50 && appLaunchEndTimeStamp < 60000) {
                hashMap.put(AFTER_MAINTAB_CREATE_COST, String.valueOf(appLaunchEndTimeStamp));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(this.mUnFixUserPerceptionCost, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_ZYGOTE, jsonData);
                    return true;
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.addStatsTimeStamp(i2, System.currentTimeMillis());
            if (i2 == 7000) {
                this.mElapsedRealtimeEnd = SystemClock.elapsedRealtime();
                this.mElapsedCpuTimeEnd = Process.getElapsedCpuTime();
            }
            if (i2 == 2000) {
                this.appOnCreateRealTime = SystemClock.elapsedRealtime();
            }
        }
    }
}
