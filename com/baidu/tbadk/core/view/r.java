package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private s Ze;

    public r(Context context, View view, s sVar) {
        super(context);
        this.Ze = null;
        setFocusableInTouchMode(true);
        this.Ze = sVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.Ze != null) {
                this.Ze.pC();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.Ze != null) {
            this.Ze.pD();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
