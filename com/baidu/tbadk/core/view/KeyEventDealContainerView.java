package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a amB;

    /* loaded from: classes.dex */
    public interface a {
        void pu();

        void pv();
    }

    public KeyEventDealContainerView(Context context, View view2, a aVar) {
        super(context);
        this.amB = null;
        setFocusableInTouchMode(true);
        this.amB = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.amB != null) {
                this.amB.pu();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.amB != null) {
            this.amB.pv();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
