package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c aaO;
    private final /* synthetic */ int aaP;
    private final /* synthetic */ TextView aaQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.aaO = cVar;
        this.aaP = i;
        this.aaQ = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.aaO.aaF;
        bVar.a(this.aaO, this.aaP, this.aaQ);
    }
}
