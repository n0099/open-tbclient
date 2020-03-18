package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void HO() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void HP() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long HQ() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void aa(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String ab(long j) {
        if (!com.baidu.swan.apps.w.a.UL().IG()) {
            if (com.baidu.swan.apps.core.j.a.Qe()) {
                return com.baidu.swan.apps.core.j.a.brt + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.brv + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
