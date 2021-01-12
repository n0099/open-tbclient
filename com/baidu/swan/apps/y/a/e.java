package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes8.dex */
public class e extends c {
    final boolean dmu;
    final f dmv;

    public e(f fVar, boolean z) {
        super(6);
        this.dmu = z;
        this.dmv = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aCC() {
        com.baidu.swan.apps.scheme.actions.m.d aiE;
        if (this.dmv == null || (aiE = this.dmv.aiE()) == null) {
            return null;
        }
        return aiE.cJd;
    }

    public boolean isAdd() {
        return this.dmu;
    }
}
