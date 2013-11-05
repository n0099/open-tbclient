package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f466a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Context context;
        TextView textView2;
        Context context2;
        if (!com.baidu.adp.lib.debug.b.d) {
            com.baidu.adp.lib.debug.b.d = true;
            textView2 = this.f466a.j;
            context2 = this.f466a.k;
            textView2.setText(((Activity) context2).getText(com.baidu.adp.g.item_open));
            this.f466a.b();
            return;
        }
        com.baidu.adp.lib.debug.b.d = false;
        textView = this.f466a.j;
        context = this.f466a.k;
        textView.setText(((Activity) context).getText(com.baidu.adp.g.item_close));
        this.f466a.c();
    }
}
