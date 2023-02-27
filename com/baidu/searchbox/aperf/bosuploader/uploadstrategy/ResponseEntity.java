package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class ResponseEntity {
    @Nullable
    public String mResponseMessage;
    public boolean mSuccess;

    public ResponseEntity() {
        this.mSuccess = true;
        this.mResponseMessage = null;
    }

    @Nullable
    public String getMessage() {
        return this.mResponseMessage;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public ResponseEntity(boolean z) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
    }

    public ResponseEntity(boolean z, String str) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
    }
}
