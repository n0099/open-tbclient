package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dFl;

    /* loaded from: classes.dex */
    public interface a {
        void aHY();

        void aHZ();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dFl = null;
        setFocusableInTouchMode(true);
        this.dFl = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dFl != null) {
                this.dFl.aHY();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dFl != null) {
            this.dFl.aHZ();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
