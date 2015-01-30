package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class u extends LinearLayout {
    private v Nf;

    public u(Context context, View view, v vVar) {
        super(context);
        this.Nf = null;
        setFocusableInTouchMode(true);
        this.Nf = vVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.Nf != null) {
                this.Nf.lx();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.Nf != null) {
            this.Nf.ly();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
