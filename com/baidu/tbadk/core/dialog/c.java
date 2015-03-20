package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final a Lr;
    final /* synthetic */ a Rm;
    private final d Ro;

    public c(a aVar, a aVar2, d dVar) {
        this.Rm = aVar;
        this.Lr = aVar2;
        this.Ro = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ro != null) {
            this.Ro.onClick(this.Lr);
        }
    }
}
