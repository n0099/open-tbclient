package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
        if (!com.baidu.adp.lib.debug.d.gj) {
            com.baidu.adp.lib.debug.d.gj = true;
            textView2 = this.hm.hd;
            context5 = this.hm.mContext;
            textView2.setText(((Activity) context5).getText(R.string.item_open));
            context6 = this.hm.mContext;
            context7 = this.hm.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(context7.getText(R.string.capture_package_swtich).toString()));
            context8 = this.hm.mContext;
            Toast.makeText(context6, sb.append(context8.getText(R.string.item_open).toString()).toString(), 1).show();
            return;
        }
        com.baidu.adp.lib.debug.d.gj = false;
        textView = this.hm.hd;
        context = this.hm.mContext;
        textView.setText(((Activity) context).getText(R.string.item_close));
        context2 = this.hm.mContext;
        context3 = this.hm.mContext;
        StringBuilder sb2 = new StringBuilder(String.valueOf(context3.getText(R.string.capture_package_swtich).toString()));
        context4 = this.hm.mContext;
        Toast.makeText(context2, sb2.append(context4.getText(R.string.item_close).toString()).toString(), 1).show();
    }
}
