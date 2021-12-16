package com.baidu.fsg.base.restnet.rest;

import com.baidu.fsg.base.restnet.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public interface e {
    com.baidu.fsg.base.restnet.http.a a();

    int b() throws IOException;

    String c() throws IOException;

    void close();

    InputStream d() throws IOException;

    HttpStatus getStatusCode() throws Exception;
}
