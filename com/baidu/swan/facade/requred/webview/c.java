package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.ar;
/* loaded from: classes11.dex */
public class c implements ar {
    @Override // com.baidu.swan.apps.adaptation.a.ar
    public boolean Ub() {
        return !b.awV().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public boolean Uc() {
        return Ub() || com.baidu.swan.f.b.aLk();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public void a(com.baidu.swan.apps.core.k.c cVar) {
        com.baidu.swan.a.c.setDownloadUrl(b.awV().getDownloadUrl());
        b.awV().b(cVar);
    }
}
