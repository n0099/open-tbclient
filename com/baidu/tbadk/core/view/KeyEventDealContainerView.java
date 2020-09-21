package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a esK;

    /* loaded from: classes.dex */
    public interface a {
        void bcw();

        void bcx();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.esK = null;
        setFocusableInTouchMode(true);
        this.esK = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.esK != null) {
                this.esK.bcw();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.esK != null) {
            this.esK.bcx();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
