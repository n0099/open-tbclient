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
        TextView textView;
        Context context;
        boolean z2;
        boolean z3;
        z = c.p;
        c.p = !z;
        textView = this.a.o;
        context = this.a.k;
        Activity activity = (Activity) context;
        z2 = c.p;
        textView.setText(activity.getText(z2 ? com.baidu.adp.f.item_close : com.baidu.adp.f.item_open));
        StringBuilder sb = new StringBuilder("LCS Blocker: Done: ");
        z3 = c.p;
        BdLog.w(sb.append(!z3 ? "unblock " : "block ").append("LCS").toString());
    }
}
