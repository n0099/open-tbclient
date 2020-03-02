package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes11.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean ID() {
        return !b.ajW().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean IE() {
        return ID() || com.baidu.swan.e.b.awv();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.ajW().getDownloadUrl());
        b.ajW().b(cVar);
    }
}
