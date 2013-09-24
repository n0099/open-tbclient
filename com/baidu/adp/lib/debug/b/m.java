package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f424a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        i.a(motionEvent, this.f424a.f421a);
        return true;
    }
}
