package com.baidu.swan.facade.requred.webview;

import com.baidu.swan.apps.adaptation.a.az;
/* loaded from: classes6.dex */
public class c implements az {
    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean amd() {
        return !b.aUx().isNeedDownload();
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public boolean ame() {
        return amd() || com.baidu.swan.apps.env.b.c.dcH.ov("zeus");
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public void a(boolean z, com.baidu.swan.apps.core.k.c cVar) {
        b.aUx().b(z, cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.az
    public com.baidu.swan.pms.e.b amf() {
        return b.aUx().amf();
    }
}
