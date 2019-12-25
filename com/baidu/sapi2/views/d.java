package com.baidu.sapi2.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* loaded from: classes4.dex */
class d implements View.OnClickListener {
    final /* synthetic */ View.OnClickListener a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f fVar, View.OnClickListener onClickListener) {
        this.b = fVar;
        this.a = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            context = this.b.i;
            ViewUtility.dismissDialog((Activity) context, this.b);
            this.a.onClick(view);
        } catch (Exception e) {
        }
    }
}
