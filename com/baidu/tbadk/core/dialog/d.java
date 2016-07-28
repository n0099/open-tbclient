package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c Te;
    private final /* synthetic */ int Tf;
    private final /* synthetic */ TextView Tg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.Te = cVar;
        this.Tf = i;
        this.Tg = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.Te.SV;
        bVar.a(this.Te, this.Tf, this.Tg);
    }
}
