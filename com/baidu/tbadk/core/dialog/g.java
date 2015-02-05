package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ e FH;
    private final e FI;
    private final h FJ;

    public g(e eVar, e eVar2, h hVar) {
        this.FH = eVar;
        this.FI = eVar2;
        this.FJ = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FJ != null) {
            this.FJ.onClick(this.FI);
        }
    }
}
