package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a cnL;

    /* loaded from: classes.dex */
    public interface a {
        void agh();

        void agi();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.cnL = null;
        setFocusableInTouchMode(true);
        this.cnL = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.cnL != null) {
                this.cnL.agh();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.cnL != null) {
            this.cnL.agi();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
