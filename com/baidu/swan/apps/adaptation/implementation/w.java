package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes3.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aaG() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aaH() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long aaI() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void aL(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String aM(long j) {
        if (!com.baidu.swan.apps.t.a.aqh().abn()) {
            if (com.baidu.swan.apps.core.k.a.akf()) {
                return com.baidu.swan.apps.core.k.a.cop + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cor + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean aaJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] aaK() {
        return null;
    }
}
