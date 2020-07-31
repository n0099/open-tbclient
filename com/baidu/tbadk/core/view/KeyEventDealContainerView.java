package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a egU;

    /* loaded from: classes.dex */
    public interface a {
        void aTl();

        void aTm();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.egU = null;
        setFocusableInTouchMode(true);
        this.egU = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.egU != null) {
                this.egU.aTl();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.egU != null) {
            this.egU.aTm();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
