package com.baidu.nadcore.download.consts;
/* loaded from: classes2.dex */
public enum AdDownloadAction {
    START(1),
    PAUSE(2),
    RESUME(3),
    PROGRESS_UPDATE(4),
    COMPLETE(5),
    INSTALL_START(6),
    INSTALL_FINISH(7),
    REMOVE(8),
    OPEN(9),
    FAIL(10),
    FAIL_RETRY(11),
    FAIL_PERMISSION_DENY(12);
    
    public final int action;

    AdDownloadAction(int i) {
        this.action = i;
    }
}
