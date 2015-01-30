package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i FU;
    private final /* synthetic */ int FV;
    private final /* synthetic */ TextView FW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, TextView textView) {
        this.FU = iVar;
        this.FV = i;
        this.FW = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        lVar = this.FU.FO;
        lVar.itemClick(this.FU, this.FV, this.FW);
    }
}
