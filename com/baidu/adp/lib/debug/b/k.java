package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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
        Context context;
        String str;
        Context context2;
        context = this.a.k;
        String editable = ((EditText) ((Activity) context).findViewById(com.baidu.adp.d.switch_lcs_reOnline_lcs_address)).getText().toString();
        if (editable != null || editable.length() != 0) {
            if (!editable.startsWith("ws://")) {
                c.r = "ws://" + editable;
            } else {
                c.r = editable;
            }
        }
        com.baidu.adp.framework.c.c a = com.baidu.adp.framework.c.c.a();
        str = c.r;
        a.a(str);
        com.baidu.adp.framework.c.c.a().a(-1, "Closed by Debug View");
        com.baidu.adp.framework.c.c.a().h();
        com.baidu.adp.framework.c.c.a().a(true, "Restart by Debug View");
        context2 = this.a.k;
        Toast.makeText(context2, com.baidu.adp.f.lcsReOnlineSucc, 1);
    }
}
