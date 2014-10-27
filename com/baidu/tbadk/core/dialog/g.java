package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ e Bt;
    private final e Bu;
    private final h Bv;

    public g(e eVar, e eVar2, h hVar) {
        this.Bt = eVar;
        this.Bu = eVar2;
        this.Bv = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bv != null) {
            this.Bv.onClick(this.Bu);
        }
    }
}
