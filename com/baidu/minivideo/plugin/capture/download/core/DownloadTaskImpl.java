package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public abstract class DownloadTaskImpl implements DownloadTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int mCommend;
    public final DownloadInfo mDownloadInfo;
    public final DownloadTask.OnDownloadListener mOnDownloadListener;
    public volatile int mStatus;
    public String mTag;
    public final ThreadRecord mThreadRecord;

    public DownloadTaskImpl(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, threadRecord, onDownloadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCommend = 0;
        this.mDownloadInfo = downloadInfo;
        this.mThreadRecord = threadRecord;
        this.mOnDownloadListener = onDownloadListener;
        String tag = getTag();
        this.mTag = tag;
        if (TextUtils.isEmpty(tag)) {
            this.mTag = getClass().getSimpleName();
        }
    }

    private void checkPausedOrCanceled() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.mCommend != 107) {
                if (this.mCommend != 106) {
                    return;
                }
                updateDB(this.mThreadRecord);
                throw new DownloadException(106, "Download paused!");
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    private final void close(Closeable closeable) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, closeable) == null) || closeable == null) {
            return;
        }
        synchronized (DownloadTaskImpl.class) {
            closeable.close();
        }
    }

    private final String createFileSavedPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.mDownloadInfo.getDir().getAbsolutePath() + File.separator + this.mDownloadInfo.getName();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void executeDownload() throws DownloadException {
        IOException e2;
        ProtocolException e3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) {
            return;
        }
        try {
            URL url = new URL(this.mThreadRecord.getUri());
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, downloadException) == null) {
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
    }

    private void setHttpHeader(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, map, uRLConnection) == null) || map == null) {
            return;
        }
        for (String str : map.keySet()) {
            uRLConnection.setRequestProperty(str, map.get(str));
        }
    }

    private void transferData(HttpURLConnection httpURLConnection) throws DownloadException {
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65544, this, httpURLConnection) != null) {
            return;
        }
        Closeable closeable2 = null;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
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
                } catch (Throwable th) {
                    th = th;
                    closeable2 = inputStream;
                    closeable = null;
                    try {
                        close(closeable2);
                        close(closeable);
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                throw new DownloadException(108, "http get inputStream error", e6);
            }
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCommend = 107;
        }
    }

    public abstract RandomAccessFile getFile(File file, String str, long j2) throws IOException;

    public abstract Map<String, String> getHttpHeaders(ThreadRecord threadRecord);

    public abstract int getResponseCode();

    public abstract String getTag();

    public abstract void insertIntoDB(ThreadRecord threadRecord);

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatus == 107 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStatus == 105 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStatus == 104 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStatus == 108 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStatus == 106 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mCommend = 106;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadTask, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Process.setThreadPriority(10);
            insertIntoDB(this.mThreadRecord);
            try {
                this.mStatus = 104;
                executeDownload();
                synchronized (this.mOnDownloadListener) {
                    this.mStatus = 105;
                    this.mOnDownloadListener.onDownloadCompleted(createFileSavedPath());
                }
            } catch (DownloadException e2) {
                handleDownloadException(e2);
            }
        }
    }

    public abstract void updateDB(ThreadRecord threadRecord);

    private void transferData(InputStream inputStream, RandomAccessFile randomAccessFile) throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, this, inputStream, randomAccessFile) != null) {
            return;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            checkPausedOrCanceled();
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j2 = read;
                this.mThreadRecord.setFinished(this.mThreadRecord.getFinished() + j2);
                synchronized (this.mOnDownloadListener) {
                    this.mDownloadInfo.setFinished(this.mDownloadInfo.getFinished() + j2);
                    this.mOnDownloadListener.onDownloadProgress(this.mDownloadInfo.getFinished(), this.mDownloadInfo.getLength());
                }
            } catch (IOException e2) {
                updateDB(this.mThreadRecord);
                throw new DownloadException(108, e2);
            }
        }
    }
}
