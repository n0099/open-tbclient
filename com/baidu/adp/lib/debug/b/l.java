package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f423a = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f423a.w && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f423a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch_bk));
            this.f423a.m.setVisibility(8);
            this.f423a.m.setClickable(false);
            this.f423a.b.setVisibility(8);
            this.f423a.w = false;
            this.f423a.c.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.f423a.getResources().getDrawable(com.baidu.adp.d.adp_debug_switch));
            this.f423a.m.setVisibility(0);
            this.f423a.m.setClickable(true);
            this.f423a.b.setVisibility(0);
            this.f423a.c.setVisibility(8);
            this.f423a.w = true;
        }
        return false;
    }
}
