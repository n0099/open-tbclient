package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnTouchListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        i.a(motionEvent, this.a.a);
        return true;
    }
}
