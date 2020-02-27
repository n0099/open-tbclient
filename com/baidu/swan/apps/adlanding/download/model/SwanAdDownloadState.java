package com.baidu.swan.apps.adlanding.download.model;
/* loaded from: classes11.dex */
public enum SwanAdDownloadState {
    NOT_START(0),
    DOWNLOADING(1),
    DOWNLOAD_PAUSED(2),
    DOWNLOADED(3),
    DOWNLOAD_FAILED(4),
    INSTALLED(5),
    DELETED(6);
    
    private int state;

    SwanAdDownloadState(int i) {
        this.state = i;
    }

    public int value() {
        return this.state;
    }

    public static SwanAdDownloadState convert(int i) {
        SwanAdDownloadState swanAdDownloadState = NOT_START;
        SwanAdDownloadState[] values = values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            SwanAdDownloadState swanAdDownloadState2 = values[i2];
            if (swanAdDownloadState2.state != i) {
                swanAdDownloadState2 = swanAdDownloadState;
            }
            i2++;
            swanAdDownloadState = swanAdDownloadState2;
        }
        return swanAdDownloadState;
    }
}
