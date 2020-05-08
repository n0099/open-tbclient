package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.al;
/* loaded from: classes11.dex */
public class c implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean Qr() {
        return !b.asg().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean Qs() {
        return Qr() || com.baidu.swan.e.b.aEJ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void a(com.baidu.swan.apps.core.j.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.asg().getDownloadUrl());
        b.asg().b(cVar);
    }
}
