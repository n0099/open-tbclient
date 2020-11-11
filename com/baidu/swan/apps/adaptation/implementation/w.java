package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes10.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahM() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahN() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long ahO() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void br(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bs(long j) {
        if (!com.baidu.swan.apps.t.a.axn().ait()) {
            if (com.baidu.swan.apps.core.k.a.arl()) {
                return com.baidu.swan.apps.core.k.a.cOT + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cOV + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean ahP() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] ahQ() {
        return null;
    }
}
