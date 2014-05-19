package com.baidu.tbadk.core.dialog;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a a;
    private final a b;
    private final c c;

    public b(a aVar, a aVar2, c cVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c != null) {
            this.c.onClick(this.b);
        }
        this.a.c();
    }
}
