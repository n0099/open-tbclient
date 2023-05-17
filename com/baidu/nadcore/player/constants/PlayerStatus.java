package com.baidu.nadcore.player.constants;
/* loaded from: classes3.dex */
public enum PlayerStatus {
    IDLE,
    PREPARING,
    PREPARED,
    PLAYING,
    PAUSE,
    STOP,
    COMPLETE,
    ERROR;

    public static boolean isActiveStatus(PlayerStatus playerStatus) {
        if (playerStatus != PREPARING && playerStatus != PREPARED && playerStatus != PAUSE && playerStatus != PLAYING) {
            return false;
        }
        return true;
    }
}
