package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.au;
/* loaded from: classes4.dex */
public class c implements au {
    @Override // com.baidu.swan.apps.adaptation.a.au
    public boolean UC() {
        return !b.azJ().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.au
    public boolean UD() {
        return UC() || com.baidu.swan.e.b.aOY();
    }

    @Override // com.baidu.swan.apps.adaptation.a.au
    public void a(com.baidu.swan.apps.core.k.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.azJ().getDownloadUrl());
        b.azJ().b(cVar);
    }
}
