package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private m HO;

    public l(Context context, View view, m mVar) {
        super(context);
        this.HO = null;
        setFocusableInTouchMode(true);
        this.HO = mVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.HO != null) {
                this.HO.iR();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.HO != null) {
            this.HO.iS();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
