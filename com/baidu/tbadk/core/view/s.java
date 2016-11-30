package com.baidu.tbadk.core.view;

import android.content.Context;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.agb = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Context context;
        o oVar = this.agb;
        context = this.agb.mContext;
        oVar.b(context, 1.0f);
    }
}
