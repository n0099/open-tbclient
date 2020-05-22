package com.baidu.swan.apps.aa.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes11.dex */
public class e extends c {
    final boolean cpJ;
    final f cpK;

    public e(f fVar, boolean z) {
        super(6);
        this.cpJ = z;
        this.cpK = fVar;
    }

    @Override // com.baidu.swan.apps.aa.a.c
    public String aks() {
        com.baidu.swan.apps.scheme.actions.m.d Tl;
        if (this.cpK == null || (Tl = this.cpK.Tl()) == null) {
            return null;
        }
        return Tl.bPG;
    }

    public boolean isAdd() {
        return this.cpJ;
    }
}
