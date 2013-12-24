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
        if (this.a.w && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.adp.c.adp_debug_switch_bk));
            this.a.m.setVisibility(8);
            this.a.m.setClickable(false);
            this.a.b.setVisibility(8);
            this.a.w = false;
            this.a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.adp.c.adp_debug_switch));
            this.a.m.setVisibility(0);
            this.a.m.setClickable(true);
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(8);
            this.a.w = true;
        }
        return false;
    }
}
