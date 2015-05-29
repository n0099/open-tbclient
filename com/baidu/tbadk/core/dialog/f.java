package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e RX;
    private final /* synthetic */ int RY;
    private final /* synthetic */ TextView RZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, int i, TextView textView) {
        this.RX = eVar;
        this.RY = i;
        this.RZ = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        hVar = this.RX.RR;
        hVar.itemClick(this.RX, this.RY, this.RZ);
    }
}
