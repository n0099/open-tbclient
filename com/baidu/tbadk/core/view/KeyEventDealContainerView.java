package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dFp;

    /* loaded from: classes.dex */
    public interface a {
        void aHW();

        void aHX();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dFp = null;
        setFocusableInTouchMode(true);
        this.dFp = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dFp != null) {
                this.dFp.aHW();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dFp != null) {
            this.dFp.aHX();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
