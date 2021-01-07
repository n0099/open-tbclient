package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes9.dex */
public class e extends c {
    final boolean drk;
    final f drl;

    public e(f fVar, boolean z) {
        super(6);
        this.drk = z;
        this.drl = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aGw() {
        com.baidu.swan.apps.scheme.actions.m.d amy;
        if (this.drl == null || (amy = this.drl.amy()) == null) {
            return null;
        }
        return amy.cNP;
    }

    public boolean isAdd() {
        return this.drk;
    }
}
