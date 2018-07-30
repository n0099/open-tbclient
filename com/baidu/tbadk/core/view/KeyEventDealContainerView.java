package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a avb;

    /* loaded from: classes.dex */
    public interface a {
        void sC();

        void sD();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.avb = null;
        setFocusableInTouchMode(true);
        this.avb = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.avb != null) {
                this.avb.sC();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.avb != null) {
            this.avb.sD();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
