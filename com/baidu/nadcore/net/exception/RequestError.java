package com.baidu.nadcore.net.exception;
/* loaded from: classes3.dex */
public class RequestError extends Exception {
    public RequestError() {
    }

    public RequestError(String str) {
        super(str);
    }

    public RequestError(String str, Throwable th) {
        super(str, th);
    }

    public RequestError(Throwable th) {
        super(th);
    }
}
