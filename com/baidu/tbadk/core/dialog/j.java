package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i FR;
    private final /* synthetic */ int FS;
    private final /* synthetic */ TextView FT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, TextView textView) {
        this.FR = iVar;
        this.FS = i;
        this.FT = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        lVar = this.FR.FL;
        lVar.itemClick(this.FR, this.FS, this.FT);
    }
}
