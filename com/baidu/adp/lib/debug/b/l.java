package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.s && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch_bk));
            this.a.l.setVisibility(8);
            this.a.l.setClickable(false);
            this.a.b.setVisibility(8);
            this.a.s = false;
            this.a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch));
            this.a.l.setVisibility(0);
            this.a.l.setClickable(true);
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(8);
            this.a.s = true;
        }
        return false;
    }
}
