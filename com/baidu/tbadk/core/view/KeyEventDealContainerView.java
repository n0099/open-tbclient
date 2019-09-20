package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bZQ;

    /* loaded from: classes.dex */
    public interface a {
        void abD();

        void abE();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bZQ = null;
        setFocusableInTouchMode(true);
        this.bZQ = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bZQ != null) {
                this.bZQ.abD();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bZQ != null) {
            this.bZQ.abE();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
