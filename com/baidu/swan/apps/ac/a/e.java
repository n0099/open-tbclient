package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean bGl;
    final f bGm;

    public e(f fVar, boolean z) {
        super(6);
        this.bGl = z;
        this.bGm = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String YU() {
        com.baidu.swan.apps.scheme.actions.m.d IW;
        if (this.bGm == null || (IW = this.bGm.IW()) == null) {
            return null;
        }
        return IW.biB;
    }

    public boolean isAdd() {
        return this.bGl;
    }
}
