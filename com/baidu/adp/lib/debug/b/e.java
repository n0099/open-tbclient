package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Context context;
        TextView textView2;
        Context context2;
        if (!com.baidu.adp.lib.debug.b.d) {
            com.baidu.adp.lib.debug.b.d = true;
            textView2 = this.a.j;
            context2 = this.a.k;
            textView2.setText(((Activity) context2).getText(com.baidu.adp.f.item_open));
            this.a.b();
            return;
        }
        com.baidu.adp.lib.debug.b.d = false;
        textView = this.a.j;
        context = this.a.k;
        textView.setText(((Activity) context).getText(com.baidu.adp.f.item_close));
        this.a.c();
    }
}
