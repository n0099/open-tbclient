package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.ajL = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.ajL.ajB;
        if (popupWindow != null) {
            popupWindow2 = this.ajL.ajB;
            popupWindow2.dismiss();
            this.ajL.ajB = null;
        }
    }
}
