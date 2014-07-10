package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e a;
    private final /* synthetic */ int b;
    private final /* synthetic */ TextView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, int i, TextView textView) {
        this.a = eVar;
        this.b = i;
        this.c = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        hVar = this.a.c;
        hVar.a(this.a, this.b, this.c);
    }
}
