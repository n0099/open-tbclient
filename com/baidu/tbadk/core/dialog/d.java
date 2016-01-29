package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final /* synthetic */ int YA;
    private final /* synthetic */ TextView YB;
    final /* synthetic */ c Yz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.Yz = cVar;
        this.YA = i;
        this.YB = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.Yz.Ys;
        bVar.a(this.Yz, this.YA, this.YB);
    }
}
