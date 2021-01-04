package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes9.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void alu() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void alv() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long alw() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void bR(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bS(long j) {
        if (!com.baidu.swan.apps.t.a.aBe().amd()) {
            if (com.baidu.swan.apps.core.k.a.avc()) {
                return com.baidu.swan.apps.core.k.a.cYY + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cZa + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean alx() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] aly() {
        return null;
    }
}
