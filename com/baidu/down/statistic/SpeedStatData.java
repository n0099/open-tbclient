package com.baidu.down.statistic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.request.taskmanager.DownConfig;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.IdentityManager;
import com.baidu.down.utils.Utils;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SpeedStatData {
    private static final String TAG = "SpeedStatData";

    public static ConfigSpeedStat parseSpeedConfig(Context context, String str) {
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

    public static ConfigSpeedStat innerParseSpeedConfig(String str) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String buildSpeedReqCfg(Context context, String str) {
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
                jSONObject.put("ver", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + "");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            jSONObject.put("type", "1");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String buildSpeedStat(Context context, TaskSpeedStat taskSpeedStat, ConfigSpeedStat configSpeedStat) {
        long j;
        JSONObject jSONObject = new JSONObject();
        if (taskSpeedStat != null && !Utils.isEmpty(taskSpeedStat.getSpeedStatThreadList())) {
            if (taskSpeedStat.status == 1004 || taskSpeedStat.status == 1006) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= taskSpeedStat.getSpeedStatThreadList().size()) {
                        break;
                    }
                    ThreadSpeedStat threadSpeedStat = taskSpeedStat.getSpeedStatThreadList().get(i2);
                    j2 += (threadSpeedStat.dend + threadSpeedStat.dTempDownSize) - threadSpeedStat.dstart;
                    i = i2 + 1;
                }
                if (configSpeedStat != null && (Math.abs(currentTimeMillis - taskSpeedStat.startTimeMillis) < configSpeedStat.cfgMinTime * 1000 || j2 < configSpeedStat.cfgMinSize)) {
                    return null;
                }
            }
            if (configSpeedStat != null) {
                try {
                    jSONObject.put("cfg_ver", configSpeedStat.cfgVersion);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("from", "as");
            jSONObject.put("sdk_ver", Constants.SDK_VER);
            jSONObject.put("uid", IdentityManager.getInstance(context).getEncodedUid());
            jSONObject.put("ver", "as");
            jSONObject.put("network", Utils.getWifiOr2gOr3G(context));
            jSONObject.put("apn", Utils.getCurrentNetWorkApn(context));
            try {
                jSONObject.put("ver", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + "");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            jSONObject.put("type", "0");
            jSONObject.put("docid", taskSpeedStat.docid);
            jSONObject.put("did", taskSpeedStat.did + "");
            jSONObject.put("status", taskSpeedStat.status + "");
            jSONObject.put("startwritetime", taskSpeedStat.startWriteTimeMillis + "");
            jSONObject.put("endwritetime", taskSpeedStat.endWriteTimeMillis + "");
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < taskSpeedStat.getSpeedStatThreadList().size(); i3++) {
                ThreadSpeedStat threadSpeedStat2 = taskSpeedStat.getSpeedStatThreadList().get(i3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat2.cqid);
                jSONObject2.put("url", threadSpeedStat2.url);
                if (!TextUtils.isEmpty(threadSpeedStat2.ip)) {
                    jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_IP, threadSpeedStat2.ip);
                    jSONObject2.put(SuspensionBallUbc.VALUE_DT, threadSpeedStat2.dt + "");
                }
                jSONObject2.put("drs", threadSpeedStat2.drs);
                if (threadSpeedStat2.downEndTime - threadSpeedStat2.downStartTime > 0 && threadSpeedStat2.downEndTime > 0) {
                    jSONObject2.put("dspt", ((((threadSpeedStat2.dend + threadSpeedStat2.dTempDownSize) - threadSpeedStat2.dstart) * 1000) / j) + "");
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

    public static boolean acquireSpeedStatConfig(Context context, DownConfig downConfig) {
        if (downConfig.mDownSpeedStatEnable && downConfig.mConfigSpeedStat.cfgEnable != 1) {
            return Math.abs(System.currentTimeMillis() - DownPrefUtils.getLong(context, DownPrefUtils.PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY, 0L)) > downConfig.mConfigSpeedStat.cfgMinInterval * 1000;
        }
        return false;
    }
}
