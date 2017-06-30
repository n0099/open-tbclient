package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PopupWindow.OnDismissListener {
    final /* synthetic */ o ako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.ako = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.ako.akc;
        if (popupWindow != null) {
            popupWindow2 = this.ako.akc;
            popupWindow2.dismiss();
            this.ako.akc = null;
        }
    }
}
