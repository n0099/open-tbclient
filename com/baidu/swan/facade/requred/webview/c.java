package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes11.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean IG() {
        return !b.ajZ().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean IH() {
        return IG() || com.baidu.swan.e.b.awy();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.ajZ().getDownloadUrl());
        b.ajZ().b(cVar);
    }
}
