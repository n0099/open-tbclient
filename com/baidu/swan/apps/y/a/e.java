package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes9.dex */
public class e extends c {
    final boolean doH;
    final f doI;

    public e(f fVar, boolean z) {
        super(6);
        this.doH = z;
        this.doI = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aCY() {
        com.baidu.swan.apps.scheme.actions.m.d ajc;
        if (this.doI == null || (ajc = this.doI.ajc()) == null) {
            return null;
        }
        return ajc.cLr;
    }

    public boolean isAdd() {
        return this.doH;
    }
}
