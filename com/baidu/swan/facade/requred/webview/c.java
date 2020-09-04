package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes20.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aaE() {
        return !b.aHT().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aaF() {
        return aaE() || com.baidu.swan.apps.env.b.c.cqa.mn("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aHT().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aaG() {
        return b.aHT().aaG();
    }
}
