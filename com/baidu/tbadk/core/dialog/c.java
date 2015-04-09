package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final a Lt;
    final /* synthetic */ a Ro;
    private final d Rq;

    public c(a aVar, a aVar2, d dVar) {
        this.Ro = aVar;
        this.Lt = aVar2;
        this.Rq = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Rq != null) {
            this.Rq.onClick(this.Lt);
        }
    }
}
