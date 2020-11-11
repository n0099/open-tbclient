package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes16.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ait() {
        return !b.aPG().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aiu() {
        return ait() || com.baidu.swan.apps.env.b.c.cSD.nZ("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aPG().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aiv() {
        return b.aPG().aiv();
    }
}
