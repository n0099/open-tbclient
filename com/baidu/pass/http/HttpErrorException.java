package com.baidu.pass.http;
/* loaded from: classes4.dex */
public class HttpErrorException extends Exception implements com.baidu.pass.a {
    public int statusCode;

    public HttpErrorException() {
    }

    public HttpErrorException(int i, String str) {
        super(str);
        this.statusCode = i;
    }
}
