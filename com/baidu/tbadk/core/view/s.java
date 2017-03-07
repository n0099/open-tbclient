package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o ajZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.ajZ = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.ajZ.ajP;
        if (popupWindow != null) {
            popupWindow2 = this.ajZ.ajP;
            popupWindow2.dismiss();
            this.ajZ.ajP = null;
        }
    }
}
