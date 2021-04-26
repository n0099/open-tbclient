package com.baidu.down.loopj.android.http;

import java.io.IOException;
/* loaded from: classes2.dex */
public class HttpResponseException extends IOException {
    public int mStatusCode;

    public HttpResponseException(int i2, String str) {
        super(str);
        this.mStatusCode = i2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
