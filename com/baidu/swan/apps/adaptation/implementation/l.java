package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void Pz() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void PA() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long PB() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void aE(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String aF(long j) {
        if (!com.baidu.swan.apps.w.a.acz().Qr()) {
            if (com.baidu.swan.apps.core.j.a.XS()) {
                return com.baidu.swan.apps.core.j.a.bPF + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.bPH + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
