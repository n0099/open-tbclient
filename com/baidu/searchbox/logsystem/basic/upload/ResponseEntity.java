package com.baidu.searchbox.logsystem.basic.upload;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class ResponseEntity {
    @Nullable
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

    @Nullable
    public String getMessage() {
        return this.mResponseMessage;
    }
}
