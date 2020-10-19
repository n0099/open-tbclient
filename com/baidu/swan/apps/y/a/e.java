package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes10.dex */
public class e extends c {
    final boolean cSA;
    final f cSB;

    public e(f fVar, boolean z) {
        super(6);
        this.cSA = z;
        this.cSB = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String ayg() {
        com.baidu.swan.apps.scheme.actions.m.d aet;
        if (this.cSB == null || (aet = this.cSB.aet()) == null) {
            return null;
        }
        return aet.cpq;
    }

    public boolean isAdd() {
        return this.cSA;
    }
}
