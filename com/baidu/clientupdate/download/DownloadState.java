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

    public static DownloadState getState(int i) {
        return i == 0 ? WAITING : i == 1 ? DOWNLOADING : i == 2 ? PAUSE : i == 3 ? FAILED : i == 4 ? CANCEL : i == 5 ? FINISH : i == 6 ? UNKNOWN : i == 7 ? MEAGESTART : i == 8 ? MEAGEEND : UNKNOWN;
    }
}
