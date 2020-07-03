package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.aj;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class s implements aj {
    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void Tw() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void Tx() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public long Ty() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void aJ(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public String aK(long j) {
        if (!com.baidu.swan.apps.u.a.agI().Ub()) {
            if (com.baidu.swan.apps.core.k.a.abS()) {
                return com.baidu.swan.apps.core.k.a.ceh + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cej + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
