package com.baidu.minivideo.plugin.capture.download.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.base.DownloadResponse;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatus;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DownloadResponseImpl implements DownloadResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadStatusDelivery mDelivery;
    public DownloadStatus mDownloadStatus;

    public DownloadResponseImpl(DownloadStatusDelivery downloadStatusDelivery, DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadStatusDelivery, downloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelivery = downloadStatusDelivery;
        DownloadStatus downloadStatus = new DownloadStatus();
        this.mDownloadStatus = downloadStatus;
        downloadStatus.setCallBack(downloadCallback);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDownloadStatus.setStatus(107);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onConnectFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            this.mDownloadStatus.setException(downloadException);
            this.mDownloadStatus.setStatus(108);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.mDownloadStatus.setTime(j);
            this.mDownloadStatus.setAcceptRanges(z);
            this.mDownloadStatus.setStatus(103);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mDownloadStatus.setStatus(102);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mDownloadStatus.setStatus(107);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mDownloadStatus.setStatus(105);
            this.mDownloadStatus.setSavedPath(str);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onDownloadFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            this.mDownloadStatus.setException(downloadException);
            this.mDownloadStatus.setStatus(108);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mDownloadStatus.setStatus(106);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onDownloadProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.mDownloadStatus.setFinished(j);
            this.mDownloadStatus.setLength(j2);
            this.mDownloadStatus.setPercent(i2);
            this.mDownloadStatus.setStatus(104);
            this.mDelivery.post(this.mDownloadStatus);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadResponse
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mDownloadStatus.setStatus(101);
            this.mDownloadStatus.getCallBack().onStarted();
        }
    }
}
