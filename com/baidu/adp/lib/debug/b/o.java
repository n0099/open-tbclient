package com.baidu.adp.lib.debug.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class o implements View.OnTouchListener {
    final /* synthetic */ m hO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.hO = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.hO.hN && motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.hO.getResources().getDrawable(R.drawable.adp_debug_switch_bk));
            this.hO.hD.setVisibility(8);
            this.hO.hD.setClickable(false);
            this.hO.hx.setVisibility(8);
            this.hO.hN = false;
            this.hO.hy.setVisibility(0);
        } else if (motionEvent.getAction() == 0) {
            ((ImageButton) view).setBackgroundDrawable(this.hO.getResources().getDrawable(R.drawable.adp_debug_switch));
            this.hO.hD.setVisibility(0);
            this.hO.hD.setClickable(true);
            this.hO.hx.setVisibility(0);
            this.hO.hy.setVisibility(8);
            this.hO.hN = true;
        }
        return false;
    }
}
