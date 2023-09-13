package com.baidu.cyberplayer.sdk.videodownload;

import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.remote.CyberDownloadItem;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
@Keep
/* loaded from: classes3.dex */
public class CyberDownloader {
    public static final int DOWNLOAD_EVENT_COMPLETE = 3;
    public static final int DOWNLOAD_EVENT_ERROR = 4;
    public static final int DOWNLOAD_EVENT_PROGRESS = 1;
    public static final int DOWNLOAD_EVENT_STATUE_CHANGED = 2;
    public static final int OPERATE_FORBID = -35102;
    public static final String TAG = "CyberDownloader";
    public String mDir;
    public DownloaderProvider mDownloaderProvider;
    public DownloaderListener mListener;
    public PrefetchOptions mOptions;
    public boolean mRemote;
    public int mType;

    @Keep
    /* loaded from: classes3.dex */
    public interface DownloaderListener {
        boolean onTransfer(String str, int i, int i2, Object obj);
    }

    public CyberDownloader(int i, String str, PrefetchOptions prefetchOptions) {
        this(i, str, prefetchOptions, true);
        CyberLog.i(TAG, "CyberDownloader mDownloaderProvider = " + this.mDownloaderProvider);
    }

    public CyberDownloader(int i, String str, PrefetchOptions prefetchOptions, boolean z) {
        this.mListener = null;
        CyberLog.i(TAG, "CyberDownloader remote = " + z);
        this.mType = i;
        this.mDir = str;
        this.mRemote = z;
        this.mOptions = prefetchOptions;
        if (getDownloader() == null) {
            CyberLog.w(TAG, "construct on uninstalled");
        }
    }

    private synchronized DownloaderProvider getDownloader() {
        if (this.mDownloaderProvider == null) {
            this.mDownloaderProvider = DownloaderProviderFactor.getInstance().create(this.mType, this.mDir, this.mOptions, this.mRemote);
            setListener(this.mListener);
        }
        return this.mDownloaderProvider;
    }

    public void cancelAllTasks() {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.cancelAllTasks();
            CyberLog.i(TAG, "cancelAllTasks");
            return;
        }
        CyberLog.w(TAG, "cancelAllTasks on uninstalled");
    }

    public void clearAllCaches() {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.clearAllCaches();
            CyberLog.i(TAG, "clearAllCaches");
            return;
        }
        CyberLog.w(TAG, "clearAllCaches on uninstalled");
    }

    public long getAllCacheSize() {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            return downloader.getAllCacheSize();
        }
        return -1L;
    }

    public void pauseAllTasks() {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.pauseAllTasks();
            CyberLog.i(TAG, "pauseAllTasks");
            return;
        }
        CyberLog.w(TAG, "pauseAllTasks on uninstalled");
    }

    public void release() {
        DownloaderProvider downloaderProvider = this.mDownloaderProvider;
        if (downloaderProvider != null) {
            downloaderProvider.release();
        }
        this.mDownloaderProvider = null;
        this.mListener = null;
    }

    public void resumeAllTasks() {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.resumeAllTasks();
            CyberLog.i(TAG, "resumeAllTasks");
            return;
        }
        CyberLog.w(TAG, "resumeAllTasks on uninstalled");
    }

    public void addTask(CyberDownloadItem cyberDownloadItem) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.addTask(cyberDownloadItem);
            CyberLog.i(TAG, "addTask item = " + cyberDownloadItem);
            return;
        }
        CyberLog.w(TAG, "addTask item on uninstalled");
        DownloaderListener downloaderListener = this.mListener;
        if (downloaderListener != null) {
            downloaderListener.onTransfer(cyberDownloadItem.getUrl(), 4, OPERATE_FORBID, null);
        }
    }

    public void cancelTask(String str) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.cancelTask(str);
            CyberLog.i(TAG, "cancelTask");
            return;
        }
        CyberLog.w(TAG, "cancelTask on uninstalled");
    }

    public void clearCacheFile(String str) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.clearCacheFile(str);
            CyberLog.i(TAG, "clearCacheFile");
            return;
        }
        CyberLog.w(TAG, "clearCacheFile on uninstalled");
    }

    public Bundle getDownloadInfo(String str) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            return downloader.getDownloadInfo(str);
        }
        return null;
    }

    public void pauseTask(String str) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.pauseTask(str);
            CyberLog.i(TAG, "pauseTask");
            return;
        }
        CyberLog.w(TAG, "pauseTask on uninstalled");
    }

    public void resumeTask(String str) {
        DownloaderProvider downloader = getDownloader();
        if (downloader != null) {
            downloader.resumeTask(str);
            CyberLog.i(TAG, "resumeTask");
            return;
        }
        CyberLog.w(TAG, "resumeTask on uninstalled");
    }

    public void setListener(DownloaderListener downloaderListener) {
        DownloaderListener downloaderListener2;
        this.mListener = downloaderListener;
        CyberLog.i(TAG, "setListener:" + downloaderListener);
        DownloaderProvider downloaderProvider = this.mDownloaderProvider;
        if (downloaderProvider != null && (downloaderListener2 = this.mListener) != null) {
            downloaderProvider.setListener(downloaderListener2);
        }
    }
}
