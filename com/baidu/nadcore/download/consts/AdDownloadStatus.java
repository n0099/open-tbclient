package com.baidu.nadcore.download.consts;
/* loaded from: classes2.dex */
public enum AdDownloadStatus {
    NONE(0),
    DOWNLOADING(1),
    PAUSE(2),
    COMPLETED(3),
    INSTALLED(4),
    FAILED(5);
    
    public final int status;

    AdDownloadStatus(int i) {
        this.status = i;
    }
}
