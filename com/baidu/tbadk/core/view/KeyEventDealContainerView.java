package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bXP;

    /* loaded from: classes.dex */
    public interface a {
        void aaA();

        void aaB();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bXP = null;
        setFocusableInTouchMode(true);
        this.bXP = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bXP != null) {
                this.bXP.aaA();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bXP != null) {
            this.bXP.aaB();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
