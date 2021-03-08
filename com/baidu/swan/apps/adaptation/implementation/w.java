package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes8.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aic() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aid() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long aie() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void bX(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bY(long j) {
        if (!com.baidu.swan.apps.t.a.axM().aiL()) {
            if (com.baidu.swan.apps.core.k.a.arJ()) {
                return com.baidu.swan.apps.core.k.a.cXZ + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cYb + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean aif() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] aig() {
        return null;
    }
}
