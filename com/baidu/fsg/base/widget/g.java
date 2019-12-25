package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements View.OnTouchListener {
    final /* synthetic */ SafeKeyBoardPopupWindow a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.a = safeKeyBoardPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageButton imageButton;
        if (motionEvent.getAction() == 0) {
            this.a.d();
            return false;
        } else if (motionEvent.getAction() == 1) {
            this.a.c();
            return false;
        } else if (motionEvent.getAction() == 2) {
            imageButton = this.a.k;
            if (!imageButton.isPressed()) {
                this.a.c();
                return false;
            }
            return false;
        } else {
            return false;
        }
    }
}
