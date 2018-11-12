package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aDL;

    /* loaded from: classes.dex */
    public interface a {
        void vZ();

        void wa();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aDL = null;
        setFocusableInTouchMode(true);
        this.aDL = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aDL != null) {
                this.aDL.vZ();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aDL != null) {
            this.aDL.wa();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
