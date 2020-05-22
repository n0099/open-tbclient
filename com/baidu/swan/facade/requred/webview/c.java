package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.ar;
/* loaded from: classes11.dex */
public class c implements ar {
    @Override // com.baidu.swan.apps.adaptation.a.ar
    public boolean SV() {
        return !b.avP().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public boolean SW() {
        return SV() || com.baidu.swan.f.b.aKe();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public void a(com.baidu.swan.apps.core.k.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.avP().getDownloadUrl());
        b.avP().b(cVar);
    }
}
