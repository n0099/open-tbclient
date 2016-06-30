package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c Sw;
    private final /* synthetic */ int Sx;
    private final /* synthetic */ TextView Sy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.Sw = cVar;
        this.Sx = i;
        this.Sy = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.Sw.Sn;
        bVar.a(this.Sw, this.Sx, this.Sy);
    }
}
