package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes7.dex */
public class w implements ap {
    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahe() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void ahf() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public long ahg() {
        return -1L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public void br(long j) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String bs(long j) {
        if (!com.baidu.swan.apps.t.a.awF().ahL()) {
            if (com.baidu.swan.apps.core.k.a.aqD()) {
                return com.baidu.swan.apps.core.k.a.cNj + File.separator + GlobalConstants.LIB_ZEUS;
            }
            return com.baidu.swan.apps.core.k.a.cNl + File.separator + GlobalConstants.LIB_ZEUS;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public boolean ahh() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public String[] ahi() {
        return null;
    }
}
