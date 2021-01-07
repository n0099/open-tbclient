package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardPopupWindow f2091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f2091a = safeKeyBoardPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageButton imageButton;
        if (motionEvent.getAction() == 0) {
            this.f2091a.d();
            return false;
        } else if (motionEvent.getAction() == 1) {
            this.f2091a.c();
            return false;
        } else if (motionEvent.getAction() == 2) {
            imageButton = this.f2091a.k;
            if (!imageButton.isPressed()) {
                this.f2091a.c();
                return false;
            }
            return false;
        } else {
            return false;
        }
    }
}
