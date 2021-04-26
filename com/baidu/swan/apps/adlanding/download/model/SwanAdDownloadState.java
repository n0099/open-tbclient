package com.baidu.swan.apps.adlanding.download.model;
/* loaded from: classes2.dex */
public enum SwanAdDownloadState {
    NOT_START(0),
    DOWNLOADING(1),
    DOWNLOAD_PAUSED(2),
    DOWNLOADED(3),
    DOWNLOAD_FAILED(4),
    INSTALLED(5),
    DELETED(6),
    PREPARE_DOWNLOAD(7),
    WAIT(8);
    
    public int state;

    SwanAdDownloadState(int i2) {
        this.state = i2;
    }

    public static SwanAdDownloadState convert(int i2) {
        SwanAdDownloadState[] values;
        SwanAdDownloadState swanAdDownloadState = NOT_START;
        for (SwanAdDownloadState swanAdDownloadState2 : values()) {
            if (swanAdDownloadState2.state == i2) {
                swanAdDownloadState = swanAdDownloadState2;
            }
        }
        return swanAdDownloadState;
    }

    public int value() {
        return this.state;
    }
}
