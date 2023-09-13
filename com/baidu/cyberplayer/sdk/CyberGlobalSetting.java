package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes3.dex */
public class CyberGlobalSetting {
    public static final String DEFAULT_CLOUD_SETTING_SERVER_URL = "https://browserkernel.baidu.com/video";
    public static final String DEFAULT_LIBS_CDN_DOWNLOAD_SERVER_URL = "https://b.bdstatic.com/searchbox/androidvideo";
    public static final String DEFAULT_LIBS_XCDN_DOWNLOAD_SERVER_URL = "https://pms-zeus-xcdn.bdstatic.com/searchbox/androidvideo";
    public static final String DEFAULT_STATISTICS_UPLOAD_SERVER_URL = "https://browserkernel.baidu.com/kw?r_en=true&type=";
    public static final String TAG = "CyberGlobalSetting";
    public String mCloundSettingServerUrl;
    public boolean mIsCloundSettingEnable;
    public boolean mIsDownloadLibsEnable;
    public boolean mIsSFSwitchEnable;
    public String mLibsDownloadServerUrl;
    public boolean mStatisticsUploadEnable;
    public String mStatisticsUploadServerUrl;

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static final CyberGlobalSetting INSTANCE = new CyberGlobalSetting();
    }

    public CyberGlobalSetting() {
        this.mStatisticsUploadEnable = true;
        this.mStatisticsUploadServerUrl = null;
        this.mCloundSettingServerUrl = null;
        this.mIsCloundSettingEnable = true;
        this.mIsDownloadLibsEnable = true;
        this.mLibsDownloadServerUrl = null;
        this.mIsSFSwitchEnable = false;
    }

    public static CyberGlobalSetting getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getCloundSettingServerUrl() {
        if (!TextUtils.isEmpty(this.mCloundSettingServerUrl)) {
            return this.mCloundSettingServerUrl;
        }
        return CyberCfgManager.getInstance().makeCloundSettingRequestUrl(CyberCfgManager.getInstance().getCfgValue(CyberCfgManager.KEY_STR_UPDATE_CLOUD_CFG_SERVER, DEFAULT_CLOUD_SETTING_SERVER_URL));
    }

    public String getStatisticsUploadServerUrl() {
        if (!TextUtils.isEmpty(this.mStatisticsUploadServerUrl)) {
            return this.mStatisticsUploadServerUrl;
        }
        String cfgValue = CyberCfgManager.getInstance().getCfgValue(CyberCfgManager.KEY_STR_UPLOAD_SESSION_SERVER, "");
        if (TextUtils.isEmpty(cfgValue)) {
            return "https://browserkernel.baidu.com/kw?r_en=true&type=";
        }
        return cfgValue;
    }

    public boolean isCloundSettingEnable() {
        if (isSFSwitchEnabled()) {
            return false;
        }
        return this.mIsCloundSettingEnable;
    }

    public boolean isDownloadLibsEnable() {
        if (!this.mIsDownloadLibsEnable || isSFSwitchEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isLibInitSessionUploadEnable() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_UPLOAD_KERNEL_INIT_LOG, true);
    }

    public boolean isLiveUploadDoubleEnable() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_LIVE_UPLOAD_DOUBLE, false);
    }

    public synchronized boolean isSFSwitchEnabled() {
        CyberLog.d(TAG, "isSFSwitchEnabled:" + this.mIsSFSwitchEnable);
        return this.mIsSFSwitchEnable;
    }

    public boolean isStatisticsUploadEnable() {
        if (!this.mStatisticsUploadEnable) {
            CyberLog.i(TAG, "isStatisticsUploadEnable closed");
            return false;
        } else if (isSFSwitchEnabled()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_UPLOAD_SESSION_LOG, false);
        }
    }

    public boolean isUbcUploadEnable() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_UPLOAD_UBC_LOG, true);
    }

    public String getLibsDownloadServerUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(this.mLibsDownloadServerUrl)) {
            return this.mLibsDownloadServerUrl;
        }
        String cfgValue = CyberCfgManager.getInstance().getCfgValue(CyberCfgManager.KEY_STR_UPDATE_CORE_SERVER, "");
        if (!TextUtils.isEmpty(cfgValue)) {
            return cfgValue;
        }
        return DEFAULT_LIBS_CDN_DOWNLOAD_SERVER_URL;
    }

    public void setCloundSettingEnable(boolean z) {
        this.mIsCloundSettingEnable = z;
    }

    public void setCloundSettingServerUrl(String str) {
        this.mCloundSettingServerUrl = str;
    }

    public void setDownloadLibsEnable(boolean z) {
        this.mIsDownloadLibsEnable = z;
    }

    public void setLibsDownloadServerUrl(String str) {
        this.mLibsDownloadServerUrl = str;
    }

    public void setSFSwitchEnable(boolean z) {
        this.mIsSFSwitchEnable = z;
    }

    public void setStatisticsEnable(boolean z) {
        this.mStatisticsUploadEnable = z;
    }

    public void setStatisticsUploadServerUrl(String str) {
        this.mStatisticsUploadServerUrl = str;
    }
}
