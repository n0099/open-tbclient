package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes8.dex */
public class e extends c {
    final boolean cEx;
    final f cEy;

    public e(f fVar, boolean z) {
        super(6);
        this.cEx = z;
        this.cEy = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String auM() {
        com.baidu.swan.apps.scheme.actions.m.d aaY;
        if (this.cEy == null || (aaY = this.cEy.aaY()) == null) {
            return null;
        }
        return aaY.caY;
    }

    public boolean isAdd() {
        return this.cEx;
    }
}
