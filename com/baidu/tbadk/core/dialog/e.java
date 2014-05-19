package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ int b;
    private final /* synthetic */ Button c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i, Button button) {
        this.a = dVar;
        this.b = i;
        this.c = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        gVar = this.a.c;
        gVar.a(this.a, this.b, this.c);
    }
}
