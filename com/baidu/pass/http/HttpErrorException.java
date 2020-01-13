package com.baidu.pass.http;
/* loaded from: classes6.dex */
public class HttpErrorException extends Exception {
    public int statusCode;

    public HttpErrorException() {
    }

    public HttpErrorException(int i, String str) {
        super(str);
        this.statusCode = i;
    }
}
