package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnTouchListener {
    final /* synthetic */ m hO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.hO = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        l.a(motionEvent, this.hO.hw);
        return true;
    }
}
