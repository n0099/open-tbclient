package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o ajB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.ajB = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.ajB.ajr;
        if (popupWindow != null) {
            popupWindow2 = this.ajB.ajr;
            popupWindow2.dismiss();
            this.ajB.ajr = null;
        }
    }
}
