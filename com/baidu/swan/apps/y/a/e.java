package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes10.dex */
public class e extends c {
    final boolean dgT;
    final f dgU;

    public e(f fVar, boolean z) {
        super(6);
        this.dgT = z;
        this.dgU = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aCA() {
        com.baidu.swan.apps.scheme.actions.m.d aiN;
        if (this.dgU == null || (aiN = this.dgU.aiN()) == null) {
            return null;
        }
        return aiN.cDL;
    }

    public boolean isAdd() {
        return this.dgT;
    }
}
