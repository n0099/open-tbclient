package com.baidu.minivideo.plugin.capture.download;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
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
/* loaded from: classes11.dex */
public class DownloadManager implements Downloader.OnDownloaderDestroyedListener {
    public static final String TAG = "DownloadManager";
    private static DownloadManager sDownloadManager;
    private DownloadConfig mConfig;
    private DownloadStatusDelivery mDelivery;
    private ExecutorService mExecutorService;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Map<String, Downloader> mDownloaderMap = new LinkedHashMap();

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

    private DownloadManager() {
        init(new DownloadConfig());
    }

    private void init(@NonNull DownloadConfig downloadConfig) {
        if (downloadConfig.getThreadNum() > downloadConfig.getMaxThreadNum()) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.mConfig = downloadConfig;
        this.mExecutorService = Executors.newFixedThreadPool(this.mConfig.getMaxThreadNum());
        this.mDelivery = new DownloadStatusDeliveryImpl(this.mHandler);
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

    public void download(DownloadRequest downloadRequest, String str, DownloadCallback downloadCallback) {
        String createKey = createKey(str);
        if (!isDownloadRequestRunning(createKey)) {
            DownloaderImpl downloaderImpl = new DownloaderImpl(downloadRequest, new DownloadResponseImpl(this.mDelivery, downloadCallback), this.mExecutorService, createKey, this.mConfig, this);
            this.mDownloaderMap.put(createKey, downloaderImpl);
            downloaderImpl.start();
        }
    }

    public void download(String str, String str2, String str3, DownloadCallback downloadCallback) {
        download(new DownloadRequest.Builder().setUri(str).setFolder(new File(str2)).setName(str3).build(), str, downloadCallback);
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

    public boolean isRunning(String str) {
        Downloader downloader;
        String createKey = createKey(str);
        if (!this.mDownloaderMap.containsKey(createKey) || (downloader = this.mDownloaderMap.get(createKey)) == null) {
            return false;
        }
        return downloader.isRunning();
    }

    private boolean isDownloadRequestRunning(String str) {
        Downloader downloader;
        if (this.mDownloaderMap.containsKey(str) && (downloader = this.mDownloaderMap.get(str)) != null) {
            if (downloader.isRunning()) {
                LogUtils.w("DownloadInfo has been started!");
                return true;
            }
            throw new IllegalStateException("Downloader instance with same tag has not been destroyed!");
        }
        return false;
    }

    private String createKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return String.valueOf(str.hashCode());
    }
}
