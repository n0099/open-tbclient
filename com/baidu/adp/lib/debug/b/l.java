package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
final class l implements View.OnTouchListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setBackgroundResource(com.baidu.adp.c.adp_debug_refresh_press);
            com.baidu.adp.lib.debug.c.b(0);
            com.baidu.adp.lib.debug.c.c(0);
            com.baidu.adp.lib.debug.c.g();
        } else if (motionEvent.getAction() == 1) {
            view.setBackgroundResource(com.baidu.adp.c.adp_debug_refresh);
        }
        return false;
    }
}
