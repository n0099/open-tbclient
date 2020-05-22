package com.baidu.swan.apps.adaptation.implementation;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.adaptation.a.m {
    @Override // com.baidu.swan.apps.adaptation.a.m
    public InputStream j(InputStream inputStream) throws IOException {
        return new org.brotli.dec.b(inputStream);
    }
}
