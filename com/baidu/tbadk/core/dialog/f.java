package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ TextView RA;
    final /* synthetic */ e Ry;
    private final /* synthetic */ int Rz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, int i, TextView textView) {
        this.Ry = eVar;
        this.Rz = i;
        this.RA = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        hVar = this.Ry.Rs;
        hVar.itemClick(this.Ry, this.Rz, this.RA);
    }
}
