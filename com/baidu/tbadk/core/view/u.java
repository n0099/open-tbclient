package com.baidu.tbadk.core.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnTouchListener {
    final /* synthetic */ o ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.ajL = oVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        if (view == null || motionEvent == null) {
            return false;
        }
        popupWindow = this.ajL.ajs;
        if (popupWindow == null) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (x >= 0) {
                popupWindow2 = this.ajL.ajs;
                if (x < popupWindow2.getWidth() && y >= 0) {
                    popupWindow3 = this.ajL.ajs;
                    if (y < popupWindow3.getHeight()) {
                        return false;
                    }
                }
            }
            this.ajL.wf();
            return true;
        }
        return false;
    }
}
