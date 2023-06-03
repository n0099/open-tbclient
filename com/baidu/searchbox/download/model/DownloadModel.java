package com.baidu.searchbox.download.model;
/* loaded from: classes3.dex */
public class DownloadModel {
    public long mCurrentBytes;
    public long mDownloadId;
    public String mDownloadPath;
    public int mStatus;
    public long mTotalBytes;

    public static DownloadModel buildErrorBean() {
        DownloadModel downloadModel = new DownloadModel();
        downloadModel.mCurrentBytes = 0L;
        downloadModel.mTotalBytes = -1L;
        downloadModel.mStatus = -1;
        downloadModel.mDownloadId = -1L;
        downloadModel.mDownloadPath = "";
        return downloadModel;
    }
}
