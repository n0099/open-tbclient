package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes3.dex */
public class e extends c {
    final boolean cGx;
    final f cGy;

    public e(f fVar, boolean z) {
        super(6);
        this.cGx = z;
        this.cGy = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String avv() {
        com.baidu.swan.apps.scheme.actions.m.d abH;
        if (this.cGy == null || (abH = this.cGy.abH()) == null) {
            return null;
        }
        return abH.cda;
    }

    public boolean isAdd() {
        return this.cGx;
    }
}
