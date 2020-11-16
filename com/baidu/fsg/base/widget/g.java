package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardPopupWindow f1553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f1553a = safeKeyBoardPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageButton imageButton;
        if (motionEvent.getAction() == 0) {
            this.f1553a.d();
            return false;
        } else if (motionEvent.getAction() == 1) {
            this.f1553a.c();
            return false;
        } else if (motionEvent.getAction() == 2) {
            imageButton = this.f1553a.k;
            if (!imageButton.isPressed()) {
                this.f1553a.c();
                return false;
            }
            return false;
        } else {
            return false;
        }
    }
}
