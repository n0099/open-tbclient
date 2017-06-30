package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c aaj;
    private final /* synthetic */ int aak;
    private final /* synthetic */ TextView aal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.aaj = cVar;
        this.aak = i;
        this.aal = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.aaj.aaa;
        bVar.a(this.aaj, this.aak, this.aal);
    }
}
