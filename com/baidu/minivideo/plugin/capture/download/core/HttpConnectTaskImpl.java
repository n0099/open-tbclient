package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes2.dex */
public class HttpConnectTaskImpl implements HttpConnectTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpConnectTask.OnConnectListener mOnConnectListener;
    public volatile long mStartTime;
    public volatile int mStatus;
    public final String mUri;

    public HttpConnectTaskImpl(String str, HttpConnectTask.OnConnectListener onConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, onConnectListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUri = str;
        this.mOnConnectListener = onConnectListener;
    }

    private void checkCanceledOrPaused() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (!isCanceled()) {
                if (isPaused()) {
                    throw new DownloadException(106, "Connection Paused!");
                }
                return;
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0064 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void executeConnection() throws DownloadException {
        IOException e;
        ProtocolException e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65538, this) != null) {
            return;
        }
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
                    } catch (ProtocolException e3) {
                        e2 = e3;
                        throw new DownloadException(108, "Protocol error", e2);
                    } catch (IOException e4) {
                        e = e4;
                        throw new DownloadException(108, "IO error", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = url;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e5) {
                e2 = e5;
            } catch (IOException e6) {
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (MalformedURLException e7) {
            throw new DownloadException(108, "Bad url.", e7);
        }
    }

    private void handleDownloadException(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, downloadException) == null) {
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

    private void parseResponse(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection, z) == null) {
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
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mStatus = 107;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStatus == 107 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mStatus == 103 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isConnecting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStatus == 102 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus == 108 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStatus == 106 : invokeV.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mStatus = 106;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.HttpConnectTask, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Process.setThreadPriority(10);
            this.mStatus = 102;
            this.mOnConnectListener.onConnecting();
            try {
                executeConnection();
            } catch (DownloadException e) {
                handleDownloadException(e);
            }
        }
    }
}
