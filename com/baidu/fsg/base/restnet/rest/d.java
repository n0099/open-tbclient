package com.baidu.fsg.base.restnet.rest;

import com.baidu.fsg.base.restnet.http.HttpDefines;
/* loaded from: classes5.dex */
public interface d {
    com.baidu.fsg.base.restnet.http.a a();

    void a(int i2);

    void a(String str);

    String b();

    String c();

    void close();

    int d();

    e execute() throws Exception;

    HttpDefines.HttpMethod getMethod();

    String getUrl();
}
