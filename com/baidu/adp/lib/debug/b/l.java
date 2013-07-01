package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f164a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f164a.s && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f164a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch_bk));
            this.f164a.l.setVisibility(8);
            this.f164a.l.setClickable(false);
            this.f164a.b.setVisibility(8);
            this.f164a.s = false;
            this.f164a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f164a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch));
            this.f164a.l.setVisibility(0);
            this.f164a.l.setClickable(true);
            this.f164a.b.setVisibility(0);
            this.f164a.c.setVisibility(8);
            this.f164a.s = true;
        }
        return false;
    }
}
