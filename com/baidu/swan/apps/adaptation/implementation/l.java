package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes9.dex */
public class l implements ag {
    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void EY() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void EZ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public long Fa() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public void T(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ag
    public String U(long j) {
        if (!com.baidu.swan.apps.w.a.RW().FQ()) {
            if (com.baidu.swan.apps.core.j.a.Np()) {
                return com.baidu.swan.apps.core.j.a.bmg + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.j.a.bmi + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }
}
