package com.baidu.ar.http;

import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public interface k {
    void a(Charset charset);

    InputStream[] eI();

    String getContentType();

    int getSize();
}
