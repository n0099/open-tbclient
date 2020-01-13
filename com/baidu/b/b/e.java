package com.baidu.b.b;

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
/* loaded from: classes10.dex */
public class e {
    private Context mContext = AppRuntime.getAppContext();
    private static boolean DEBUG = AppConfig.isDebug();
    private static String TAG = "networkparam";
    private static HashMap<String, Integer> OZ = new HashMap<>();

    static {
        OZ.put("WIFI", 1);
        OZ.put("3GNET", 21);
        OZ.put("3GWAP", 22);
        OZ.put("CMNET", 31);
        OZ.put("UNINET", 32);
        OZ.put("CTNET", 33);
        OZ.put("CMWAP", 41);
        OZ.put("UNIWAP", 42);
        OZ.put("CTWAP", 43);
    }

    public String np() {
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
            Integer num = OZ.get(upperCase);
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

    public String h(String str, boolean z) {
        if (z) {
            String np = np();
            if (TextUtils.equals(np, "5_0")) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString("last network type", "5_0"));
            }
            if (!TextUtils.isEmpty(np)) {
                if (!TextUtils.equals(np, "5_0")) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString("last network type", np);
                    edit.commit();
                }
                return UrlUtil.addParam(str, "network", np);
            }
            return str;
        }
        return UrlUtil.addParam(str, "network", np());
    }
}
