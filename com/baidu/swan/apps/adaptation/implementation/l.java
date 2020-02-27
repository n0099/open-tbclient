package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void HJ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void HK() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long HL() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void aa(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String ab(long j) {
        if (!com.baidu.swan.apps.w.a.UG().IB()) {
            if (com.baidu.swan.apps.core.j.a.PZ()) {
                return com.baidu.swan.apps.core.j.a.brf + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.brh + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
