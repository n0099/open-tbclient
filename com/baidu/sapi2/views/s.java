package com.baidu.sapi2.views;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ float a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(float f) {
        this.a = f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (Build.VERSION.SDK_INT >= 11) {
                view.setAlpha(this.a);
                return false;
            }
            return false;
        } else if (action != 1) {
            if (action == 3 && Build.VERSION.SDK_INT >= 11) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(1.0f);
            return false;
        } else {
            return false;
        }
    }
}
