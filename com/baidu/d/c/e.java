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
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e {
    private static boolean DEBUG = AppConfig.isDebug();
    private static String TAG = "networkparam";
    private static HashMap<String, Integer> amO = new HashMap<>();
    private Context mContext = AppRuntime.getAppContext();

    static {
        amO.put("WIFI", 1);
        amO.put("3GNET", 21);
        amO.put("3GWAP", 22);
        amO.put("CMNET", 31);
        amO.put("UNINET", 32);
        amO.put("CTNET", 33);
        amO.put("CMWAP", 41);
        amO.put("UNIWAP", 42);
        amO.put("CTWAP", 43);
    }

    public String uT() {
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
            Integer num = amO.get(upperCase);
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

    public String l(String str, boolean z) {
        if (z) {
            String uT = uT();
            if (TextUtils.equals(uT, "5_0")) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString("last network type", "5_0"));
            }
            if (!TextUtils.isEmpty(uT)) {
                if (!TextUtils.equals(uT, "5_0")) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString("last network type", uT);
                    edit.commit();
                }
                return UrlUtil.addParam(str, "network", uT);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", uT());
    }
}
