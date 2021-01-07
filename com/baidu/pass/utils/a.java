package com.baidu.pass.utils;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f4156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f) {
        this.f4156a = f;
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
            view.setAlpha(this.f4156a);
            return false;
        } else {
            return false;
        }
    }
}
