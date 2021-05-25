package com.baidu.swan.apps.gamecenter;
/* loaded from: classes3.dex */
public enum GameCenterDownloadState {
    WAITING,
    DOWNLOADING,
    PAUSE,
    FAILED,
    CANCEL,
    FINISH,
    UNKNOWN;

    public static GameCenterDownloadState getState(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
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
