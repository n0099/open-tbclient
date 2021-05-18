package com.baidu.apollon.restnet;

import com.baidu.apollon.restnet.http.HttpStatus;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class RestResponseEntity<T> {

    /* renamed from: a  reason: collision with root package name */
    public final HttpStatus f3816a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f3817b;

    /* renamed from: c  reason: collision with root package name */
    public T f3818c;

    /* renamed from: d  reason: collision with root package name */
    public String f3819d;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.f3816a = httpStatus;
    }

    public HttpStatus a() {
        return this.f3816a;
    }

    public String b(String str) {
        com.baidu.apollon.restnet.http.a aVar = this.f3817b;
        return aVar != null ? aVar.c(str) : "";
    }

    public void c(String str) {
        this.f3819d = str;
    }

    public T getBody() {
        return this.f3818c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f3816a.toString());
        sb.append(' ');
        sb.append(this.f3816a.getReasonPhrase());
        sb.append(',');
        T body = getBody();
        com.baidu.apollon.restnet.http.a aVar = this.f3817b;
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
        com.baidu.apollon.restnet.http.a aVar = this.f3817b;
        if (aVar != null) {
            return aVar.get((Object) str);
        }
        return null;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.f3816a = httpStatus;
        this.f3818c = t;
    }

    public String b() {
        return this.f3819d;
    }

    public RestResponseEntity(com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        this.f3817b = aVar;
        this.f3816a = httpStatus;
    }

    public RestResponseEntity(T t, com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        this.f3817b = aVar;
        this.f3818c = t;
        this.f3816a = httpStatus;
    }
}
