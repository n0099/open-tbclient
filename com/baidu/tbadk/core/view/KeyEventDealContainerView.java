package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bPX;

    /* loaded from: classes.dex */
    public interface a {
        void VX();

        void VY();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bPX = null;
        setFocusableInTouchMode(true);
        this.bPX = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bPX != null) {
                this.bPX.VX();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bPX != null) {
            this.bPX.VY();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
