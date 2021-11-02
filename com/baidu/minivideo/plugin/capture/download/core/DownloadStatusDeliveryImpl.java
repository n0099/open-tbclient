package com.baidu.minivideo.plugin.capture.download.core;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatus;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class DownloadStatusDeliveryImpl implements DownloadStatusDelivery {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownloadStatusDelivery";
    public transient /* synthetic */ FieldHolder $fh;
    public Executor mDownloadStatusPoster;

    /* loaded from: classes7.dex */
    public static class DownloadStatusDeliveryRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DownloadCallback mCallBack;
        public final DownloadStatus mDownloadStatus;

        public DownloadStatusDeliveryRunnable(DownloadStatus downloadStatus) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadStatus};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDownloadStatus = downloadStatus;
            this.mCallBack = downloadStatus.getCallBack();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.mDownloadStatus.getStatus()) {
                    case 102:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.mCallBack.onConnecting();
                        return;
                    case 103:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.mDownloadStatus.getLength() + " acceptRanges: " + this.mDownloadStatus.isAcceptRanges());
                        this.mCallBack.onConnected(this.mDownloadStatus.getLength(), this.mDownloadStatus.isAcceptRanges());
                        return;
                    case 104:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.mDownloadStatus.getFinished() + " length: " + this.mDownloadStatus.getLength() + " percent: " + this.mDownloadStatus.getPercent());
                        this.mCallBack.onProgress(this.mDownloadStatus.getFinished(), this.mDownloadStatus.getLength(), this.mDownloadStatus.getPercent());
                        return;
                    case 105:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.mDownloadStatus.getSavedPath());
                        if (this.mDownloadStatus.getCalledCompleted()) {
                            return;
                        }
                        this.mDownloadStatus.setCalledCompleted(true);
                        this.mCallBack.onCompleted(this.mDownloadStatus.getSavedPath());
                        return;
                    case 106:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.mCallBack.onDownloadPaused();
                        return;
                    case 107:
                        LogUtils.d(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.mCallBack.onDownloadCanceled();
                        return;
                    case 108:
                        LogUtils.e(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.mDownloadStatus.getException().getCause());
                        this.mCallBack.onFailed((DownloadException) this.mDownloadStatus.getException());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public DownloadStatusDeliveryImpl(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownloadStatusPoster = new Executor(this, handler) { // from class: com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadStatusDeliveryImpl this$0;
            public final /* synthetic */ Handler val$handler;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, handler};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$handler = handler;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    this.val$handler.post(runnable);
                }
            }
        };
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery
    public void post(DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadStatus) == null) {
            this.mDownloadStatusPoster.execute(new DownloadStatusDeliveryRunnable(downloadStatus));
        }
    }
}
