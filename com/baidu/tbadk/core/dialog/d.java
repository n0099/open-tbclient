package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c aax;
    private final /* synthetic */ int aay;
    private final /* synthetic */ TextView aaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.aax = cVar;
        this.aay = i;
        this.aaz = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.aax.aao;
        bVar.a(this.aax, this.aay, this.aaz);
    }
}
