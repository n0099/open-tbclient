package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e Rw;
    private final /* synthetic */ int Rx;
    private final /* synthetic */ TextView Ry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, int i, TextView textView) {
        this.Rw = eVar;
        this.Rx = i;
        this.Ry = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        hVar = this.Rw.Rq;
        hVar.itemClick(this.Rw, this.Rx, this.Ry);
    }
}
