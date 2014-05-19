package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        TextView textView;
        Context context;
        boolean z4;
        boolean z5;
        StringBuilder sb = new StringBuilder("LCS Blocker: Going to ");
        z = c.p;
        BdLog.d(sb.append(!z ? "block " : "unblock ").append("LCS").toString());
        com.baidu.adp.framework.c.c a = com.baidu.adp.framework.c.c.a();
        z2 = c.p;
        a.a(!z2);
        z3 = c.p;
        c.p = z3 ? false : true;
        textView = this.a.o;
        context = this.a.k;
        Activity activity = (Activity) context;
        z4 = c.p;
        textView.setText(activity.getText(z4 ? com.baidu.adp.f.item_close : com.baidu.adp.f.item_open));
        StringBuilder sb2 = new StringBuilder("LCS Blocker: Done: ");
        z5 = c.p;
        BdLog.d(sb2.append(!z5 ? "unblock " : "block ").append("LCS").toString());
    }
}
