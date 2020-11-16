package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes8.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ahL() {
        return !b.aOY().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ahM() {
        return ahL() || com.baidu.swan.apps.env.b.c.cQT.nT("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aOY().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b ahN() {
        return b.aOY().ahN();
    }
}
