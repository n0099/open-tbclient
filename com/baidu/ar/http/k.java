package com.baidu.ar.http;

import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes12.dex */
interface k {
    void a(Charset charset);

    InputStream[] eJ();

    String getContentType();

    int getSize();
}
