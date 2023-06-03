package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NetworkParam {
    public static final String LAST_NETWORK_TYPE = "last network type";
    public static final String NET_TYPE_ID_DISCONNECT = "5_0";
    public static final int UNKOWN_NET_TYPE = 5;
    public static HashMap<String, Integer> netType2Id;
    public Context mContext = AppRuntime.getAppContext();
    public static boolean DEBUG = AppConfig.isDebug();
    public static String TAG = "networkparam";

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        netType2Id = hashMap;
        hashMap.put("WIFI", 1);
        netType2Id.put("3GNET", 21);
        netType2Id.put("3GWAP", 22);
        netType2Id.put("CMNET", 31);
        netType2Id.put("UNINET", 32);
        netType2Id.put("CTNET", 33);
        netType2Id.put("CMWAP", 41);
        netType2Id.put("UNIWAP", 42);
        netType2Id.put("CTWAP", 43);
    }

    public String addNetWorkParam(String str, boolean z) {
        if (z) {
            String currentNetTypeId = getCurrentNetTypeId();
            if (TextUtils.equals(currentNetTypeId, NET_TYPE_ID_DISCONNECT)) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString(LAST_NETWORK_TYPE, NET_TYPE_ID_DISCONNECT));
            }
            if (!TextUtils.isEmpty(currentNetTypeId)) {
                if (!TextUtils.equals(currentNetTypeId, NET_TYPE_ID_DISCONNECT)) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString(LAST_NETWORK_TYPE, currentNetTypeId);
                    edit.apply();
                }
                return UrlUtil.addParam(str, "network", currentNetTypeId);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", getCurrentNetTypeId());
    }

    public String getCurrentNetTypeId() {
        long j;
        String str;
        if (DEBUG) {
            j = SystemClock.uptimeMillis();
        } else {
            j = 0;
        }
        ConnectManager connectManager = new ConnectManager(this.mContext);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            netType = netType.toUpperCase();
            Integer num = netType2Id.get(netType);
            if (num == null) {
                num = 5;
            }
            str = num + "_" + subType;
        } else {
            str = ((Object) 5) + "_" + subType;
        }
        if (DEBUG) {
            long uptimeMillis = SystemClock.uptimeMillis();
            Log.i(TAG, "getCurrentNetTypeId cost " + (uptimeMillis - j) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
        }
        return str;
    }
}
