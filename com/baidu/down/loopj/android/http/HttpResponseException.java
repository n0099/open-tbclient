package com.baidu.down.loopj.android.http;

import java.io.IOException;
/* loaded from: classes3.dex */
public class HttpResponseException extends IOException {
    private int mStatusCode;

    public HttpResponseException(int i, String str) {
        super(str);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
