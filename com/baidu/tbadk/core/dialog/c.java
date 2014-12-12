package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a Fu;
    private final a Fw;
    private final d Fx;

    public c(a aVar, a aVar2, d dVar) {
        this.Fu = aVar;
        this.Fw = aVar2;
        this.Fx = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Fx != null) {
            this.Fx.onClick(this.Fw);
        }
    }
}
