package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ e Bu;
    private final e Bv;
    private final h Bw;

    public g(e eVar, e eVar2, h hVar) {
        this.Bu = eVar;
        this.Bv = eVar2;
        this.Bw = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bw != null) {
            this.Bw.onClick(this.Bv);
        }
    }
}
