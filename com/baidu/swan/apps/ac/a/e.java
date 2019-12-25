package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes9.dex */
public class e extends c {
    final boolean bBg;
    final f bBh;

    public e(f fVar, boolean z) {
        super(6);
        this.bBg = z;
        this.bBh = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String We() {
        com.baidu.swan.apps.scheme.actions.m.d Gg;
        if (this.bBh == null || (Gg = this.bBh.Gg()) == null) {
            return null;
        }
        return Gg.bdi;
    }

    public boolean isAdd() {
        return this.bBg;
    }
}
