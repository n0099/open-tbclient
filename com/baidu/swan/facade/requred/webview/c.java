package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes16.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean afT() {
        return !b.aNg().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean afU() {
        return afT() || com.baidu.swan.apps.env.b.c.cMK.nL("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aNg().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b afV() {
        return b.aNg().afV();
    }
}
