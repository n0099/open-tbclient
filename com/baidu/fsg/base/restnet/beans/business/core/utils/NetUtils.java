package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class NetUtils {
    private static final String TAG = "NetUtils";

    public static JSONObject getWifiSig(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        try {
            jSONObject.put("cuid", str);
            if (wifiManager == null || !wifiManager.isWifiEnabled()) {
                jSONObject.put("wifi_conn", "");
                jSONObject.put("wifi_scan", "");
                return jSONObject;
            }
        } catch (Exception e) {
            LogUtil.e(TAG, BdStatsConstant.StatsType.ERROR, e);
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        List<ScanResult> scanResults = wifiManager.getScanResults();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (connectionInfo != null) {
                jSONObject2.put("mac", connectionInfo.getBSSID());
                jSONObject2.put("rssi", connectionInfo.getRssi());
                jSONObject2.put("ssid", connectionInfo.getSSID());
                jSONObject.put("wifi_conn", jSONObject2);
            }
            if (scanResults != null && scanResults.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                for (ScanResult scanResult : scanResults) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("mac", scanResult.BSSID);
                    jSONObject3.put("rssi", scanResult.level);
                    jSONObject3.put("ssid", scanResult.SSID);
                    jSONArray.put(jSONObject3);
                    int i2 = i + 1;
                    if (i2 >= 10) {
                        break;
                    }
                    i = i2;
                }
                jSONObject.put("wifi_scan", jSONArray);
            } else {
                jSONObject.put("wifi_scan", "");
            }
            return jSONObject;
        } catch (Exception e2) {
            LogUtil.e(TAG, BdStatsConstant.StatsType.ERROR, e2);
            return null;
        }
    }

    public static JSONObject getConnectedWifi(Context context) {
        if (context == null) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mac", connectionInfo.getBSSID());
                jSONObject.put("rssi", connectionInfo.getRssi());
                jSONObject.put("ssid", connectionInfo.getSSID());
                return jSONObject;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
