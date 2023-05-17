package com.baidu.pass.utils;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {
    public final /* synthetic */ float a;

    public a(float f) {
        this.a = f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                view2.setAlpha(1.0f);
                return false;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            view2.setAlpha(this.a);
            return false;
        } else {
            return false;
        }
    }
}
