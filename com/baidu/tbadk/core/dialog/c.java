package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final a Ll;
    final /* synthetic */ a RN;
    private final d RP;

    public c(a aVar, a aVar2, d dVar) {
        this.RN = aVar;
        this.Ll = aVar2;
        this.RP = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.RP != null) {
            this.RP.onClick(this.Ll);
        }
    }
}
