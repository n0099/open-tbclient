package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes8.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean akT() {
        return !b.aSd().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean akU() {
        return akT() || com.baidu.swan.apps.env.b.c.cXM.oC("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aSd().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b akV() {
        return b.aSd().akV();
    }
}
