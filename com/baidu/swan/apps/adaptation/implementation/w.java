package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes8.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahB() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahC() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long ahD() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void bR(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bS(long j) {
        if (!com.baidu.swan.apps.t.a.axl().aik()) {
            if (com.baidu.swan.apps.core.k.a.ari()) {
                return com.baidu.swan.apps.core.k.a.cUm + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cUo + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean ahE() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] ahF() {
        return null;
    }
}
