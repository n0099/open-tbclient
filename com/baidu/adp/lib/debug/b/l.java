package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f473a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f473a.w && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f473a.getResources().getDrawable(com.baidu.adp.c.adp_debug_switch_bk));
            this.f473a.m.setVisibility(8);
            this.f473a.m.setClickable(false);
            this.f473a.b.setVisibility(8);
            this.f473a.w = false;
            this.f473a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f473a.getResources().getDrawable(com.baidu.adp.c.adp_debug_switch));
            this.f473a.m.setVisibility(0);
            this.f473a.m.setClickable(true);
            this.f473a.b.setVisibility(0);
            this.f473a.c.setVisibility(8);
            this.f473a.w = true;
        }
        return false;
    }
}
