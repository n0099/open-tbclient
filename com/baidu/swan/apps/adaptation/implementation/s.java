package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.aj;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class s implements aj {
    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void Sq() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void Sr() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public long Ss() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void aJ(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public String aK(long j) {
        if (!com.baidu.swan.apps.u.a.afC().SV()) {
            if (com.baidu.swan.apps.core.k.a.aaM()) {
                return com.baidu.swan.apps.core.k.a.bZr + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.bZt + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
