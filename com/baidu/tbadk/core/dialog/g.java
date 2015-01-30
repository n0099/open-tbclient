package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ e FK;
    private final e FL;
    private final h FM;

    public g(e eVar, e eVar2, h hVar) {
        this.FK = eVar;
        this.FL = eVar2;
        this.FM = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FM != null) {
            this.FM.onClick(this.FL);
        }
    }
}
