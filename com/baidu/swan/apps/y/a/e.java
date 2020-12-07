package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes25.dex */
public class e extends c {
    final boolean dml;
    final f dmm;

    public e(f fVar, boolean z) {
        super(6);
        this.dml = z;
        this.dmm = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aFb() {
        com.baidu.swan.apps.scheme.actions.m.d aln;
        if (this.dmm == null || (aln = this.dmm.aln()) == null) {
            return null;
        }
        return aln.cIW;
    }

    public boolean isAdd() {
        return this.dml;
    }
}
