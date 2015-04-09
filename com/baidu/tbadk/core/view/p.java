package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private q Ym;

    public p(Context context, View view, q qVar) {
        super(context);
        this.Ym = null;
        setFocusableInTouchMode(true);
        this.Ym = qVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.Ym != null) {
                this.Ym.oY();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.Ym != null) {
            this.Ym.oZ();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
