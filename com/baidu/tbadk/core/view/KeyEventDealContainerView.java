package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a fex;

    /* loaded from: classes.dex */
    public interface a {
        void bkr();

        void bks();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.fex = null;
        setFocusableInTouchMode(true);
        this.fex = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.fex != null) {
                this.fex.bkr();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.fex != null) {
            this.fex.bks();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
