package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final a FB;
    private final d FC;
    final /* synthetic */ a Fz;

    public c(a aVar, a aVar2, d dVar) {
        this.Fz = aVar;
        this.FB = aVar2;
        this.FC = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FC != null) {
            this.FC.onClick(this.FB);
        }
    }
}
