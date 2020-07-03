package com.baidu.ar.http;

import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
interface k {
    void a(Charset charset);

    InputStream[] dz();

    String getContentType();

    int getSize();
}
