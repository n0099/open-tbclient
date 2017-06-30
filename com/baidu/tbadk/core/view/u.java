package com.baidu.tbadk.core.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnTouchListener {
    final /* synthetic */ o ako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.ako = oVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        if (view == null || motionEvent == null) {
            return false;
        }
        popupWindow = this.ako.ajQ;
        if (popupWindow == null) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (x >= 0) {
                popupWindow2 = this.ako.ajQ;
                if (x < popupWindow2.getWidth() && y >= 0) {
                    popupWindow3 = this.ako.ajQ;
                    if (y < popupWindow3.getHeight()) {
                        return false;
                    }
                }
            }
            this.ako.wt();
            return true;
        }
        return false;
    }
}
