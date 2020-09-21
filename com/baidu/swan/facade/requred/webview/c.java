package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes3.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean abn() {
        return !b.aID().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean abo() {
        return abn() || com.baidu.swan.apps.env.b.c.csd.mG("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aID().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b abp() {
        return b.aID().abp();
    }
}
