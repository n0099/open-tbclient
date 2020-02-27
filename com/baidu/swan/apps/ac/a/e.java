package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean bFY;
    final f bFZ;

    public e(f fVar, boolean z) {
        super(6);
        this.bFY = z;
        this.bFZ = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String YP() {
        com.baidu.swan.apps.scheme.actions.m.d IR;
        if (this.bFZ == null || (IR = this.bFZ.IR()) == null) {
            return null;
        }
        return IR.bil;
    }

    public boolean isAdd() {
        return this.bFY;
    }
}
