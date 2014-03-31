package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        TextView textView2;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        if (!com.baidu.adp.lib.debug.c.e) {
            com.baidu.adp.lib.debug.c.e = true;
            textView2 = this.a.j;
            context5 = this.a.k;
            textView2.setText(((Activity) context5).getText(com.baidu.adp.f.item_open));
            context6 = this.a.k;
            context7 = this.a.k;
            StringBuilder sb = new StringBuilder(String.valueOf(context7.getText(com.baidu.adp.f.capture_package_swtich).toString()));
            context8 = this.a.k;
            Toast.makeText(context6, sb.append(context8.getText(com.baidu.adp.f.item_open).toString()).toString(), 1).show();
            return;
        }
        com.baidu.adp.lib.debug.c.e = false;
        textView = this.a.j;
        context = this.a.k;
        textView.setText(((Activity) context).getText(com.baidu.adp.f.item_close));
        context2 = this.a.k;
        context3 = this.a.k;
        StringBuilder sb2 = new StringBuilder(String.valueOf(context3.getText(com.baidu.adp.f.capture_package_swtich).toString()));
        context4 = this.a.k;
        Toast.makeText(context2, sb2.append(context4.getText(com.baidu.adp.f.item_close).toString()).toString(), 1).show();
    }
}
