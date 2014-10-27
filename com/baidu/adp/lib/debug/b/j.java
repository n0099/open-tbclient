package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        Context context;
        boolean z2;
        boolean z3;
        z = c.hj;
        c.hj = !z;
        textView = this.hm.hi;
        context = this.hm.mContext;
        Activity activity = (Activity) context;
        z2 = c.hj;
        textView.setText(activity.getText(z2 ? R.string.item_close : R.string.item_open));
        StringBuilder sb = new StringBuilder("LCS Blocker: Done: ");
        z3 = c.hj;
        BdLog.w(sb.append(!z3 ? "unblock " : "block ").append("LCS").toString());
    }
}
