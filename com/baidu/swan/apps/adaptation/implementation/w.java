package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes10.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ads() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void adt() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long adu() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aT(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String aU(long j) {
        if (!com.baidu.swan.apps.t.a.asT().adZ()) {
            if (com.baidu.swan.apps.core.k.a.amQ()) {
                return com.baidu.swan.apps.core.k.a.cAE + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cAG + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean adv() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] adw() {
        return null;
    }
}
