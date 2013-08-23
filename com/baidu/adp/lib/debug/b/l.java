package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f419a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f419a.s && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f419a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch_bk));
            this.f419a.l.setVisibility(8);
            this.f419a.l.setClickable(false);
            this.f419a.b.setVisibility(8);
            this.f419a.s = false;
            this.f419a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f419a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch));
            this.f419a.l.setVisibility(0);
            this.f419a.l.setClickable(true);
            this.f419a.b.setVisibility(0);
            this.f419a.c.setVisibility(8);
            this.f419a.s = true;
        }
        return false;
    }
}
