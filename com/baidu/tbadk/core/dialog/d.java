package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c Vm;
    private final /* synthetic */ int Vn;
    private final /* synthetic */ TextView Vo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i, TextView textView) {
        this.Vm = cVar;
        this.Vn = i;
        this.Vo = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar;
        bVar = this.Vm.Vd;
        bVar.a(this.Vm, this.Vn, this.Vo);
    }
}
