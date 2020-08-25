package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes8.dex */
public class e extends c {
    final boolean cEt;
    final f cEu;

    public e(f fVar, boolean z) {
        super(6);
        this.cEt = z;
        this.cEu = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String auM() {
        com.baidu.swan.apps.scheme.actions.m.d aaY;
        if (this.cEu == null || (aaY = this.cEu.aaY()) == null) {
            return null;
        }
        return aaY.caU;
    }

    public boolean isAdd() {
        return this.cEt;
    }
}
