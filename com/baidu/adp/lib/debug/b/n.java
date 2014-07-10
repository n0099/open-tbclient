package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnTouchListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setBackgroundResource(com.baidu.adp.c.adp_debug_refresh_press);
            com.baidu.adp.lib.debug.d.b(0);
            com.baidu.adp.lib.debug.d.c(0);
            com.baidu.adp.lib.debug.d.g();
        } else if (motionEvent.getAction() == 1) {
            view.setBackgroundResource(com.baidu.adp.c.adp_debug_refresh);
        }
        return false;
    }
}
