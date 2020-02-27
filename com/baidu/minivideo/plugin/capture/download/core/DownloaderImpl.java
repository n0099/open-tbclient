package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.minivideo.plugin.capture.download.DownloadConfig;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadResponse;
import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidu.minivideo.plugin.capture.download.base.Downloader;
import com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes13.dex */
public class DownloaderImpl implements DownloadTask.OnDownloadListener, Downloader, HttpConnectTask.OnConnectListener {
    private DownloadConfig mConfig;
    private HttpConnectTask mConnectTask;
    private DownloadInfo mDownloadInfo;
    private List<DownloadTask> mDownloadTasks;
    private Executor mExecutor;
    private Downloader.OnDownloaderDestroyedListener mListener;
    private DownloadRequest mRequest;
    private DownloadResponse mResponse;
    private int mStatus;
    private String mTag;

    public DownloaderImpl(DownloadRequest downloadRequest, DownloadResponse downloadResponse, Executor executor, String str, DownloadConfig downloadConfig, Downloader.OnDownloaderDestroyedListener onDownloaderDestroyedListener) {
        this.mRequest = downloadRequest;
        this.mResponse = downloadResponse;
        this.mExecutor = executor;
        this.mTag = str;
        this.mConfig = downloadConfig;
        this.mListener = onDownloaderDestroyedListener;
        init();
    }

    private void init() {
        this.mDownloadInfo = new DownloadInfo(this.mRequest.getName().toString(), this.mRequest.getUri(), this.mRequest.getFolder());
        this.mDownloadTasks = new LinkedList();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public boolean isRunning() {
        return this.mStatus == 101 || this.mStatus == 102 || this.mStatus == 103 || this.mStatus == 104;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void start() {
        this.mStatus = 101;
        this.mResponse.onStarted();
        startConnect();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void pause() {
        if (this.mConnectTask != null) {
            this.mConnectTask.pause();
        }
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            downloadTask.pause();
        }
        if (this.mStatus != 104) {
            onDownloadPaused();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void cancel() {
        if (this.mConnectTask != null) {
            this.mConnectTask.cancel();
        }
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            downloadTask.cancel();
        }
        if (this.mStatus != 104) {
            onDownloadCanceled();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void onDestroy() {
        this.mListener.onDestroyed(this.mTag, this);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnecting() {
        this.mStatus = 102;
        this.mResponse.onConnecting();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnected(long j, long j2, boolean z) {
        if (this.mConnectTask.isCanceled()) {
            onConnectCanceled();
            return;
        }
        this.mStatus = 103;
        this.mResponse.onConnected(j, j2, z);
        this.mDownloadInfo.setAcceptRanges(z);
        this.mDownloadInfo.setLength(j2);
        download(j2, z);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectPaused() {
        onDownloadPaused();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectCanceled() {
        deleteFile();
        this.mStatus = 107;
        this.mResponse.onConnectCanceled();
        onDestroy();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectFailed(DownloadException downloadException) {
        if (this.mConnectTask.isCanceled()) {
            onConnectCanceled();
        } else if (this.mConnectTask.isPaused()) {
            onDownloadPaused();
        } else {
            this.mStatus = 108;
            this.mResponse.onConnectFailed(downloadException);
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadProgress(long j, long j2) {
        this.mResponse.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadCompleted(String str) {
        if (isAllComplete()) {
            this.mStatus = 105;
            this.mResponse.onDownloadCompleted(str);
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadPaused() {
        if (isAllPaused()) {
            this.mStatus = 106;
            this.mResponse.onDownloadPaused();
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadCanceled() {
        if (isAllCanceled()) {
            deleteFile();
            this.mStatus = 107;
            this.mResponse.onDownloadCanceled();
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadFailed(DownloadException downloadException) {
        if (isAllFailed()) {
            this.mStatus = 108;
            this.mResponse.onDownloadFailed(downloadException);
            onDestroy();
        }
    }

    private void startConnect() {
        this.mConnectTask = new HttpConnectTaskImpl(this.mRequest.getUri(), this);
        this.mExecutor.execute(this.mConnectTask);
    }

    private void download(long j, boolean z) {
        this.mStatus = 104;
        initDownloadTasks(j, z);
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            this.mExecutor.execute(downloadTask);
        }
    }

    private void initDownloadTasks(long j, boolean z) {
        int i;
        this.mDownloadTasks.clear();
        if (z) {
            List<ThreadRecord> multiThreadRecords = getMultiThreadRecords(j);
            int i2 = 0;
            Iterator<ThreadRecord> it = multiThreadRecords.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = (int) (it.next().getFinished() + i);
            }
            this.mDownloadInfo.setFinished(i);
            for (ThreadRecord threadRecord : multiThreadRecords) {
                this.mDownloadTasks.add(new MultiDownloadTask(this.mDownloadInfo, threadRecord, this));
            }
            return;
        }
        this.mDownloadTasks.add(new SingleDownloadTask(this.mDownloadInfo, getSingleThreadInfo(), this));
    }

    private List<ThreadRecord> getMultiThreadRecords(long j) {
        ArrayList arrayList = new ArrayList();
        int threadNum = this.mConfig.getThreadNum();
        int i = 0;
        while (i < threadNum) {
            long j2 = j / threadNum;
            long j3 = i * j2;
            arrayList.add(new ThreadRecord(i, this.mTag, this.mRequest.getUri(), j3, i == threadNum + (-1) ? j : (j2 + j3) - 1, 0L));
            i++;
        }
        return arrayList;
    }

    private ThreadRecord getSingleThreadInfo() {
        return new ThreadRecord(0, this.mTag, this.mRequest.getUri(), 0L);
    }

    private boolean isAllComplete() {
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            if (!downloadTask.isComplete()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllFailed() {
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            if (downloadTask.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllPaused() {
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            if (downloadTask.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllCanceled() {
        for (DownloadTask downloadTask : this.mDownloadTasks) {
            if (downloadTask.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private void deleteFile() {
        File file = new File(this.mDownloadInfo.getDir(), this.mDownloadInfo.getName());
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}
