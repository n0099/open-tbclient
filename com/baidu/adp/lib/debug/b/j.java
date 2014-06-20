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
        TextView textView;
        Context context;
        boolean z3;
        boolean z4;
        StringBuilder sb = new StringBuilder("LCS Blocker: Going to ");
        z = c.p;
        BdLog.d(sb.append(!z ? "block " : "unblock ").append("LCS").toString());
        z2 = c.p;
        c.p = !z2;
        textView = this.a.o;
        context = this.a.k;
        Activity activity = (Activity) context;
        z3 = c.p;
        textView.setText(activity.getText(z3 ? com.baidu.adp.f.item_close : com.baidu.adp.f.item_open));
        StringBuilder sb2 = new StringBuilder("LCS Blocker: Done: ");
        z4 = c.p;
        BdLog.d(sb2.append(!z4 ? "unblock " : "block ").append("LCS").toString());
    }
}
