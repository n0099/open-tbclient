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
    private static HashMap<String, Integer> ajS = new HashMap<>();
    private Context mContext = AppRuntime.getAppContext();

    static {
        ajS.put("WIFI", 1);
        ajS.put("3GNET", 21);
        ajS.put("3GWAP", 22);
        ajS.put("CMNET", 31);
        ajS.put("UNINET", 32);
        ajS.put("CTNET", 33);
        ajS.put("CMWAP", 41);
        ajS.put("UNIWAP", 42);
        ajS.put("CTWAP", 43);
    }

    public String sA() {
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
            Integer num = ajS.get(upperCase);
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
            String sA = sA();
            if (TextUtils.equals(sA, "5_0")) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString("last network type", "5_0"));
            }
            if (!TextUtils.isEmpty(sA)) {
                if (!TextUtils.equals(sA, "5_0")) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString("last network type", sA);
                    edit.commit();
                }
                return UrlUtil.addParam(str, "network", sA);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", sA());
    }
}
