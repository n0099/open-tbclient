package com.baidu.clientupdate.download;
/* loaded from: classes.dex */
public enum DownloadState {
    WAITING,
    DOWNLOADING,
    PAUSE,
    FAILED,
    CANCEL,
    FINISH,
    UNKNOWN,
    MEAGESTART,
    MEAGEEND;

    public static DownloadState getState(int i2) {
        return i2 == 0 ? WAITING : i2 == 1 ? DOWNLOADING : i2 == 2 ? PAUSE : i2 == 3 ? FAILED : i2 == 4 ? CANCEL : i2 == 5 ? FINISH : i2 == 6 ? UNKNOWN : i2 == 7 ? MEAGESTART : i2 == 8 ? MEAGEEND : UNKNOWN;
    }
}
