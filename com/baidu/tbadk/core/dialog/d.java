package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c aaN;
    private final /* synthetic */ int aaO;
    private final /* synthetic */ TextView aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.aaN = cVar;
        this.aaO = i;
        this.aaP = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.aaN.aaE;
        bVar.a(this.aaN, this.aaO, this.aaP);
    }
}
