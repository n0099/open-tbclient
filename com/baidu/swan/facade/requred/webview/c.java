package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes6.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aik() {
        return !b.aQE().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ail() {
        return aik() || com.baidu.swan.apps.env.b.c.cXS.ni("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aQE().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aim() {
        return b.aQE().aim();
    }
}
