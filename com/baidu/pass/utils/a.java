package com.baidu.pass.utils;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f9315a;

    public a(float f2) {
        this.f9315a = f2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(this.f9315a);
            return false;
        } else {
            return false;
        }
    }
}
