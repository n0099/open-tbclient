package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes3.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aiL() {
        return !b.aRa().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aiM() {
        return aiL() || com.baidu.swan.apps.env.b.c.dbF.nH("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aRa().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aiN() {
        return b.aRa().aiN();
    }
}
