package com.baidu.ar.ihttp;

import java.io.InputStream;
/* loaded from: classes9.dex */
public interface IHttpResponse {
    int getCode();

    String getContent();

    int getContentLength();

    String getHeader(String str);

    String getMessage();

    InputStream getStream();

    boolean isSuccess();
}
