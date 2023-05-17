package com.baidu.swan.game.ad.downloader.model;
/* loaded from: classes4.dex */
public enum DownloadState {
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

    DownloadState(int i) {
        this.state = i;
    }

    public static DownloadState convert(int i) {
        DownloadState[] values;
        DownloadState downloadState = NOT_START;
        for (DownloadState downloadState2 : values()) {
            if (downloadState2.state == i) {
                downloadState = downloadState2;
            }
        }
        return downloadState;
    }

    public int value() {
        return this.state;
    }
}
