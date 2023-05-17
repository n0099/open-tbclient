package com.baidu.swan.apps.gamecenter;
/* loaded from: classes4.dex */
public enum GameCenterDownloadState {
    WAITING,
    DOWNLOADING,
    PAUSE,
    FAILED,
    CANCEL,
    FINISH,
    UNKNOWN;

    public static GameCenterDownloadState getState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return UNKNOWN;
                        }
                        return FAILED;
                    }
                    return FINISH;
                }
                return PAUSE;
            }
            return DOWNLOADING;
        }
        return WAITING;
    }
}
