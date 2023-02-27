package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import com.baidu.searchbox.bddownload.core.interceptor.BreakpointInterceptor;
import com.baidu.searchbox.bddownload.core.interceptor.FetchDataInterceptor;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import com.baidu.searchbox.bddownload.core.interceptor.RetryInterceptor;
import com.baidu.searchbox.bddownload.core.interceptor.connect.CallServerInterceptor;
import com.baidu.searchbox.bddownload.core.interceptor.connect.HeaderInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class DownloadChain implements Runnable {
    public static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Cancel Block", false));
    public static final String TAG = "DownloadChain";
    public final int blockIndex;
    @NonNull
    public final DownloadCache cache;
    public volatile DownloadConnection connection;
    public volatile Thread currentThread;
    @NonNull
    public final BreakpointInfo info;
    public long noCallbackIncreaseBytes;
    public long responseContentLength;
    @NonNull
    public final DownloadStore store;
    @NonNull
    public final DownloadTask task;
    public final AtomicBoolean finished = new AtomicBoolean(false);
    public final List<Interceptor.Connect> connectInterceptorList = new ArrayList();
    public final List<Interceptor.Fetch> fetchInterceptorList = new ArrayList();
    public int connectIndex = 0;
    public int fetchIndex = 0;
    public final Runnable releaseConnectionRunnable = new Runnable() { // from class: com.baidu.searchbox.bddownload.core.download.DownloadChain.1
        @Override // java.lang.Runnable
        public void run() {
            DownloadChain.this.releaseConnection();
        }
    };
    public final CallbackDispatcher callbackDispatcher = BdDownload.with().callbackDispatcher();

    public void cancel() {
        if (!this.finished.get() && this.currentThread != null) {
            this.currentThread.interrupt();
        }
    }

    public void flushNoCallbackIncreaseBytes() {
        if (this.noCallbackIncreaseBytes == 0) {
            return;
        }
        this.callbackDispatcher.dispatch().fetchProgress(this.task, this.blockIndex, this.noCallbackIncreaseBytes);
        this.noCallbackIncreaseBytes = 0L;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    @NonNull
    public DownloadCache getCache() {
        return this.cache;
    }

    @Nullable
    public synchronized DownloadConnection getConnection() {
        return this.connection;
    }

    @NonNull
    public DownloadStore getDownloadStore() {
        return this.store;
    }

    @NonNull
    public BreakpointInfo getInfo() {
        return this.info;
    }

    public MultiPointOutputStream getOutputStream() {
        return this.cache.getOutputStream();
    }

    public long getResponseContentLength() {
        return this.responseContentLength;
    }

    @NonNull
    public DownloadTask getTask() {
        return this.task;
    }

    public boolean isFinished() {
        return this.finished.get();
    }

    public long loopFetch() throws IOException {
        if (this.fetchIndex == this.fetchInterceptorList.size()) {
            this.fetchIndex--;
        }
        return processFetch();
    }

    public DownloadConnection.Connected processConnect() throws IOException {
        if (!this.cache.isInterrupt()) {
            List<Interceptor.Connect> list = this.connectInterceptorList;
            int i = this.connectIndex;
            this.connectIndex = i + 1;
            return list.get(i).interceptConnect(this);
        }
        throw InterruptException.SIGNAL;
    }

    public long processFetch() throws IOException {
        if (!this.cache.isInterrupt()) {
            List<Interceptor.Fetch> list = this.fetchInterceptorList;
            int i = this.fetchIndex;
            this.fetchIndex = i + 1;
            return list.get(i).interceptFetch(this);
        }
        throw InterruptException.SIGNAL;
    }

    public void releaseConnectionAsync() {
        EXECUTOR.execute(this.releaseConnectionRunnable);
    }

    public void resetConnectForRetry() {
        this.connectIndex = 1;
        releaseConnection();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!isFinished()) {
            this.currentThread = Thread.currentThread();
            try {
                start();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.finished.set(true);
                releaseConnectionAsync();
                throw th;
            }
            this.finished.set(true);
            releaseConnectionAsync();
            return;
        }
        throw new IllegalAccessError("The chain has been finished!");
    }

    public DownloadChain(int i, @NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadCache downloadCache, @NonNull DownloadStore downloadStore) {
        this.blockIndex = i;
        this.task = downloadTask;
        this.cache = downloadCache;
        this.info = breakpointInfo;
        this.store = downloadStore;
    }

    public static DownloadChain createChain(int i, DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadCache downloadCache, @NonNull DownloadStore downloadStore) {
        return new DownloadChain(i, downloadTask, breakpointInfo, downloadCache, downloadStore);
    }

    @NonNull
    public synchronized DownloadConnection getConnectionOrCreate() throws IOException {
        if (!this.cache.isInterrupt()) {
            if (this.connection == null) {
                String redirectLocation = this.cache.getRedirectLocation();
                if (redirectLocation == null) {
                    redirectLocation = this.info.getUrl();
                }
                Util.d(TAG, "create connection on url: " + redirectLocation);
                this.connection = BdDownload.with().connectionFactory().create(redirectLocation);
            }
        } else {
            throw InterruptException.SIGNAL;
        }
        return this.connection;
    }

    public synchronized void releaseConnection() {
        if (this.connection != null) {
            this.connection.release();
            Util.d(TAG, "release connection " + this.connection + " task[" + this.task.getId() + "] block[" + this.blockIndex + PreferencesUtil.RIGHT_MOUNT);
        }
        this.connection = null;
    }

    public void increaseCallbackBytes(long j) {
        this.noCallbackIncreaseBytes += j;
    }

    public synchronized void setConnection(@NonNull DownloadConnection downloadConnection) {
        this.connection = downloadConnection;
    }

    public void setRedirectLocation(String str) {
        this.cache.setRedirectLocation(str);
    }

    public void setResponseContentLength(long j) {
        this.responseContentLength = j;
    }

    public void start() throws IOException {
        CallbackDispatcher callbackDispatcher = BdDownload.with().callbackDispatcher();
        RetryInterceptor retryInterceptor = new RetryInterceptor();
        BreakpointInterceptor breakpointInterceptor = new BreakpointInterceptor();
        this.connectInterceptorList.add(retryInterceptor);
        this.connectInterceptorList.add(breakpointInterceptor);
        this.connectInterceptorList.add(new HeaderInterceptor());
        this.connectInterceptorList.add(new CallServerInterceptor());
        this.connectIndex = 0;
        DownloadConnection.Connected processConnect = processConnect();
        if (!this.cache.isInterrupt()) {
            callbackDispatcher.dispatch().fetchStart(this.task, this.blockIndex, getResponseContentLength());
            FetchDataInterceptor fetchDataInterceptor = new FetchDataInterceptor(this.blockIndex, processConnect.getInputStream(), getOutputStream(), this.task);
            this.fetchInterceptorList.add(retryInterceptor);
            this.fetchInterceptorList.add(breakpointInterceptor);
            this.fetchInterceptorList.add(fetchDataInterceptor);
            this.fetchIndex = 0;
            callbackDispatcher.dispatch().fetchEnd(this.task, this.blockIndex, processFetch());
            return;
        }
        throw InterruptException.SIGNAL;
    }
}
