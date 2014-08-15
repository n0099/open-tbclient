package com.baidu.tbadk.core.dialog;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;
    private final a b;
    private final d c;

    public c(a aVar, a aVar2, d dVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c != null) {
            this.c.onClick(this.b);
        }
    }
}
