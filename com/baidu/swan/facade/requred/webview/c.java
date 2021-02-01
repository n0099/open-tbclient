package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes3.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aiI() {
        return !b.aQX().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aiJ() {
        return aiI() || com.baidu.swan.apps.env.b.c.dac.nA("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aQX().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aiK() {
        return b.aQX().aiK();
    }
}
