package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dfo;

    /* loaded from: classes.dex */
    public interface a {
        void azI();

        void azJ();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dfo = null;
        setFocusableInTouchMode(true);
        this.dfo = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dfo != null) {
                this.dfo.azI();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dfo != null) {
            this.dfo.azJ();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
