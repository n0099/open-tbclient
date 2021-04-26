package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes2.dex */
public class g implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5698a;

    public g(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f5698a = safeKeyBoardPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageButton imageButton;
        if (motionEvent.getAction() == 0) {
            this.f5698a.d();
            return false;
        } else if (motionEvent.getAction() == 1) {
            this.f5698a.c();
            return false;
        } else if (motionEvent.getAction() == 2) {
            imageButton = this.f5698a.k;
            if (imageButton.isPressed()) {
                return false;
            }
            this.f5698a.c();
            return false;
        } else {
            return false;
        }
    }
}
