package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o akn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.akn = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.akn.akd;
        if (popupWindow != null) {
            popupWindow2 = this.akn.akd;
            popupWindow2.dismiss();
            this.akn.akd = null;
        }
    }
}
