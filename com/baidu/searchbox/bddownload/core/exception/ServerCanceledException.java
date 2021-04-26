package com.baidu.searchbox.bddownload.core.exception;

import java.io.IOException;
/* loaded from: classes2.dex */
public class ServerCanceledException extends IOException {
    public final int responseCode;

    public ServerCanceledException(int i2, long j) {
        super("Response code can't handled on internal " + i2 + " with current offset " + j);
        this.responseCode = i2;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
