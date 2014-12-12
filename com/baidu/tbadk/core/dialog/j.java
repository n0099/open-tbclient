package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i FP;
    private final /* synthetic */ TextView FQ;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, TextView textView) {
        this.FP = iVar;
        this.val$position = i;
        this.FQ = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        lVar = this.FP.FJ;
        lVar.itemClick(this.FP, this.val$position, this.FQ);
    }
}
