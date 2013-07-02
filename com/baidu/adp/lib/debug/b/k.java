package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnTouchListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setBackgroundResource(com.baidu.adp.d.adp_debug_refresh_press);
            com.baidu.adp.lib.debug.b.b(0);
            com.baidu.adp.lib.debug.b.c(0);
        } else if (motionEvent.getAction() == 1) {
            view.setBackgroundResource(com.baidu.adp.d.adp_debug_refresh);
        }
        return false;
    }
}
