package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes2.dex */
public class HttpConnectTaskImpl implements HttpConnectTask {
    public final HttpConnectTask.OnConnectListener mOnConnectListener;
    public volatile long mStartTime;
    public volatile int mStatus;
    public final String mUri;

    public HttpConnectTaskImpl(String str, HttpConnectTask.OnConnectListener onConnectListener) {
        this.mUri = str;
        this.mOnConnectListener = onConnectListener;
    }

    private void checkCanceledOrPaused() throws DownloadException {
        if (!isCanceled()) {
            if (isPaused()) {
                throw new DownloadException(106, "Connection Paused!");
            }
            return;
        }
        throw new DownloadException(107, "Connection Canceled!");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0060 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void executeConnection() throws DownloadException {
        IOException e2;
        ProtocolException e3;
        this.mStartTime = System.currentTimeMillis();
        try {
            URL url = new URL(this.mUri);
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setRequestProperty("Range", "bytes=0-");
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            parseResponse(httpURLConnection, false);
                        } else if (responseCode == 206) {
                            parseResponse(httpURLConnection, true);
                        } else {
                            throw new DownloadException(108, "UnSupported response code:" + responseCode);
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (ProtocolException e4) {
                        e3 = e4;
                        throw new DownloadException(108, "Protocol error", e3);
                    } catch (IOException e5) {
                        e2 = e5;
                        throw new DownloadException(108, "IO error", e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = url;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e6) {
                e3 = e6;
            } catch (IOException e7) {
                e2 = e7;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (MalformedURLException e8) {
            throw new DownloadException(108, "Bad url.", e8);
        }
    }

    private void handleDownloadException(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.mOnConnectListener) {
                    this.mStatus = 106;
                    this.mOnConnectListener.onConnectPaused();
                }
                return;
            case 107:
                synchronized (this.mOnConnectListener) {
                    this.mStatus = 107;
                    this.mOnConnectListener.onConnectCanceled();
                }
                return;
            case 108:
                synchronized (this.mOnConnectListener) {
                    this.mStatus = 108;
                    this.mOnConnectListener.onConnectFailed(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    private void parseResponse(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
            contentLength = Long.parseLong(headerField);
        } else {
            contentLength = httpURLConnection.getContentLength();
        }
        long j = contentLength;
        if (j > 0) {
            checkCanceledOrPaused();
            this.mStatus = 103;
            this.mOnConnectListener.onConnected(System.currentTimeMillis() - this.mStartTime, j, z);
            return;
        }
        throw new DownloadException(108, "length <= 0");
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void cancel() {
        this.mStatus = 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isCanceled() {
        return this.mStatus == 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnected() {
        return this.mStatus == 103;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnecting() {
        return this.mStatus == 102;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isFailed() {
        return this.mStatus == 108;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isPaused() {
        return this.mStatus == 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void pause() {
        this.mStatus = 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mStatus = 102;
        this.mOnConnectListener.onConnecting();
        try {
            executeConnection();
        } catch (DownloadException e2) {
            handleDownloadException(e2);
        }
    }
}
