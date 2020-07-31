package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.al;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes7.dex */
public class t implements al {
    @Override // com.baidu.swan.apps.adaptation.a.al
    public void TU() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void TV() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public long TW() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public void aJ(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public String aK(long j) {
        if (!com.baidu.swan.apps.t.a.ahV().UC()) {
            if (com.baidu.swan.apps.core.k.a.acW()) {
                return com.baidu.swan.apps.core.k.a.cfQ + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cfS + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public boolean TX() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.al
    public String[] TY() {
        return null;
    }
}
