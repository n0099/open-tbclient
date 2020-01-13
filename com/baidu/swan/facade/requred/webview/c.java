package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes10.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean Gm() {
        return !b.ahG().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean Gn() {
        return Gm() || com.baidu.swan.e.b.auf();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.ahG().getDownloadUrl());
        b.ahG().b(cVar);
    }
}
