package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i BE;
    private final /* synthetic */ int BF;
    private final /* synthetic */ TextView BG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, TextView textView) {
        this.BE = iVar;
        this.BF = i;
        this.BG = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        lVar = this.BE.Bx;
        lVar.a(this.BE, this.BF, this.BG);
    }
}
