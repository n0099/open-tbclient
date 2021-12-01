package com.baidu.down.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.request.taskmanager.DownConfig;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.IdentityManager;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SpeedStatData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SpeedStatData";
    public transient /* synthetic */ FieldHolder $fh;

    public SpeedStatData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean acquireSpeedStatConfig(Context context, DownConfig downConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, downConfig)) == null) ? downConfig.mDownSpeedStatEnable && downConfig.mConfigSpeedStat.cfgEnable != 1 && Math.abs(System.currentTimeMillis() - DownPrefUtils.getLong(context, DownPrefUtils.PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY, 0L)) > downConfig.mConfigSpeedStat.cfgMinInterval * 1000 : invokeLL.booleanValue;
    }

    public static String buildSpeedReqCfg(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cfg_ver", str);
                jSONObject.put("from", "as");
                jSONObject.put("sdk_ver", Constants.SDK_VER);
                jSONObject.put("uid", IdentityManager.getInstance(context).getEncodedUid());
                jSONObject.put("ver", "as");
                jSONObject.put("network", Utils.getWifiOr2gOr3G(context));
                jSONObject.put("apn", Utils.getCurrentNetWorkApn(context));
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    jSONObject.put("ver", packageInfo.versionCode + "");
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                jSONObject.put("type", "1");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String buildSpeedStat(Context context, TaskSpeedStat taskSpeedStat, ConfigSpeedStat configSpeedStat) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, taskSpeedStat, configSpeedStat)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (taskSpeedStat != null && !Utils.isEmpty(taskSpeedStat.getSpeedStatThreadList())) {
                int i2 = taskSpeedStat.status;
                if (i2 == 1004 || i2 == 1006) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = 0;
                    for (int i3 = 0; i3 < taskSpeedStat.getSpeedStatThreadList().size(); i3++) {
                        ThreadSpeedStat threadSpeedStat = taskSpeedStat.getSpeedStatThreadList().get(i3);
                        j2 += (threadSpeedStat.dend + threadSpeedStat.dTempDownSize) - threadSpeedStat.dstart;
                    }
                    if (configSpeedStat != null && (Math.abs(currentTimeMillis - taskSpeedStat.startTimeMillis) < configSpeedStat.cfgMinTime * 1000 || j2 < configSpeedStat.cfgMinSize)) {
                        return null;
                    }
                }
                if (configSpeedStat != null) {
                    try {
                        jSONObject.put("cfg_ver", configSpeedStat.cfgVersion);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jSONObject.put("from", "as");
                jSONObject.put("sdk_ver", Constants.SDK_VER);
                jSONObject.put("uid", IdentityManager.getInstance(context).getEncodedUid());
                jSONObject.put("ver", "as");
                jSONObject.put("network", Utils.getWifiOr2gOr3G(context));
                jSONObject.put("apn", Utils.getCurrentNetWorkApn(context));
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    jSONObject.put("ver", packageInfo.versionCode + "");
                } catch (PackageManager.NameNotFoundException e3) {
                    e3.printStackTrace();
                }
                jSONObject.put("type", "0");
                jSONObject.put("docid", taskSpeedStat.docid);
                jSONObject.put("did", taskSpeedStat.did + "");
                jSONObject.put("status", taskSpeedStat.status + "");
                jSONObject.put("startwritetime", taskSpeedStat.startWriteTimeMillis + "");
                jSONObject.put("endwritetime", taskSpeedStat.endWriteTimeMillis + "");
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < taskSpeedStat.getSpeedStatThreadList().size(); i4++) {
                    ThreadSpeedStat threadSpeedStat2 = taskSpeedStat.getSpeedStatThreadList().get(i4);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat2.cqid);
                    jSONObject2.put("url", threadSpeedStat2.url);
                    if (!TextUtils.isEmpty(threadSpeedStat2.ip)) {
                        jSONObject2.put("ip", threadSpeedStat2.ip);
                        jSONObject2.put("dt", threadSpeedStat2.dt + "");
                    }
                    jSONObject2.put("drs", threadSpeedStat2.drs);
                    long j3 = threadSpeedStat2.downEndTime - threadSpeedStat2.downStartTime;
                    if (j3 > 0 && threadSpeedStat2.downEndTime > 0) {
                        long j4 = (((threadSpeedStat2.dend + threadSpeedStat2.dTempDownSize) - threadSpeedStat2.dstart) * 1000) / j3;
                        jSONObject2.put("dspt", j4 + "");
                    } else {
                        jSONObject2.put("dspt", "0");
                    }
                    jSONObject2.put("downstarttime", threadSpeedStat2.downStartTime);
                    jSONObject2.put("downendtime", threadSpeedStat2.downEndTime);
                    jSONObject2.put("dstart", threadSpeedStat2.dstart + "");
                    jSONObject2.put("dend", (threadSpeedStat2.dend + threadSpeedStat2.dTempDownSize) + "");
                    jSONObject2.put("dsize", threadSpeedStat2.dsize + "");
                    jSONObject2.put("drnum", threadSpeedStat2.drnum + "");
                    jSONObject2.put("dstartconnecttime", threadSpeedStat2.downStartConnectTime);
                    jSONObject2.put("dendconnecttime", threadSpeedStat2.downEndConnectTime);
                    jSONArray.put(jSONObject2);
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                jSONObject.put("dl_info", jSONArray);
            }
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static ConfigSpeedStat innerParseSpeedConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ConfigSpeedStat configSpeedStat = new ConfigSpeedStat();
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    configSpeedStat.cfgVersion = jSONObject.optString("cfg_ver");
                    configSpeedStat.cfgEnable = Integer.parseInt(jSONObject.optString("cfg_enable", "1"));
                    configSpeedStat.cfgMinTime = Long.parseLong(jSONObject.optString("cfg_min_time"));
                    configSpeedStat.cfgMinSize = Long.parseLong(jSONObject.optString("cfg_min_size"));
                    configSpeedStat.cfgMinInterval = Math.min(86400L, Long.parseLong(jSONObject.optString("cfg_min_interval")));
                } else {
                    configSpeedStat.cfgVersion = "";
                    configSpeedStat.cfgEnable = 1;
                    configSpeedStat.cfgMinTime = 5L;
                    configSpeedStat.cfgMinSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
                    configSpeedStat.cfgMinInterval = ConfigSpeedStat.CFG_MIN_INTERVAL_DEFAULT;
                }
                return configSpeedStat;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ConfigSpeedStat) invokeL.objValue;
    }

    public static ConfigSpeedStat parseSpeedConfig(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                ConfigSpeedStat innerParseSpeedConfig = innerParseSpeedConfig(str);
                if (innerParseSpeedConfig != null) {
                    DownPrefUtils.setString(context, DownPrefUtils.PREF_SPEED_CONFIG_KEY, str);
                    return innerParseSpeedConfig;
                }
                return innerParseSpeedConfig(DownPrefUtils.getString(context, DownPrefUtils.PREF_SPEED_CONFIG_KEY, ""));
            }
            return innerParseSpeedConfig(DownPrefUtils.getString(context, DownPrefUtils.PREF_SPEED_CONFIG_KEY, ""));
        }
        return (ConfigSpeedStat) invokeLL.objValue;
    }
}
