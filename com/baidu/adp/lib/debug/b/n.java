package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class n implements View.OnTouchListener {
    final /* synthetic */ m hO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.hO = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setBackgroundResource(R.drawable.adp_debug_refresh_press);
            com.baidu.adp.lib.debug.d.p(0);
            com.baidu.adp.lib.debug.d.q(0);
            com.baidu.adp.lib.debug.d.cG();
        } else if (motionEvent.getAction() == 1) {
            view.setBackgroundResource(R.drawable.adp_debug_refresh);
        }
        return false;
    }
}
