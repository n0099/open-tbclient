package com.baidu.swan.apps.y.a;

import com.baidu.swan.apps.adaptation.b.f;
/* loaded from: classes7.dex */
public class e extends c {
    final boolean dfm;
    final f dfn;

    public e(f fVar, boolean z) {
        super(6);
        this.dfm = z;
        this.dfn = fVar;
    }

    @Override // com.baidu.swan.apps.y.a.c
    public String aBS() {
        com.baidu.swan.apps.scheme.actions.m.d aif;
        if (this.dfn == null || (aif = this.dfn.aif()) == null) {
            return null;
        }
        return aif.cCb;
    }

    public boolean isAdd() {
        return this.dfm;
    }
}
