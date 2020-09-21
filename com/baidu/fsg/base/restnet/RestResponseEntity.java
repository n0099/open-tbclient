package com.baidu.fsg.base.restnet;

import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.http.a;
import java.util.List;
/* loaded from: classes15.dex */
public class RestResponseEntity<T> {
    private T mBody;
    private a mHeaders;
    private final HttpStatus mStatusCode;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
        this.mBody = t;
    }

    public RestResponseEntity(a aVar, HttpStatus httpStatus) {
        this.mHeaders = aVar;
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(T t, a aVar, HttpStatus httpStatus) {
        this.mHeaders = aVar;
        this.mBody = t;
        this.mStatusCode = httpStatus;
    }

    public HttpStatus getStatusCode() {
        return this.mStatusCode;
    }

    public T getBody() {
        return this.mBody;
    }

    public List<String> getHeaderValue(String str) {
        if (this.mHeaders != null) {
            return this.mHeaders.get((Object) str);
        }
        return null;
    }

    public String getFirstHeaderValue(String str) {
        return this.mHeaders != null ? this.mHeaders.c(str) : "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.mStatusCode.toString());
        sb.append(' ');
        sb.append(this.mStatusCode.getReasonPhrase());
        sb.append(',');
        T body = getBody();
        a aVar = this.mHeaders;
        if (body != null) {
            sb.append(body);
            if (aVar != null) {
                sb.append(',');
            }
        }
        if (aVar != null) {
            sb.append(aVar);
        }
        sb.append('>');
        return sb.toString();
    }
}
