package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class BasicStoreTools extends bu {
    private static final String a = "__Baidu_Stat_SDK_SendRem";
    private static BasicStoreTools b = new BasicStoreTools();

    private BasicStoreTools() {
    }

    public static BasicStoreTools getInstance() {
        return b;
    }

    @Override // com.baidu.mobstat.bu
    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(a, 0);
    }

    public void setSendStrategy(Context context, int i) {
        putInt(context, "sendLogtype", i);
    }

    public int getSendStrategy(Context context) {
        return getInt(context, "sendLogtype", 0);
    }

    public void setSendStrategyTime(Context context, int i) {
        putInt(context, "timeinterval", i);
    }

    public int getSendStrategyTime(Context context) {
        return getInt(context, "timeinterval", 1);
    }

    public void setOnlyWifi(Context context, boolean z) {
        putBoolean(context, "onlywifi", z);
    }

    public boolean getOnlyWifiChannel(Context context) {
        return getBoolean(context, "onlywifi", false);
    }

    public void setGenerateDeviceId(Context context, String str) {
        putString(context, "device_id_1", str);
    }

    public String getGenerateDeviceId(Context context) {
        return getString(context, "device_id_1", null);
    }

    public void setGenerateDeviceCUID(Context context, String str) {
        if (getString(context, "cuid", null) != null) {
            removeString(context, "cuid");
        }
        putString(context, "cuidsec_1", str);
    }

    public String getGenerateDeviceCUID(Context context) {
        return getString(context, "cuidsec_1", null);
    }

    public void setAppChannelWithPreference(Context context, String str) {
        putString(context, "setchannelwithcodevalue", str);
    }

    public String getAppChannelWithPreference(Context context) {
        return getString(context, "setchannelwithcodevalue", null);
    }

    public void setAppChannelWithCode(Context context, boolean z) {
        putBoolean(context, "setchannelwithcode", z);
    }

    public boolean getAppChannelWithCode(Context context) {
        return getBoolean(context, "setchannelwithcode", false);
    }

    public void setAppKey(Context context, String str) {
        putString(context, "mjsetappkey", str);
    }

    public String getAppKey(Context context) {
        return getString(context, "mjsetappkey", null);
    }

    public void setAppDeviceMac(Context context, String str) {
        putString(context, "mtjsdkmacss2_1", str);
    }

    public String getAppDeviceMac(Context context) {
        return getString(context, "mtjsdkmacss2_1", null);
    }

    public void setLastData(Context context, String str) {
        putString(context, "lastdata", str);
    }

    public String getLastData(Context context) {
        return getString(context, "lastdata", null);
    }

    public void setForTV(Context context, boolean z) {
        putBoolean(context, "mtjtv", z);
    }

    public boolean getForTV(Context context) {
        return getBoolean(context, "mtjtv", false);
    }

    public void setAppDeviceMacTv(Context context, String str) {
        putString(context, "mtjsdkmacsstv_1", str);
    }

    public String getAppDeviceMacTv(Context context) {
        return getString(context, "mtjsdkmacsstv_1", null);
    }

    public void setHeaderExt(Context context, String str) {
        putString(context, "he.ext", str);
    }

    public String getHeaderExt(Context context) {
        return getString(context, "he.ext", null);
    }

    public void setPushId(Context context, String str) {
        putString(context, "he.push", str);
    }

    public String getPushId(Context context) {
        return getString(context, "he.push", null);
    }

    public void setMacEnabledTrick(Context context, boolean z) {
        putBoolean(context, "mtjsdkmactrick", z);
    }

    public boolean getMacEnabledTrick(Context context) {
        return getBoolean(context, "mtjsdkmactrick", true);
    }

    public void setAutoTraceTrackJsFetchTime(Context context, long j) {
        putLong(context, "autotrace_track_js_fetch_time", j);
    }

    public long getAutoTraceTrackJsFetchTime(Context context) {
        return getLong(context, "autotrace_track_js_fetch_time", 0L);
    }

    public void setAutoTraceTrackJsFetchInterval(Context context, long j) {
        putLong(context, "autotrace_track_js_fetch_interval", j);
    }

    public long getAutoTraceTrackJsFetchInterval(Context context) {
        return getLong(context, "autotrace_track_js_fetch_interval", 0L);
    }

    public void setAutoTraceConfigFetchTime(Context context, long j) {
        putLong(context, "autotrace_config_fetch_time", j);
    }

    public long getAutoTraceConfigFetchTime(Context context) {
        return getLong(context, "autotrace_config_fetch_time", 0L);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        putString(context, "custom_userid", str);
    }

    public String getUserId(Context context) {
        return getString(context, "custom_userid", "");
    }
}
