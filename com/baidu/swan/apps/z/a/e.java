package com.baidu.swan.apps.z.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes7.dex */
public class e extends c {
    final f cwA;
    final boolean cwz;

    public e(f fVar, boolean z) {
        super(6);
        this.cwz = z;
        this.cwA = fVar;
    }

    @Override // com.baidu.swan.apps.z.a.c
    public String amP() {
        com.baidu.swan.apps.scheme.actions.m.d UT;
        if (this.cwA == null || (UT = this.cwA.UT()) == null) {
            return null;
        }
        return UT.bVm;
    }

    public boolean isAdd() {
        return this.cwz;
    }
}
