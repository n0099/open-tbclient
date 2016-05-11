package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c Sf;
    private final /* synthetic */ int Sg;
    private final /* synthetic */ TextView Sh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.Sf = cVar;
        this.Sg = i;
        this.Sh = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.Sf.RV;
        bVar.a(this.Sf, this.Sg, this.Sh);
    }
}
