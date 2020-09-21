package com.baidu.down.common;
/* loaded from: classes14.dex */
public abstract class TaskObserver implements TaskObserverInterface {
    protected abstract void onDownloadCancel(String str, long j, long j2, long j3, String str2);

    protected abstract void onDownloadFail(String str, long j, long j2, String str2, String str3, int i, DownDetail downDetail);

    protected abstract void onDownloadPause(String str, long j, long j2, long j3, String str2);

    protected abstract void onDownloadRunning(String str, long j, long j2, long j3);

    protected abstract void onDownloadStart(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, DownDetail downDetail);

    protected abstract void onDownloadSuccess(String str, long j, long j2, long j3, String str2, long j4);

    protected abstract void onDownloadWait(String str, long j);

    protected abstract void onDownloading(String str, long j, long j2, long j3, long j4, String str2);

    protected abstract void onWriteFinish(String str, long j, long j2, long j3, DownDetail downDetail);

    @Override // com.baidu.down.common.TaskObserverInterface
    public void onUpdate(Object obj) {
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
