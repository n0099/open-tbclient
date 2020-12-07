package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes25.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void akm() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void akn() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long ako() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void bQ(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bR(long j) {
        if (!com.baidu.swan.apps.t.a.azN().akT()) {
            if (com.baidu.swan.apps.core.k.a.atL()) {
                return com.baidu.swan.apps.core.k.a.cUc + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cUe + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean akp() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] akq() {
        return null;
    }
}
