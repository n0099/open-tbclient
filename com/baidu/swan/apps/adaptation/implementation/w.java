package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes10.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void afm() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void afn() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long afo() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aV(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String aW(long j) {
        if (!com.baidu.swan.apps.t.a.auN().afT()) {
            if (com.baidu.swan.apps.core.k.a.aoK()) {
                return com.baidu.swan.apps.core.k.a.cJa + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cJc + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean afp() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] afq() {
        return null;
    }
}
