package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes10.dex */
public class e extends c {
    final boolean daY;
    final f daZ;

    public e(f fVar, boolean z) {
        super(6);
        this.daY = z;
        this.daZ = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aAa() {
        com.baidu.swan.apps.scheme.actions.m.d agn;
        if (this.daZ == null || (agn = this.daZ.agn()) == null) {
            return null;
        }
        return agn.cxS;
    }

    public boolean isAdd() {
        return this.daY;
    }
}
