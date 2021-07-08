package com.baidu.minivideo.plugin.capture.download.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.DownloadConfig;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadResponse;
import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidu.minivideo.plugin.capture.download.base.Downloader;
import com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class DownloaderImpl implements Downloader, HttpConnectTask.OnConnectListener, DownloadTask.OnDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadConfig mConfig;
    public HttpConnectTask mConnectTask;
    public DownloadInfo mDownloadInfo;
    public List<DownloadTask> mDownloadTasks;
    public Executor mExecutor;
    public Downloader.OnDownloaderDestroyedListener mListener;
    public DownloadRequest mRequest;
    public DownloadResponse mResponse;
    public int mStatus;
    public String mTag;

    public DownloaderImpl(DownloadRequest downloadRequest, DownloadResponse downloadResponse, Executor executor, String str, DownloadConfig downloadConfig, Downloader.OnDownloaderDestroyedListener onDownloaderDestroyedListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadRequest, downloadResponse, executor, str, downloadConfig, onDownloaderDestroyedListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequest = downloadRequest;
        this.mResponse = downloadResponse;
        this.mExecutor = executor;
        this.mTag = str;
        this.mConfig = downloadConfig;
        this.mListener = onDownloaderDestroyedListener;
        init();
    }

    private void deleteFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            File file = new File(this.mDownloadInfo.getDir(), this.mDownloadInfo.getName());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    private void download(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.mStatus = 104;
            initDownloadTasks(j, z);
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                this.mExecutor.execute(downloadTask);
            }
        }
    }

    private List<ThreadRecord> getMultiThreadRecords(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int threadNum = this.mConfig.getThreadNum();
            int i2 = 0;
            while (i2 < threadNum) {
                long j2 = j / threadNum;
                long j3 = j2 * i2;
                arrayList.add(new ThreadRecord(i2, this.mTag, this.mRequest.getUri(), j3, i2 == threadNum + (-1) ? j : (j2 + j3) - 1, 0L));
                i2++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    private ThreadRecord getSingleThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new ThreadRecord(0, this.mTag, this.mRequest.getUri(), 0L) : (ThreadRecord) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mDownloadInfo = new DownloadInfo(this.mRequest.getName().toString(), this.mRequest.getUri(), this.mRequest.getFolder());
            this.mDownloadTasks = new LinkedList();
        }
    }

    private void initDownloadTasks(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.mDownloadTasks.clear();
            if (z) {
                List<ThreadRecord> multiThreadRecords = getMultiThreadRecords(j);
                int i2 = 0;
                for (ThreadRecord threadRecord : multiThreadRecords) {
                    i2 = (int) (i2 + threadRecord.getFinished());
                }
                this.mDownloadInfo.setFinished(i2);
                for (ThreadRecord threadRecord2 : multiThreadRecords) {
                    this.mDownloadTasks.add(new MultiDownloadTask(this.mDownloadInfo, threadRecord2, this));
                }
                return;
            }
            this.mDownloadTasks.add(new SingleDownloadTask(this.mDownloadInfo, getSingleThreadInfo(), this));
        }
    }

    private boolean isAllCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                if (downloadTask.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean isAllComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                if (!downloadTask.isComplete()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean isAllFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                if (downloadTask.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean isAllPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                if (downloadTask.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void startConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            HttpConnectTaskImpl httpConnectTaskImpl = new HttpConnectTaskImpl(this.mRequest.getUri(), this);
            this.mConnectTask = httpConnectTaskImpl;
            this.mExecutor.execute(httpConnectTaskImpl);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpConnectTask httpConnectTask = this.mConnectTask;
            if (httpConnectTask != null) {
                httpConnectTask.cancel();
            }
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                downloadTask.cancel();
            }
            if (this.mStatus != 104) {
                onDownloadCanceled();
            }
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.mStatus;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            deleteFile();
            this.mStatus = 107;
            this.mResponse.onConnectCanceled();
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
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
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
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
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask.OnConnectListener
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mStatus = 102;
            this.mResponse.onConnecting();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mListener.onDestroyed(this.mTag, this);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && isAllCanceled()) {
            deleteFile();
            this.mStatus = 107;
            this.mResponse.onDownloadCanceled();
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && isAllComplete()) {
            this.mStatus = 105;
            this.mResponse.onDownloadCompleted(str);
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, downloadException) == null) && isAllFailed()) {
            this.mStatus = 108;
            this.mResponse.onDownloadFailed(downloadException);
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && isAllPaused()) {
            this.mStatus = 106;
            this.mResponse.onDownloadPaused();
            onDestroy();
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask.OnDownloadListener
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mResponse.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HttpConnectTask httpConnectTask = this.mConnectTask;
            if (httpConnectTask != null) {
                httpConnectTask.pause();
            }
            for (DownloadTask downloadTask : this.mDownloadTasks) {
                downloadTask.pause();
            }
            if (this.mStatus != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mStatus = 101;
            this.mResponse.onStarted();
            startConnect();
        }
    }
}
