package com.baidu.a.b;

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
/* loaded from: classes12.dex */
public class e {
    private static boolean DEBUG = AppConfig.isDebug();
    private static String TAG = "networkparam";
    private static HashMap<String, Integer> ajo = new HashMap<>();
    private Context mContext = AppRuntime.getAppContext();

    static {
        ajo.put("WIFI", 1);
        ajo.put("3GNET", 21);
        ajo.put("3GWAP", 22);
        ajo.put("CMNET", 31);
        ajo.put("UNINET", 32);
        ajo.put("CTNET", 33);
        ajo.put("CMWAP", 41);
        ajo.put("UNIWAP", 42);
        ajo.put("CTWAP", 43);
    }

    public String sq() {
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
            Integer num = ajo.get(upperCase);
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
            String sq = sq();
            if (TextUtils.equals(sq, "5_0")) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString("last network type", "5_0"));
            }
            if (!TextUtils.isEmpty(sq)) {
                if (!TextUtils.equals(sq, "5_0")) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString("last network type", sq);
                    edit.commit();
                }
                return UrlUtil.addParam(str, "network", sq);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", sq());
    }
}
