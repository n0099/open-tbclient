package com.baidu.cyberplayer.sdk.videodownload;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberRuntimeInfo;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.CyberDownloadItem;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.videodownload.CyberDownloader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class DuMediaPreloader implements IDuMediaDownload, CyberDownloader.DownloaderListener {
    public static final int OPERATE_ADD_REPEATE = -35100;
    public static final String TAG = "DuMediaPreloader";
    public String mCacheDir;
    public CyberDownloader mDownloader;
    public final Map<String, DuMediaDownloadItem> mItems = new ConcurrentHashMap();
    public final Object mLock = new Object();
    public PrefetchOptions mOptions;
    public String mWorkDir;

    private boolean isDownloadEnd(int i, int i2) {
        if (i == 4 || i == 3) {
            return true;
        }
        if (i == 2) {
            return i2 == 5 || i2 == 6 || i2 == 7;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public PrefetchOptions mOptions;
        public String mWorkDir;

        public DuMediaPreloader build() {
            return new DuMediaPreloader(this);
        }

        public Builder setWorkDir(String str) {
            this.mWorkDir = str;
            return this;
        }

        public Builder setGobalOption(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (this.mOptions == null) {
                    this.mOptions = new PrefetchOptions();
                }
                this.mOptions.setOption(str, str2);
            }
            return this;
        }
    }

    public DuMediaPreloader(Builder builder) {
        this.mDownloader = null;
        if (builder != null) {
            boolean cfgBoolValueFast = CyberCfgManager.getInstance().getCfgBoolValueFast("preloader_use_remote", true);
            this.mWorkDir = builder.mWorkDir;
            this.mOptions = builder.mOptions;
            if (CyberCfgManager.getInstance().getCfgBoolValueFast("enable_preloader", false)) {
                synchronized (this.mLock) {
                    CyberDownloader cyberDownloader = new CyberDownloader(3, this.mWorkDir, this.mOptions, cfgBoolValueFast);
                    this.mDownloader = cyberDownloader;
                    cyberDownloader.setListener(this);
                }
                CyberLog.i(TAG, "DuMediaPreloader mDownloader = " + this.mDownloader);
                return;
            }
            CyberLog.w(TAG, "disable preloader");
            return;
        }
        CyberLog.e(TAG, "builder is null");
    }

    private DownloadItemCallBackInfo buildCallbackInfo(String str, int i, int i2, Object obj) {
        DownloadItemCallBackInfo downloadItemCallBackInfo = new DownloadItemCallBackInfo(eventMapping(i));
        switch (downloadItemCallBackInfo.getEvent()) {
            case 100:
                downloadItemCallBackInfo.url = str;
                downloadItemCallBackInfo.percent = i2;
                CyberLog.i(TAG, "KEY_IS_DOWNLOAD_EVENT_PROGRESS = " + downloadItemCallBackInfo.percent);
                break;
            case 101:
                downloadItemCallBackInfo.url = str;
                downloadItemCallBackInfo.status = i2;
                if (obj != null && (obj instanceof Bundle)) {
                    downloadItemCallBackInfo.bean = bundleToDuMediaDownloadBean((Bundle) obj);
                }
                CyberLog.i(TAG, "KEY_IS_DOWNLOAD_EVENT_STATUE_CHANGED = " + downloadItemCallBackInfo.status);
                break;
            case 102:
                downloadItemCallBackInfo.url = str;
                CyberLog.i(TAG, "KEY_IS_DOWNLOAD_EVENT_COMPLETE");
                break;
            case 103:
                downloadItemCallBackInfo.url = str;
                downloadItemCallBackInfo.errorCode = i2;
                if (obj != null && (obj instanceof Bundle)) {
                    downloadItemCallBackInfo.bean = bundleToDuMediaDownloadBean((Bundle) obj);
                } else if (obj != null && (obj instanceof String)) {
                    downloadItemCallBackInfo.errorDetail = (String) obj;
                }
                CyberLog.e(TAG, "KEY_IS_DOWNLOAD_EVENT_ERROR = " + downloadItemCallBackInfo.errorCode);
                break;
        }
        return downloadItemCallBackInfo;
    }

    public static DuMediaDownloadBean bundleToDuMediaDownloadBean(Bundle bundle) {
        if (bundle != null) {
            DuMediaDownloadBean duMediaDownloadBean = new DuMediaDownloadBean();
            CyberLog.i(TAG, "bundleToDuMediaDownloadBean bundle=" + bundle.toString());
            duMediaDownloadBean.url = bundle.getString("key_url");
            duMediaDownloadBean.taskId = bundle.getString("key_url");
            duMediaDownloadBean.extraJsonStr = bundle.getString("extra");
            duMediaDownloadBean.mimeType = bundle.getString("mime_type");
            duMediaDownloadBean.status = bundle.getInt("status");
            duMediaDownloadBean.playUrl = bundle.getString("play_url");
            duMediaDownloadBean.md5 = bundle.getString("md5");
            duMediaDownloadBean.progress = bundle.getInt("progress");
            duMediaDownloadBean.totalBytes = bundle.getLong("video_size");
            duMediaDownloadBean.receivedBytes = bundle.getLong("downloaded_size");
            duMediaDownloadBean.speed = bundle.getInt(CyberRuntimeInfo.DP_RUNTIME_DOWNLOAD_SPEED);
            duMediaDownloadBean.createTimestamp = String.valueOf(bundle.getLong("create_timestamp"));
            duMediaDownloadBean.errorMessage = bundle.getString("error_detail");
            CyberLog.i(TAG, "bundleToDuMediaDownloadBean bean=" + duMediaDownloadBean.toString());
            return duMediaDownloadBean;
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public void addTask(DuMediaDownloadItem duMediaDownloadItem) {
        if (duMediaDownloadItem != null && duMediaDownloadItem.getUrl() != null) {
            if (this.mItems.containsKey(duMediaDownloadItem.getUrl())) {
                CyberLog.e(TAG, "same task added " + duMediaDownloadItem.getUrl());
                IDuMediaDownloadItemListener callBackListener = duMediaDownloadItem.getCallBackListener();
                if (callBackListener != null) {
                    callBackListener.downloadItemInfo(buildCallbackInfo(duMediaDownloadItem.getUrl(), 4, OPERATE_ADD_REPEATE, null));
                    return;
                }
                return;
            }
            synchronized (this.mLock) {
                CyberLog.i(TAG, "addTask key = " + duMediaDownloadItem.getUrl() + ", listener = " + duMediaDownloadItem.getCallBackListener());
                if (this.mDownloader != null) {
                    this.mDownloader.addTask(new CyberDownloadItem(duMediaDownloadItem.getUrl(), duMediaDownloadItem.getSize(), duMediaDownloadItem.getOffset(), duMediaDownloadItem.getHeaders(), duMediaDownloadItem.getOptions(), duMediaDownloadItem.getExtra()));
                    this.mItems.put(duMediaDownloadItem.getUrl(), duMediaDownloadItem);
                }
            }
            return;
        }
        CyberLog.e(TAG, "item or url is null");
    }

    public static int eventMapping(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        CyberLog.e(TAG, "Undefine Event =  " + i);
                        return 0;
                    }
                    return 103;
                }
                return 102;
            }
            return 101;
        }
        return 100;
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public void cancelTask(String str) {
        if (str == null) {
            CyberLog.e(TAG, "key is null");
            return;
        }
        synchronized (this.mLock) {
            CyberLog.i(TAG, "cancelTask key = " + str);
            if (this.mDownloader != null) {
                this.mDownloader.cancelTask(str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public void clearCacheFile(String str) {
        if (str == null) {
            CyberLog.e(TAG, "key is null");
            return;
        }
        synchronized (this.mLock) {
            if (this.mDownloader != null) {
                this.mDownloader.clearCacheFile(str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public void pauseTask(String str) {
        if (str == null) {
            CyberLog.e(TAG, "key is null");
            return;
        }
        synchronized (this.mLock) {
            CyberLog.i(TAG, "pauseTask key = " + str);
            if (this.mDownloader != null) {
                this.mDownloader.pauseTask(str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public void resumeTask(String str) {
        if (str == null) {
            CyberLog.e(TAG, "key is null");
            return;
        }
        synchronized (this.mLock) {
            CyberLog.i(TAG, "resumeTask key = " + str);
            if (this.mDownloader != null) {
                this.mDownloader.resumeTask(str);
            }
        }
    }

    public static boolean isSupportAndReady() {
        boolean z = false;
        boolean cfgBoolValueFast = CyberCfgManager.getInstance().getCfgBoolValueFast("enable_preloader", false) & CyberPlayerManager.isCoreLoaded();
        if (!CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_REMOTE_FORBIDDEN, false)) {
            if (RemotePlayerFactory.getInstance().getBinderState() == 1) {
                z = true;
            }
            cfgBoolValueFast &= z;
        }
        CyberLog.i(TAG, "isSupport = " + cfgBoolValueFast);
        return cfgBoolValueFast;
    }

    public void cancelAllTasks() {
        synchronized (this.mLock) {
            CyberLog.i(TAG, "cancelAllTasks");
            if (this.mDownloader != null) {
                this.mDownloader.cancelAllTasks();
            }
        }
    }

    public void clearAllCaches() {
        synchronized (this.mLock) {
            CyberLog.i(TAG, "clearAllCaches");
            if (this.mDownloader != null) {
                this.mDownloader.clearAllCaches();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.IDuMediaDownload
    public long getAllCacheSize() {
        long j;
        synchronized (this.mLock) {
            CyberLog.i(TAG, "getAllCacheSize");
            if (this.mDownloader != null) {
                j = this.mDownloader.getAllCacheSize();
            } else {
                j = 0;
            }
        }
        return j;
    }

    public int getTaskNums() {
        int size = this.mItems.size();
        CyberLog.i(TAG, "getTaskNums = " + size);
        return size;
    }

    public void pauseAllTasks() {
        synchronized (this.mLock) {
            CyberLog.i(TAG, "pauseAllTasks");
            if (this.mDownloader != null) {
                this.mDownloader.pauseAllTasks();
            }
        }
    }

    public void release() {
        synchronized (this.mLock) {
            if (this.mDownloader != null) {
                this.mDownloader.release();
                this.mDownloader = null;
            }
        }
        this.mWorkDir = null;
        this.mItems.clear();
    }

    public void resumeAllTasks() {
        synchronized (this.mLock) {
            CyberLog.i(TAG, "resumeAllTasks");
            if (this.mDownloader != null) {
                this.mDownloader.resumeAllTasks();
            }
        }
    }

    public DuMediaDownloadBean getDownloadInfo(String str) {
        Bundle downloadInfo;
        DuMediaDownloadBean duMediaDownloadBean = null;
        if (str == null) {
            CyberLog.e(TAG, "key is null");
            return null;
        }
        synchronized (this.mLock) {
            CyberLog.i(TAG, "getDownloadInfo key = " + str);
            if (this.mDownloader != null && (downloadInfo = this.mDownloader.getDownloadInfo(str)) != null) {
                duMediaDownloadBean = bundleToDuMediaDownloadBean(downloadInfo);
            }
        }
        return duMediaDownloadBean;
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.CyberDownloader.DownloaderListener
    public boolean onTransfer(String str, int i, int i2, Object obj) {
        CyberLog.i(TAG, "onTransfer key = " + str + ", what = " + i + ", extra = " + i2);
        if (str != null && this.mItems.containsKey(str)) {
            IDuMediaDownloadItemListener callBackListener = this.mItems.get(str).getCallBackListener();
            CyberLog.i(TAG, "onTransfer key = " + str + ", find listener = " + callBackListener);
            if (callBackListener != null) {
                callBackListener.downloadItemInfo(buildCallbackInfo(str, i, i2, obj));
            } else {
                CyberLog.i(TAG, "onTransfer listener null key = " + str + ", what = " + i);
            }
            if (isDownloadEnd(i, i2)) {
                this.mItems.remove(str);
                return true;
            }
            return true;
        } else if (i == 4 && i2 == -30001) {
            synchronized (this.mLock) {
                this.mDownloader = null;
                CyberDownloader cyberDownloader = new CyberDownloader(3, this.mWorkDir, this.mOptions);
                this.mDownloader = cyberDownloader;
                cyberDownloader.setListener(this);
            }
            for (String str2 : this.mItems.keySet()) {
                DuMediaDownloadItem duMediaDownloadItem = this.mItems.get(str2);
                IDuMediaDownloadItemListener callBackListener2 = duMediaDownloadItem.getCallBackListener();
                DownloadItemCallBackInfo buildCallbackInfo = buildCallbackInfo(str, i, i2, obj);
                if (callBackListener2 != null) {
                    buildCallbackInfo.url = duMediaDownloadItem.getUrl();
                    callBackListener2.downloadItemInfo(buildCallbackInfo);
                }
            }
            this.mItems.clear();
            return true;
        } else {
            CyberLog.i(TAG, "onTransfer not find key = " + str + ", what = " + i);
            return true;
        }
    }
}
