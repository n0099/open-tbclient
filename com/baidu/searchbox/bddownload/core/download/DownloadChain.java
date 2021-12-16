package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class DownloadChain implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExecutorService EXECUTOR;
    public static final String TAG = "DownloadChain";
    public transient /* synthetic */ FieldHolder $fh;
    public final int blockIndex;
    @NonNull
    public final DownloadCache cache;
    public final CallbackDispatcher callbackDispatcher;
    public int connectIndex;
    public final List<Interceptor.Connect> connectInterceptorList;
    public volatile DownloadConnection connection;
    public volatile Thread currentThread;
    public int fetchIndex;
    public final List<Interceptor.Fetch> fetchInterceptorList;
    public final AtomicBoolean finished;
    @NonNull
    public final BreakpointInfo info;
    public long noCallbackIncreaseBytes;
    public final Runnable releaseConnectionRunnable;
    public long responseContentLength;
    @NonNull
    public final DownloadStore store;
    @NonNull
    public final DownloadTask task;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-651074748, "Lcom/baidu/searchbox/bddownload/core/download/DownloadChain;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-651074748, "Lcom/baidu/searchbox/bddownload/core/download/DownloadChain;");
                return;
            }
        }
        EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Cancel Block", false));
    }

    public DownloadChain(int i2, @NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadCache downloadCache, @NonNull DownloadStore downloadStore) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), downloadTask, breakpointInfo, downloadCache, downloadStore};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.finished = new AtomicBoolean(false);
        this.connectInterceptorList = new ArrayList();
        this.fetchInterceptorList = new ArrayList();
        this.connectIndex = 0;
        this.fetchIndex = 0;
        this.releaseConnectionRunnable = new Runnable(this) { // from class: com.baidu.searchbox.bddownload.core.download.DownloadChain.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadChain this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.releaseConnection();
                }
            }
        };
        this.blockIndex = i2;
        this.task = downloadTask;
        this.cache = downloadCache;
        this.info = breakpointInfo;
        this.store = downloadStore;
        this.callbackDispatcher = BdDownload.with().callbackDispatcher();
    }

    public static DownloadChain createChain(int i2, DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadCache downloadCache, @NonNull DownloadStore downloadStore) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), downloadTask, breakpointInfo, downloadCache, downloadStore})) == null) ? new DownloadChain(i2, downloadTask, breakpointInfo, downloadCache, downloadStore) : (DownloadChain) invokeCommon.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.finished.get() || this.currentThread == null) {
            return;
        }
        this.currentThread.interrupt();
    }

    public void flushNoCallbackIncreaseBytes() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.noCallbackIncreaseBytes == 0) {
            return;
        }
        this.callbackDispatcher.dispatch().fetchProgress(this.task, this.blockIndex, this.noCallbackIncreaseBytes);
        this.noCallbackIncreaseBytes = 0L;
    }

    public int getBlockIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.blockIndex : invokeV.intValue;
    }

    @NonNull
    public DownloadCache getCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cache : (DownloadCache) invokeV.objValue;
    }

    @Nullable
    public synchronized DownloadConnection getConnection() {
        InterceptResult invokeV;
        DownloadConnection downloadConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                downloadConnection = this.connection;
            }
            return downloadConnection;
        }
        return (DownloadConnection) invokeV.objValue;
    }

    @NonNull
    public synchronized DownloadConnection getConnectionOrCreate() throws IOException {
        InterceptResult invokeV;
        DownloadConnection downloadConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (!this.cache.isInterrupt()) {
                    if (this.connection == null) {
                        String redirectLocation = this.cache.getRedirectLocation();
                        if (redirectLocation == null) {
                            redirectLocation = this.info.getUrl();
                        }
                        Util.d(TAG, "create connection on url: " + redirectLocation);
                        this.connection = BdDownload.with().connectionFactory().create(redirectLocation);
                    }
                    downloadConnection = this.connection;
                } else {
                    throw InterruptException.SIGNAL;
                }
            }
            return downloadConnection;
        }
        return (DownloadConnection) invokeV.objValue;
    }

    @NonNull
    public DownloadStore getDownloadStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.store : (DownloadStore) invokeV.objValue;
    }

    @NonNull
    public BreakpointInfo getInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.info : (BreakpointInfo) invokeV.objValue;
    }

    public MultiPointOutputStream getOutputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cache.getOutputStream() : (MultiPointOutputStream) invokeV.objValue;
    }

    public long getResponseContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.responseContentLength : invokeV.longValue;
    }

    @NonNull
    public DownloadTask getTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.task : (DownloadTask) invokeV.objValue;
    }

    public void increaseCallbackBytes(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.noCallbackIncreaseBytes += j2;
        }
    }

    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.finished.get() : invokeV.booleanValue;
    }

    public long loopFetch() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.fetchIndex == this.fetchInterceptorList.size()) {
                this.fetchIndex--;
            }
            return processFetch();
        }
        return invokeV.longValue;
    }

    public DownloadConnection.Connected processConnect() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.cache.isInterrupt()) {
                List<Interceptor.Connect> list = this.connectInterceptorList;
                int i2 = this.connectIndex;
                this.connectIndex = i2 + 1;
                return list.get(i2).interceptConnect(this);
            }
            throw InterruptException.SIGNAL;
        }
        return (DownloadConnection.Connected) invokeV.objValue;
    }

    public long processFetch() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.cache.isInterrupt()) {
                List<Interceptor.Fetch> list = this.fetchInterceptorList;
                int i2 = this.fetchIndex;
                this.fetchIndex = i2 + 1;
                return list.get(i2).interceptFetch(this);
            }
            throw InterruptException.SIGNAL;
        }
        return invokeV.longValue;
    }

    public synchronized void releaseConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (this.connection != null) {
                    this.connection.release();
                    Util.d(TAG, "release connection " + this.connection + " task[" + this.task.getId() + "] block[" + this.blockIndex + PreferencesUtil.RIGHT_MOUNT);
                }
                this.connection = null;
            }
        }
    }

    public void releaseConnectionAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            EXECUTOR.execute(this.releaseConnectionRunnable);
        }
    }

    public void resetConnectForRetry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.connectIndex = 1;
            releaseConnection();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
    }

    public synchronized void setConnection(@NonNull DownloadConnection downloadConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, downloadConnection) == null) {
            synchronized (this) {
                this.connection = downloadConnection;
            }
        }
    }

    public void setRedirectLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.cache.setRedirectLocation(str);
        }
    }

    public void setResponseContentLength(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            this.responseContentLength = j2;
        }
    }

    public void start() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
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
}
