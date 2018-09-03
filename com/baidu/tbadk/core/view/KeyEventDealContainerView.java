package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a ava;

    /* loaded from: classes.dex */
    public interface a {
        void sB();

        void sC();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.ava = null;
        setFocusableInTouchMode(true);
        this.ava = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ava != null) {
                this.ava.sB();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ava != null) {
            this.ava.sC();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
