package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes19.dex */
public abstract class DownloadTaskImpl implements DownloadTask {
    private volatile int mCommend = 0;
    private final DownloadInfo mDownloadInfo;
    private final DownloadTask.OnDownloadListener mOnDownloadListener;
    private volatile int mStatus;
    private String mTag;
    private final ThreadRecord mThreadRecord;

    protected abstract RandomAccessFile getFile(File file, String str, long j) throws IOException;

    protected abstract Map<String, String> getHttpHeaders(ThreadRecord threadRecord);

    protected abstract int getResponseCode();

    protected abstract String getTag();

    protected abstract void insertIntoDB(ThreadRecord threadRecord);

    protected abstract void updateDB(ThreadRecord threadRecord);

    public DownloadTaskImpl(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        this.mDownloadInfo = downloadInfo;
        this.mThreadRecord = threadRecord;
        this.mOnDownloadListener = onDownloadListener;
        this.mTag = getTag();
        if (TextUtils.isEmpty(this.mTag)) {
            this.mTag = getClass().getSimpleName();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public void cancel() {
        this.mCommend = 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public void pause() {
        this.mCommend = 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isDownloading() {
        return this.mStatus == 104;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isComplete() {
        return this.mStatus == 105;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isPaused() {
        return this.mStatus == 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isCanceled() {
        return this.mStatus == 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isFailed() {
        return this.mStatus == 108;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        insertIntoDB(this.mThreadRecord);
        try {
            this.mStatus = 104;
            executeDownload();
            synchronized (this.mOnDownloadListener) {
                this.mStatus = 105;
                this.mOnDownloadListener.onDownloadCompleted(createFileSavedPath());
            }
        } catch (DownloadException e) {
            handleDownloadException(e);
        }
    }

    private void handleDownloadException(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.mOnDownloadListener) {
                    this.mStatus = 106;
                    this.mOnDownloadListener.onDownloadPaused();
                }
                return;
            case 107:
                synchronized (this.mOnDownloadListener) {
                    this.mStatus = 107;
                    this.mOnDownloadListener.onDownloadCanceled();
                }
                return;
            case 108:
                synchronized (this.mOnDownloadListener) {
                    this.mStatus = 108;
                    this.mOnDownloadListener.onDownloadFailed(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    private void executeDownload() throws DownloadException {
        HttpURLConnection httpURLConnection;
        try {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.mThreadRecord.getUri()).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (ProtocolException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                httpURLConnection.setConnectTimeout(4000);
                httpURLConnection.setReadTimeout(4000);
                httpURLConnection.setRequestMethod("GET");
                setHttpHeader(getHttpHeaders(this.mThreadRecord), httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == getResponseCode()) {
                    transferData(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                throw new DownloadException(108, "UnSupported response code:" + responseCode);
            } catch (ProtocolException e3) {
                e = e3;
                throw new DownloadException(108, "Protocol error", e);
            } catch (IOException e4) {
                e = e4;
                throw new DownloadException(108, "IO error", e);
            } catch (Throwable th2) {
                httpURLConnection2 = httpURLConnection;
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e5) {
            throw new DownloadException(108, "Bad url.", e5);
        }
    }

    private void setHttpHeader(Map<String, String> map, URLConnection uRLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                uRLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    private void transferData(HttpURLConnection httpURLConnection) throws DownloadException {
        InputStream inputStream;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
                throw new DownloadException(108, "http get inputStream error", e);
            }
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            long start = this.mThreadRecord.getStart() + this.mThreadRecord.getFinished();
            try {
                File dir = this.mDownloadInfo.getDir();
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                RandomAccessFile file = getFile(dir, this.mDownloadInfo.getName(), start);
                transferData(inputStream, file);
                try {
                    close(inputStream);
                    close(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                throw new DownloadException(108, "File occur IOException ", e3);
            } catch (Exception e4) {
                throw new DownloadException(108, "Occur Exception ", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                close(inputStream);
                close(null);
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    private void transferData(InputStream inputStream, RandomAccessFile randomAccessFile) throws DownloadException {
        byte[] bArr = new byte[8192];
        while (true) {
            checkPausedOrCanceled();
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    randomAccessFile.write(bArr, 0, read);
                    this.mThreadRecord.setFinished(this.mThreadRecord.getFinished() + read);
                    synchronized (this.mOnDownloadListener) {
                        this.mDownloadInfo.setFinished(this.mDownloadInfo.getFinished() + read);
                        this.mOnDownloadListener.onDownloadProgress(this.mDownloadInfo.getFinished(), this.mDownloadInfo.getLength());
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                updateDB(this.mThreadRecord);
                throw new DownloadException(108, e);
            }
        }
    }

    private void checkPausedOrCanceled() throws DownloadException {
        if (this.mCommend == 107) {
            throw new DownloadException(107, "Download canceled!");
        }
        if (this.mCommend == 106) {
            updateDB(this.mThreadRecord);
            throw new DownloadException(106, "Download paused!");
        }
    }

    private final void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            synchronized (DownloadTaskImpl.class) {
                closeable.close();
            }
        }
    }

    private final String createFileSavedPath() {
        return this.mDownloadInfo.getDir().getAbsolutePath() + File.separator + this.mDownloadInfo.getName();
    }
}
