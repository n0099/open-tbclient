package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aym;

    /* loaded from: classes.dex */
    public interface a {
        void tI();

        void tJ();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aym = null;
        setFocusableInTouchMode(true);
        this.aym = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aym != null) {
                this.aym.tI();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aym != null) {
            this.aym.tJ();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
