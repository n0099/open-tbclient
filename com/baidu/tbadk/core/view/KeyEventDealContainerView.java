package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bQa;

    /* loaded from: classes.dex */
    public interface a {
        void VU();

        void VV();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bQa = null;
        setFocusableInTouchMode(true);
        this.bQa = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bQa != null) {
                this.bQa.VU();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bQa != null) {
            this.bQa.VV();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
