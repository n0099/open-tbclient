package com.baidu.down.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class TaskObserver implements TaskObserverInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TaskObserver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void onDownloadCancel(String str, long j2, long j3, long j4, String str2);

    public abstract void onDownloadFail(String str, long j2, long j3, String str2, String str3, int i2, DownDetail downDetail);

    public abstract void onDownloadPause(String str, long j2, long j3, long j4, String str2);

    public abstract void onDownloadRunning(String str, long j2, long j3, long j4);

    public abstract void onDownloadStart(String str, long j2, long j3, String str2, String str3, String str4, String str5, boolean z, DownDetail downDetail);

    public abstract void onDownloadSuccess(String str, long j2, long j3, long j4, String str2, long j5);

    public abstract void onDownloadWait(String str, long j2);

    public abstract void onDownloading(String str, long j2, long j3, long j4, long j5, String str2);

    @Override // com.baidu.down.common.TaskObserverInterface
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            TaskMsg taskMsg = (TaskMsg) obj;
            switch (taskMsg.status) {
                case 1000:
                    onDownloadRunning(taskMsg.uKey, taskMsg._id, taskMsg.transferedSize, taskMsg.fileSize);
                    return;
                case 1001:
                    onDownloadStart(taskMsg.uKey, taskMsg._id, taskMsg.fileSize, taskMsg.thumnailpath, taskMsg.filePath, taskMsg.etag, taskMsg.strRedownload, taskMsg.supportRange, taskMsg.downDetail);
                    return;
                case 1002:
                    onDownloading(taskMsg.uKey, taskMsg._id, taskMsg.transferedSize, taskMsg.fileSize, taskMsg.transferedSpeed, taskMsg.progressMap);
                    return;
                case 1003:
                    onDownloadSuccess(taskMsg.uKey, taskMsg._id, taskMsg.fileSize, taskMsg.transferedSize, taskMsg.filePath, taskMsg.transferedSpeed);
                    return;
                case 1004:
                    onDownloadCancel(taskMsg.uKey, taskMsg._id, taskMsg.transferedSize, taskMsg.fileSize, taskMsg.filePath);
                    return;
                case 1005:
                    onDownloadFail(taskMsg.uKey, taskMsg._id, taskMsg.transferedSize, taskMsg.filePath, taskMsg.errorStr, taskMsg.failType, taskMsg.downDetail);
                    return;
                case 1006:
                    onDownloadPause(taskMsg.uKey, taskMsg._id, taskMsg.transferedSize, taskMsg.fileSize, taskMsg.filePath);
                    return;
                case 1007:
                default:
                    return;
                case 1008:
                    onWriteFinish(taskMsg.uKey, taskMsg._id, taskMsg.fileSize, taskMsg.transferedSpeed, taskMsg.downDetail);
                    return;
                case 1009:
                    onDownloadWait(taskMsg.uKey, taskMsg._id);
                    return;
            }
        }
    }

    public abstract void onWriteFinish(String str, long j2, long j3, long j4, DownDetail downDetail);
}
