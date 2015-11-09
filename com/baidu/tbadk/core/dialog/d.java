package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c WW;
    private final /* synthetic */ TextView WX;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.WW = cVar;
        this.val$position = i;
        this.WX = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.WW.WP;
        bVar.itemClick(this.WW, this.val$position, this.WX);
    }
}
