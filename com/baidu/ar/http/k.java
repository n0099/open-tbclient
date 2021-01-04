package com.baidu.ar.http;

import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
interface k {
    void a(Charset charset);

    InputStream[] eI();

    String getContentType();

    int getSize();
}
