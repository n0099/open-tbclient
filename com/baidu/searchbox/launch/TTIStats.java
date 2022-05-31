package com.baidu.searchbox.launch;

import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
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
    public static Map<String, TTIData> mRecordMap;
    public static long sAppCreateTimeStamp;
    public transient /* synthetic */ FieldHolder $fh;
    public UBCManager mUbcManager;

    /* loaded from: classes2.dex */
    public static class TTIData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long duration;
        public long startTs;

        public TTIData(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.duration = j;
            this.startTs = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1497543101, "Lcom/baidu/searchbox/launch/TTIStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1497543101, "Lcom/baidu/searchbox/launch/TTIStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sAppCreateTimeStamp = -1L;
        mRecordMap = new HashMap();
    }

    public TTIStats() {
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

    private void asyncWriteTtiInfoToSdcard(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) {
            if (jSONObject != null && jSONObject.length() > 0 && SpeedStatsUtils.hasPermission(AppRuntime.getAppContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (DEBUG) {
                    Log.d(TAG, "have sdcard permission! delay task execute.");
                }
                ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, jSONObject) { // from class: com.baidu.searchbox.launch.TTIStats.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TTIStats this$0;
                    public final /* synthetic */ JSONObject val$jsonObject;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jSONObject};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$jsonObject = jSONObject;
                    }

                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009f -> B:41:0x00a2). Please submit an issue!!! */
                    @Override // java.lang.Runnable
                    public void run() {
                        BufferedWriter bufferedWriter;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BufferedWriter bufferedWriter2 = null;
                            try {
                                try {
                                    try {
                                        File file = new File(Environment.getExternalStorageDirectory(), "cold_start_tti.txt");
                                        if (!file.exists()) {
                                            file.createNewFile();
                                        }
                                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } catch (IOException e) {
                                    e = e;
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                bufferedWriter.write("starttime：" + System.currentTimeMillis() + "\n");
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.val$jsonObject.toString());
                                sb.append("\n");
                                bufferedWriter.write(sb.toString());
                                if (TTIStats.DEBUG) {
                                    Log.d(TTIStats.TAG, "write info to cold_start_tti.txt: " + this.val$jsonObject.toString());
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
                    }
                }, "asyncWriteTtiInfoToSdcard", 3, 10000L);
            } else if (DEBUG) {
                Log.d(TAG, "do not have sdcard permission!");
            }
        }
    }

    public static void record(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j) == null) || SmartLaunchStats.getIdleTaskStartTime() > 0) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SpeedStatsManager.getInstance().getStatsFlag() == 0 && this.mUbcManager != null) {
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
