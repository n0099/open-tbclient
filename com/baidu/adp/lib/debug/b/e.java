package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f157a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Context context;
        TextView textView2;
        Context context2;
        if (!com.baidu.adp.lib.debug.b.d) {
            com.baidu.adp.lib.debug.b.d = true;
            textView2 = this.f157a.j;
            context2 = this.f157a.k;
            textView2.setText(((Activity) context2).getText(com.baidu.adp.g.item_open));
            this.f157a.b();
            return;
        }
        com.baidu.adp.lib.debug.b.d = false;
        textView = this.f157a.j;
        context = this.f157a.k;
        textView.setText(((Activity) context).getText(com.baidu.adp.g.item_close));
        this.f157a.c();
    }
}
