package com.baidu.swan.apps.ac.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean cfb;
    final f cfc;

    public e(f fVar, boolean z) {
        super(6);
        this.cfb = z;
        this.cfc = fVar;
    }

    @Override // com.baidu.swan.apps.ac.a.c
    public String agZ() {
        com.baidu.swan.apps.scheme.actions.m.d QH;
        if (this.cfc == null || (QH = this.cfc.QH()) == null) {
            return null;
        }
        return QH.bGO;
    }

    public boolean isAdd() {
        return this.cfb;
    }
}
