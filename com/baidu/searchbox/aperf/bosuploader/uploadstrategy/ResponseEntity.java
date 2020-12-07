package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;
/* loaded from: classes16.dex */
public class ResponseEntity {
    private String mResponseMessage;
    private boolean mSuccess;

    public ResponseEntity() {
        this.mSuccess = true;
        this.mResponseMessage = null;
    }

    public ResponseEntity(boolean z, String str) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
    }

    public ResponseEntity(boolean z) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public String getMessage() {
        return this.mResponseMessage;
    }
}
