package com.baidu.d.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class f {
    private static boolean DEBUG = AppConfig.isDebug();
    private static String TAG = "networkparam";
    private static HashMap<String, Integer> netType2Id = new HashMap<>();
    private Context mContext = AppRuntime.getAppContext();

    static {
        netType2Id.put("WIFI", 1);
        netType2Id.put("3GNET", 21);
        netType2Id.put("3GWAP", 22);
        netType2Id.put("CMNET", 31);
        netType2Id.put("UNINET", 32);
        netType2Id.put("CTNET", 33);
        netType2Id.put("CMWAP", 41);
        netType2Id.put("UNIWAP", 42);
        netType2Id.put("CTWAP", 43);
    }

    public String getCurrentNetTypeId() {
        long j;
        String str;
        if (!DEBUG) {
            j = 0;
        } else {
            j = SystemClock.uptimeMillis();
        }
        ConnectManager connectManager = new ConnectManager(this.mContext);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            String upperCase = netType.toUpperCase();
            Integer num = netType2Id.get(upperCase);
            if (num == null) {
                num = 5;
            }
            str = num + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + subType;
            netType = upperCase;
        } else {
            str = ((Object) 5) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + subType;
        }
        if (DEBUG) {
            Log.i(TAG, "getCurrentNetTypeId cost " + (SystemClock.uptimeMillis() - j) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
        }
        return str;
    }

    public String addNetWorkParam(String str, boolean z) {
        if (z) {
            String currentNetTypeId = getCurrentNetTypeId();
            if (TextUtils.equals(currentNetTypeId, "5_0")) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, "5_0"));
            }
            if (!TextUtils.isEmpty(currentNetTypeId)) {
                if (!TextUtils.equals(currentNetTypeId, "5_0")) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString(NetworkParam.LAST_NETWORK_TYPE, currentNetTypeId);
                    edit.apply();
                }
                return UrlUtil.addParam(str, "network", currentNetTypeId);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", getCurrentNetTypeId());
    }
}
