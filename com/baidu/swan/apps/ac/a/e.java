package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean bGa;
    final f bGb;

    public e(f fVar, boolean z) {
        super(6);
        this.bGa = z;
        this.bGb = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String YR() {
        com.baidu.swan.apps.scheme.actions.m.d IT;
        if (this.bGb == null || (IT = this.bGb.IT()) == null) {
            return null;
        }
        return IT.bin;
    }

    public boolean isAdd() {
        return this.bGa;
    }
}
