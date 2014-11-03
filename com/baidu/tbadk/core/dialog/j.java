package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i BF;
    private final /* synthetic */ int BG;
    private final /* synthetic */ TextView BH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, TextView textView) {
        this.BF = iVar;
        this.BG = i;
        this.BH = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        lVar = this.BF.By;
        lVar.a(this.BF, this.BG, this.BH);
    }
}
