package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c WT;
    private final /* synthetic */ TextView WU;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.WT = cVar;
        this.val$position = i;
        this.WU = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.WT.WM;
        bVar.itemClick(this.WT, this.val$position, this.WU);
    }
}
