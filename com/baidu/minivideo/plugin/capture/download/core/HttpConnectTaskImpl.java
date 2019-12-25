package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes11.dex */
public class HttpConnectTaskImpl implements HttpConnectTask {
    private final HttpConnectTask.OnConnectListener mOnConnectListener;
    private volatile long mStartTime;
    private volatile int mStatus;
    private final String mUri;

    public HttpConnectTaskImpl(String str, HttpConnectTask.OnConnectListener onConnectListener) {
        this.mUri = str;
        this.mOnConnectListener = onConnectListener;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void pause() {
        this.mStatus = 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void cancel() {
        this.mStatus = 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnecting() {
        return this.mStatus == 102;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnected() {
        return this.mStatus == 103;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isPaused() {
        return this.mStatus == 106;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isCanceled() {
        return this.mStatus == 107;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isFailed() {
        return this.mStatus == 108;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mStatus = 102;
        this.mOnConnectListener.onConnecting();
        try {
            executeConnection();
        } catch (DownloadException e) {
            handleDownloadException(e);
        }
    }

    private void executeConnection() throws DownloadException {
        HttpURLConnection httpURLConnection;
        this.mStartTime = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.mUri).openConnection();
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
                httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=0-");
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

    private void parseResponse(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) {
            contentLength = httpURLConnection.getContentLength();
        } else {
            contentLength = Long.parseLong(headerField);
        }
        if (contentLength <= 0) {
            throw new DownloadException(108, "length <= 0");
        }
        checkCanceledOrPaused();
        this.mStatus = 103;
        this.mOnConnectListener.onConnected(System.currentTimeMillis() - this.mStartTime, contentLength, z);
    }

    private void checkCanceledOrPaused() throws DownloadException {
        if (isCanceled()) {
            throw new DownloadException(107, "Connection Canceled!");
        }
        if (isPaused()) {
            throw new DownloadException(106, "Connection Paused!");
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
}
