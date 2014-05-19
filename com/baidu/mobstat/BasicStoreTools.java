package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
public class BasicStoreTools extends BasicStoreToolsBase {
    public static final String APP_ANALYSIS_EXCEPTION = "exceptionanalysisflag";
    public static final String APP_ANALYSIS_EXCEPTION_TAG = "exceptionanalysistag";
    public static final String APP_MAC_ADDRESS = "mtjsdkmacss";
    public static final String APP_SET_APPKEY = "mjsetappkey";
    public static final String APP_SET_CHANNEL = "setchannelwithcodevalue";
    public static final String APP_SET_CHANNEL_WITH_CODE = "setchannelwithcode";
    public static final String DEVICE_CUID = "cuidsec";
    public static final String DEVICE_ID = "device_id";
    public static final String LAST_SEND_TIME = "lastsendtime";
    public static final String ONLY_WIFI = "onlywifi";
    public static final String SEND_LOG_TYPE = "sendLogtype";
    public static final String TIME_INTERVAL = "timeinterval";
    static BasicStoreTools a = new BasicStoreTools();

    private BasicStoreTools() {
    }

    public static BasicStoreTools getInstance() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getAppChannelWithCode(Context context) {
        return getBoolean(context, APP_SET_CHANNEL_WITH_CODE, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAppChannelWithPreference(Context context) {
        return getString(context, APP_SET_CHANNEL, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAppDeviceMac(Context context) {
        return getString(context, APP_MAC_ADDRESS, null);
    }

    protected String getAppKey(Context context) {
        return getString(context, APP_SET_APPKEY, null);
    }

    protected String getExceptionHeadTag(Context context) {
        return getString(context, APP_ANALYSIS_EXCEPTION_TAG, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getExceptionTurn(Context context) {
        return getBoolean(context, APP_ANALYSIS_EXCEPTION, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getGenerateDeviceCUID(Context context) {
        return getString(context, DEVICE_CUID, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getGenerateDeviceId(Context context) {
        return getString(context, DEVICE_ID, null);
    }

    protected long getLastSendTime(Context context) {
        return getLong(context, LAST_SEND_TIME, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getOnlyWifiChannel(Context context) {
        return getBoolean(context, ONLY_WIFI, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSendStrategy(Context context) {
        return getInt(context, SEND_LOG_TYPE, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSendStrategyTime(Context context) {
        return getInt(context, TIME_INTERVAL, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAppChannelWithCode(Context context, boolean z) {
        putBoolean(context, APP_SET_CHANNEL_WITH_CODE, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAppChannelWithPreference(Context context, String str) {
        putString(context, APP_SET_CHANNEL, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAppDeviceMac(Context context, String str) {
        putString(context, APP_MAC_ADDRESS, str);
    }

    protected void setAppKey(Context context, String str) {
        putString(context, APP_SET_APPKEY, str);
    }

    protected void setExceptionHeadTag(Context context, String str) {
        putString(context, APP_ANALYSIS_EXCEPTION_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExceptionTurn(Context context, boolean z) {
        putBoolean(context, APP_ANALYSIS_EXCEPTION, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGenerateDeviceCUID(Context context, String str) {
        if (getString(context, "cuid", null) != null) {
            removeString(context, "cuid");
        }
        putString(context, DEVICE_CUID, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGenerateDeviceId(Context context, String str) {
        putString(context, DEVICE_ID, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLastSendTime(Context context, long j) {
        putLong(context, LAST_SEND_TIME, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnlyWifi(Context context, boolean z) {
        putBoolean(context, ONLY_WIFI, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSendStrategy(Context context, int i) {
        putInt(context, SEND_LOG_TYPE, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSendStrategyTime(Context context, int i) {
        putInt(context, TIME_INTERVAL, i);
    }
}
