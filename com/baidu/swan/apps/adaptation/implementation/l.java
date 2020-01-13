package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes10.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void Fu() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void Fv() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long Fw() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void W(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String X(long j) {
        if (!com.baidu.swan.apps.w.a.Ss().Gm()) {
            if (com.baidu.swan.apps.core.j.a.NL()) {
                return com.baidu.swan.apps.core.j.a.bmW + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.bmY + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
