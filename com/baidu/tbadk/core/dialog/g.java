package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ e FF;
    private final e FG;
    private final h FH;

    public g(e eVar, e eVar2, h hVar) {
        this.FF = eVar;
        this.FG = eVar2;
        this.FH = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FH != null) {
            this.FH.onClick(this.FG);
        }
    }
}
