package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void PA() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void PB() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long PC() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void aE(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String aF(long j) {
        if (!com.baidu.swan.apps.w.a.acA().Qs()) {
            if (com.baidu.swan.apps.core.j.a.XT()) {
                return com.baidu.swan.apps.core.j.a.bPA + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.bPC + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
