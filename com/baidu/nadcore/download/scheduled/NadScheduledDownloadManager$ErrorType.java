package com.baidu.nadcore.download.scheduled;
/* loaded from: classes3.dex */
public enum NadScheduledDownloadManager$ErrorType {
    SUCCESS("SUCCESS"),
    PERMISSION_DENIED("STORAGE_PERMISSION_DENIED"),
    OVERTIME("OVERTIME"),
    AUTHEN_FAIL("AUTHEN_FAIL"),
    DELAY("ONLINE_DELAY"),
    CANCEL("CANCEL"),
    NOT_FOUND("CHANNELID_NOT_FOUND"),
    PARAMS_ERROR("REQUEST_PARAMS_ERROR"),
    ILLEGAL_RESPONSE("ILLEGAL_RESPONSE");
    
    public final String value;

    NadScheduledDownloadManager$ErrorType(String str) {
        this.value = str;
    }
}
