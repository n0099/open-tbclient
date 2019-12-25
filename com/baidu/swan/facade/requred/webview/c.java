package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes9.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean FQ() {
        return !b.ahn().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean FR() {
        return FQ() || com.baidu.swan.e.b.atM();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.ahn().getDownloadUrl());
        b.ahn().b(cVar);
    }
}
