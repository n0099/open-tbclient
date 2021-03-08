package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes8.dex */
public class e extends c {
    final boolean dqj;
    final f dqk;

    public e(f fVar, boolean z) {
        super(6);
        this.dqj = z;
        this.dqk = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aDb() {
        com.baidu.swan.apps.scheme.actions.m.d ajf;
        if (this.dqk == null || (ajf = this.dqk.ajf()) == null) {
            return null;
        }
        return ajf.cMR;
    }

    public boolean isAdd() {
        return this.dqj;
    }
}
