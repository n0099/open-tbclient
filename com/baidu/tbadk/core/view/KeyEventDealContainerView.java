package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dTB;

    /* loaded from: classes.dex */
    public interface a {
        void aNK();

        void aNL();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dTB = null;
        setFocusableInTouchMode(true);
        this.dTB = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dTB != null) {
                this.dTB.aNK();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dTB != null) {
            this.dTB.aNL();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
