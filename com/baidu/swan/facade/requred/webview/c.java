package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes11.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean IB() {
        return !b.ajU().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean IC() {
        return IB() || com.baidu.swan.e.b.awt();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.ajU().getDownloadUrl());
        b.ajU().b(cVar);
    }
}
