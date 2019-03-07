package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bPW;

    /* loaded from: classes.dex */
    public interface a {
        void VX();

        void VY();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bPW = null;
        setFocusableInTouchMode(true);
        this.bPW = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bPW != null) {
                this.bPW.VX();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bPW != null) {
            this.bPW.VY();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
