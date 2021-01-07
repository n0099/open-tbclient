package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes6.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ame() {
        return !b.aUy().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean amf() {
        return ame() || com.baidu.swan.apps.env.b.c.dcH.ov("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aUy().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b amg() {
        return b.aUy().amg();
    }
}
