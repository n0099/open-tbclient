package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.CyberFileDownloader;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.cyberplayer.sdk.task.UpgradeTask;
import com.baidu.cyberplayer.sdk.task.UpgradeTaskManager;
import com.baidu.cyberplayer.sdk.utils.CyberFileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberCoreLoader implements CyberFileDownloader.ICyberFileDownloadListener {
    public static final String CYBER_MEDIA_DEX = "cyber-media-dex";
    public static final String CYBER_PREFER = "video_cfg";
    public static final String KEY_SUCCESS_DOWNLOAD_CORE_COUNT = "success-download-core-count";
    public static final String KEY_SUCCESS_DOWNLOAD_CORE_TIME = "success-download-core-time";
    public static final int LOAD_CODE_CHECK_ERROR = -3;
    public static final int LOAD_CODE_CPU_NOT_SUPPORT_ERROR = -5;
    public static final int LOAD_CODE_DOWNLOAD_ERROR = -1;
    public static final int LOAD_CODE_LOAD_ERROR = -4;
    public static final int LOAD_CODE_RENAME_ERROR = -6;
    public static final int LOAD_CODE_SUCCESS = 0;
    public static final int LOAD_CODE_UNKONW_ERROR = -100;
    public static final int LOAD_CODE_UNZIP_ERROR = -2;
    public static final int MAX_SUCCESS_DOWNLOAD_COUNT = 36;
    public static final long MIN_INTERNAL_STORAGE_USABLE_SPACE = 20971520;
    public static final long MIN_UPDATE_LOAD_PROGRESS_INTERVAL = 500;
    public static final String TAG = "CyberCoreLoader";
    public static final int TYPE_INIT_CFG = 2;
    public static final int TYPE_LOAD_CORE = 0;
    public static final int TYPE_LOAD_CORE_LIBS = 1;
    public static ClassLoader sClassLoader;
    public static volatile CyberCoreLoader sInstance;
    public volatile int mReqInstallType;
    public long mLastProgressUpdateTime = 0;
    public int mSuccessDownloadCount = 0;
    public Context mContext = null;
    public String mLoadableVer = SDKVersion.VERSION;
    public String mLibsFolder = null;
    public String mCyberMediaFolder = null;
    public String mDownloadServer = null;
    public boolean mIsDowngraded = false;
    public Map<String, String> mOpts = null;
    public ArrayList<String> mUnzipFileList = null;
    public CyberPlayerManager.InstallListener2 mListener = null;
    public long mLoadCoreTime = -1;
    public long mLoadLibsTime = -1;
    public long mInitCfgTime = -1;
    public volatile boolean mUseXCDNServer = false;
    public String mXCDNFailInfo = null;
    public int mDownloadCount = 0;

    @Override // com.baidu.cyberplayer.sdk.downloader.CyberFileDownloader.ICyberFileDownloadListener
    public void onDownloadStart(String str, long j) {
    }

    public static CyberCoreLoader getInstance() {
        if (sInstance == null) {
            synchronized (CyberCoreLoader.class) {
                if (sInstance == null) {
                    sInstance = new CyberCoreLoader();
                }
            }
        }
        return sInstance;
    }

    private SharedPreferences getPrefs() {
        return this.mContext.getSharedPreferences("video_cfg", 0);
    }

    private boolean isCpuSupport() {
        String cpuType = Utils.getCpuType();
        if (!cpuType.contains("armv7-neon") && !cpuType.contains("AArch64") && !cpuType.contains("arm64")) {
            return false;
        }
        return true;
    }

    private void notiyLoadSuccess() {
        CyberPlayerManager.InstallListener2 installListener2 = this.mListener;
        if (installListener2 != null) {
            installListener2.onInstallSuccess(this.mReqInstallType, CyberPlayerCoreInvoker.getCoreVersion());
        }
        if (Utils.isMainProcess()) {
            CyberCfgManager.getInstance().setPrefInt(CyberCfgManager.SP_KEY_INSTALL_ERROR_COUNT, 0);
        }
    }

    public int getDownloadCount() {
        return this.mDownloadCount;
    }

    public boolean getIsDowngradled() {
        return this.mIsDowngraded;
    }

    public boolean getIsXCDNDownload() {
        return this.mUseXCDNServer;
    }

    public String getXCDNFailInfo() {
        return this.mXCDNFailInfo;
    }

    private boolean downgrade() {
        if (this.mIsDowngraded) {
            return false;
        }
        if (!SDKVersion.VERSION.equals(this.mLoadableVer)) {
            if (this.mLoadableVer.equals(CyberPlayerCoreInvoker.getCoreVersion()) || !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_STR_UPDATE_CORE_EANBLE_DOWNGRADE, true)) {
                return false;
            }
            this.mLoadableVer = SDKVersion.VERSION;
            this.mIsDowngraded = true;
            return true;
        } else if (!CyberPlayerCoreInvoker.downgrade()) {
            return false;
        } else {
            this.mIsDowngraded = true;
            return true;
        }
    }

    private void preLoadRecord() {
        if (Utils.isMainProcess()) {
            CyberCfgManager.getInstance().setPrefInt(CyberCfgManager.SP_KEY_INSTALL_ERROR_COUNT, CyberCfgManager.getInstance().getPrefInt(CyberCfgManager.SP_KEY_INSTALL_ERROR_COUNT, 0) + 1);
            if (!SDKVersion.VERSION.equals(this.mLoadableVer)) {
                CyberCfgManager.getInstance().setPrefStr("update_type", CYBER_MEDIA_DEX);
                CyberCfgManager.getInstance().setPrefStr("update_version", this.mLoadableVer);
            }
        }
    }

    private void downloadLibs(String str) {
        if (isDownload() && !TextUtils.isEmpty(str)) {
            CyberFileDownloader cyberFileDownloader = new CyberFileDownloader();
            String str2 = this.mDownloadServer;
            this.mDownloadCount++;
            if (this.mUseXCDNServer) {
                CyberLog.d(TAG, "download zip from xCDN");
                str2 = CyberGlobalSetting.DEFAULT_LIBS_XCDN_DOWNLOAD_SERVER_URL;
            } else {
                CyberLog.d(TAG, "download zip from CDN");
            }
            if (str.startsWith("model_")) {
                cyberFileDownloader.downloadFile(str2, str, this.mCyberMediaFolder, this);
            } else {
                cyberFileDownloader.downloadFile(str2, str, this.mLibsFolder, this);
            }
        }
    }

    private synchronized String getCfg(String str, String str2) {
        return getPrefs().getString(str, str2);
    }

    private synchronized int getCfgIntValue(String str, int i) {
        String string = getPrefs().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    private void notiyLoadError(int i, String str) {
        if (downgrade()) {
            tryLoadCore();
            return;
        }
        CyberPlayerManager.InstallListener2 installListener2 = this.mListener;
        if (installListener2 != null) {
            installListener2.onInstallError(this.mReqInstallType, i, str);
        }
        if (i != -4 && Utils.isMainProcess()) {
            CyberCfgManager.getInstance().setPrefInt(CyberCfgManager.SP_KEY_INSTALL_ERROR_COUNT, 0);
        }
    }

    private synchronized void setCfg(String str, String str2) {
        SharedPreferences.Editor edit = getPrefs().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private boolean isDownload() {
        if (!CyberGlobalSetting.getInstance().isDownloadLibsEnable()) {
            CyberLog.d(TAG, "cancel download isSFSwitchEnabled");
            notiyLoadError(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        int cfgIntValue = getCfgIntValue(KEY_SUCCESS_DOWNLOAD_CORE_COUNT, 0);
        this.mSuccessDownloadCount = cfgIntValue;
        if (cfgIntValue >= 36) {
            CyberLog.w(TAG, "Achieve max success download time:36");
            notiyLoadError(-1, "Achieve max success download time");
            return false;
        } else if (Utils.getInternalStorageSpace() < 20971520) {
            notiyLoadError(-1, "storagespace not enough " + Utils.getInternalStorageSpace());
            return false;
        } else {
            return true;
        }
    }

    private void notiyLoadProgress(int i) {
        CyberPlayerManager.InstallListener2 installListener2 = this.mListener;
        if (installListener2 != null) {
            installListener2.onInstallProgress(this.mReqInstallType, i);
        }
    }

    public long getInstallTime(int i) {
        if (i == 0) {
            return this.mLoadCoreTime;
        }
        if (i == 1) {
            return this.mLoadLibsTime;
        }
        if (i == 2) {
            return this.mInitCfgTime;
        }
        return -1L;
    }

    private String parseUpgradeCoreInfo() {
        UpgradeInfo parse = UpgradeInfo.parse(CYBER_MEDIA_DEX);
        String str = SDKVersion.VERSION;
        if (parse != null && TextUtils.equals(parse.mLocalVersion, SDKVersion.VERSION)) {
            String str2 = "cyber-media-dex_" + parse.mUpgradeVersion + ".jar";
            File file = new File(this.mLibsFolder, str2);
            CyberLog.d(TAG, "mLibsFolder:" + this.mLibsFolder + str2);
            if (!file.exists() && !parse.mForceUpgrade) {
                if (Utils.isMainProcess()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Utils.getLoadLibsABI());
                    sb.append("_cyber-media-dex_");
                    sb.append(parse.mUpgradeVersion);
                    if (!TextUtils.isEmpty(parse.mExtInfo)) {
                        sb.append("_");
                        sb.append(parse.mExtInfo);
                    }
                    sb.append(".zip");
                    HashMap hashMap = new HashMap();
                    hashMap.put("saveDirectory", this.mLibsFolder);
                    UpgradeTaskManager.getInstance().submitTask(new UpgradeTask(sb.toString(), hashMap));
                } else {
                    CyberLog.d(TAG, "just download in main process");
                }
            } else {
                str = parse.mUpgradeVersion;
            }
        }
        String cfgValue = CyberCfgManager.getInstance().getCfgValue(CyberCfgManager.KEY_STR_CORE_EXTERNAL_PATH, "");
        if (!TextUtils.isEmpty(cfgValue) && new File(cfgValue).exists()) {
            String unzipCyberFile = CyberFileUtils.unzipCyberFile(cfgValue, Utils.getCyberMediaPath());
            if (!TextUtils.isEmpty(unzipCyberFile)) {
                CyberLog.d(TAG, "load from local:" + str);
                return unzipCyberFile;
            }
            return str;
        }
        return str;
    }

    private void tryLoadCore() {
        long currentTimeMillis = System.currentTimeMillis();
        CyberLog.d(TAG, "tryLoadCore:" + this.mReqInstallType);
        if (CyberPlayerCoreInvoker.isLoaded(this.mReqInstallType)) {
            return;
        }
        if (!CyberPlayerCoreInvoker.isCoreDexLoaded()) {
            this.mLoadableVer = parseUpgradeCoreInfo();
            preLoadRecord();
            File file = new File(this.mLibsFolder, "cyber-media-dex_" + this.mLoadableVer + ".jar");
            if (file.exists()) {
                CyberLog.d(TAG, "try load from extend:" + file.getAbsolutePath());
                sClassLoader = CyberClassLoader.createClassLoader(file.getAbsolutePath(), new File(this.mLibsFolder), null, this.mContext.getClassLoader());
            } else if (this.mLoadableVer.equals(SDKVersion.VERSION)) {
                sClassLoader = this.mContext.getClassLoader();
            } else {
                downloadLibs(Utils.getLoadLibsABI() + "_cyber-media-dex_" + this.mLoadableVer + ".zip");
                return;
            }
            try {
                CyberPlayerCoreInvoker.init(this.mContext, sClassLoader, this.mCyberMediaFolder, this.mListener);
                this.mLoadCoreTime = System.currentTimeMillis() - currentTimeMillis;
            } catch (Exception unused) {
                sClassLoader = null;
                downloadLibs(Utils.getLoadLibsABI() + "_cyber-media-dex_" + this.mLoadableVer + ".zip");
                return;
            }
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (CyberPlayerCoreInvoker.loadLibs(this.mReqInstallType, this.mOpts)) {
                this.mLoadLibsTime = System.currentTimeMillis() - currentTimeMillis2;
                notiyLoadSuccess();
                CyberLog.d(TAG, "load success curVer:" + CyberPlayerCoreInvoker.getCoreVersion() + " installType:" + this.mReqInstallType);
            }
        } catch (FileNotFoundException e) {
            CyberLog.d(TAG, "FileNotFoundException:" + e.getMessage());
            downloadLibs(e.getMessage());
        } catch (Error e2) {
            CyberLog.w(TAG, "loadLibs Error:" + e2.getMessage());
        } catch (Exception e3) {
            CyberLog.w(TAG, "loadLibs Exception:" + e3.getMessage());
            notiyLoadError(-4, e3.getMessage());
        }
    }

    public synchronized void install(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener2 installListener2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mReqInstallType = i;
        this.mOpts = map;
        if (!isCpuSupport()) {
            if (installListener2 != null) {
                notiyLoadError(-5, "cpu not support:" + Utils.getCpuType());
            }
            return;
        }
        CyberCfgManager.getInstance().init();
        CyberLog.d(TAG, "InstallTask:" + i + " start");
        this.mInitCfgTime = System.currentTimeMillis() - currentTimeMillis;
        CyberLog.setYalogLevel(CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_YALOG_LEVEL, 6));
        this.mDownloadServer = CyberGlobalSetting.getInstance().getLibsDownloadServerUrl(str);
        this.mUseXCDNServer = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DOWNLOAD_ZIP_XCDN, true);
        this.mListener = installListener2;
        this.mContext = CyberPlayerManager.getApplicationContext();
        String formatNowDate = Utils.formatNowDate();
        if (!formatNowDate.equals(getCfg(KEY_SUCCESS_DOWNLOAD_CORE_TIME, null))) {
            setCfg(KEY_SUCCESS_DOWNLOAD_CORE_COUNT, Integer.toString(0));
            setCfg(KEY_SUCCESS_DOWNLOAD_CORE_TIME, formatNowDate);
        }
        this.mCyberMediaFolder = Utils.getCyberMediaPath();
        this.mLibsFolder = this.mCyberMediaFolder + File.separator + "libs";
        tryLoadCore();
        CyberLog.d(TAG, "InstallTask:" + i + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.CyberFileDownloader.ICyberFileDownloadListener
    public void onDownloadFail(String str, long j, int i, String str2) {
        CyberLog.d(TAG, "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            int i2 = this.mSuccessDownloadCount + 1;
            this.mSuccessDownloadCount = i2;
            setCfg(KEY_SUCCESS_DOWNLOAD_CORE_COUNT, Integer.toString(i2));
        } else if (this.mUseXCDNServer) {
            this.mUseXCDNServer = false;
            CyberLog.w(TAG, "xCDN degrade to CDN");
            this.mXCDNFailInfo = str2;
            try {
                String path = new URL(str).getPath();
                downloadLibs(path.substring(path.lastIndexOf(47) + 1));
                return;
            } catch (Exception e) {
                CyberLog.e(TAG, e.toString());
            }
        }
        notiyLoadError(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.CyberFileDownloader.ICyberFileDownloadListener
    public void onDownloadSuccess(String str, long j, ArrayList<String> arrayList) {
        this.mUnzipFileList = arrayList;
        int i = this.mSuccessDownloadCount + 1;
        this.mSuccessDownloadCount = i;
        setCfg(KEY_SUCCESS_DOWNLOAD_CORE_COUNT, Integer.toString(i));
        CyberLog.d(TAG, "onDownloadSuccess:" + this.mUnzipFileList);
        tryLoadCore();
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.CyberFileDownloader.ICyberFileDownloadListener
    public void onDownloading(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.mLastProgressUpdateTime > 500) {
            int i = (int) ((((float) j) / ((float) j2)) * 99.0f);
            notiyLoadProgress(i);
            this.mLastProgressUpdateTime = valueOf.longValue();
            CyberLog.d(TAG, "onDownloading:" + i + "%");
        }
    }
}
