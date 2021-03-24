package com.baidu.apollon.restnet;

import com.baidu.apollon.restnet.http.HttpStatus;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class RestResponseEntity<T> {

    /* renamed from: a  reason: collision with root package name */
    public final HttpStatus f3731a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f3732b;

    /* renamed from: c  reason: collision with root package name */
    public T f3733c;

    /* renamed from: d  reason: collision with root package name */
    public String f3734d;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.f3731a = httpStatus;
    }

    public HttpStatus a() {
        return this.f3731a;
    }

    public String b(String str) {
        com.baidu.apollon.restnet.http.a aVar = this.f3732b;
        return aVar != null ? aVar.c(str) : "";
    }

    public void c(String str) {
        this.f3734d = str;
    }

    public T getBody() {
        return this.f3733c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f3731a.toString());
        sb.append(' ');
        sb.append(this.f3731a.getReasonPhrase());
        sb.append(',');
        T body = getBody();
        com.baidu.apollon.restnet.http.a aVar = this.f3732b;
        if (body != null) {
            sb.append(body);
            if (aVar != null) {
                sb.append(',');
            }
        }
        if (aVar != null) {
            sb.append(aVar);
        }
        sb.append(Typography.greater);
        return sb.toString();
    }

    public List<String> a(String str) {
        com.baidu.apollon.restnet.http.a aVar = this.f3732b;
        if (aVar != null) {
            return aVar.get((Object) str);
        }
        return null;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.f3731a = httpStatus;
        this.f3733c = t;
    }

    public String b() {
        return this.f3734d;
    }

    public RestResponseEntity(com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        this.f3732b = aVar;
        this.f3731a = httpStatus;
    }

    public RestResponseEntity(T t, com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        this.f3732b = aVar;
        this.f3733c = t;
        this.f3731a = httpStatus;
    }
}
