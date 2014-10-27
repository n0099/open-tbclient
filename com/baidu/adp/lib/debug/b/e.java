package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        Context context;
        TextView textView2;
        Context context2;
        if (!com.baidu.adp.lib.debug.d.gi) {
            com.baidu.adp.lib.debug.d.gi = true;
            textView2 = this.hm.hc;
            context2 = this.hm.mContext;
            textView2.setText(((Activity) context2).getText(R.string.item_open));
            this.hm.cT();
            return;
        }
        com.baidu.adp.lib.debug.d.gi = false;
        textView = this.hm.hc;
        context = this.hm.mContext;
        textView.setText(((Activity) context).getText(R.string.item_close));
        this.hm.cU();
    }
}
