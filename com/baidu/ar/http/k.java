package com.baidu.ar.http;

import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public interface k {
    void a(Charset charset);

    InputStream[] eI();

    String getContentType();

    int getSize();
}
