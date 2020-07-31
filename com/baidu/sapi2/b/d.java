package com.baidu.sapi2.b;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        this.a.a();
        aVar = this.a.m;
        aVar.onCall(-2);
    }
}
