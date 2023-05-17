package com.baidu.nadcore.download.consts;
/* loaded from: classes3.dex */
public enum AdDownloadCode {
    SUCCESS(0),
    ERROR_START_FAIL(1),
    ERROR_CONNECT_TIMEOUT(2),
    ERROR_FAST_CLICK(3),
    ERROR_INVALID_DATA(4),
    ERROR_OTHERS(5);
    
    public int code;

    AdDownloadCode(int i) {
        this.code = i;
    }
}
