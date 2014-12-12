package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class u extends LinearLayout {
    private v MI;

    public u(Context context, View view, v vVar) {
        super(context);
        this.MI = null;
        setFocusableInTouchMode(true);
        this.MI = vVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.MI != null) {
                this.MI.lx();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.MI != null) {
            this.MI.ly();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
