package com.baidu.swan.apps.adaptation.implementation;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.adaptation.a.n {
    @Override // com.baidu.swan.apps.adaptation.a.n
    public InputStream k(InputStream inputStream) throws IOException {
        return new org.brotli.dec.b(inputStream);
    }
}
