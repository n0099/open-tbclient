package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes16.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean adZ() {
        return !b.aLm().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean aea() {
        return adZ() || com.baidu.swan.apps.env.b.c.cEo.ns("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aLm().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b aeb() {
        return b.aLm().aeb();
    }
}
