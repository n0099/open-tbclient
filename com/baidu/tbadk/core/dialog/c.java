package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a Bj;
    private final a Bl;
    private final d Bm;

    public c(a aVar, a aVar2, d dVar) {
        this.Bj = aVar;
        this.Bl = aVar2;
        this.Bm = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bm != null) {
            this.Bm.onClick(this.Bl);
        }
    }
}
