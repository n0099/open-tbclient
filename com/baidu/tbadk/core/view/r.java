package com.baidu.tbadk.core.view;

import android.content.Context;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements PopupWindow.OnDismissListener {
    final /* synthetic */ o afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.afB = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Context context;
        o oVar = this.afB;
        context = this.afB.mContext;
        oVar.b(context, 1.0f);
    }
}
