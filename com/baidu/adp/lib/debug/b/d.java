package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            com.baidu.adp.lib.debug.d.gh = false;
            context = this.hm.mContext;
            ((Activity) context).finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
