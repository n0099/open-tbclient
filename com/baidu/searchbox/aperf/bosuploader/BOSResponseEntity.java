package com.baidu.searchbox.aperf.bosuploader;
/* loaded from: classes16.dex */
public class BOSResponseEntity {
    private int mErrorCode;
    private String mResponseMessage;
    private boolean mSuccess;

    public BOSResponseEntity() {
        this.mSuccess = true;
        this.mResponseMessage = null;
    }

    public BOSResponseEntity(boolean z, String str) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
    }

    public BOSResponseEntity(boolean z, String str, int i) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
        this.mErrorCode = i;
    }

    public BOSResponseEntity(boolean z) {
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

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
