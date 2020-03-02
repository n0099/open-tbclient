package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean bFZ;
    final f bGa;

    public e(f fVar, boolean z) {
        super(6);
        this.bFZ = z;
        this.bGa = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String YR() {
        com.baidu.swan.apps.scheme.actions.m.d IT;
        if (this.bGa == null || (IT = this.bGa.IT()) == null) {
            return null;
        }
        return IT.bim;
    }

    public boolean isAdd() {
        return this.bFZ;
    }
}
