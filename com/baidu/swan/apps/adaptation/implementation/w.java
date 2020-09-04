package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes8.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ZX() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ZY() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long ZZ() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aK(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String aL(long j) {
        if (!com.baidu.swan.apps.t.a.apx().aaE()) {
            if (com.baidu.swan.apps.core.k.a.ajv()) {
                return com.baidu.swan.apps.core.k.a.cmm + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cmo + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean aaa() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] aab() {
        return null;
    }
}
