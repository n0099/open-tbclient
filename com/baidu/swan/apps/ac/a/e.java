package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes10.dex */
public class e extends c {
    final boolean bBS;
    final f bBT;

    public e(f fVar, boolean z) {
        super(6);
        this.bBS = z;
        this.bBT = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String WB() {
        com.baidu.swan.apps.scheme.actions.m.d GC;
        if (this.bBT == null || (GC = this.bBT.GC()) == null) {
            return null;
        }
        return GC.bdW;
    }

    public boolean isAdd() {
        return this.bBS;
    }
}
