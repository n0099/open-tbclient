package com.baidu.adp.lib.debug.b;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.framework.c.c.a().a(-1, "Closed by Debug View");
        com.baidu.adp.framework.c.c.a().a(true, "Restart by Debug View");
    }
}
