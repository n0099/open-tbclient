package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes9.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahZ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aia() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long aib() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void bX(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bY(long j) {
        if (!com.baidu.swan.apps.t.a.axJ().aiI()) {
            if (com.baidu.swan.apps.core.k.a.arG()) {
                return com.baidu.swan.apps.core.k.a.cWz + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cWB + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean aic() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] aid() {
        return null;
    }
}
