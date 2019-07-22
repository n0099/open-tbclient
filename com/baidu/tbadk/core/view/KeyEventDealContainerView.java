package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bYR;

    /* loaded from: classes.dex */
    public interface a {
        void abA();

        void abz();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bYR = null;
        setFocusableInTouchMode(true);
        this.bYR = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bYR != null) {
                this.bYR.abz();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bYR != null) {
            this.bYR.abA();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
