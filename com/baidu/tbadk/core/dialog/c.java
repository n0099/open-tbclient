package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a Fw;
    private final a Fy;
    private final d Fz;

    public c(a aVar, a aVar2, d dVar) {
        this.Fw = aVar;
        this.Fy = aVar2;
        this.Fz = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Fz != null) {
            this.Fz.onClick(this.Fy);
        }
    }
}
