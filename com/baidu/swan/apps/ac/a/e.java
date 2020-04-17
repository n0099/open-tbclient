package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean ceV;
    final f ceW;

    public e(f fVar, boolean z) {
        super(6);
        this.ceV = z;
        this.ceW = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String aha() {
        com.baidu.swan.apps.scheme.actions.m.d QI;
        if (this.ceW == null || (QI = this.ceW.QI()) == null) {
            return null;
        }
        return QI.bGJ;
    }

    public boolean isAdd() {
        return this.ceV;
    }
}
