package com.baidu.minivideo.plugin.capture.download;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery;
import com.baidu.minivideo.plugin.capture.download.base.Downloader;
import com.baidu.minivideo.plugin.capture.download.core.DownloadResponseImpl;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.minivideo.plugin.capture.download.core.DownloaderImpl;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class DownloadManager implements Downloader.OnDownloaderDestroyedListener {
    public static final String TAG = "DownloadManager";
    public static DownloadManager sDownloadManager;
    public DownloadConfig mConfig;
    public DownloadStatusDelivery mDelivery;
    public ExecutorService mExecutorService;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public Map<String, Downloader> mDownloaderMap = new LinkedHashMap();

    public DownloadManager() {
        init(new DownloadConfig());
    }

    private String createKey(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new IllegalArgumentException("Tag can't be null!");
    }

    public static DownloadManager getInstance() {
        if (sDownloadManager == null) {
            synchronized (DownloadManager.class) {
                if (sDownloadManager == null) {
                    sDownloadManager = new DownloadManager();
                }
            }
        }
        return sDownloadManager;
    }

    private void init(@NonNull DownloadConfig downloadConfig) {
        if (downloadConfig.getThreadNum() <= downloadConfig.getMaxThreadNum()) {
            this.mConfig = downloadConfig;
            this.mExecutorService = Executors.newFixedThreadPool(downloadConfig.getMaxThreadNum());
            this.mDelivery = new DownloadStatusDeliveryImpl(this.mHandler);
            return;
        }
        throw new IllegalArgumentException("thread num must < max thread num");
    }

    private boolean isDownloadRequestRunning(String str) {
        Downloader downloader;
        if (!this.mDownloaderMap.containsKey(str) || (downloader = this.mDownloaderMap.get(str)) == null) {
            return false;
        }
        if (downloader.isRunning()) {
            LogUtils.w("DownloadInfo has been started!");
            return true;
        }
        throw new IllegalStateException("Downloader instance with same tag has not been destroyed!");
    }

    public void cancel(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            Downloader downloader = this.mDownloaderMap.get(createKey);
            if (downloader != null) {
                downloader.cancel();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void cancelAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.3
            @Override // java.lang.Runnable
            public void run() {
                for (Downloader downloader : DownloadManager.this.mDownloaderMap.values()) {
                    if (downloader != null && downloader.isRunning()) {
                        downloader.cancel();
                    }
                }
            }
        });
    }

    public void delete(String str) {
    }

    public void download(DownloadRequest downloadRequest, String str, DownloadCallback downloadCallback) {
        String createKey = createKey(str);
        if (isDownloadRequestRunning(createKey)) {
            return;
        }
        DownloaderImpl downloaderImpl = new DownloaderImpl(downloadRequest, new DownloadResponseImpl(this.mDelivery, downloadCallback), this.mExecutorService, createKey, this.mConfig, this);
        this.mDownloaderMap.put(createKey, downloaderImpl);
        downloaderImpl.start();
    }

    public boolean isRunning(String str) {
        Downloader downloader;
        String createKey = createKey(str);
        if (!this.mDownloaderMap.containsKey(createKey) || (downloader = this.mDownloaderMap.get(createKey)) == null) {
            return false;
        }
        return downloader.isRunning();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader.OnDownloaderDestroyedListener
    public void onDestroyed(final String str, Downloader downloader) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadManager.this.mDownloaderMap.containsKey(str)) {
                    DownloadManager.this.mDownloaderMap.remove(str);
                }
            }
        });
    }

    public void pause(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            Downloader downloader = this.mDownloaderMap.get(createKey);
            if (downloader != null && downloader.isRunning()) {
                downloader.pause();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void pauseAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                for (Downloader downloader : DownloadManager.this.mDownloaderMap.values()) {
                    if (downloader != null && downloader.isRunning()) {
                        downloader.pause();
                    }
                }
            }
        });
    }

    public void download(String str, String str2, String str3, DownloadCallback downloadCallback) {
        download(new DownloadRequest.Builder().setUri(str).setFolder(new File(str2)).setName(str3).build(), str, downloadCallback);
    }
}
