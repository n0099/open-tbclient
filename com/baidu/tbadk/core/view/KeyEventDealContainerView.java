package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a fgN;

    /* loaded from: classes.dex */
    public interface a {
        void bkJ();

        void bkK();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.fgN = null;
        setFocusableInTouchMode(true);
        this.fgN = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.fgN != null) {
                this.fgN.bkJ();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.fgN != null) {
            this.fgN.bkK();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
